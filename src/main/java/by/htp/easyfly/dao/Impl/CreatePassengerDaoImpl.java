package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.*;
import java.util.Date;

import by.htp.easyfly.dao.CreatePassengerDao;
import by.htp.easyfly.util.DateTimeTransform;
import com.mysql.jdbc.Statement;

import by.htp.easyfly.bin.Passenger;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

public class CreatePassengerDaoImpl implements CreatePassengerDao {
	Connection connection;

	@Override
	public int passenger(Passenger passenger) throws DAOException {
		PreparedStatement ps;
		int key = 0;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_PASSENGER, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, passenger.getName());
				ps.setString(2, passenger.getSurname());
                if(null!=passenger.getMiddleName()) ps.setString(3, passenger.getMiddleName());
                    else  ps.setString(3, null);
				ps.setTimestamp(4, new Timestamp(passenger.getDateOfBirth().getTime()));// String.valueOf(passenger.getDateOfBirth()));
				ps.setInt(5, passenger.getAge());
				ps.setString(6, passenger.getSex());
				ps.setString(7, passenger.getPassportId());
				ps.setTimestamp(8, new Timestamp(passenger.getPassportExpiry().getTime()));
				ps.setString(9, passenger.getBaggage().toString());
                ps.setString(10, passenger.getEmail());
				ps.executeUpdate();

				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					// Retrieve the auto generated key(s).
					key = rs.getInt(1);
					System.out.println("id in sql " + key);
				}
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method passenger(): " + e);
		}

		return key;
	}

}
