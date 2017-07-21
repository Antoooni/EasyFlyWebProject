package by.htp.easyfly.dao.Impl;


import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.SearchChangedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.SQLConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.htp.easyfly.util.SQLConstantValue.*;

/**
 * Created by Ayumazec on 20.07.2017.
 */
public class SearchChangedFlightDaoImpl implements SearchChangedFlightDao {
    @Override
    public Flight searchChangedFlight(User user)throws DAOException {
        Flight selectedChangedFlight = null;

        try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SEARCH_CHANGED_FLIGHT);
            ps.setInt(1, user.getUserId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                selectedChangedFlight = new Flight();
                selectedChangedFlight.setFlightId(rs.getInt(1));
                selectedChangedFlight.setDepartureDate(DateTimeTransform.convertDate(rs.getString(2)));
                selectedChangedFlight.setDepartureTime(DateTimeTransform.convertTimeHHMMSS(rs.getString(3)));
                selectedChangedFlight.setArrivalDate(DateTimeTransform.convertDate(rs.getString(4)));
                selectedChangedFlight.setArrivalTime(DateTimeTransform.convertTimeHHMMSS(rs.getString(5)));
                selectedChangedFlight.setFlightCode(rs.getString(6));
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in method searchChangedFlight(): " + e);
        }
        return selectedChangedFlight;
    }

    @Override
    public Flight searchCancelledFlight(User user) throws DAOException {
        Flight selectedChangedFlight = null;

        try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SEARCH_CANCELLED_FLIGHT);
            ps.setInt(1, user.getUserId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                selectedChangedFlight = new Flight();
                selectedChangedFlight.setFlightId(rs.getInt(1));
                selectedChangedFlight.setDepartureDate(DateTimeTransform.convertDate(rs.getString(2)));
                selectedChangedFlight.setDepartureTime(DateTimeTransform.convertTimeHHMMSS(rs.getString(3)));
                selectedChangedFlight.setArrivalDate(DateTimeTransform.convertDate(rs.getString(4)));
                selectedChangedFlight.setArrivalTime(DateTimeTransform.convertTimeHHMMSS(rs.getString(5)));
                selectedChangedFlight.setFlightCode(rs.getString(6));
                selectedChangedFlight.setDepartureAirport(rs.getString(8));
                selectedChangedFlight.setArrivalAirport(rs.getString(9));
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in method searchCancelledFlight(): " + e);
        }
        return selectedChangedFlight;
    }
}
