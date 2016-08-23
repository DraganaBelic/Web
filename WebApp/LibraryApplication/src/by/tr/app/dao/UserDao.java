package by.tr.app.dao;

import java.util.List;

import by.tr.app.bean.Book;
import by.tr.app.dao.exception.DAOException;

public interface UserDao {

	List<Book> getBooks()throws DAOException;
}
