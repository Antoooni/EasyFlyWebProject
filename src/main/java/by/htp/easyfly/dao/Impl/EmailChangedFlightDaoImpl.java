package by.htp.easyfly.dao.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.EmailChangedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.util.SQLConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.htp.easyfly.util.SQLConstantValue.*;

/**
 * Created by Ayumazec on 07.07.2017.
 */
public class EmailChangedFlightDaoImpl implements EmailChangedFlightDao {
    @Override
    public List<User> selectUserChangedFlight(Flight flight) throws DAOException {
        User user=null;
        List<User> userList= new ArrayList<User>();
        int i=0;
        try (Connection connection = SQLConnectionPool.getDs().getConnection()){
            PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SELECT_USER_CHANGED_FLIGHT);
            ps.setInt(1, flight.getFlightId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user= new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getNString(2));
                user.setUserSurname(rs.getNString(3));
                user.setUserEmail(rs.getNString(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in method directionCode(): " + e);
        }
        return userList;
    }
}
