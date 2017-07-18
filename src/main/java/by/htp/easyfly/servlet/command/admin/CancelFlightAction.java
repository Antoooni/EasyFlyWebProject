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
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class CancelFlightAction implements CommandAction {
	private ChangeFlightService changeFlightService;
    private SendEmailService sendEmailService;

	public CancelFlightAction() {
        changeFlightService = ServiceFactory.getInstance().getChangeFlightService();
        sendEmailService = ServiceFactory.getInstance().getSendEmailService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
        String textEmail= "Dear customer, you flight has been cancel.We are so sorry.";
		HttpSession session = request.getSession(true);
		Flight flight = new Flight();
		try {
			flight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO);
			changeFlightService.cancelFlight(flight);

            //sendEmail email about cancellation
            sendEmailService.sendEmail(flight,textEmail);
            //attribute to notification
            request.setAttribute(NOTIFICATION_MESSAGE_CANCEL_FLIGHT, true);
			String page = PAGE_DONE_CANCELLATION;
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
