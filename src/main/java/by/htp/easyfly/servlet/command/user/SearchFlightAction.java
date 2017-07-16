package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.service.DirectionCodeService;
import by.htp.easyfly.service.FlightListService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.util.ConvertingValues;
import by.htp.easyfly.util.InputDataValidator;

public class SearchFlightAction implements CommandAction {
	// ServiceFactory serviceFactory = new ServiceFactory();

	private FlightListService flightListService;
	private DirectionCodeService directionCodeService;

	public SearchFlightAction() {
		flightListService = ServiceFactory.getInstance().getFlightListService();
		directionCodeService = ServiceFactory.getInstance().getDirectionCodeService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		String page = request.getParameter(PAGE_FLIGHT_LIST);
		String departureCity = request.getParameter(REQUEST_PARAM_DIRECTION_FROM);
		String arrivalCity = request.getParameter(REQUEST_PARAM_DIRECTION_TO);
        if(null!=departureCity || null!=arrivalCity) {
            Date departureDateSQL = ConvertingValues.convertDate(request.getParameter(REQUEST_PARAM_DEPARTURE_DATE));
            Date arrivalDateSQL = ConvertingValues.convertDate(request.getParameter(REQUEST_PARAM_ARRIVAL_DATE));

            // String userRole=request.getParameter(REQUEST_PARAM_SESSION_USERNAME);
            if(!InputDataValidator.dateInPast(departureDateSQL, arrivalDateSQL)){
                if(!InputDataValidator.isArrivalBeforeDeparture(departureDateSQL,arrivalDateSQL)) {
                    try {
                        String departureCode = null;
                        String arrivalCode = null;
                        //convert departure city to city code
                        departureCode = directionCodeService.directionCode(departureCity);
                        //convert arrival city to city code
                        arrivalCode = directionCodeService.directionCode(arrivalCity);

                        List<Flight> listFlight = flightListService.flightList(departureCode, arrivalCode, departureDateSQL,
                                arrivalDateSQL);

                        request.setAttribute(REQUEST_PARAM_FLIGHTS_LIST, listFlight);
                        session.setAttribute(REQUEST_PARAM_SESSION_FLIGHTLIST, listFlight);
                        User user = (User) session.getAttribute(REQUEST_PARAM_SESSION_USER);
                        if (user == null) {
                            page = PAGE_FLIGHT_LIST;
                        } else if (user.getRole() == null) {
                            page = PAGE_FLIGHT_LIST;
                        } else {
                            page = PAGE_FLIGHT_LIST_CHANGING;
//			page = PAGE_NO_FLIGHTS_ERROR;
                            request.setAttribute(REQUEST_PARAM_ERROR_MSG, "error temp");
                        }
                        ForwardPage.forwardPage(request, response, page);

                    } catch (Exception e) {
                    }
                }
                else{
                    page = PAGE_HOME;
                    request.setAttribute(ERROR_INVALID_ARRIVAL_DATE, INVALID_ARRIVAL_DATE);
                    ForwardPage.forwardPage(request, response, page);
                }
            }
            else {
                page = PAGE_HOME;
                request.setAttribute(ERROR_INVALID_DATES, INVALID_DATES);
                ForwardPage.forwardPage(request, response, page);
            }
        }
        else{
            page=PAGE_HOME;
            request.setAttribute(ERROR_SAME_DIRECTION,INVALID_DIRECTION);
            ForwardPage.forwardPage(request, response, page);
        }
	}

}
