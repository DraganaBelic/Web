package by.tr.app.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.app.command.exception.CommandException;

public interface Command {

	void execute(HttpServletRequest request, HttpServletResponse response)throws CommandException;
}
