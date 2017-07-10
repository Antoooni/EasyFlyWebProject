package by.htp.easyfly.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface CommandAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
