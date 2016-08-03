package by.tr.library.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tr.library.dao.CommonDao;
import by.tr.library.dao.exception.DAOException;

public class SQLCommonDao implements CommonDao {

	@Override
	public boolean authorization(String login, String password) throws DAOException {
		// stub code
		Connection conn=null;
		PreparedStatement preparedStat= null;
		String insertInTable = "INSERT INTO library_users " + " (`id`, `login`, `password`) VALUES " + "(?,?,?)";
		String checkDuplikates="SELECT* FROM  LIBRARY_USERS WHERE login ='"+login+"'";
		ResultSet rs= null;
		Statement statement = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new DAOException("DAOExceptin message", e1);
		}
		
		
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root","12345");
			statement=  conn.createStatement();
			rs=statement.executeQuery(checkDuplikates);
			
			if (rs.next()) {
				System.out.println("User already exist");
				return false;
			}
			
			preparedStat= conn.prepareStatement(insertInTable);
			
			preparedStat.setInt(1,0);
			preparedStat.setString(2, login);
			preparedStat.setString(3, password);
			
			
			
			preparedStat.executeUpdate();
			System.out.println("Table library_users is updated !");
			System.out.println("New user is added !");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new DAOException("DAOExceptin message", e1);
			
		}
		
		
		finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new DAOException("DAOExceptin message", e);
				}
			}
			if (preparedStat!=null) {
				try {
					preparedStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new DAOException("DAOExceptin message", e);
				}
			}
		}
		return true;
	}

}
