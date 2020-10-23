<html lang="en">
<#include "base.ftl">
<#macro title>Exception Details</#macro>
<#macro content>
        <form action="/registration" method="post">
            Фамилия:
            <label>
                <input name="surname" type="text" value= ${userSurname}>
            </label>
            <br>
            Имя:
            <label>
                <input name="name" type="text" value= ${userName}>
            </label>
            <br>
            Ваша почта:
            <label>
                <input name="mail" type="email" value= ${userMail}>
            </label>
            <br>
            Номер телефона:
            <label>
                <input name="numberPhone" type="number" value= ${userPhone}>
            </label>
            <br>
            Пароль:
            <label>
                <input name="password" type="password">
            </label>
            <br>
            <h4>${sessionError}</h4>
            <input type="submit" value="Log up">

            <br>
            <br>
            <br>
        </form>
</#macro>
</html>