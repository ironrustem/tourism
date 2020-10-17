package com.saifullin.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        String mail = req.getParameter("mail");
        String numberPhone = req.getParameter("numberPhone");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();

        if ((login.equals(""))||(password.equals(""))||(name.equals(""))||(surname.equals(""))){
            httpSession.setAttribute("userSurname", surname);
            httpSession.setAttribute("userName", name);
            httpSession.setAttribute("userBirth", birth);
            httpSession.setAttribute("userMail", mail);
            httpSession.setAttribute("userPhone", numberPhone);
            httpSession.setAttribute("userLogin", login);

            String error = "";
            if(login.equals("")) error ="Укажите Логин!";
            if(password.equals("")) error ="Укажите Пароль!";
            if(name.equals("")) error ="Укажите Имя!";
            if(surname.equals("")) error ="Укажите Фамилию!";

            System.out.println(error);
            httpSession.setAttribute("userError", error);
            resp.sendRedirect("registration.jsp");
        }


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
