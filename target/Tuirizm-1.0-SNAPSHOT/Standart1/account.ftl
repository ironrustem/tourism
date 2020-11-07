<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>
<#macro title>Прилетающим</#macro>
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
    <#if errorAccount??>
    <h5>${errorAccount}</h5>
    </#if>
    <form method="post" action="account">
        <input type="hidden" name="deleteAccount" value=1 />
        <input type="submit" value="Удалить аккаунт"/>
    </form>
    <table>
        <tr>
            <th>Взлет</th>
            <th>Приземление</th>
            <th>Город</th>
            <th>Терминал</th>
            <th>Статус</th>
            <th>Приоритет</th>
        </tr>
        <#if flies??>
            <#list flies as fly>
                <tr>
                    <td>${fly.flight.date1?time?string("hh:mm")}</td>
                    <td>${fly.flight.date2?time?string("hh:mm")}</td>
                    <td>${fly.flight.city}</td>
                    <td>${fly.flight.terminal}</td>
                    <td>${fly.flight.status}</td>
                    <td>${fly.priorityFly.name}</td>
                    <td>
                        <form method="post" action="account">
                            <input type="hidden" name="dataFlight" value=${fly.flight.id} />
                            <input type="hidden" name="dataPriority" value=${fly.priorityFly.id} />
                            <input type="submit" value="удалить"/>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
    <br>
    <br>
    <br>
    <table>
        <tr>
            <th>Название</th>
            <th>Цена</th>
            <th>Дата заезда</th>
            <th>Дата выезда</th>
        </tr>
        <#if hotels??>
            <#list hotels as hotel>
                <tr>
                    <td>${hotel.room.name}</td>
                    <td>${hotel.price}</td>
                    <td>${hotel.date}</td>
                    <td>${hotel.date1}</td>
                    <td>
                        <form method="post" action="account">
                            <input type="hidden" name="idHotel" value=${hotel.id} />
                            <input type="submit" value="удалить"/>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>

    <form action="chat" method="get">
        <input type="submit" value="Чат с поддержкой">
    </form>
    <form action="logout" method="post">
        <input type="submit" value="logout">
    </form>
</#macro>
</html>