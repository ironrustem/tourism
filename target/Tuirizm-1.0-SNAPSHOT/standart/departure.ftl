<html lang="en">
<#include "base.ftl">
<#macro title>Улетающим</#macro>
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
    <form method="post" action="departure">
        <input type="hidden" name="day" value="-1"/>
        <input type="submit" value="Вчера"/>
    </form>

    <form method="post" action="departure">
        <input type="hidden" name="day" value="0"/>
        <input type="submit" value="Сегодня"/>
    </form>

    <form method="post" action="departure">
        <input type="hidden" name="day" value="1"/>
        <input type="submit" value="Завтра"/>
    </form>
    <table>
        <tr>
            <th>Взлет</th>
            <th>Приземление</th>
            <th>Город</th>
            <th>Терминал</th>
            <th>Статус</th>
            <th>         </th>
        </tr>
        <#if flights??>
            <#list flights as flight>
                <tr>
                    <td>${flight.date1?time?string("hh:mm")}</td>
                    <td>${flight.date2?time?string("hh:mm")}</td>
                    <td>${flight.date2?time?string("hh:mm")}</td>
                    <td>${flight.terminal}</td>
                    <td>${flight.status}</td>
                    <td>
                        <form method="post" action="departure">
                            <input type="hidden" name="data" value=${flight.id} />
                            <input type="submit" value="лечу"/>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
</#macro>
</html>