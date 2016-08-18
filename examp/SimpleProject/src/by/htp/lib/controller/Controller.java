package by.htp.lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.lib.exep.CommandExeption;
import by.htp.lib.intecomm.Command;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static final CommandHelper commandHelper= new CommandHelper();
	private static final String COMMAND="command";
	
    public Controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter(COMMAND);
		Command command= commandHelper.getCommand(name);
		
		try {
			command.execute(request, response);
		} catch (CommandExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

}
