<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>

<#macro title>Отель</#macro>
<#macro content>

<!-- Главная отеля
================================================== -->
<section id="service" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-8 col-sm-10">
                <div class="section-title">
                    <h1>Отель "у Рустема"</h1>
                    <p>Основная информация о нас!</p>
                </div>
            </div>

            <div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="media">
                    <div class="media-object pull-left">
                        <i class="icon icon-laptop"></i>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Завтраки</h3>
                        <p>По утрам накрывается завтрак «шведский стол», в 17:00 подается чай со свежей выпечкой. В
                            число прочих удобств входит лобби-бар.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="1.3s">
                <div class="media">
                    <div class="media-object pull-left">
                        <i class="icon icon-focus"></i>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Больше информации</h3>
                        <p>Вы можете узнать больше информации нас <a href="https://kpfu.ru/itis" target="_blank"
                                                                     class="font-color-yellow">ТУТ</a>. Кроме того,
                            будем рады ответить на все ваши вопросы по телефону +7(880)555-35-45 </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="1.6s">
                <div class="media">
                    <div class="media-object pull-left">
                        <i class="icon icon-cloud"></i>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Расположение отеля</h3>
                        <p> Отель находится на территории аэропорта в 270 метрах от Терминала 1. Такое расположение
                            гостиницы дает возможность быстро попасть в здание терминала и позволяет полноценно
                            отдохнуть в случае задержки рейса.
                            К услугам гостей предлагаются номера различного уровня комфортности.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="1.9s">
                <div class="media">
                    <div class="media-object pull-left">
                        <i class="icon icon-basket"></i>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Приятный бонус</h3>
                        <p>Для остановившихся в отеле предусмотрена скидка 20% на услуги ресторана и тренажерного зала
                            гостиницы «Аэротель», расположенной в 500 метрах от пассажирского терминала.</p>
                    </div>
                </div>
            </div>

        </div>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="text-center wow fadeInUp" data-wow-delay="0.5s">
            <#if error??>
            <h5>${error}</h5>
                </#if>
                <form action="hotel" method="post">
                <label for="date">Дата заезда: </label>
                <input class= ".form-control" type="date" id="date1" name="date1" value=${date1Str} />
                <label for="date">Дата выезда: </label>
                <input type="date" id="date2" name="date2" value=${date2Str}/>
                <input type="hidden" name="day" value="1"/>
                <input type="submit" value="Найти номер">
                </form>
        </div>
    </div>
</section>

<!-- portfolio section
================================================== -->
<section id="portfolio" class="parallax-section">
    <div class="container">
        <div class="row">

            <!-- Section title
            ================================================== -->
            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 wow bounceIn text-center">
                <div class="section-title">
                    <h1>Номера</h1>
                </div>
            </div>

            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="portfolio-thumb">
                    <a href="images/room1.jpg" data-lightbox-gallery="portfolio-gallery">
                        <img src="images/room1.jpg" class="fluid-img" alt="portfolio img">
                        <div class="portfolio-overlay">
                            <div class="portfolio-overlay-des">
                                <i class="fa fa-link"></i>
                                <h3>Стандартный номер</h3>
                                <h5>Одноместный</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="portfolio-thumb">
                    <a href="images/room2.jpg" data-lightbox-gallery="portfolio-gallery">
                        <img src="images/room2.jpg" class="fluid-img" alt="portfolio img">
                        <div class="portfolio-overlay">
                            <div class="portfolio-overlay-des">
                                <i class="fa fa-link"></i>
                                <h3>Стандартный номер</h3>
                                <h5>Двухместный</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="portfolio-thumb">
                    <a href="images/room3.jpg" data-lightbox-gallery="portfolio-gallery">
                        <img src="images/room3.jpg" class="fluid-img" alt="portfolio img">
                        <div class="portfolio-overlay">
                            <div class="portfolio-overlay-des">
                                <i class="fa fa-link"></i>
                                <h3>Полулюкс</h3>
                                <h5>2 человека + место по запросу</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="portfolio-thumb">
                    <a href="images/room4.jpg" data-lightbox-gallery="portfolio-gallery">
                        <img src="images/room4.jpg" class="fluid-img" alt="portfolio img">
                        <div class="portfolio-overlay">
                            <div class="portfolio-overlay-des">
                                <i class="fa fa-link"></i>
                                <h3>Полулюкс</h3>
                                <h5>4 человека + 1 по запросу</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="portfolio-thumb">
                    <a href="images/room5.jpg" data-lightbox-gallery="portfolio-gallery">
                        <img src="images/room5.jpg" class="fluid-img" alt="portfolio img">
                        <div class="portfolio-overlay">
                            <div class="portfolio-overlay-des">
                                <i class="fa fa-link"></i>
                                <h3>Стандартный люкс</h3>
                                <h5>Двухместный</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="portfolio-thumb">
                    <a href="images/room6.jpg" data-lightbox-gallery="portfolio-gallery">
                        <img src="images/room6.jpg" class="fluid-img" alt="portfolio img">
                        <div class="portfolio-overlay">
                            <div class="portfolio-overlay-des">
                                <i class="fa fa-link"></i>
                                <h3>Улучшенный люкс</h3>
                                <h5>Кровать размера «king-size»</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- Вопросы об отеле
