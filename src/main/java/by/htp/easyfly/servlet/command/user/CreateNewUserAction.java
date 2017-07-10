package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.easyfly.bin.LogonData;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.UserCreateService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class CreateNewUserAction implements CommandAction {
	private UserCreateService userCreateService;
	// private ServiceFactory serviceFactory = new ServiceFactory();

	public CreateNewUserAction() {
		userCreateService = ServiceFactory.getInstance().getUserCreateService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_REGISTRATION_SUCCESS;

		String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
		String input_email = request.getParameter(REQUEST_PARAM_USER_USER_EMAIL);

		String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
		String passwordConfirmation = request.getParameter(REQUEST_PARAM_USER_CONFIRM_PASSWORD);
		String name = request.getParameter(REQUEST_PARAM_USER_FIRST_NAME);
		String surname = request.getParameter(REQUEST_PARAM_USER_SURNAME);

		User user = new User();
		user.setUserName(name);
		user.setUserSurname(surname);
		user.setUserEmail(input_email);

		LogonData userLogonData = new LogonData();
		userLogonData.setPassword(password);
		userLogonData.setLogin(login);
		user.setLogonData(userLogonData);

		try {
			if (userCreateService.checkUserExist(login) == false) {

				if (userCreateService.checkUserEmailExist(input_email) == false) {
					userCreateService.createNewUser(user); // create new user
					request.setAttribute(REQUEST_PARAM_CREATED_SUCCESSFULLY, user);
					page = PAGE_REGISTRATION;
					System.out.println("User created successfully");
				} else {

					boolean existEmail = true;
					request.setAttribute(REQUEST_PARAM_EXIST_EMAIL, existEmail);
					page = PAGE_REGISTRATION;
					System.out.println("This email is already busy");
				}
			} else {
				boolean existUser = true;
				request.setAttribute(REQUEST_PARAM_EXIST_USER, existUser);
				page = PAGE_REGISTRATION;
				System.out.println("This user is already exist");
			}
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
