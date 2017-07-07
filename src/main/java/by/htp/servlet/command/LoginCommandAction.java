package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.xml.DOMConfigurator;

import by.htp.bin.FlightDirection;
import by.htp.bin.User;
import by.htp.exception.ServiceException;
import by.htp.service.AuthorizationService;
import by.htp.service.DirectionService;
import by.htp.service.factory.ServiceFactory;
import by.htp.servlet.ForwardPage;
import by.htp.util.LogConfig;

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
		try {
			user = authorizationService.userData(login, password);
			// try {
			if (user != null) {
				List<FlightDirection> flightDirection = directionService.listDirections();
				// вывести список направлений dropdown
				session.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);

				session.setAttribute(REQUEST_PARAM_SESSION_USERNAME, user.getUserName());
				session.setAttribute(REQUEST_PARAM_SESSION_USER, user);

				/////////////
				String workingDir = System.getProperty("user.dir");

				System.out.println(workingDir);
				// config.init();
				// DOMConfigurator.configure("log4j.xml");
				log.info("Это информационное сообщение!");
				// log.fine("!!!!!!!!!");
				page = PAGE_HOME;
			} else {
				page = PAGE_ERROR;
			}
		} catch (ServiceException e) {

		}

		ForwardPage.forwardPage(request, response, page);
	}

}
