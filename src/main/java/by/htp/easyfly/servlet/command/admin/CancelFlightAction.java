package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.ChangeFlightService;
import by.htp.easyfly.service.SendEmailService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CancelFlightAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(CancelFlightAction.class.getName());
	private ChangeFlightService changeFlightService;
    private SendEmailService sendEmailService;

	public CancelFlightAction() {
        changeFlightService = ServiceFactory.getInstance().getChangeFlightService();
        sendEmailService = ServiceFactory.getInstance().getSendEmailService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
        String textEmail= EMAIL_BODY_CANCELLATION;
		HttpSession session = request.getSession(true);
		Flight flight;
		try {
			flight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO);
			changeFlightService.cancelFlight(flight);

            //send cancellation email
            sendEmailService.sendEmail(flight,textEmail);
            //attribute to notification
            request.setAttribute(NOTIFICATION_MESSAGE_CANCEL_FLIGHT, true);
			String page = PAGE_DONE_CANCELLATION;
            LOG.info("Flight #"+flight.getFlightId()+" is cancel");
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {
            LOG.error("Cancellation error " + e);
		} catch (IOException e) {
            e.printStackTrace();
        }
    }

}
