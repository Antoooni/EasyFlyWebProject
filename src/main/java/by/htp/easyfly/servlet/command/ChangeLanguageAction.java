package by.htp.easyfly.servlet.command;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.DirectionService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.ForwardPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.htp.easyfly.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(ChangeLanguageAction.class.getName());

    private DirectionService directionService;

    public ChangeLanguageAction() {
        directionService = ServiceFactory.getInstance().getDirectionService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter(REQUEST_PARAM_LANGUAGE);
        HttpSession session = request.getSession();

        session.setAttribute(REQUEST_PARAM_LANGUAGE, lang);
        String page = PAGE_HOME;
        // get Flight direction
        List<FlightDirection> flightDirection;
        try {
            flightDirection = directionService.listDirections();
        } catch (ServiceException e) {
            LOG.error("directionService error " + e);
        }
        flightDirection = (List<FlightDirection>) session.getAttribute(REQUEST_PARAM_LIST_DIRECTION);
        request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);

        //get flight list
        List<Flight> listFlight= (List<Flight>) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHTLIST);
        request.setAttribute(REQUEST_PARAM_FLIGHTS_LIST , listFlight);
        //get flight
        Flight flight= (Flight) session.getAttribute(REQUEST_PARAM_FLIGHT_INFO);
        if (null!=flight) {
            request.setAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO, flight);
            int[] duration;
            duration = DateTimeTransform.duration(flight.getDepartureDate(), flight.getDepartureTime(), flight.getArrivalDate(), flight.getArrivalTime());
            //get duration
            request.setAttribute(REQUEST_PARAM_FLIGHT_DURATION, duration);
        }
        LOG.info("Language was switched on "+lang);
        ForwardPage.forwardPage(request, response, (String) session.getAttribute(REQUEST_PARAM_SESSION_CURRENT_PAGE));
    }

}
