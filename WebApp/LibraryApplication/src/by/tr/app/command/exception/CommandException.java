package by.tr.app.command.exception;

public class CommandException extends Exception {

	public CommandException(String message) {
		super(message);
	}
	public CommandException(String message, Exception e) {
		super(message, e);
	}
}
