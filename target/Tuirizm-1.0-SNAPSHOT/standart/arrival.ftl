<html lang="ru">
<#include "base.ftl">
<#macro title>Прилетающим</#macro>
<#macro content>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#yesterday').click(function () {
                $.get("arrival", function (responseJson) {
                    const $table = $("<table>").appendTo($("#tableDiv"));
                    $.each(responseJson, function(index, flights) {
                        $("<tr>").appendTo($table)
                            .append($("<td>").text(${flight.date1?time?string("hh:mm")}))
                            .append($("<td>").text(${flight.date2?time?string("hh:mm")}))
                            .append($("<td>").text(${flight.city}))
                            .append($("<td>").text(${flight.city}))
                            .append($("<td>").text(${flight.terminal}));
                    });
                });
            });
        });
    </script>


    <form method="post" action="arrival">
                <input type="hidden" name="day" value="-1"/>
                <input type="submit" value="Вчера"/>
            </form>

            <form method="post" action="arrival">
                <input type="hidden" name="day" value="0"/>
                <input type="submit" value="Сегодня"/>
            </form>

            <form method="post" action="arrival">
                <input type="hidden" name="day" value="1"/>
                <input type="submit" value="Завтра"/>
            </form>

            <form>
                <input type="button" id="ajaxbutton">
            </form>

            <div id="ajaxdiv"></div>
            <form method="post" action="arrival">
                <select name="hourTagSelect">
                    <option value="1" > 00:00 - 6:00</option>
                    <option value="2" > 7:00 - 12:00</option>
                    <option value="3" > 13:00 - 18:00</option>
                    <option value="4" > 19:00 - 24:00</option>
                </select>
            </form>

    <div class="tableDiv"></div>


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
                            <td>${flight.date1?time?string("hh:mm")}</td>
                            <td>${flight.date2?time?string("hh:mm")}</td>
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