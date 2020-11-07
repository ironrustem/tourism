<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>
<#macro title>Exception Details</#macro>
<#macro content>
    <form action="main" method="get">
        <input type="submit" value="Главная">
    </form>
    <form action="arrival" method="get">
        <input type="submit" value="Прилетающим">
    </form>
    <form action="departure" method="get">
        <input type="submit" value="Вылетающим">
    </form>
    <form action="hotel" method="get">
        <input type="submit" value="отель">
    </form>
    <form action="hotel" method="get">
        <input type="submit" value="о нас">
    </form>
    <br>
    <form action="account" method="get">
        <input type="submit" value="войти">
    </form>
    <br>
    <br>
    <br>
    <br>
    <br>
    <form action="/login" method="post">
        Login:
        <input name="login" type="text">
        <br>
        Password:
        <input name="password" type="password">
        <br>
        <input type="checkbox" name="remember" value="1">Запомнить меня<Br>
        <br>
        <input type="submit" value="Войти">
        <br>
        <br>
        <br>
    </form>

    <form action="registration" method="get">
        <input type="submit" value="registration">
    </form>
</#macro>
</html>