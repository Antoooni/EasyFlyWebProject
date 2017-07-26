package by.htp.easyfly.servlet.command.user;

import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.util.ForwardPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.htp.easyfly.util.ConstantValue.*;

/**
 * Created by Ayumazec on 26.07.2017.
 */
public class PrintTicketAction implements CommandAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String page = PAGE_PRINT_TICKET;
        ForwardPage.forwardPage(request, response, page);
    }
}
