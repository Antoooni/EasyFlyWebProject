package by.htp.easyfly.servlet.command;

import static by.htp.easyfly.util.ConstantValue.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.Cookie.CookieController;
import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.AuthorizationService;
import by.htp.easyfly.service.DirectionService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;

public class LoginCommandAction implements CommandAction {

	private static final Logger log = Logger.getLogger(LoginCommandAction.class.getName());

	private AuthorizationService authorizationService;
	private DirectionService directionService;

	public LoginCommandAction() {
		authorizationService = ServiceFactory.getInstance().getAuthorizationService();
		directionService = ServiceFactory.getInstance().getDirectionService();

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);

		HttpSession session = request.getSession(true);
		String page = PAGE_DEFAULT;
		User user = new User();
        CookieController cookieController= new CookieController();
		try {
			user = authorizationService.userData(login, password);
			// try {
			if (user != null) {
				List<FlightDirection> flightDirection = directionService.listDirections();
				// dropdown
				session.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
				session.setAttribute(REQUEST_PARAM_SESSION_USERNAME, user.getUserName());
				session.setAttribute(REQUEST_PARAM_SESSION_USER, user);

                cookieController.doGet(request,response);

				String workingDir = System.getProperty("user.dir");

				System.out.println(workingDir);
				// config.init();
				// DOMConfigurator.configure("log4j.xml");
				log.info("Информационное сообщение");
				// log.fine("!!!!!!!!!");
				page = PAGE_HOME;
			} else {
				page = PAGE_ERROR;
			}
		} catch (ServiceException e) {

		} catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ForwardPage.forwardPage(request, response, page);
	}

}
