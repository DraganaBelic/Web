package by.tr.app.service;

import java.util.List;

import by.tr.app.bean.Book;
import by.tr.app.service.exception.ServiceException;

public interface LibraryService {
	
	List<Book> showBooks() throws ServiceException;

	boolean addBook(String title, String author, double price, String genre) throws ServiceException;
	
	List<Book> searchForBooks(String someString) throws ServiceException;

}
