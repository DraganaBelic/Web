package by.htp.lib.exep;

public class CommandExeption extends Exception {

	public CommandExeption(String message) {
		super(message);
	}
	
	public CommandExeption(Exception e) {
		super(e);
	}
	public CommandExeption(String message, Exception e) {
		super(message, e);
	}
}
