<%@ page import="java.sql.SQLOutput" %><%--
  Created by IntelliJ IDEA.
  User: rustem
  Date: 13.10.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<meta charset="utf-8">
<%
    String sessionSurname = (String) session.getAttribute("userSurname");
    if (sessionSurname == null) sessionSurname = "";
    String sessionName = (String) session.getAttribute("userName");
    if (sessionName == null) sessionName = "";
    String sessionBirth = (String) session.getAttribute("userBirth");
    if (sessionBirth == null) sessionBirth = "";
    String sessionMail = (String) session.getAttribute("userMail");
    if (sessionMail == null) sessionMail = "";
    String sessionPhone = (String) session.getAttribute("userPhone");
    if (sessionPhone == null) sessionPhone = "";
    String sessionLogin = (String) session.getAttribute("userLogin");
    if (sessionLogin == null) sessionLogin = "";
    String sessionError = (String) session.getAttribute("userError");
    if (sessionError == null) sessionError = "";
    System.out.println(sessionError);
%>
<form action="/registration" method="post">
    Фамилия:
    <input name="surname" type="text" value= <%=sessionSurname%>>
    <br>
    Имя:
    <input name="name" type="text" value= <%=sessionName%>>
    <br>
    Дата рождения:
    <input name="birth" type="date" value= <%=sessionBirth%>>
    <br>
    Ваша почта:
    <input name="mail" type="email" value= <%=sessionMail%>>
    <br>
    Номер телефона:
    <input name="numberPhone" type="number" value= <%=sessionPhone%>>
    <br>
    Логин:
    <input name="login" type="text" value= <%=sessionLogin%>>
    <br>
    Пароль:
    <input name="password" type="password">
    <br>
    <h4><%=sessionError%></h4>
    <input type="submit" value="Log up">

    <br>
    <br>
    <br>
</form>

<form action="login" method="get">
    <input type="submit" value="login">
</form>

</body>
</html>
