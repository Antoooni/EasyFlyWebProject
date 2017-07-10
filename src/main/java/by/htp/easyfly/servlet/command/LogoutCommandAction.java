package by.htp.easyfly.servlet.command;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.servlet.ForwardPage;

public class LogoutCommandAction implements CommandAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		session.invalidate();
		String page = PAGE_DEFAULT;
		ForwardPage.forwardPage(request, response, page);
	}

}
