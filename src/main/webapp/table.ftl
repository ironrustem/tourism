<html lang="ru">
<#include "base.ftl">
<#macro title>Прилетающим</#macro>
<#macro content1></#macro>
<#macro content>


    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/forTables.js"></script>

    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <h1>${type}</h1>

        <section id="service" class="parallax-section">
            <input id="search" type="search" name="" placeholder="Поиск по номеру рейса или по городу"
                   class="search"/>


            <button class="btn btn-default section-btn smoothScroll tbl " id="yesterday">yesterday</button>
            <button class="btn btn-default section-btn smoothScroll tbl" id="today">today</button>
            <button class="btn btn-default section-btn smoothScroll tbl " id="tomorrow">tomorrow</button>

            <select class="hour"  id="hour">
                <option value="0"> Весь день</option>
                <option value="1"> 00:00 - 6:00</option>
                <option value="2"> 7:00 - 12:00</option>
                <option value="3"> 13:00 - 18:00</option>
                <option value="4"> 19:00 - 24:00</option>
            </select>

            <input type="hidden" id="dayAt" name="data" value=${day} />
            <input type="hidden" id="hourTagAt" name="data" value=${hourTag} />

            <div class="result">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Номер полета</th>
                        <th>Взлет</th>
                        <th>Приземление</th>
                        <th>Город</th>
                        <th>Авиакомпания</th>
                        <th>Терминал</th>
                        <th>Статус</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody class="t_res">

                    </tbody>
                </table>
            </div>

        </section>
    </div>
</#macro>
</html>