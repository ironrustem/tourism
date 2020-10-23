package com.saifullin.servlets;

import com.saifullin.dao.Dao;
import com.saifullin.dao.impl.UserDaoImpl;
import com.saifullin.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("userSurname", "");
        httpSession.setAttribute("userName", "");
        httpSession.setAttribute("userMail","");
        httpSession.setAttribute("userPhone", "");
        httpSession.setAttribute("sessionError", "");
        req.getRequestDispatcher("registration.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String numberPhone = req.getParameter("numberPhone");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();

        if ((password.equals("")) || (name.equals("")) || (surname.equals(""))) {

            httpSession.setAttribute("userSurname", surname);
            httpSession.setAttribute("userName", name);
            httpSession.setAttribute("userMail", mail);
            httpSession.setAttribute("userPhone", numberPhone);

            String error = "";
            if (password.equals("")) error = "Укажите Пароль!";
            if (name.equals("")) error = "Укажите Имя!";
            if (surname.equals("")) error = "Укажите Фамилию!";

            httpSession.setAttribute("sessionError", error);

            req.getRequestDispatcher("/registration.ftl").forward(req,resp);
        } else {
            Dao<User> dao = new UserDaoImpl();

            User user = new User(name, surname, mail, numberPhone, "user", password);
            dao.save(user);
            resp.sendRedirect("login.html");
        }


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
