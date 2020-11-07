package com.saifullin.servlets;

import com.google.gson.Gson;
import com.saifullin.dao.impl.MessageDaoImpl;
import com.saifullin.dao.impl.UserDaoImpl;
import com.saifullin.models.Flight;
import com.saifullin.models.Message;
import com.saifullin.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "chatServlet", urlPatterns = "/chat")
public class ChatServlet  extends HttpServlet {

    int id = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies1 = req.getCookies();
        HttpSession httpSession = req.getSession();
        boolean check = false;
        String userName = null;

//        ищем в куки пользователя
        if (cookies1 != null) {
            for (Cookie c : cookies1) {
                if (c.getName().equals("username")) {
                    userName = c.getValue();
                    check = true;
                }
            }
        }

//        ищем пользователя в атрибутах запроса
        String sessionUser = (String) httpSession.getAttribute("username");

//        проверяем данные с куки и запроса
        if ((sessionUser == null) && (!check)) {
            resp.sendRedirect("/login");
        } else {
            UserDaoImpl userDao = new UserDaoImpl();

//            проверяем отличаются ли данные о USER в запросах и куки если да, то что-то не так
            boolean checkConflict = true;
            if ((sessionUser != null) && (userName != null) && (!sessionUser.equals(userName))) checkConflict = false;
            if (userName == null) userName = sessionUser;

//            проверяем существует ли такой аккаунт
            User userDB = userDao.getByEMail(userName);
            httpSession.setAttribute("userName", sessionUser);

            if ((userName.equals(userDB.getMail())) && (checkConflict)) {

                MessageDaoImpl messageDao = new MessageDaoImpl();

                List<Message> messages = messageDao.getAll(userDB.getId());

                id = userDB.getId();

                for (int i = 0; i < messages.size(); i++) {
                    System.out.println(messages.get(i).getText());
                }


                req.getRequestDispatcher("chat.ftl").forward(req, resp);
            } else {
                resp.sendRedirect("/login");
            }
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageDaoImpl messageDao = new MessageDaoImpl();

        if( req.getParameter("text") != null) {
            System.out.println("text");
            Timestamp dateCurrent = new Timestamp(Calendar.getInstance().getTime().getTime());
            messageDao.save(new Message(id, req.getParameter("text"), null, dateCurrent, "send", "new"));

            List<Message> messages = messageDao.getAll(id);
            Comparator<Message> comparator = Comparator.comparing(obj -> obj.getDate());
            messages.sort(comparator);
            String json = new Gson().toJson(messages);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }

        if( req.getParameter("check") != null) {
            System.out.println("check");
            List<Message> messages = messageDao.getAll(id);

            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("" + messages.size());
        }

        if( req.getParameter("refresh") != null) {
            System.out.println("refresh");

            List<Message> messages = messageDao.getAll(id);

            Comparator<Message> comparator = Comparator.comparing(obj -> obj.getDate());
            messages.sort(comparator);

            String json = new Gson().toJson(messages);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
    }
}
