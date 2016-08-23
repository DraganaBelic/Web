package by.tr.app.service;

import java.util.List;

import by.tr.app.bean.Book;
import by.tr.app.service.exception.ServiceException;

public interface LibraryService {
	List <Book> showBooks() throws ServiceException;
	
}
