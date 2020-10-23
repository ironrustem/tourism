package com.saifullin.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountServlet", urlPatterns = "/accountServlet")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = null;
        String sessionUser = (String) req.getAttribute("username");
        if (sessionUser == null) {
            resp.sendRedirect("/login");
        } else {

            String userName = null;
            String sessionId = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) userName = c.getValue();
                    if (c.getName().equals("JSESSIONID")) sessionId = c.getValue();
                }
            } else {
                sessionId = req.getRequestedSessionId();
            }
            req.setAttribute(sessionId, "sessionId");
            req.setAttribute(userName, "userName");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
