package by.tr.app.command.impl;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.app.command.Command;
import by.tr.app.command.exception.CommandException;
import by.tr.app.dao.LogDao;
import by.tr.app.service.ClientService;
import by.tr.app.service.ServiceFactory;
import by.tr.app.service.exception.ServiceException;
import sun.rmi.server.Dispatcher;

public class Registration implements Command {

	private static final String FNAME = "name";
	private static final String LNAME = "lname";
	private static final String EMAIL = "email";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "pass";
	private static final String REPASS = "repass";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		String firstName;
		String lastName;
		String email;
		String login;
		String password;
		String pass2;
		
		firstName = request.getParameter(FNAME);
		lastName = request.getParameter(LNAME);
		email = request.getParameter(EMAIL);
		login = request.getParameter(LOGIN);
		password = request.getParameter(PASSWORD);
		pass2=request.getParameter(REPASS);
		String errorPage="jsp/log_error.jsp";
		
		if(firstName==null || firstName.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		}
		if(lastName==null || lastName.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		}
		
		if(email==null || email.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		}
		
		if(login==null || login.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		}
		
		if(password==null || password.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		}
		if(pass2==null || pass2.isEmpty()){
			RequestDispatcher d= request.getRequestDispatcher(errorPage);
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
		}
		if (!pass2.equals(password)){
			RequestDispatcher d= request.getRequestDispatcher("jsp/pass_match_error.jsp");
			try {
				d.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				throw new CommandException("Command error");
			}
			
		}
		
		ServiceFactory service = ServiceFactory.getInstance();
		ClientService clientService= service.getClientService();
		try {
			boolean registered = clientService.registerMethod(firstName, lastName, email, login, password);
		} catch (ServiceException e1) {
			throw new  CommandException("command error");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			try {
				disp.forward(request, response);
			} catch (ServletException | IOException e) {
				throw new CommandException("comm error");
			}
		
	}

}
