<html lang="en">
<#include "base.ftl">
<#macro title>Прилетающим</#macro>
<#macro content>
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
                    <td>${fly.flight.date1}</td>
                    <td>${fly.flight.date2}</td>
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
    <form action="logout" method="post">
        <input type="submit" value="logout">
    </form>
</#macro>
</html>