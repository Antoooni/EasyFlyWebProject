package by.htp.easyfly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.servlet.command.CommandChooser;
import static by.htp.easyfly.util.ConstantValue.*;

/**
 * Servlet implementation class Main
 */
@WebServlet("/controller")
public class Main extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestProcessingGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestProcessingPost(request, response);
	}

	/**
	 * This method processes the action and execute the command specified for
	 * current action
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 *             {@value #page} page default
	 */
	private void requestProcessingGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter(VALUE_OF_A_REQUEST_PARAMETER);
		String page = null;
		if (action != null) {
			CommandAction currentAction = CommandChooser.chooseAction(action);
			currentAction.execute(request, response);
//			RequestDispatcher disp = request.getRequestDispatcher(page); ��������� � ��������������� �������������
//			disp.forward(request, response);
		}

	}

	private void requestProcessingPost(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter(VALUE_OF_A_REQUEST_PARAMETER);
		String page = null;
		if (action != null) {
			CommandAction currentAction = CommandChooser.chooseAction(action);
			/*page = */currentAction.execute(request, response);
//			page = trimSlashPageName(page);
			page="index.jsp";
			try {
				response.sendRedirect("Main?action=go_home");
				System.out.println("POST ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private String trimSlashPageName(String page) {
		if (page.charAt(0) == '/') {
			page = page.substring(1, page.length());
			return page;
		} else {
			return page;
		}
	}

}
