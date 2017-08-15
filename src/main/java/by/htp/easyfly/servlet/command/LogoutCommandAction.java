package by.htp.easyfly.servlet.command;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.util.ForwardPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutCommandAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(LogoutCommandAction.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
        User user= (User) session.getAttribute(REQUEST_PARAM_SESSION_USER);
        LOG.info(user.getUserName()+" has been logged-out");
		session.invalidate();
		String page = PAGE_DEFAULT;
		ForwardPage.forwardPage(request, response, page);
	}

}
