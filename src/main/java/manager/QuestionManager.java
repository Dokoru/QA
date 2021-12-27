package manager;

import dbconnection.DBConnection;
import model.Question;

import java.sql.*;

public class QuestionManager {

    public final Connection connection = DBConnection.getDBConnection();

    public int addQuestion(Question question) throws SQLException {
        int ownerID = question.ownerID;
        String topic = question.topic;
        String text = question.text;

        String addQuery  = "INSERT INTO questions (owner_id, topic, text) VALUES (?, ?, ?)";
        PreparedStatement addStatement = connection.prepareStatement(addQuery, Statement.RETURN_GENERATED_KEYS);
        addStatement.setInt(1, ownerID);
        addStatement.setString(2, topic);
        addStatement.setString(3, text);

        addStatement.executeUpdate();
        ResultSet rs = addStatement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public boolean deleteQuestion(int id) throws SQLException, ClassNotFoundException {
        String delQuery = "DELETE FROM questions WHERE id=?";
        PreparedStatement delStatement = connection.prepareStatement(delQuery);
        delStatement.setInt(1, id);

        AnswerManager am = new AnswerManager();
        am.deleteAnswerByQuestion(id);

        return delStatement.executeUpdate() >= 1;
    }

    public boolean changeQuestionСontent(int id, String topic, String text) throws SQLException {
        String changeQuery = "UPDATE questions SET topic=?, text=? WHERE id=?";
        PreparedStatement changeStatement = connection.prepareStatement(changeQuery);
        changeStatement.setString(1, topic);
        changeStatement.setString(2, text);
        changeStatement.setInt(3, id);

        return changeStatement.executeUpdate(changeQuery) >= 1;
    }

    public boolean changeQuestionTopic(int id, String topic) throws SQLException {
        String changeQuery = "UPDATE questions SET topic=? WHERE id=?";
        PreparedStatement changeStatement = connection.prepareStatement(changeQuery);
        changeStatement.setString(1, topic);
        changeStatement.setInt(2, id);

        return changeStatement.executeUpdate(changeQuery) >= 1;
    }

    public boolean changeQuestionText(int id, String text) throws SQLException {
        String changeQuery = "UPDATE questions SET text=? WHERE id=?";
        PreparedStatement changeStatement = connection.prepareStatement(changeQuery);
        changeStatement.setString(1, text);
        changeStatement.setInt(2, id);

        return changeStatement.executeUpdate(changeQuery) >= 1;
    }

    public ResultSet getQuestionByID(int id) throws SQLException {
        String getQuery = "SELECT * FROM questions WHERE id=?";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setInt(1, id);
        return getStatement.executeQuery();
    }

    public ResultSet getQuestionByContent(String content) throws SQLException {
        /*String getQuery = "SELECT * FROM question WHERE topic LIKE '%?%' OR text LIKE '%?%'";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setString(1, content);
        getStatement.setString(2, content);
        return getStatement.executeQuery();*/
        String getQuery = "SELECT * FROM questions WHERE topic LIKE '%" + content + "%' OR text LIKE '%" + content + "%'";
        Statement getStatement = connection.createStatement();
        ResultSet rs = getStatement.executeQuery(getQuery);
        return rs;
    }

    public ResultSet getQuestionByAuthor(int user_id) throws SQLException {
        String getQuery = "SELECT * FROM questions WHERE owner_id=?";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setInt(1, user_id);
        ResultSet rs = getStatement.executeQuery();
        return rs;
    }

    public ResultSet getAllQuestions() throws SQLException {
        String getQuery = "SELECT * FROM questions";
        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        return getStatement.executeQuery();
    }
}
