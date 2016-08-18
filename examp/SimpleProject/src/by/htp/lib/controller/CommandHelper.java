package by.htp.lib.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.lib.impl.Logination;
import by.htp.lib.impl.Registration;
import by.htp.lib.impl.ShowBooks;
import by.htp.lib.intecomm.Command;

class CommandHelper {

	private Map<CommandName, Command> commands = new HashMap<>();

	CommandHelper() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.SHOW_BOOKS, new ShowBooks());
	}

	Command getCommand(String name){
		
		CommandName commandName=CommandName.valueOf(name.toUpperCase());
		Command command= commands.get(commandName);
		
		return command;	
	}
}
