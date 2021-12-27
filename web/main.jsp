<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlet.MainPageServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Question" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная</title>
</head>
<body>

<div style="margin-top: 5%; text-align: center;">
    <form action="" method="post">
        <div>
            <p>Найти вопрос:<br><input name="search-q" type="text">
                <button name="search-q" type="submit">Найти вопрос</button></p>
        </div>
        <div>
            <p><button name="add-q" type="submit">Задать вопрос</button></p>
        </div>
        <div>
            Тут должен быть список всех вопросов
            <ul>
                    <%
            List<Question> questions = (List<Question>) request.getAttribute("qlist"); %>
                    <%
            for (Question question:
                    questions) { %>
                <li><%=question.topic%></li>
                <%}%>
            </ul>
        </div>
    </form>
</div>

</body>
</html>