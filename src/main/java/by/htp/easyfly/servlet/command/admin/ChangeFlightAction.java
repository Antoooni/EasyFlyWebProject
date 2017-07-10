package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

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
		HttpSession session = request.getSession(true);
		try {
			Flight selectedFlight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO);

			String departureDate = request.getParameter(REQUEST_PARAM_CHANGE_DEPARTURE_DATE);
			String departureTime = request.getParameter(REQUEST_PARAM_CHANGE_DEPARTURE_TIME);
			String arrivalDate = request.getParameter(REQUEST_PARAM_CHANGE_ARRIVAL_DATE);
			String arrivatTime = request.getParameter(REQUEST_PARAM_CHANGE_ARRIVAL_TIME);

			selectedFlight = defineFlightFields(selectedFlight, departureDate, departureTime, arrivalDate, arrivatTime);
			System.out.println(selectedFlight.toString());

			if (isValidDates(departureDate, departureTime, arrivalDate, arrivatTime)) {
				changeFlightService.chancheFlightData(selectedFlight);
                //send email about changes
                sendEmailService.send("This is Subject", "TLS: This is text!", "easyfly.info@gmail.com", "mazets_anton@tut.by");
				ForwardPage.forwardPage(request, response, page);
			} else {
				request.setAttribute(REQUEST_PARAM_IS_CHANGE_DATA_INVALID, true);
				page = PAGE_CANCELLATION;
				ForwardPage.forwardPage(request, response, page);
			}
		} catch (ServiceException e) {

		}
	}

	private Flight defineFlightFields(Flight flight, String departureDate, String departureTime, String arrivalDate,
			String arrivatTime) {
		if (departureDate != null) {
			flight.setDepartureDate(departureDate);
		}
		if (departureTime != null) {
			flight.setDepartureTime(departureTime);
		}
		if (arrivalDate != null) {
			flight.setArrivalDate(arrivalDate);
		}
		if (arrivatTime != null) {
			flight.setArrivalTime(arrivatTime);
		}

		return flight;
	}

	private boolean isValidDates(String departureDate, String departureTime, String arrivalDate, String arrivatTime) {
		Date departDate = null;
		Date arrDate = null;
		Date departTime = null;
		Date arrTime = null;

		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		DateFormat formatTime = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
		try {
			departDate = formatDate.parse(departureDate);
			arrDate = formatDate.parse(arrivalDate);
			departTime = formatTime.parse(departureTime);
			arrTime = formatTime.parse(arrivatTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (departDate.getTime() < arrDate.getTime()) {
			return false;
		}
		if (departDate.getTime() == arrDate.getTime()) {
			if (departTime.getTime() < arrTime.getTime()) {
				return false;
			}
		}
		if (!isEmptyFields(departureDate, departureTime, arrivalDate, arrivatTime)) {
			return false;
		}
		return true;
	}

	private boolean isEmptyFields(String departureDate, String departureTime, String arrivalDate, String arrivatTime) {
		if (departureDate == null && departureTime == null && arrivalDate == null && arrivatTime == null) {
			return true;
		} else
			return false;
	}
}
