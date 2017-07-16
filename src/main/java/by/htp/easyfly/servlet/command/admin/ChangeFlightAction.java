package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.ChangeFlightService;
import by.htp.easyfly.service.SendEmailService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.util.ConvertingValues;

public class ChangeFlightAction implements CommandAction {
	private ChangeFlightService changeFlightService;
    private SendEmailService sendEmailService;

	public ChangeFlightAction() {
		changeFlightService = ServiceFactory.getInstance().getChangeFlightService();
        sendEmailService = ServiceFactory.getInstance().getSendEmailService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_DONE_CANCELLATION;
        String textEmail= "Dear customer, you flight data has been changed. Please check you data before check-in.  Best regards, EasyFly.";
		HttpSession session = request.getSession(true);
		try {
			Flight selectedFlight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO);

			Date departureDate = ConvertingValues.convertDate(request.getParameter(REQUEST_PARAM_CHANGE_DEPARTURE_DATE));
			Time departureTime = ConvertingValues.convertTime(request.getParameter(REQUEST_PARAM_CHANGE_DEPARTURE_TIME));
			Date arrivalDate = ConvertingValues.convertDate(request.getParameter(REQUEST_PARAM_CHANGE_ARRIVAL_DATE));
			Time arrivalTime = ConvertingValues.convertTime(request.getParameter(REQUEST_PARAM_CHANGE_ARRIVAL_TIME));

			selectedFlight = defineFlightFields(selectedFlight, departureDate, departureTime, arrivalDate, arrivalTime);
			System.out.println(selectedFlight.toString());

			if (isValidDates(departureDate, departureTime, arrivalDate, arrivalTime)) {
				changeFlightService.changeFlightData(selectedFlight);
                //sendEmail email about changes or cancellation
                sendEmailService.sendEmail(selectedFlight,textEmail);
                //attribute to notification
                request.setAttribute(NOTIFICATION_MESSAGE_CHANGE_DATA_FLIGHT, true);
				ForwardPage.forwardPage(request, response, page);
			} else {
				request.setAttribute(REQUEST_PARAM_IS_CHANGE_DATA_INVALID, true);
				page = PAGE_CANCELLATION;
				ForwardPage.forwardPage(request, response, page);
			}
		} catch (ServiceException e) {

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

	private boolean isValidDates(Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {

		if (departureDate.getTime() < arrivalDate.getTime()) {
			return false;
		}
		if (departureDate.getTime() == arrivalDate.getTime()) {
			if (departureTime.getTime() < arrivalTime.getTime()) {
				return false;
			}
		}
		if (!isEmptyFields(departureDate, departureTime, arrivalDate, arrivalTime)) {
			return false;
		}
		return true;
	}

	private boolean isEmptyFields(Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {
		if (departureDate == null && departureTime == null && arrivalDate == null && arrivalTime == null) {
			return true;
		} else
			return false;
	}
}
