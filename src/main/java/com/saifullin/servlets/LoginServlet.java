package com.saifullin.servlets;


import com.saifullin.dao.impl.UserDaoImpl;
import com.saifullin.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UserDaoImpl userDao = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User userDB = userDao.get(login);

        if(userDB != null) {
            if (login.equals(userDB.geteMail()) && password.equals(userDB.getPassword())) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                Cookie userCookie = new Cookie("username", login);
                userCookie.setMaxAge(24 * 60 * 60);

                resp.addCookie(userCookie);

                resp.sendRedirect("/account");

            } else {
                resp.sendRedirect("/login");
            }
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
