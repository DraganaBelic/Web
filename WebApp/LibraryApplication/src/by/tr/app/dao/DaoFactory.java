package by.tr.app.dao;

import by.tr.app.dao.implement.SQLLogDao;
import by.tr.app.dao.implement.SQLBookDao;

public class DaoFactory {

	private static final DaoFactory factory= new DaoFactory();
	
	private final LogDao logDao = new SQLLogDao();
	private final BookDao bookDao= new SQLBookDao();
	
	private DaoFactory(){}
	
	public static DaoFactory getInstance(){
		return factory;
	}
	
	public LogDao getLogDao(){
		return logDao;
	}
	public BookDao getBookDao(){
		return bookDao;
	}
	
}
