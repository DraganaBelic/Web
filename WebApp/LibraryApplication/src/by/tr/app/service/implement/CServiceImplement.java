package by.tr.app.service.implement;

import by.tr.app.dao.DaoFactory;
import by.tr.app.dao.LogDao;
import by.tr.app.dao.exception.DAOException;
import by.tr.app.service.ClientService;
import by.tr.app.service.exception.ServiceException;

public class CServiceImplement implements ClientService {

	@Override
	public boolean loginMethod(String login, String password) throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException("service error");
		}
		if (password == null || password.isEmpty()) {
			throw new ServiceException("service error");
		}
		DaoFactory factory = DaoFactory.getInstance();
		LogDao logDao = factory.getLogDao();//new SQLLogDao

		boolean loged;

		try {
			
			loged = logDao.authorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException("service error");
		}

		return loged;
	}

	@Override
	public boolean registerMethod(String name, String lastName, String login, String password, String email)
			throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException("empty");

		}
		if (name == null || name.isEmpty()) {
			throw new ServiceException("empty");

		}
		if (lastName == null || lastName.isEmpty()) {
			throw new ServiceException("emptyj");

		}
		if (email == null || email.isEmpty()) {
			throw new ServiceException("empty");

		}
		if (password == null || password.isEmpty()) {
			throw new ServiceException("service error");
		}
		DaoFactory factory = DaoFactory.getInstance();

		LogDao logDao = factory.getLogDao();

		boolean registered;

		try {
			registered = logDao.registration(name, lastName, login, password, email);
		} catch (DAOException e) {
			throw new ServiceException("service error");
		}

		return registered;
	}

}
