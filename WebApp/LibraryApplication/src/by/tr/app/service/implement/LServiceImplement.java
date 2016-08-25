package by.tr.app.service.implement;

import java.util.List;

import by.tr.app.bean.Book;
import by.tr.app.dao.DaoFactory;
import by.tr.app.dao.exception.DAOException;
import by.tr.app.dao.BookDao;
import by.tr.app.service.LibraryService;
import by.tr.app.service.exception.ServiceException;

public class LServiceImplement implements LibraryService {

	@Override
	public List<Book> showBooks() throws ServiceException {
		
		DaoFactory factory = DaoFactory.getInstance();
		BookDao bookDao= factory.getBookDao();
		
		List<Book> books;
		
		try {
			books=bookDao.getBooks();
		} catch (DAOException e) {
			throw new ServiceException("service exception");
		}
		
		
		return books;
	}

	@Override
	public boolean addBook(String title, String author, double price, String genre) throws ServiceException {
		
		DaoFactory factory= DaoFactory.getInstance();
		BookDao bookDao= factory.getBookDao();
		
		boolean added = false;
		
		try {
			added= bookDao.newBook(title, author, price, genre);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	
	

	@Override
	public List<Book> searchForBooks(String someString) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		
		BookDao bookDao= factory.getBookDao();
		
		List<Book> books;
		
		try {
			books=bookDao.findBook(someString);
		} catch (DAOException e) {
			throw new ServiceException("service exception");
		}
		
		
		return books;
		}

	

}
