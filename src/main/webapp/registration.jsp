<%--
  Created by IntelliJ IDEA.
  User: rustem
  Date: 13.10.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<form action="${pageContext.request.contextPath}/registration" method="post">
    Фамилия:
    <label>
        <input name="surname" type="text" value= <%=sessionSurname%>>
    </label>
    <br>
    Имя:
    <label>
        <input name="name" type="text" value= <%=sessionName%>>
    </label>
    <br>
    Дата рождения:
    <label>
        <input name="birth" type="date" value= <%=sessionBirth%>>
    </label>
    <br>
    Ваша почта:
    <label>
        <input name="mail" type="email" value= <%=sessionMail%>>
    </label>
    <br>
    Номер телефона:
    <label>
        <input name="numberPhone" type="number" value= <%=sessionPhone%>>
    </label>
    <br>
    Логин:
    <label>
        <input name="login" type="text" value= <%=sessionLogin%>>
    </label>
    <br>
    Пароль:
    <label>
        <input name="password" type="password">
    </label>
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
