<html lang="en">
<#include "base.ftl">
<#macro title>Прилетающим</#macro>
<#macro content>
    <table>
        <tr>
            <th>Взлет</th>
            <th>Приземление</th>
            <th>Город</th>
            <th>Терминал</th>
            <th>Статус</th>
        </tr>
        <#if flights??>
            <#list flights as flight>
                <tr>
                    <td>${flight.date1}</td>
                    <td>${flight.date2}</td>
                    <td>${flight.city}</td>
                    <td>${flight.terminal}</td>
                    <td>${flight.status}</td>
                    <td>
                        <form method="post" action="arrival">
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