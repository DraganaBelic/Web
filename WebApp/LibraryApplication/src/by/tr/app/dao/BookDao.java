package by.tr.app.dao;

import java.util.List;

import by.tr.app.bean.Book;
import by.tr.app.dao.exception.DAOException;

public interface BookDao {

	List<Book> getBooks()throws DAOException;
	boolean newBook(String title, String author, double price, String genre)throws DAOException;
	List<Book> findBook(String someString)throws DAOException;
	
	
}
