package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.easyfly.util.Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.easyfly.bin.LogonData;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.UserCreateService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class CreateNewUserAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(CreateNewUserAction.class.getName());
    private UserCreateService userCreateService;

    public CreateNewUserAction() {
        userCreateService = ServiceFactory.getInstance().getUserCreateService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String page;

        String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
        String input_email = request.getParameter(REQUEST_PARAM_USER_USER_EMAIL);

        String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
        String passwordConfirmation = request.getParameter(REQUEST_PARAM_USER_CONFIRM_PASSWORD);
        String name = request.getParameter(REQUEST_PARAM_USER_FIRST_NAME);
        String surname = request.getParameter(REQUEST_PARAM_USER_SURNAME);
        if (passwordsAreSame(password, passwordConfirmation)) {
            User user = new User();
            user.setUserName(name);
            user.setUserSurname(surname);
            user.setUserEmail(input_email);

            LogonData userLogonData = new LogonData();
            userLogonData.setPassword(Hashing.passwordEncode(password));
            userLogonData.setLogin(login);
            user.setLogonData(userLogonData);

            try {
                if (!userCreateService.checkUserExist(login)) {
                    if (!userCreateService.checkUserEmailExist(input_email)) {
                        userCreateService.createNewUser(user); // create new user
                        request.setAttribute(REQUEST_PARAM_CREATED_SUCCESSFULLY, user);
                        page = PAGE_REGISTRATION;
                        LOG.info("User " + user.getUserId() + " was created successfully");
                    } else {
                        request.setAttribute(REQUEST_PARAM_EXIST_EMAIL, true);
                        page = PAGE_REGISTRATION;
                    }
                } else {
                    request.setAttribute(REQUEST_PARAM_EXIST_USER, true);
                    page = PAGE_REGISTRATION;
                }

                ForwardPage.forwardPage(request, response, page);
            } catch (ServiceException e) {
                LOG.error("Create user error " + e);
            }
        }
        request.setAttribute(REQUEST_PARAM_DIFFERENT_PASSWORDS, true);
        page = PAGE_REGISTRATION;
        ForwardPage.forwardPage(request, response, page);
    }

    private boolean passwordsAreSame(String password, String confirmPAssword) {
        return Hashing.passwordEncode(password).equals(Hashing.passwordEncode(confirmPAssword));
    }

}
