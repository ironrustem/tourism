package com.saifullin.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class  LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logout(req, resp);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        HttpSession httpSession = req.getSession(false);
        if (httpSession != null) {
            httpSession.invalidate();
        }

        req.getRequestDispatcher("/main").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logout(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
