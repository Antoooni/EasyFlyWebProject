package by.htp.dao;

import by.htp.bin.Flight;
import by.htp.bin.User;
import by.htp.exception.DAOException;
import by.htp.util.SQLConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.htp.util.SQLConstantValue.*;

/**
 * Created by Ayumazec on 07.07.2017.
 */
public class EmailChangedFlightDaoImpl implements EmailChangedFlightDao {
    @Override
    public List<User> emailData(Flight flight) throws DAOException {
        List<User> userListSelected = new ArrayList<User>();
        User user=null;
        int i=0;

        try (Connection connection = SQLConnectionPool.getDs().getConnection()){
            PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_EMAIL_DATA);
            ps.setInt(1, flight.getFlightId()); // ��� ��� PreparedStatement
            ResultSet rs = ps.executeQuery(); // ��� ��� PreparedStatement
            while (rs.next()) {

                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserSurname(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                userListSelected.add(i, new User());
                i++;

            }
        } catch (SQLException e) {

            throw new DAOException("SQLException in method emailData(): " + e);
        }
        return userListSelected;
    }
}
