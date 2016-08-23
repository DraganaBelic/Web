package by.tr.app.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.app.command.Command;
import by.tr.app.command.exception.CommandException;

public class Registration implements Command {

	private static final String FNAME = "name";
	private static final String LNAME = "lname";
	private static final String EMAIL = "email";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "pass";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		String fname;
		String lname;
		String email;
		String login;
		String pass;
		String pass2;
		
		fname = request.getParameter(FNAME);
		lname = request.getParameter(LNAME);
		email = request.getParameter(EMAIL);
		login = request.getParameter(LOGIN);
		pass = request.getParameter(PASSWORD);
		pass2=request.getParameter("repass");

		
		if(fname==null || fname.isEmpty()){
			
		}
		if(lname==null || lname.isEmpty()){
			
		}
		
		if(email==null || email.isEmpty()){
			
		}
		
		if(login==null || login.isEmpty()){
			
		}
		
		if(pass==null || pass.isEmpty()){
			
		}
		if(pass2!=pass || !pass2.equals(pass)){
			
			
		}
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");

		
			try {
				disp.forward(request, response);
			} catch (ServletException | IOException e) {
				throw new CommandException("comm error");
			}
		
	}

}
