<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>
<#macro title>Exception Details</#macro>
<#macro content>
    <!-- Зарегистрироваться
================================================== -->
    <section id="contact" class="parallax-section">
        <div class="container">
            <div class="row">

                <!-- Section title
                ================================================== -->
                <div class="col-md-offset-2 col-md-8 col-sm-12">
                    <div class="section-title">
                        <h1>Личный кабинет</h1>
                    </div>
                </div>

                <!-- Contact form section
                ================================================== -->
                <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 wow fadeIn" data-wow-delay="0.6s">

                    <div class="col-lg-12 text-center">
                        <form action="/login" method="post">
                            <input name="login" type="email" class="form-control" placeholder="Электронная почта"
                                   required>
                            <input type="password" class="form-control" placeholder="Пароль" name="password"
                                   required>
                            <input type="checkbox" name="remember" value="1">Запомнить меня<Br>
                            <input type="submit" class="form-control" value="Войти">
                        </form>
                    </div>

                    <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
                        <form action="/registration" method="get">
                            <input type="submit" class="form-control" value="Зарегистрироваться">
                        </form>
                    </div>


                </div>

            </div>
        </div>
    </section>
</#macro>
</html>