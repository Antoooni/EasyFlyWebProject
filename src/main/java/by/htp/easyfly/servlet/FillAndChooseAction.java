package by.htp.easyfly.servlet;

import java.util.HashMap;

import by.htp.easyfly.servlet.command.ChangeLanguageAction;
import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.servlet.command.GoHomeAction;
import by.htp.easyfly.servlet.command.LoginCommandAction;
import by.htp.easyfly.servlet.command.LogoutCommandAction;
import by.htp.easyfly.servlet.command.admin.CancelFlightAction;
import by.htp.easyfly.servlet.command.admin.ChangeFlightAction;
import by.htp.easyfly.servlet.command.admin.GoToCancellation;
import by.htp.easyfly.servlet.command.user.*;

public final class FillAndChooseAction {
	public HashMap<String, CommandAction> map() {
		HashMap<String, CommandAction> actionsMap = new HashMap<String, CommandAction>();
		actionsMap.put(Action.login.toString(), new LoginCommandAction());
		actionsMap.put(Action.logout.toString(), new LogoutCommandAction());
		actionsMap.put(Action.go_home.toString(), new GoHomeAction());
		actionsMap.put(Action.go_search.toString(), new SearchFlightAction());
		actionsMap.put(Action.registration.toString(), new RegistrationAction());
		actionsMap.put(Action.create_user.toString(), new CreateNewUserAction());
		actionsMap.put(Action.buy.toString(), new FlightInfoAction());
		actionsMap.put(Action.buy_ticket.toString(), new BuyTicketAction());
		actionsMap.put(Action.change_flight_data.toString(), new ChangeFlightAction());
		actionsMap.put(Action.cancel_flight.toString(), new CancelFlightAction());
		actionsMap.put(Action.change_language.toString(), new ChangeLanguageAction());
		actionsMap.put(Action.change_flight.toString(), new GoToCancellation());
        actionsMap.put(Action.print.toString(), new PrintTicketAction());
		
		return actionsMap;
	}
}
