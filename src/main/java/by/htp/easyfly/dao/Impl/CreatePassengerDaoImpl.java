package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.easyfly.dao.CreatePassengerDao;
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
				ps.setString(3, passenger.getMiddleName());
				ps.setString(4, passenger.getDateOfBirth());
				ps.setInt(5, passenger.getAge());
				ps.setString(6, passenger.getSex());
				ps.setString(7, passenger.getPassportId());
				ps.setDate(8, passenger.getPassportExpiry());
				ps.setString(9, passenger.getBaggage().toString());
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
