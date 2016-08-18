package by.htp.lib.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.lib.domain.Book;
import by.htp.lib.domain.User;
import by.htp.lib.exep.CommandExeption;
import by.htp.lib.intecomm.Command;

public class ShowBooks implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandExeption {
		
		List<Book> books= new ArrayList<Book>();
		
		HttpSession session= request.getSession(false);
		if(session==null){
			request.setAttribute("error", "Logination, please!");
		
		
		try {
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandExeption(e);
		}
		return;
		}
		
		User user= (User) session.getAttribute("user");
		
		if(user==null){
			try {
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				throw new CommandExeption(e);
			}
			return;
		}
		
		
		Connection conn=null;
		ResultSet rs=null;
		Statement stat= null;
		String sql=" SELECT NAME, PRICE, AUTHOR FROM EXAMPLE.LIBRARY_USERS ";
		conn=getConnection();
		try {
			stat= conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(2) + rs.getDouble(3) + rs.getString(4));
				books.add(new Book(rs.getString("name"), rs.getDouble("price"), rs.getString("author")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("books",books);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("jsp/show_books.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandExeption(e);
		}
		
		
		
		
		

	}

	
	
	
	
	
	
	
	
	
public Connection getConnection(){
		
		Connection conn=null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
		
		
	}
}
