<html lang="ru">
<#include "base.ftl">
<#macro title>Прилетающим</#macro>
<#macro content1></#macro>
<#macro content>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/forTables.js"></script>


    <input id="search" type="search" name="" placeholder="Поиск по номеру рейса, городу и авиакомпании" class="input" />


    <button class="yesterday" id="yesterday">yesterday</button>
    <button class="today" id="today">today</button>
    <button class="tomorrow" id="tomorrow">tomorrow</button>

    <select class="hour" name="hour" id="hour">
        <option value="0" > Весь день</option>
        <option value="1" > 00:00 - 6:00</option>
        <option value="2" > 7:00 - 12:00</option>
        <option value="3" > 13:00 - 18:00</option>
        <option value="4" > 19:00 - 24:00</option>
    </select>

    <input type="hidden" id="dayAt" name="data" value=${day} />
    <input type="hidden" id="hourTagAt" name="data" value=${hourTag} />

    <div class="result">
        <table class="table">
            <thead>
            <tr>
                <th>Взлет</th>
                <th>Приземление</th>
                <th>Город</th>
                <th>Терминал</th>
                <th>Статус</th>
            </tr>
            </thead>
            <tbody class="t_res">

            </tbody>
        </table>

    </div>
</#macro>
</html>