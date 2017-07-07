package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bin.FlightDirection;
import by.htp.exception.ServiceException;
import by.htp.service.DirectionService;
import by.htp.service.DirectionServiceImpl;
import by.htp.service.factory.ServiceFactory;
import by.htp.servlet.ForwardPage;

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
			// вывести список направлений dropdown
			request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
			page = PAGE_HOME;

			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
