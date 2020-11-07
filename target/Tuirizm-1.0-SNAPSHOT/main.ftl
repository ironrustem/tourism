<html lang="en">
<#include "base.ftl">
<#macro title>Exception Details</#macro>

<#macro content1>
    <!-- Главная
    ================================================== -->
    <section id="home" class="parallax-section">
        <div class="container">
            <div class="row">

                <div class="col-md-offset-2 col-md-8 col-sm-12">
                    <h2 class="wow bounceIn"> Аэропорт имени Рустема Сайфуллина</h2>
                    <h4 class="font-weight-normal font-color-gray wow fadeInUp" data-wow-delay="1s">Мы рады приветствовать вас на нашем сайте</h4>
                    <a href="/arrival" class="btn btn-default section-btn smoothScroll wow fadeInUp" data-wow-delay="1.9s">Прилетающим</a>
                    <a href="/departure" class="btn btn-default section-btn smoothScroll wow fadeInUp" data-wow-delay="1.9s">Вылетающим</a>
                    <a href="/hotel" class="btn btn-warning section-btn smoothScroll hidden-xs wow fadeInUp" data-wow-delay="1.9s">Бронь отеля</a>
                </div>

            </div>
        </div>
    </section>
</#macro>

<#macro content>

    <!-- Правая сторона
    ================================================== -->
    <section id="blog" class="parallax-section">
        <div class="container">
            <div class="row">

                <div class="col-md-8 col-sm-7">

                    <div class="blog-image wow fadeInUp" data-wow-delay="0.9s">
                        <img src="images/blog-wrapper.jpg" class="img-responsive" alt="blog">
                    </div>

                </div>


                <div class="col-md-4 col-sm-5 wow fadeInUp" data-wow-delay="1.3s">

                    <div class="blog-about">
                        <h3>О нас</h3>
                        <img src="images/about.jpg" class="img-responsive" alt="blog">
                        <p>В далёком 2020 году гуру компьютерных наук Марат Альбертович Солнцев дал задание своим студентам, создать свой сайт. Тем было очень много, так, Сайфуллину Рустему выпала тема туризма. Раазумеется, он бы не справился в таком непростом деле один, ему на помощь вызвалась Камалова Лия.
                            Спустя некоторое время,  они начали реализовывать эту гениальную идею и создали сайт аэропорта имени Рустема Сайфуллина!</p>
                    </div>

                    <div class="recent-post">
                        <h3>Новости аэропорта</h3>

                        <div class="media">
                            <div class="media-object pull-left">
                                <a href="#"><img src="images/blog-thumb1.jpg" class="img-responsive" alt="blog"></a>
                            </div>
                            <div class="media-body">
                                <h5>15 Марта 2020</h5>
                                <h4 class="media-heading"><a href="#">Ковид-19. Носите маски</a></h4>
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-object pull-left">
                                <a href="#"><img src="images/blog-thumb2.jpg" class="img-responsive" alt="blog"></a>
                            </div>
                            <div class="media-body">
                                <h5>24 Сентября 2020</h5>
                                <h4 class="media-heading"><a href="#">Отслеживайте стасус рейса</a></h4>
                            </div>
                        </div>
                        <div class="media">
                            <div class="media-object pull-left">
                                <a href="#"><img src="images/blog-thumb3.jpg" class="img-responsive" alt="blog"></a>
                            </div>
                            <div class="media-body">
                                <h5>10 Июль 2020</h5>
                                <h4 class="media-heading"><a href="#">Делай покупки онлайн</a></h4>
                            </div>
                        </div>
                    </div>

                </div>

                <!-- О нас
    ================================================== -->
                <section id="team" class="paralla-section">
                    <div class="container">
                        <div class="row">

                            <!-- Section title
                            ================================================== -->
                            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 wow bounceIn">
                                <div class="section-title">
                                    <h1>Наша команда</h1>
                                    <p>Команда профессионалов своего дела.</p>
                                </div>
                            </div>

                            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                                <div class="team-wrapper">
                                    <img src="images/team_1.jpg" class="img-responsive" alt="about">
                                    <div class="team-wrapper-social">
                                        <ul class="social-icon">
                                            <li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.9s"></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="team-description">
                                    <h3>Сайфуллин Рустем</h3>
                                    <h5>Исполнительный директор</h5>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="1.3s">
                                <div class="team-wrapper">
                                    <img src="images/team_2.jpg" class="img-responsive" alt="about">
                                    <div class="team-wrapper-social">
                                        <ul class="social-icon">
                                            <li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.9s"></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="team-description">
                                    <h3>Камалова Лия</h3>
                                    <h5>никто</h5>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="1.6s">
                                <div class="team-wrapper">
                                    <img src="images/team_3.jpg" class="img-responsive" alt="about">
                                    <div class="team-wrapper-social">
                                        <ul class="social-icon">
                                            <li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.9s"></a></li>
                                            <li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.9s"></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="team-description">
                                    <h3>Солнцев Марат</h3>
                                    <h5>Генеральный директор всех Авиакомпаний Сайфуллина Рустема</h5>
                                </div>
                            </div>


                        </div>
                    </div>
                </section>



            </div>
        </div>
    </section>


</#macro>
</html>