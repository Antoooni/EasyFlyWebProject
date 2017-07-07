package by.htp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardPage {
	private ForwardPage(){
		
	}
	public static void forwardPage(HttpServletRequest request, HttpServletResponse response, String page) {
		RequestDispatcher disp = request.getRequestDispatcher(page);
		try {
			disp.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
