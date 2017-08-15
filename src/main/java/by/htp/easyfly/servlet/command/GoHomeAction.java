package by.htp.easyfly.servlet.command;

import static by.htp.easyfly.util.ConstantValue.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.Cookie.CookieController;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.DirectionService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.ForwardPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoHomeAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(GoHomeAction.class.getName());

    protected DirectionService directionService;

    public GoHomeAction() {
        directionService = ServiceFactory.getInstance().getDirectionService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CookieController cookieController = new CookieController();
        try {
            session.setAttribute(REQUEST_PARAM_LANGUAGE, "en_EN"); //default language
            String page = PAGE_HOME;
            session.setAttribute(REQUEST_PARAM_SESSION_CURRENT_PAGE, page);
            LOG.info("AZAZAZ ");
            List<FlightDirection> flightDirection = directionService.listDirections();
            request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
            session.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);

            cookieController.doGet(request, response);
            ForwardPage.forwardPage(request, response, page);
        } catch (ServiceException e) {
            LOG.error("Error directionService " +e);
        } catch (ServletException e) {
            LOG.error("Error cookieController " +e);
        } catch (IOException e) {
            LOG.error("Error cookieController IO" +e);
        }
    }

}
