<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>
<#macro title>Прилетающим</#macro>
<#macro content>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/forAccount.js"></script>

    <!-- Service section
    ================================================== -->
    <section id="service" class="parallax-section">
        <div class="container">
            <div class="row">

                <div class="col-md-8 col-sm-10">
                    <div class="section-title">
                        <h1>Личный кабинет</h1>

                        <form action="chat" method="get">
                            <input type="submit" value="Чат поддержки">
                        </form>

                        <form action="logout" method="post">
                            <input type="submit" value="logout">
                        </form>

                        <form method="post" action="account">
                            <input type="hidden" name="deleteAccount" value=1/>
                            <input type="submit" value="Удалить аккаунт"/>
                        </form>


                        <br>
                        <br>
                        <#if errorAccount??>
                            <h5>${errorAccount}</h5>
                        </#if>
                        <br>
                        <br>
                        <br>
                        <p>Ваши рейсы</p>
                    </div>
                </div>

                <table id="flightTable" class="table">
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
                    <tbody class="flightsTable_res">
                    <#if flies??>
                        <#list flies as fly>
                            <tr>
                                <td>${fly.flight.number}</td>
                                <td>${fly.flight.date1?time?string("hh:mm")}</td>
                                <td>${fly.flight.date2?time?string("hh:mm")}</td>
                                <td>${fly.flight.city}</td>
                                <td>${fly.flight.company}</td>
                                <td>${fly.flight.terminal}</td>
                                <td>${fly.flight.status}</td>
                                <td>
                                    <input type="submit" id="delFly" value="удалить"
                                           onclick="deleteFl(${fly.flight.id})"/>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>


                <br>
                <br>
                <br>
                <br>
                <br>
                <div class="col-md-8 col-sm-10">
                    <div class="section-title">
                        <p>Бронирование отеля</p>
                    </div>
                </div>

                <div class="container">
                    <div class="row">

                        <table class="table" id="hotelTable">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Название</th>
                                <th scope="col">Цена</th>
                                <th scope="col">Дата выезда</th>
                                <th scope="col">Дата заезда</th>
                                <th scope="col">Дополнительные услуги</th>
                                <th scope="col"></th>
                            </tr>
                            </thead>
                            <tbody class="hotelTable_res">
                            <#if hotels??>
                                <#list hotels as hotel>
                                    <tr id=${hotel.id}>
                                        <td>${hotel.id}</td>
                                        <td>${hotel.room.name}</td>
                                        <td>${hotel.price}</td>
                                        <td>${hotel.date}</td>
                                        <td>${hotel.date1}</td>
                                        <td id=${hotel.id}>
                                            <input type="submit" id="editHot" value="изменить"
                                                   onclick="editHot(${hotel.id})"/>
                                        </td>
                                        <td>
                                            <input type="submit" id="delHot" value="удалить"
                                                   onclick="deleteHot(${hotel.id})"/>
                                        </td>
                                    </tr>
                                </#list>
                            </#if>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- Перелёт
    ================================================== -->
    <section id="about" class="parallax-section">
        <div class="container">
            <div class="row">

                <div class="col-md-6 col-sm-10 wow fadeInUp" data-wow-delay="1.3s">
                    <h1>Как вести себя во время перелёта?</h1>
                    <p>В первый раз в аэропорту легко растеряться. Но уже через пару перелетов вы с ходу сориентируетесь
                        в любом аэропорту и будете рассказывать друзьям, что это легче поездки на дачу.</p>
                    <p>Маршрут: Контроль на входе --> Поиск рейса на табло --> Регистрация на рейс и сдача багажа -->
                        Посадочный талон и как его расшифровать --> Контроль и предполетный досмотр --> Зона вылета и
                        выход на посадку --> Особенности перелета с пересадкой --> Аэропорт прилета </p>
                </div>
                <div class="col-md-6 col-sm-10 wow fadeInUp" data-wow-delay="1.6s">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/yTd0MdEUq70" frameborder="0"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                allowfullscreen></iframe>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <br>
    <br>

</#macro>
</html>