package by.htp.easyfly.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.htp.easyfly.util.ConstantValue.REQUEST_PARAM_SESSION_CURRENT_PAGE;

public class ForwardPage {
	private ForwardPage(){
		
	}
	public static void forwardPage(HttpServletRequest request, HttpServletResponse response, String page) {
		RequestDispatcher disp = request.getRequestDispatcher(page);
        HttpSession session = request.getSession(true);
		try {
			disp.forward(request, response);
            session.setAttribute(REQUEST_PARAM_SESSION_CURRENT_PAGE, page);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
