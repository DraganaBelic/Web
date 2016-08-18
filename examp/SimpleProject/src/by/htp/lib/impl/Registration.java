package by.htp.lib.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.lib.domain.User;
import by.htp.lib.exep.CommandExeption;
import by.htp.lib.intecomm.Command;

public class Registration implements Command {

	
	private static final String FNAME ="fname";
	private static final String LNAME ="lname";
	private static final String EMAIL ="email";
	private static final String LOGIN ="login";
	private static final String PASSWORD ="pass";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandExeption {
		
		String fname;
		String lname;
		String email;
		String login;
		String pass;
		
		fname=request.getParameter(FNAME);
		lname=request.getParameter(LNAME);
		email=request.getParameter(EMAIL);
		login=request.getParameter(LOGIN);
		pass=request.getParameter(PASSWORD);
		
		String sql= "INSERT INTO `example`.`library_users` (`login`, `password`, `first_name`, `last_name`, `email`) VALUES (?,?,?,?,?)";
		
		Connection conn= getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, login);
			ps.setString(2, pass);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);
			
			ps.executeUpdate();
			System.out.println("Registered");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		
		
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
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return conn;
		
		
	}
}
