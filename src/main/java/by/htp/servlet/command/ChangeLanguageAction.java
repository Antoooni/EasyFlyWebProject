package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageAction implements CommandAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 String lang = request.getParameter(REQUEST_PARAM_LANGUAGE);
	     HttpSession session = request.getSession();
	     session.setAttribute(REQUEST_PARAM_LANGUAGE, lang);
	     String page=PAGE_HOME;
	     RequestDispatcher disp = request.getRequestDispatcher(page); 
			try {
				disp.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
