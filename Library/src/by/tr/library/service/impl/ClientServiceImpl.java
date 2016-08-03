package by.tr.library.service.impl;

import by.tr.library.dao.CommonDao;
import by.tr.library.dao.DAOFactory;
import by.tr.library.dao.exception.DAOException;
import by.tr.library.service.ClientService;
import by.tr.library.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService{

	@Override
	public boolean logination(String login, String password) throws ServiceException  {
		// parameters validation
		if (login == null || login.isEmpty()){
			throw new ServiceException("jhvjvj");
		}
		
		
		DAOFactory factory = DAOFactory.getInstance();
		CommonDao commonDao = factory.getCommonDao();// new SQLCommonDAO
		
		boolean result;
		try {
			result = commonDao.authorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return result;
	}

	@Override
	public boolean register(String firstName, String lastName, String email, String login, String password)
			throws ServiceException {
		
		if (login == null || login.isEmpty()){
			throw new ServiceException("empty");
			
		}
		if (firstName == null || firstName.isEmpty()){
			throw new ServiceException("empty");
			
		}
		if (lastName == null || lastName.isEmpty()){
			throw new ServiceException("emptyj");
			
		}
		if (email == null || email.isEmpty()){
			throw new ServiceException("empty");
			
		}
		
		DAOFactory factoryReg= DAOFactory.getInstance();
		CommonDao commonDaoReg= factoryReg.getCommonDao(); //new SQLCommonDAO 
		
		boolean isRegistered;
		
		try {
			isRegistered= commonDaoReg.registration(firstName, lastName, email, login, password);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("Registration not successful");
		}
		
		return isRegistered;
	}
	
}
