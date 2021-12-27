package service;

import manager.UserManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    private final UserManager userManager = new UserManager();

    public int authorization(String login, String password) {
        ResultSet rs = null;
        try {
            rs = userManager.authorization(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.next()) return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int registration(String login, String password) {
        if (login.length() >= 3 & password.length() >= 8){
            try {
                return userManager.registration(login, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
