package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;

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
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.InputDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeFlightAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(ChangeFlightAction.class.getName());
	private ChangeFlightService changeFlightService;
    private SendEmailService sendEmailService;

	public ChangeFlightAction() {
		changeFlightService = ServiceFactory.getInstance().getChangeFlightService();
        sendEmailService = ServiceFactory.getInstance().getSendEmailService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_DONE_CANCELLATION;
        String textEmail= EMAIL_BODY_CHANGING;
		HttpSession session = request.getSession(true);
		try {
			Flight selectedFlight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO);

			Date departureDate = DateTimeTransform.convertDate(request.getParameter(REQUEST_PARAM_CHANGE_DEPARTURE_DATE));
			Time departureTime = DateTimeTransform.convertTimeHHMM(request.getParameter(REQUEST_PARAM_CHANGE_DEPARTURE_TIME));
			Date arrivalDate = DateTimeTransform.convertDate(request.getParameter(REQUEST_PARAM_CHANGE_ARRIVAL_DATE));
			Time arrivalTime = DateTimeTransform.convertTimeHHMM(request.getParameter(REQUEST_PARAM_CHANGE_ARRIVAL_TIME));

			selectedFlight = defineFlightFields(selectedFlight, departureDate, departureTime, arrivalDate, arrivalTime);

			if (!InputDataValidator.isEmptyDate(departureDate, departureTime, arrivalDate, arrivalTime)) {
                if(InputDataValidator.isValidDates(departureDate, departureTime, arrivalDate, arrivalTime)) {
                    changeFlightService.changeFlightData(selectedFlight);
                    //sendEmail email about changes or cancellation
                    sendEmailService.sendEmail(selectedFlight, textEmail);
                    //attribute to notification
                    request.setAttribute(NOTIFICATION_MESSAGE_CHANGE_DATA_FLIGHT, true);
                    LOG.info("Flight #"+selectedFlight.getFlightId()+" has been changed");
                    ForwardPage.forwardPage(request, response, page);
                }
                else{
                    request.setAttribute(ERROR_INVALID_ARRIVAL, INVALID_ARRIVAL_DATE);
                    page = PAGE_CANCELLATION;
                    ForwardPage.forwardPage(request, response, page);
                }
			}
            else {
				request.setAttribute(ERROR_CHANGE_DATA_INVALID, true);
				page = PAGE_CANCELLATION;
				ForwardPage.forwardPage(request, response, page);
			}
		} catch (ServiceException e) {
            LOG.error("Change flight error " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private Flight defineFlightFields(Flight flight, Date departureDate, Time departureTime, Date arrivalDate,
			Time arrivalTime) {
		if (departureDate != null) {
			flight.setDepartureDate(departureDate);
		}
		if (departureTime != null) {
			flight.setDepartureTime(departureTime);
		}
		if (arrivalDate != null) {
			flight.setArrivalDate(arrivalDate);
		}
		if (arrivalTime != null) {
			flight.setArrivalTime(arrivalTime);
		}

		return flight;
	}




}
