package by.tr.app.dao;

import by.tr.app.dao.exception.DAOException;

public interface LogDao {

	boolean authorization(String login, String password) throws DAOException;
	boolean registration(String name, String lastName, String login, String password, String email )throws DAOException;
}
