package by.tr.app.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.tr.app.bean.Book;
import by.tr.app.bean.User;
import by.tr.app.command.Command;
import by.tr.app.command.exception.CommandException;
import by.tr.app.service.LibraryService;
import by.tr.app.service.ServiceFactory;
import by.tr.app.service.exception.ServiceException;

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
				throw new CommandException("command exception");
			}
		
		return;
		}
		
		ServiceFactory factory= ServiceFactory.getInstance();
		LibraryService libraryService=factory.getLibraryService();
		
		try {
			books= libraryService.showBooks();
		} catch (ServiceException e1) {
			throw new CommandException("Command error");
		}
		
		User user= (User) session.getAttribute("user");
		
		if(user==null){
			
				try {
					request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					throw new CommandException("command error");
				}
			
			return;
		}
		request.setAttribute("books",books);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("jsp/show_books.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("command error");
		}
	}

}
