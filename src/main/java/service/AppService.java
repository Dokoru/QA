package service;

import model.Answer;
import model.Question;

import java.sql.SQLException;
import java.util.List;

public class AppService {
    private UserService userService = new UserService();
    private QuestionService questionService = new QuestionService();
    private AnswerService answerService = new AnswerService();

    private int currentUserID = -1;

    public boolean authorization(String login, String password) {
        currentUserID = userService.authorization(login, password);
        return currentUserID > -1;
    }

    public boolean registration(String login, String password) {
        currentUserID = userService.registration(login, password);
        return currentUserID > -1;
    }

    public void out() {
        currentUserID = -1;
    }

    public void addQuestion(String topic, String text) {
        questionService.addQuestion(currentUserID, topic, text);
    }

    public List<Question> getUserQuestions() {
        return questionService.getQuestionByAuthor(currentUserID);
    }

    public List<Question> getQuestionByContent(String content) {
        return questionService.getQuestionByContent(content);
    }

    public List<Question> getAllQuestion() {
        return questionService.getAllQuestions();
    }

    public List<Answer> getUserAnswer() {
        try {
            return answerService.getUserAnswer(currentUserID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAnswer(int question_id, String answer) {
        answerService.addAnswer(question_id, currentUserID, answer);
    }

    public void deleteQuestion(int question_id) {
        try {
            Question question = questionService.getQuestionByID(question_id);
            int owner_id = question.ownerID;
            if (owner_id == currentUserID) {
                questionService.deleteQuestion(question_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAnswer(int answer_id) {
        try {
            Answer answer = answerService.getAnswerByID(answer_id);
            int owner_id = answer.ownerID;
            if (owner_id == currentUserID) {
                answerService.deleteAnswer(answer_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCurrID() {
        return currentUserID;
    }

    public String toString(Question question) {
        return String.format("id: %d,\n автор: %d,\n заголовок: %s,\n вопрос: %s\n",
                question.id, question.ownerID, question.topic, question.text);
    }

    public String toString(Answer answer) {
        return String.format("id: %d,\n ответ на: %d,\n автор: %d,\n ответ: %s\n",
                answer.id, answer.questionID, answer.ownerID, answer.text);
    }
}
