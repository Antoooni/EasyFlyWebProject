package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class RegistrationAction implements CommandAction {
	String page=null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute(REQUEST_PARAM_EXIST_USER, false); 
		page= PAGE_REGISTRATION;
		ForwardPage.forwardPage(request, response, page);
	}

}
