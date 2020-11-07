package com.saifullin.servlets;

import com.saifullin.dao.Dao;
import com.saifullin.dao.impl.UserDaoImpl;
import com.saifullin.helpers.PasswordHelper;
import com.saifullin.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private String surname = "";
    private String name = "";
    private String mail = "";
    private String numberPhone = "";
    private String password = "";
    private String error = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("surname", surname);
        req.setAttribute("name", name);
        req.setAttribute("mail",mail);
        req.setAttribute("numberPhone", numberPhone);
        req.setAttribute("sessionError",  error);
        req.getRequestDispatcher("registration.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        surname = req.getParameter("surname");
        name = req.getParameter("name");
        mail = req.getParameter("mail");
        numberPhone = req.getParameter("numberPhone");
        password = req.getParameter("password");

        System.out.println(surname);
        System.out.println(name);
        System.out.println(mail);
        System.out.println(numberPhone);
        System.out.println(password);

        if ((password.equals("")) || (name.equals("")) || (surname.equals(""))) {
            if (password.equals("")) error = "Укажите Пароль!";
            if (name.equals("")) error = "Укажите Имя!";
            if (surname.equals("")) error = "Укажите Фамилию!";
            resp.sendRedirect("registration");
        } else {

            UserDaoImpl dao = new UserDaoImpl();
            if(!dao.check(mail)) {
                User user = new User(name, surname, mail, numberPhone, "user", PasswordHelper.encrypt(password));
                dao.save(user);
                resp.sendRedirect("/login");
            } else {
                error = "Пользователь с такой почтой уже зарегестрирован";
                resp.sendRedirect("registration");
            }
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
