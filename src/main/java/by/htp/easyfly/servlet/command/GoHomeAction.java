package by.htp.easyfly.servlet.command;

import static by.htp.easyfly.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.DirectionService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;

public class GoHomeAction implements CommandAction {
	// ServiceFactory serviceFactory = new ServiceFactory();
	private DirectionService directionService;

	public GoHomeAction() {

		directionService = ServiceFactory.getInstance().getDirectionService();

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			session.setAttribute(REQUEST_PARAM_LANGUAGE, "en_EN");
			String page = PAGE_DEFAULT;
			List<FlightDirection> flightDirection = directionService.listDirections();
			request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
			page = PAGE_HOME;

			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
