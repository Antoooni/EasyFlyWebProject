package by.htp.servlet.command.user;

import static by.htp.util.ConstantValue.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.servlet.ForwardPage;
import by.htp.servlet.command.CommandAction;

public class RegistrationAction implements CommandAction {
	String page=null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//page = request.getParameter(PAGE_REGISTRATION);
//		request.setAttribute(REQUEST_PARAM_EXIST_USER, existUser);
//		HttpSession session = request.getSession(true);
//		session.setAttribute(REQUEST_PARAM_EXIST_USER, false);
		request.setAttribute(REQUEST_PARAM_EXIST_USER, false); 
		page= PAGE_REGISTRATION;
		ForwardPage.forwardPage(request, response, page);
	}

}
