package by.htp.lib.intecomm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.lib.exep.CommandExeption;

public interface Command {
	
	void execute(HttpServletRequest request, HttpServletResponse response)throws CommandExeption;
}
