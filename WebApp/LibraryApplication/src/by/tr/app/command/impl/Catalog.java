package by.tr.app.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.tr.app.bean.Book;
import by.tr.app.bean.User;
import by.tr.app.command.Command;
import by.tr.app.command.exception.CommandException;

public class Catalog implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
	
List<Book> books= new ArrayList<Book>();
		
		HttpSession session= request.getSession(false);
		if(session==null){
			request.setAttribute("error", "Logination, please!");
		
			try {
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return;
		}
		
		User user= (User) session.getAttribute("user");
		
		if(user==null){
			
				try {
					request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return;
		}
	}

}
