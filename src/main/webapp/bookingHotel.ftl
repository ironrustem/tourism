<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>
<#macro title>Улетающим</#macro>
<#macro content>

    <!-- Service section
    ================================================== -->
    <section id="service" class="parallax-section">
        <div class="container">
            <div class="row">

                <div class="col-md-8 col-sm-10">
                    <div class="section-title">
                        <h1>Бронирование отеля</h1>
                        <p>Доступные номера по вашей дате</p>
                        <h5>Доп услуги вы можете добавить после бронирования в личном кабинете</h5>
                    </div>
                </div>

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Название</th>
                        <th scope="col"></th>
                        <th scope="col">Цена за сутки</th>
                        <th scope="col">Что входит в проживание</th>
                        <th scope="col">Кол-во персон</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if rooms??>
                        <#list rooms as room>
                            <tr>
                                <td>${room_index + 1}</td>
                                <td>${room.name}</td>
                                <td><img src=${room.image} class="fluid-img" alt="portfolio img" width="217" height="325"></td>
                                <td>${room.price}</td>
                                <td><ul type="circle">
                                    ${room.about}
                                    </ul></td>
                                <td>${room.persons}</td>
                                <td>
                                    <form method="post" action="booking">
                                        <input type="submit" value="забронировать"/>
                                        <input type="hidden" name="idRoom" value=${room.id} />
                                    </form>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</#macro>
</html>