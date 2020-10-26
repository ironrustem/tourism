<html lang="en">
<#include "base.ftl">
<#macro title>Exception Details</#macro>
<#macro content>
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