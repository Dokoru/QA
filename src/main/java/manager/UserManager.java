package manager;

import dbconnection.DBConnection;

import java.sql.*;

public class UserManager {

    public final Connection connection = DBConnection.getDBConnection();

    public ResultSet authorization(String login, String password) throws SQLException {
        String authQuery  = "SELECT * FROM users WHERE login=? AND password=?";
        PreparedStatement authStatement = connection.prepareStatement(authQuery);
        authStatement.setString(1, login);
        authStatement.setString(2, password);
        ResultSet rs = authStatement.executeQuery();
        //return rs.next() ? rs.getInt("id"): -1;
        return rs;
    }

    public int registration(String login, String password) throws SQLException {
        String existQuery = "SELECT * FROM users WHERE login=?";
        PreparedStatement existStatement = connection.prepareStatement(existQuery);
        existStatement.setString(1, login);
        ResultSet exist = existStatement.executeQuery();

        if (exist.next()) return -1;

        String regQuery  = "INSERT INTO users (login,password) VALUES (?, ?)";
        PreparedStatement regStatement = connection.prepareStatement(regQuery, Statement.RETURN_GENERATED_KEYS);
        regStatement.setString(1, login);
        regStatement.setString(2, password);
        regStatement.executeUpdate();
        ResultSet rs = regStatement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public ResultSet getIDByLogin (String login) throws SQLException {
        String getQuery = "SELECT * FROM users WHERE login=?";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setString(1, login);
        return getStatement.executeQuery();
    }
}
