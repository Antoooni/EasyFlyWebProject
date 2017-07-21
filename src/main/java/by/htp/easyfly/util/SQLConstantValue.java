package by.htp.easyfly.util;

public interface SQLConstantValue {
	
	String SQL_STATEMENT_DIRECTION_CODE = "select distinct direction.direction_code from direction where direction.direction_city = ?;";
	String SQL_STATEMENT_USER_NAME = "select user_name, user_surname, role , user.user_id from user join logon_data on user.user_id = logon_data.user_id where logon_data.login=? and logon_data.password=?;";
	String SQL_STATEMENT_ALL_DIRECTIONS = "select distinct   direction.direction_city from direction;";
	String SQL_STATEMENT_SEARCH_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time, t2.flight_id, t2.flight_code from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id where  n1.direction_code=? and n2.direction_code=? and t2.departure_date=? and t2.arrival_date=? and t2.is_canceled is null; ";
	String SQL_STATEMENT_SEARCH_CHANGED_FLIGHT="select  t2.flight_id, t2.departure_date, t2.departure_time, t2.arrival_date, t2.arrival_time,t2.flight_code, t2.changed from flight as t2 join ticket as n1 on n1.flight_id = t2.flight_id join user as n2 on n2.user_id = n1.user_id where  n2.user_id=? and t2.changed is not null";
    String SQL_STATEMENT_SEARCH_CANCELLED_FLIGHT="select  t2.flight_id, t2.departure_date, t2.departure_time, t2.arrival_date, t2.arrival_time,t2.flight_code, t2.is_canceled, t3.direction_name, t4.direction_name from flight as t2 join ticket as n1 on n1.flight_id = t2.flight_id join user as n2 on n2.user_id = n1.user_id join direction as t3 on t3.direction_id=t2.departure_id join direction as t4 on t4.direction_id=t2.arrival_id where  n2.user_id=? and t2.is_canceled is not null";
    String SQL_STATEMENT_SEARCH_SELECTED_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time, t2.flight_id, n3.airplane_name, t2.flight_code  from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id join airplane as n3 on t2.airplane_id=n3.airplane_id  where  t2.flight_id=? ";
	String SQL_STATEMENT_CREATE_USER_LOGON_DATA = "INSERT INTO logon_data (login, password) VALUES (?, ?);";
	String SQL_STATEMENT_CREATE_USER_DATA="INSERT INTO user (user_id, user_name, user_surname, user_email, ticket_list_id) select  user_id , ?, ?, ?, null from logon_data where login = ?";
	String SQL_STATEMENT_IF_USER_LOGIN_EXIST = "select count(*) from logon_data where login=?;";
	String SQL_STATEMENT_IF_USER_EMAIL_EXIST="select count(*) from user where user_email=?;";
	String SQL_STATEMENT_CREATE_PASSENGER ="INSERT INTO passenger (name, surname, middlename, birthday, age, gender, passport_number, passport_expiry, baggage, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	String SQL_STATEMENT_CREATE_TICKET = "INSERT INTO ticket (flight_id, passenger_id, primary_boarding, online_checkin, total_amount) VALUES (?, ?, ?, ?, ?);";
	String SQL_STATEMENT_CREATE_TICKET_LIST ="INSERT INTO ticket_list (ticket_list_id, ticket_id, user_id) VALUES (?,?,?);";
	String SQL_STATEMENT_CREATE_TICKET_IF_TICKETLIST_EXISTS="select count(*) from ticket_list where user_id=?";
	String SQL_STATEMENT_CREATE_TICKET_UPDATE_USER=" UPDATE user SET ticket_list_id=? WHERE  user_id=?;";
	String SQL_STATEMENT_CREATE_TICKET_SEARCH_TICKET_LIST=" select ticket_list_id from ticket_list where user_id=?";
	String SQL_STATEMENT_CREATE_TICKET_MAX_LIST="select MAX(ticket_list_id) from ticket_list";
	//change FLIGHT date & time data
	String SQL_STATEMENT_CHANGE_FLIGHT_DATA="UPDATE flight SET departure_date=?, departure_time=?, arrival_date=?, arrival_time=? WHERE  flight_id=?;";
	String SQL_STATEMENT_CANCEL_FLIGHT="UPDATE flight SET cancellation='cancelled' WHERE  flight_id=?;";
    String SQL_STATEMENT_SELECT_USER_CHANGED_FLIGHT="select t2.user_id, user_name, user_surname, user_email from user as t2 join ticket as n1 on n1.user_id = t2.user_id join flight as n2 on n2.flight_id = n1.flight_id where  n2.flight_id=?";
}
