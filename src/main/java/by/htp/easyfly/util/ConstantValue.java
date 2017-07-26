package by.htp.easyfly.util;

public class ConstantValue {
	private ConstantValue() {
	}

	public static final String VALUE_OF_A_REQUEST_PARAMETER = "action";

//	public static final String ACTION_AUTHORISE = "login";
//	public static final String ACTION_LOGOUT = "logout";
//	public static final String ACTION_GO_HOME = "go_home";
//	public static final String ACTION_SEARCH = "go_search";
//	public static final String ACTION_REGISTRATION = "registration";
//	public static final String ACTION_CREATE_USER = "create_user";
//	public static final String ACTION_FLIGHT_INFO = "buy";
//	public static final String ACTION_BUY_TICKET = "buy_ticket";
//	public static final String ACTION_CHANGE_FLIGHT_DATE = "change_date";
//	public static final String ACTION_FLIGHT_CANCEL = "cancel_flight";
	
	public static final String REQUEST_PARAM_LANGUAGE = "language";

	public static final String REQUEST_PARAM_SESSION_USERNAME = "user_data";
	public static final String REQUEST_PARAM_SESSION_USER="user";
	public static final String REQUEST_PARAM_SESSION_FLIGHT="flight";
	public static final String REQUEST_PARAM_SESSION_FLIGHTLIST="flight_list";
	public static final String REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO = "charging_flight";
    public static final String REQUEST_PARAM_SESSION_CURRENT_PAGE = "current_page";
    public static final String REQUEST_PARAM_SESSION_CHANGED_FLIGHT="flight_changing";
    public static final String REQUEST_PARAM_SESSION_CANCELLED_FLIGHT="flight_cancellation";

    public static final String REQUEST_PARAM_COOKIE="cookie";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_LIST_DIRECTION = "list_directions";
	public static final String REQUEST_PARAM_FLIGHTS_LIST = "list_flights";
	public static final String REQUEST_PARAM_FLIGHT_INFO = "flight";
    public static final String REQUEST_PARAM_FLIGHT_DURATION="duration";
	public static final String REQUEST_PARAM_EXIST_USER = "user_exist";
	public static final String REQUEST_PARAM_EXIST_EMAIL = "email_exist";
	public static final String REQUEST_PARAM_CREATED_SUCCESSFULLY ="success";
	public static final String REQUEST_PARAM_USER_LOGGED= "logged_user";

	public static final String REQUEST_PARAM_USER_LOGIN = "create_login";
	public static final String REQUEST_PARAM_USER_USER_EMAIL = "create_email";
	public static final String REQUEST_PARAM_USER_PASSWORD = "create_password";
	public static final String REQUEST_PARAM_USER_CONFIRM_PASSWORD = "create_password1";
	public static final String REQUEST_PARAM_USER_FIRST_NAME = "name[first]";
	public static final String REQUEST_PARAM_USER_SURNAME = "name[last]";
	
	public static final String REQUEST_PARAM_PASSENGER_NAME = "passenger_name";
	public static final String REQUEST_PARAM_PASSENGER_SURNAME = "passenger_surname";
	public static final String REQUEST_PARAM_PASSENGER_MIDNAME = "passenger_midname";
	public static final String REQUEST_PARAM_PASSENGER_AGE = "passenger_age";
	public static final String REQUEST_PARAM_PASSENGER_BIRTH = "passenger_birth";
	public static final String REQUEST_PARAM_PASSENGER_SEX = "passenger_sex";
    public static final String REQUEST_PARAM_PASSENGER_EMAIL = "passenger_email";
	public static final String REQUEST_PARAM_PASSENGER_PASSPORT_NUMBER = "passenger_passport_number";
	public static final String REQUEST_PARAM_PASSENGER_PASSPORT_EXPIRY = "passenger_passport_expiry";
	public static final String REQUEST_PARAM_PASSENGER_BAGGAGE = "passenger_baggage";
	public static final String REQUEST_PARAM_TICKET_PRIMARY_BOARDING ="passenger_boarding";
	public static final String REQUEST_PARAM_TICKET_CHECKIN="passenger_checkin";
	
