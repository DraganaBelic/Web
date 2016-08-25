package by.tr.app.controller;

import java.util.HashMap;
import java.util.Map;


import by.tr.app.command.Command;
import by.tr.app.command.impl.AddBook;
import by.tr.app.command.impl.Catalog;
import by.tr.app.command.impl.DeleteBook;
import by.tr.app.command.impl.FindBook;
import by.tr.app.command.impl.Logination;
import by.tr.app.command.impl.Registration;

public class CommandHelper {

	Map<CommandName, Command> commands= new HashMap<>();
	
	public CommandHelper() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.SHOW_BOOKS, new Catalog());
		commands.put(CommandName.ADD_BOOK, new AddBook());
		commands.put(CommandName.FIND_BOOK, new FindBook());
		commands.put(CommandName.DELETE_BOOK, new DeleteBook());
	}

    Command getCommand(String name) {
    	
    	CommandName commandName= CommandName.valueOf(name.toUpperCase()	);
    	Command command= commands.get(commandName);
    	
		return command;
	}
}
