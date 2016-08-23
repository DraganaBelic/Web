package by.tr.app.service;

import by.tr.app.service.exception.ServiceException;

public interface ClientService {
	boolean loginMethod(String login, String password) throws ServiceException;

	boolean registerMethod(String firstName, String lastName, String email, String login, String password)
			throws ServiceException;
}
