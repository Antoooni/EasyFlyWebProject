package by.htp.easyfly.servlet.command;

import static by.htp.easyfly.util.ConstantValue.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.util.Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.easyfly.Cookie.CookieController;
import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.AuthorizationService;
import by.htp.easyfly.service.DirectionService;
import by.htp.easyfly.service.SearchChangedFlightService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.ForwardPage;

public class LoginCommandAction implements CommandAction {

    private static final Logger LOG = LogManager.getLogger(LoginCommandAction.class.getName());

	private AuthorizationService authorizationService;
	private DirectionService directionService;
    private SearchChangedFlightService searchChangedFlightService;

	public LoginCommandAction() {
		authorizationService = ServiceFactory.getInstance().getAuthorizationService();
		directionService = ServiceFactory.getInstance().getDirectionService();
        searchChangedFlightService=ServiceFactory.getInstance().getSearchChangedFlightService();

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);

		HttpSession session = request.getSession(true);
		String page = PAGE_DEFAULT;
		User user;
        CookieController cookieController= new CookieController();
		try {
//            String hashingPass= Hashing.passwordHashing(password);
//            System.out.println("Password after hashing: "+hashingPass);
            user = authorizationService.userData(login, Hashing.passwordEncode(password));
			if (user != null) {
				List<FlightDirection> flightDirection = directionService.listDirections();
				// dropdown
				session.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
				session.setAttribute(REQUEST_PARAM_SESSION_USERNAME, user.getUserName());
				session.setAttribute(REQUEST_PARAM_SESSION_USER, user);
                //alert message
                Flight selectedChangedFlight =searchChangedFlightService.searchCancelledFlight(user);
                LOG.info(user.getUserName()+" has been logged-in");
                if (selectedChangedFlight!=null && DateTimeTransform.checkDateNotInPast(selectedChangedFlight.getDepartureDate())) {
                    session.setAttribute(REQUEST_PARAM_SESSION_CANCELLED_FLIGHT, selectedChangedFlight);
                    request.setAttribute(REQUEST_PARAM_SESSION_CANCELLED_FLIGHT, selectedChangedFlight);
                }
                else {
                    if (selectedChangedFlight!=null && DateTimeTransform.checkDateNotInPast(selectedChangedFlight.getDepartureDate())) {
                        selectedChangedFlight = searchChangedFlightService.searchChangedFlight(user);
                        session.setAttribute(REQUEST_PARAM_SESSION_CHANGED_FLIGHT, selectedChangedFlight);
                        request.setAttribute(REQUEST_PARAM_SESSION_CHANGED_FLIGHT, selectedChangedFlight);
                    }
                }
                cookieController.doGet(request,response);
				page = PAGE_HOME;
			} else {
				page = PAGE_ERROR;
                LOG.info("Was attempt made to sign in");
			}
		} catch (ServiceException e) {
            LOG.error("Authorization error "+e);
		} catch (ServletException e) {
            LOG.error("Cookie error " + e);
        } catch (IOException e) {
            LOG.error("Cookie IO error " + e);
        }
        ForwardPage.forwardPage(request, response, page);
	}
}
