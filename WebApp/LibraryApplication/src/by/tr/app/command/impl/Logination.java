package by.tr.app.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.tr.app.bean.User;
import by.tr.app.command.Command;
import by.tr.app.command.exception.CommandException;
import by.tr.app.service.ClientService;
import by.tr.app.service.ServiceFactory;
import by.tr.app.service.exception.ServiceException;

public class Logination implements Command {

	private static final String LOGIN = "login";
	private static final String PASSWORD="password";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		String login;
		String password;
		
		login= request.getParameter(LOGIN);
		password=request.getParameter(PASSWORD);
		String errorPage= "jsp/log_error.jsp";
	
		if(login==null || login.isEmpty()){
			RequestDispatcher d = request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("error");
			}
			
			
		}
		if(password==null || password.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("error");
			}
		}
		//service
		
		ServiceFactory serviceFactory= ServiceFactory.getInstance();
		ClientService clientService= serviceFactory.getClientService();
		
		boolean loged;
		
		try {
			loged = clientService.loginMethod(login, password);
		} catch (ServiceException e1) {
			throw new CommandException("eror");
			
		}
		if(!loged){
			RequestDispatcher d= request.getRequestDispatcher("jsp/match_error.jsp");
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("eror");
			}
		}
		
		User user= new User();
	
		HttpSession session= request.getSession(false);
		session.setAttribute("user", user);
		user.setLogin(login);
		
		RequestDispatcher disp= request.getRequestDispatcher("jsp/welcome.jsp");
		
			try {
				disp.forward(request, response);
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		
	}

}
