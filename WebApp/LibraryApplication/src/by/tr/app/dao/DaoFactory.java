package by.tr.app.dao;

import by.tr.app.dao.implement.SQLLogDao;
import by.tr.app.dao.implement.SQLUserDao;

public class DaoFactory {

	private static final DaoFactory factory= new DaoFactory();
	
	private final LogDao logDao = new SQLLogDao();
	private final UserDao userDao= new SQLUserDao();
	
	private DaoFactory(){}
	
	public static DaoFactory getInstance(){
		return factory;
	}
	
	public LogDao getLogDao(){
		return logDao;
	}
	public UserDao getUserDao(){
		return userDao;
	}
	
}
