package by.tr.app.dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.tr.app.dao.LogDao;
import by.tr.app.dao.exception.DAOException;

public class SQLLogDao implements LogDao {

	@Override
	public boolean authorization(String login, String password) throws DAOException {

		final String sql = "SELECT* FROM  EXAMPLE.LIBRARY_USERS WHERE login ='" + login + "'" + "&& password = '" + password
				+ "'";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
		
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			if (!rs.next()) {

				return false;
			}
		} catch (SQLException e) {
			throw new DAOException("DAOException message", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("DAOException message", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
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

	@Override
	public boolean registration(String firstName, String lastName, String email, String login, String password)
			throws DAOException {

		Connection conn = null;

		PreparedStatement ps = null;
		final String sql = "INSERT INTO `example`.`library_users` (`login`, `password`, `first_name`, `last_name`, `email`) VALUES (?,?,?,?,?)";

		try {
			
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/example", "root", "12345");

			ps = conn.prepareStatement(sql);
			
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("DAOExceptin message", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("DAOExceptin message", e);
		}

		finally {
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

}
