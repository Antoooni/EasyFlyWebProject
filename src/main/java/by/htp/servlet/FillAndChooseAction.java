package by.htp.servlet;

import static by.htp.util.ConstantValue.*;

import java.util.HashMap;

import by.htp.servlet.command.ChangeLanguageAction;
import by.htp.servlet.command.CommandAction;
import by.htp.servlet.command.GoHomeAction;
import by.htp.servlet.command.LoginCommandAction;
import by.htp.servlet.command.LogoutCommandAction;
import by.htp.servlet.command.admin.CancelFlightAction;
import by.htp.servlet.command.admin.ChangeFlightAction;
import by.htp.servlet.command.admin.GoToCancellation;
import by.htp.servlet.command.user.BuyTicketAction;
import by.htp.servlet.command.user.CreateNewUserAction;
import by.htp.servlet.command.user.FlightInfoAction;
import by.htp.servlet.command.user.RegistrationAction;
import by.htp.servlet.command.user.SearchFlightAction;

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
		actionsMap.put (Action.change_flight.toString(), new GoToCancellation());
		
		return actionsMap;
	}
}
