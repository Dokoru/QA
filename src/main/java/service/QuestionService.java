package service;

import manager.QuestionManager;
import model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    private final QuestionManager questionManager = new QuestionManager();

    public Question addQuestion(int owner_id, String topic, String text) {
        int id = -1;
        try {
            id = questionManager.addQuestion(new Question(id, owner_id, topic, text));
            return new Question(id, owner_id, topic, text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteQuestion(int id) {
        try {
            return questionManager.deleteQuestion(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Question changeQuestionСontent(int id, String topic, String text) throws SQLException {
        ResultSet rs = questionManager.getQuestionByID(id);
        questionManager.changeQuestionСontent(id, topic, text);
        return new Question(id, rs.getInt("owner_id"), topic, text);
    }

    public Question changeQuestionTopic(int id, String topic) throws SQLException {
        ResultSet rs = questionManager.getQuestionByID(id);
        questionManager.changeQuestionTopic(id, topic);
        return new Question(id, rs.getInt("owner_id"), topic, rs.getString("text"));
    }

    public Question changeQuestionText(int id, String text) throws SQLException {
        ResultSet rs = questionManager.getQuestionByID(id);
        questionManager.changeQuestionText(id, text);
        return new Question(id, rs.getInt("owner_id"), rs.getString("topic"), text);
    }

    public Question getQuestionByID(int id) throws SQLException {
        ResultSet rs = questionManager.getQuestionByID(id);
        rs.next();
        return new Question(rs.getInt("id"),
                rs.getInt("owner_id"),
                rs.getString("topic"),
                rs.getString("text"));
    }

    public List<Question> getQuestionByContent(String content) {
        List<Question> questions = new ArrayList<>();
        try {
            ResultSet rs = questionManager.getQuestionByContent(content);
            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"),
                        rs.getInt("owner_id"),
                        rs.getString("topic"),
                        rs.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;

    }

    public List<Question> getQuestionByAuthor(int author_id) {
        List<Question> questions = new ArrayList<>();
        try {
            ResultSet rs = questionManager.getQuestionByAuthor(author_id);
            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"),
                        rs.getInt("owner_id"),
                        rs.getString("topic"),
                        rs.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            ResultSet rs = questionManager.getAllQuestions();
            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"),
                        rs.getInt("owner_id"),
                        rs.getString("topic"),
                        rs.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;

    }
}
