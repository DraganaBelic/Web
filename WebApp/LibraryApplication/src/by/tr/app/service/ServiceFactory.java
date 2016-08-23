package by.tr.app.service;

import by.tr.app.service.implement.CServiceImplement;
import by.tr.app.service.implement.LServiceImplement;

public class ServiceFactory {

	private static ServiceFactory factory= new ServiceFactory();
	
	private final ClientService clientService= new CServiceImplement();
	private final LibraryService libraryService= new LServiceImplement();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance(){
		return factory;
	}
	public ClientService getClientService(){
		return clientService;
	}
	public LibraryService getLibraryService(){
		return libraryService;
	}
	
}
