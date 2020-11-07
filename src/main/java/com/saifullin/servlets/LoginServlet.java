package com.saifullin.servlets;


import com.saifullin.dao.impl.UserDaoImpl;
import com.saifullin.helpers.PasswordHelper;
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
        Cookie[] cookies1 = req.getCookies();
        boolean check = false;
        if (cookies1 != null) {
            for (Cookie c : cookies1) if (c.getName().equals("username")) check = true;
        }

        String sessionUser = (String) req.getSession().getAttribute("username");
        System.out.println(sessionUser);
        if ((sessionUser == null)&&(!check)) {
            req.getRequestDispatcher("/login.ftl").forward(req,resp);
        } else {
            req.getRequestDispatcher("/account").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println(login);
        System.out.println(password);

        int i = 0;
        if (req.getParameter("remember") != null) {
            i = Integer.parseInt(req.getParameter("remember"));
        }

        User userDB = userDao.getByEMail(login);

        boolean isLogin = false;

        String now = PasswordHelper.encrypt(password);

        if(userDB != null) {
            if (login.equals(userDB.getMail()) && now.equals(userDB.getPassword())) {
                isLogin = true;
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", login);
                httpSession.setMaxInactiveInterval(60 * 60);
                if(i == 1) {
                    Cookie userCookie = new Cookie("username", login);
                    userCookie.setMaxAge(24 * 60 * 60);
                    resp.addCookie(userCookie);
                    System.out.println("cookie");
                }
                System.out.println("account2");
                resp.sendRedirect("/account");
            }
        }
        if(!isLogin)
        req.getRequestDispatcher("/login.ftl").forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