================================================== -->
<section id="faq" class="parallax-section">
    <div class="container">
        <div class="row">

            <!-- Вопросы/ ответы
            ================================================== -->
            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 wow bounceIn text-center">
                <div class="section-title">
                    <h1>Ответы на вопросы</h1>
                    <p>Мы с радостью ответим на ваши вопросы в личном кабинете</p>
                </div>
            </div>

            <div class="col-md-offset-1 col-md-10 col-sm-12 wow fadeInUp" data-wow-delay="0.9s">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                   aria-expanded="true" aria-controls="collapseOne">
                                    <i class="icon icon-laptop"></i> В какое время осуществляется заезд в гостиницу?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                             aria-labelledby="headingOne">
                            <div class="panel-body">
                                <p>Стандартное время регистрации в отеле — 13:00. Если Вы планируете гарантированно
                                    заселиться в отель рано утром — Вам стоит забронировать ранний заезд.</p>
                                <p>В этом случае номер и завтрак ждет Вас с самого утра. Стоимость такой услуги —
                                    половина суточного тарифа. Наличие такой возможности на конкретные даты просьба
                                    уточнять в отделе бронирования.</p>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                                   aria-expanded="true" aria-controls="collapseTwo">
                                    <i class="icon icon-focus"></i> Предоставляется ли трансферы с аэропорта или
                                    вокзала?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                             aria-labelledby="headingTwo">
                            <div class="panel-body">
                                <p>Да, мы будем рады встретить Вас по приезду в аэропорту или на вокзале. Стоимость
                                    трансфера — 1200 руб.</p>
                                <p>Трансфер до гостиницы требует предоплаты.</p>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingThree">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                                   aria-expanded="true" aria-controls="collapseThree">
                                    <i class="icon icon-cloud"></i> Предоставляется ли визовая поддержка гостям для
                                    получения Российской визы?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                             aria-labelledby="headingThree">
                            <div class="panel-body">
                                <p> Да, отель оказывает визовую поддержку иностранным гражданам для получения въездной
                                    визы в Россию.</p>
                                <p>С более подробной информацией можете ознакомиться по телефону.</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
</section>


<!-- testimonial section
================================================== -->
<section id="testimonial" class="parallax-section">
    <div class="container">
        <div class="row">

            <!-- Section title
            ================================================== -->
            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 wow bounceIn text-center">
                <div class="section-title">
                    <h1>Отзывы наших посетителей</h1>
                    <p>Дорогие гости, ждём вас снова!</p>
                </div>
            </div>

            <!-- Work Owl Carousel section
            ================================================== -->
            <div id="owl-testimonial" class="owl-carousel">

                <div class="item col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                    <div class="media">
                        <div class="media-object pull-left">
                            <img src="images/testimonial-img1.jpg" class="img-responsive" alt="testimonial">
                        </div>
                        <div class="media-body">
                            <p> Концепция неплохая, обслуживание на высшем уровне</p>
                            <h4 class="media-heading">Абрамский Михаил</h4>
                        </div>
                    </div>
                </div>
                <div class="item col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                    <div class="media">
                        <div class="media-object pull-left">
                            <img src="images/testimonial-img2.jpg" class="img-responsive" alt="testimonial">
                        </div>
                        <div class="media-body">
                            <p>Хорош отел, удобный номер и добропорядковый персонал</p>
                            <h4 class="media-heading">Хакимов Джамолиддин</h4>
                        </div>
                    </div>
                </div>
                <div class="item col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                    <div class="media">
                        <div class="media-object pull-left">
                            <img src="images/testimonial-img3.jpg" class="img-responsive" alt="testimonial">
                        </div>
                        <div class="media-body">
                            <p>Всё понравилось, маршрутизаатор топовый, оценил</p>
                            <h4 class="media-heading">Максютин Сергей</h4>
                        </div>
                    </div>
                </div>
                <div class="item col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                    <div class="media">
                        <div class="media-object pull-left">
                            <img src="images/testimonial-img1.jpg" class="img-responsive" alt="testimonial">
                        </div>
                        <div class="media-body">
                            <p>Концепция неплохая, обслуживание на высшем уровне</p>
                            <h4 class="media-heading">Абрамский Михаил</h4>
                        </div>
                    </div>
                </div>
                <div class="item col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                    <div class="media">
                        <div class="media-object pull-left">
                            <img src="images/testimonial-img2.jpg" class="img-responsive" alt="testimonial">
                        </div>
                        <div class="media-body">
                            <p>Хорош отел, удобный номер и добропорядковый персонал</p>
                            <h4 class="media-heading">Хакимов Джамолиддин</h4>
                        </div>
                    </div>
                </div>


            </div>

        </div>
    </div>
</section>


</#macro>
</html>