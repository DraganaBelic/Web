package by.tr.library.service;

import by.tr.library.service.exception.ServiceException;

public interface ClientService {
	boolean logination(String login, String password) throws ServiceException;

	boolean register(String firstName, String lastName, String email, String login, String password)
			throws ServiceException;
}
