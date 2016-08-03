package by.tr.library.dao;

import by.tr.library.dao.exception.DAOException;

public interface CommonDao {
	boolean authorization(String login, String password) throws DAOException;
	boolean registration(String firstName, String lastName, String email, String login, String password )throws DAOException;
}
