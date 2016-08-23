package by.tr.app.dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.tr.app.bean.Book;
import by.tr.app.dao.UserDao;
import by.tr.app.dao.exception.DAOException;

public class SQLUserDao implements UserDao {

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
		final String sql=" SELECT* FROM EXAMPLE.BOOKS ";
		
		Connection conn=null;
		ResultSet rs=null;
		Statement stat= null;
		
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");
		
			stat= conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				
				books.add(new Book(rs.getString(2),rs.getString(3),rs.getDouble(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			Logger.getLogger(SQLUserDao.class.getName()).log(Level.SEVERE	, null	, e);
		}finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLUserDao.class.getName()).log(Level.SEVERE	, null	, e);
				}
			}if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					Logger.getLogger(SQLUserDao.class.getName()).log(Level.SEVERE	, null	, e);
				}
			}

	}
		return books;
}
}
