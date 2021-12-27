package service;

import manager.AnswerManager;
import model.Answer;
import model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerService {
    private final AnswerManager answerManager = new AnswerManager();

    public Answer addAnswer(int question_id, int owner_id, String text) {
        int id = -1;
        Answer answer = new Answer(id, question_id, owner_id, text);
        try {
            id = answerManager.addAnswer(answer);
            return new Answer(id, question_id, owner_id, text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteAnswer(int id) {
        try {
            return answerManager.deleteAnswer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Answer changeAnswerText(int id, String text) throws SQLException {
        ResultSet rs = answerManager.getAnswerByID(id);
        answerManager.changeAnswerText(id, text);
        return new Answer(id, rs.getInt("question_id"), rs.getInt("owner_id"), text);
    }

    public List<Answer> getUserAnswer(int user_id) throws SQLException {
        List<Answer> answers = new ArrayList<>();
        try {
            ResultSet rs = answerManager.getUserAnswer(user_id);
            while (rs.next()) {
                answers.add(new Answer(rs.getInt("id"),
                        rs.getInt("question_id"),
                        rs.getInt("owner_id"),
                        rs.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

    public List<Answer> getAnswerForQuestion(int guestion_id) throws SQLException {
        List<Answer> answers = new ArrayList<>();
        try {
            ResultSet rs = answerManager.getAnswerForQuestion(guestion_id);
            while (rs.next()) {
                answers.add(new Answer(rs.getInt("id"),
                        rs.getInt("question_id"),
                        rs.getInt("owner_id"),
                        rs.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

    public Answer getAnswerByID(int answer_id) throws SQLException {
        ResultSet rs = answerManager.getAnswerByID(answer_id);
        rs.next();
        return new Answer(rs.getInt("id"),
                rs.getInt("question_id"),
                rs.getInt("owner_id"),
                rs.getString("text"));
    }
}
