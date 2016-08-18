package by.htp.lib.impl;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import by.htp.lib.domain.User;
import by.htp.lib.exep.CommandExeption;
import by.htp.lib.intecomm.Command;

public class Logination implements Command {
	
	private static final String LOGIN = "login";
	private static final String PASSWORD="pass";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandExeption {
		// TODO Auto-generated method stub

		String login;
		String pass;
		
		login= request.getParameter(LOGIN);
		pass=request.getParameter(PASSWORD);
		
		String query = "SELECT* FROM EXAMPLE.LIBRARY_USERS WHERE login ='" + login + "'" + "&& password = '" + pass
				+ "'";
		
		Connection conn=null; 
		
		ResultSet rs=null;
		try {
			conn= getConnection();
			Statement stat= conn.createStatement();
			rs= stat.executeQuery(query);
			
			if (!rs.next()) {
				
				response.setContentType("text/html");
				PrintWriter pw= response.getWriter();
				pw.println("<h1>Wrong username or password</h1>");
				pw.flush();
				
			}
		} catch (SQLException e1) {
			
			throw new CommandExeption(e1);
		} catch (IOException e) {
			throw new CommandExeption(e);
		}finally {
			if(rs!=null){
				try {
					rs.close();
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
		
		User user= new User();
		user.setLogin(login);
		
		HttpSession session= request.getSession(true);
		session.setAttribute("user", user);
		
		RequestDispatcher disp= request.getRequestDispatcher("jsp/welcome.jsp");
		try {
			disp.forward(request, response);
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