	public static final String REQUEST_PARAM_CHANGE_DEPARTURE_DATE="change_dept_date";
	public static final String REQUEST_PARAM_CHANGE_DEPARTURE_TIME="change_dept_time";
	public static final String REQUEST_PARAM_CHANGE_ARRIVAL_DATE="change_arr_date";
	public static final String REQUEST_PARAM_CHANGE_ARRIVAL_TIME="change_arr_time";	
	
	
	
	public static final String REQUEST_PARAM_SELECTED_FLIGHT_ID = "flight_id";

	// request parameters from main search
	public static final String REQUEST_PARAM_DIRECTION_FROM = "direction_from";
	public static final String REQUEST_PARAM_DIRECTION_TO = "direction_to";
    public static final String REQUEST_PARAM_DEPARTURE_DATE = "departure_date";
	public static final String REQUEST_PARAM_ARRIVAL_DATE = "arrival_date";

    //error statement
	public static final String REQUEST_PARAM_ERROR_MSG = "errog_msg";
    public static final String ERROR_INPUT ="input_error";
    public static final String ERROR_SAME_DIRECTION ="same_direction";
    public static final String ERROR_INVALID_DATES ="invalid_dates";
    public static final String ERROR_INVALID_ARRIVAL_DATE ="invalid_arrival";
    public static final String ERROR_BIRTHDAY_DATE="birthday_date";
    public static final String ERROR_EXPIRY_DATE="expiry_date";
    public static final String ERROR_CHANGE_DATA_INVALID ="empty_data";
    public static final String ERROR_INVALID_ARRIVAL ="invalid_arrival_date";
    public static final String INVALID_INPUT ="Inv_pass_data";
    public static final String INVALID_DIRECTION ="same direction code";
    public static final String INVALID_DATES ="date in the past";
    public static final String INVALID_ARRIVAL_DATE ="arrival date less than departure";
    public static final String INVALID_BIRTHDAY_DATE="birthday less flight date";
    public static final String INVALID_EXPIRY_DATE="expiry less arrival date";
    public static final String INVALID_CHANGE_DATA_INVALID ="empty date or time data";

    public static final String PAGE_ERROR_ACCESS_DENIED="/WEB-INF/jsp/error_authentication.jsp";
	public static final String PAGE_NO_FLIGHTS_ERROR= "/WEB-INF/jsp/error/error_no_flights.jsp";
	public static final String PAGE_DEFAULT = "/default.jsp";
    public static final String PAGE_PRINT_TICKET = "/WEB-INF/jsp/user/ticket.jsp";
	public static final String PAGE_ERROR = "/error.jsp";
	public static final String PAGE_HOME = "/WEB-INF/jsp/user/index.jsp";
	public static final String PAGE_FLIGHT_LIST = "/WEB-INF/jsp/user/flight_list.jsp";
	public static final String PAGE_FLIGHT_INFO = "/WEB-INF/jsp/user/flight.jsp";
	public static final String PAGE_FLIGHT_LIST_CHANGING = "/WEB-INF/jsp/admin/flights_change.jsp";
	public static final String PAGE_REGISTRATION = "/WEB-INF/jsp/user/registration.jsp";
	public static final String PAGE_REGISTRATION_SUCCESS = "/registration_ok.jsp";
	public static final String PAGE_DONE = "/WEB-INF/jsp/user/done.jsp";
	public static final String PAGE_DONE_CANCELLATION = "/WEB-INF/jsp/admin/cancel_done.jsp";
	public static final String PAGE_CANCELLATION = "/WEB-INF/jsp/admin/cancel.jsp";

    public static final String NOTIFICATION_MESSAGE_CHANGE_DATA_FLIGHT="CHANGE_DATA_FLIGHT";
    public static final String NOTIFICATION_MESSAGE_CANCEL_FLIGHT="CANCEL_FLIGHT";

    public static final String COOKIE_PARAM_USER_NAME="userName";

	
	
}
