package by.tr.app.dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.tr.app.bean.Book;
import by.tr.app.command.impl.FindBook;
import by.tr.app.dao.BookDao;
import by.tr.app.dao.exception.DAOException;

public class SQLBookDao implements BookDao {

	public static void loadDriver() throws DAOException {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			throw new DAOException("DAOExceptin message", e);
		}
	}
	
	
	
	@Override
	public List<Book> getBooks() throws DAOException {

		final List<Book> books= new ArrayList<Book>();
		final String sql="SELECT* FROM BOOKS";
		
		Connection conn=null;
		ResultSet rs=null;
		Statement stat= null;
		
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");
		
			stat= conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				
				books.add(new Book(rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			Logger.getLogger(SQLBookDao.class.getName()).log(Level.SEVERE	, null	, e);
		}finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLBookDao.class.getName()).log(Level.SEVERE	, null	, e);
				}
			}if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLBookDao.class.getName()).log(Level.SEVERE	, null	, e);
				}
			}

	}
		return books;
}



	@Override
	public boolean newBook(String title, String author, double price, String genre) throws DAOException {
		
		final String sql="INSERT INTO `example`.`books` (`title`, `author`, `price`, `genre`) VALUES (?,?,?,?);";
		PreparedStatement ps = null;
		Connection conn=null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			throw new DAOException("dao error");
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");
			ps = conn.prepareStatement(sql);
			
					
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setDouble(3, price);
			ps.setString(4, genre);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("dao error");
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLLogDao.class.getName()).log(Level.SEVERE, null, e);

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLLogDao.class.getName()).log(Level.SEVERE, null, e);

				}
			}

		}

		
	return true;
		
	}



	


//find
	@Override
	public List<Book> findBook(String someString) throws DAOException {
		
		final List<Book> books= new ArrayList<Book>();
		final String sql="SELECT* FROM BOOKS WHERE TITLE LIKE '%"+ someString +"%'";
		
		Connection conn=null;
		ResultSet rs=null;
		Statement stat= null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");
			stat= conn.createStatement();
			rs= stat.executeQuery(sql);
			
			while(rs.next()){
				
				books.add(new Book(rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5)));
			}
			
		} catch (SQLException e) {
			throw new DAOException("dao error");
		}finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLBookDao.class.getName()).log(Level.SEVERE	, null	, e);
				}
			}if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLBookDao.class.getName()).log(Level.SEVERE	, null	, e);
				}
			}

	}

		return books;
	}




}
