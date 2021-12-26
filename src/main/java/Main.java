import model.Answer;
import model.Question;
import service.AppService;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppService appService = null;
        appService = new AppService();
        /*
        //авторизация существующего пользователя
        boolean success = appService.authorization("admin", "admin");
        System.out.println("авторизация существующего пользователя = " + success);
        System.out.println(appService.getCurrID());
        appService.out();

        //авторизация несуществующего пользователя
        success = appService.authorization("a", "a");
        System.out.println("авторизация несуществующего пользователя = " + success);
        System.out.println(appService.getCurrID());
        appService.out();

        //регистрация с неверными данными
        success = appService.registration("a", "a");
        System.out.println("регистрация с неверными данными = " + success);
        System.out.println(appService.getCurrID());
        appService.out();

        //регистрация с существующим логином
        success = appService.registration("admin", "abcdefghij");
        System.out.println("регистрация с существующим логином = " + success);
        System.out.println(appService.getCurrID());
        appService.out();

        //регистрация
        success = appService.registration("user3", "1234567890");
        System.out.println("регистрация = " + success);
        System.out.println(appService.getCurrID());
        appService.out();

        //вход за нового пользователя
        success = appService.authorization("user1", "123456789");
        System.out.println("вход за нового пользователя = " + success);
        System.out.println(appService.getCurrID());
        appService.out();*/

        /*Scanner scan = new Scanner(System.in);

        System.out.println("Вы не авторизованы. Чтобы получить доступ к приложению войдите или зарегистрируйтесь.");
        System.out.println("[1] войти \n[2] зарегистрироваться");

        int action = scan.nextInt();

        if (action == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите логин: ");
            String login = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();
            if (!appService.authorization(login, password)) {
                System.out.println("Такого пользователя не существует.");
            }
            else {
                System.out.println("Выберите действие:\n" +
                        "[1] задать вопрос \n" +
                        "[2] посмотреть свои вопросы \n" +
                        "[3] посмотреть свои ответы \n" +
                        "[4] посмотреть все вопросы \n" +
                        "[5] найти вопрос \n" +
                        "[6] ответить на вопрос \n" +
                        "[7] удалить свой вопрос \n" +
                        "[8] удалить свой ответ \n" +
                        "[9] выйти");
                int new_action = scanner.nextInt();
                switch (new_action) {
                    case 1:
                        System.out.println("Введите заголовок: ");
                        String topic = scanner.nextLine();
                        System.out.println("Введите вопрос: ");
                        String text = scanner.nextLine();
                        appService.addQuestion(topic, text);
                        break;
                    case 2:
                        List<Question> my_questions = appService.getUserQuestions();
                        System.out.println("Мои вопросы: ");
                        for (Question q: my_questions) {
                            System.out.println(appService.toString(q));
                        }
                        break;
                    case 3:
                        List<Answer> my_answer = appService.getUserAnswer();
                        System.out.println("Мои ответы: ");
                        for (Answer a: my_answer) {
                            System.out.println(appService.toString(a));
                        }
                        break;
                    case 4:
                        List<Question> all_question = appService.getAllQuestion();
                        System.out.println("Все вопросы: ");
                        for (Question q: all_question) {
                            System.out.println(appService.toString(q));
                        }
                        break;
                    case 5:
                        System.out.println("Введите часть вопроса: ");
                        String content = scanner.nextLine();
                        List<Question> question_content = appService.getQuestionByContent(content);
                        System.out.println("Вопросы с таким содержанием: ");
                        for (Question q: question_content) {
                            System.out.println(appService.toString(q));
                        }
                        break;
                    case 6:
                        System.out.println("Введите индекс вопроса, на который нотите ответить: ");
                        int question_id = scanner.nextInt();
                        System.out.println("Введите ответ: ");
                        String answer = scanner.nextLine();
                        appService.addAnswer(question_id, answer);
                        break;
                    case 7:
                        System.out.println("Введите индекс вопроса, который хотите удалить: ");
                        int del_q_id = scanner.nextInt();
                        appService.deleteQuestion(del_q_id);
                        break;
                    case 8:
                        System.out.println("Введите индекс ответа, который хотите удалить: ");
                        int del_ans_id = scanner.nextInt();
                        appService.deleteAnswer(del_ans_id);
                        break;
                    case 9:
                        appService.out();
                        break;
                }
            }
*/

        System.out.println("авторизация " + appService.authorization("user1", "123456789"));

        appService.addQuestion("Помогите решить", "Сколько будет 2 + 2 * 2?");

        /*List<Question> my_questions = appService.getUserQuestions();
        System.out.println("Мои вопросы: ");
        for (Question q: my_questions) {
            System.out.println(appService.toString(q));
        }*/

        /*List<Question> question_content = appService.getQuestionByContent("Должность");
        System.out.println("Вопросы с таким содержанием: ");
        for (Question q: question_content) {
            System.out.println(appService.toString(q));
        }*/

        /*List<Question> all_question = appService.getAllQuestion();
        System.out.println("Все вопросы: ");
        for (Question q: all_question) {
            System.out.println(appService.toString(q));
        }*/

        /*List<Answer> my_answer = appService.getUserAnswer();
        System.out.println("Мои ответы: ");
        for (Answer a: my_answer) {
            System.out.println(appService.toString(a));
        }*/

        //appService.addAnswer(6, "6");

        //appService.deleteQuestion(2);
        //appService.deleteQuestion(6);

        //appService.deleteAnswer(6);

        //appService.out();
        }
}