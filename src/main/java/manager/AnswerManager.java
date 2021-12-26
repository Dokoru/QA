package manager;

import dbconnection.DBConnection;
import model.Answer;

import java.sql.*;

public class AnswerManager {
    public final Connection connection = DBConnection.getDBConnection();

//    public AnswerManager() throws SQLException, ClassNotFoundException {
//    }

    public int addAnswer(Answer answer) throws SQLException {
        int question_id = answer.questionID;
        int owner_id = answer.ownerID;
        String text = answer.text;

        String addQuery  = "INSERT INTO answers (question_id, owner_id, text) VALUES (?, ?, ?)";
        PreparedStatement addStatement = connection.prepareStatement(addQuery, Statement.RETURN_GENERATED_KEYS);
        addStatement.setInt(1, question_id);
        addStatement.setInt(2, owner_id);
        addStatement.setString(3, text);

        addStatement.executeUpdate();
        ResultSet rs = addStatement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public boolean deleteAnswer(int id) throws SQLException {
        String delQuery = "DELETE FROM answers WHERE id=?";
        PreparedStatement delStatement = connection.prepareStatement(delQuery);
        delStatement.setInt(1, id);

        return delStatement.executeUpdate() >= 1;
    }

    public boolean deleteAnswerByQuestion(int question_id) throws SQLException {
        String delQuery = "DELETE FROM answers WHERE question_id=?";
        PreparedStatement delStatement = connection.prepareStatement(delQuery);
        delStatement.setInt(1, question_id);

        return delStatement.executeUpdate() >= 1;
    }

    public boolean changeAnswerText(int id, String text) throws SQLException {
        String changeQuery = "UPDATE answers SET text=? WHERE id=?";
        PreparedStatement changeStatement = connection.prepareStatement(changeQuery);
        changeStatement.setString(1, text);
        changeStatement.setInt(2, id);

        return changeStatement.executeUpdate(changeQuery) >= 1;
    }

    public ResultSet getUserAnswer(int user_id) throws SQLException {
        String getQuery = "SELECT * FROM answers WHERE owner_id=?";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setInt(1, user_id);
        return getStatement.executeQuery();
    }

    public ResultSet getAnswerForQuestion(int question_id) throws SQLException {
        String getQuery = "SELECT * FROM answers WHERE question_id=?";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setInt(1, question_id);
        return getStatement.executeQuery();
    }

    public ResultSet getAnswerByID(int id) throws SQLException {
        String getQuery = "SELECT * FROM answers WHERE id=?";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setInt(1, id);
        return getStatement.executeQuery();
    }
}
