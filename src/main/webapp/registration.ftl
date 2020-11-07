<html lang="en">
<#include "base.ftl">
<#macro title>Exception Details</#macro>
<#macro content1></#macro>
<#macro content>

    <!-- Личный кабинет
    ================================================== -->
    <section id="contact" class="parallax-section">
        <div class="container">
            <div class="row">

                <!-- Section title
                ================================================== -->
                <div class="col-md-offset-2 col-md-8 col-sm-12">
                    <div class="section-title">
                        <h1>Регистрация</h1>
                        <h3>${sessionError}</h3>
                    </div>
                </div>

                <!-- Contact form section
                ================================================== -->
                <div class="col-8 wow fadeIn" data-wow-delay="0.6s">
                        <form action="/registration" method="post">
                            <input type="surname" class="form-control" placeholder="Фамилия"  name="surname"   required>
                            <input type="name" class="form-control" placeholder="Имя" name="name" type="text"  required>
                            <input type="email" class="form-control" placeholder="Email" name="mail"  required>
                            <input type="phone" class="form-control" placeholder="Телефон" name="numberPhone"  required>
                            <input type="password" class="form-control" placeholder="Password" name="password" required>
                            <input type="submit" class="form-control" value="Зарегистрироваться">
                    </form>
            </div>

        </div>
        </div>
    </section>

</#macro>
</html>