package by.htp.easyfly.util;

import javax.naming.*;
import javax.sql.*;

public class SQLConnectionPool {

	private static InitialContext initContext;
	private static DataSource ds;

	static {
		try {
			initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("java:comp/env/jdbc/EasyFlyWebProject");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDs() {
		return ds;
	}

}
