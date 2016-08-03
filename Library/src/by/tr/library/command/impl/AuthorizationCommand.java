package by.tr.library.command.impl;

import by.tr.library.bean.LoginationRequest;
import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.ClientService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

public class AuthorizationCommand implements Command{

	@Override
	public Response execute(Request request) throws CommandException {
		LoginationRequest loginationRequest = null;
		
		if (!(request instanceof LoginationRequest)){
			throw new CommandException("Wrong request object");
		}
		
		loginationRequest = (LoginationRequest)request;
		
		String login = loginationRequest.getLogin();
		String password = loginationRequest.getPassword();
		
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService service = factory.getClientService();
		
		try {
			boolean result = service.logination(login, password);
		} catch (ServiceException e) {
			throw new CommandException("command message", e);
		}
		Response response = new Response();
		response.setErrorMessage(null);
		response.setMessage("Logination - OK");
		
		return response;
	}

}
