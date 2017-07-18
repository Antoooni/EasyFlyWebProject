package by.htp.easyfly.servlet.command;

import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.DirectionService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.ForwardPage;

import static by.htp.easyfly.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageAction implements CommandAction{
    private DirectionService directionService;

    public ChangeLanguageAction(){
        directionService = ServiceFactory.getInstance().getDirectionService();
    }

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 String lang = request.getParameter(REQUEST_PARAM_LANGUAGE);
	     HttpSession session = request.getSession();
	     session.setAttribute(REQUEST_PARAM_LANGUAGE, lang);
	     String page=PAGE_HOME;
//	     RequestDispatcher disp = request.getRequestDispatcher(page);
//			try {
//				disp.forward(request, response);
//			} catch (ServletException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        List<FlightDirection> flightDirection = null;
        try {
            flightDirection = directionService.listDirections();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        flightDirection= (List<FlightDirection>) session.getAttribute(REQUEST_PARAM_LIST_DIRECTION);
        request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
        ForwardPage.forwardPage(request, response, page);
	}

}
