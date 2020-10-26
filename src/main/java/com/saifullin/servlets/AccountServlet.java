package com.saifullin.servlets;

import com.saifullin.dao.Dao;
import com.saifullin.dao.impl.FlightDaoImpl;
import com.saifullin.dao.impl.FlyDaoImpl;
import com.saifullin.dao.impl.UserDaoImpl;
import com.saifullin.models.Flight;
import com.saifullin.models.Fly;
import com.saifullin.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AccountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
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
            boolean checkСonflict = true;
            if ((sessionUser != null) && (userName != null) && (!sessionUser.equals(userName))) checkСonflict = false;
            if(userName == null) userName = sessionUser;

//            проверяем существует ли такой аккаунт
            User userDB = userDao.getByEMail(userName);
            httpSession.setAttribute("userName", sessionUser);

            if ((userName.equals(userDB.geteMail())) && (checkСonflict)) {
                String error = " ";

                UserDaoImpl userdao = new UserDaoImpl();
                FlyDaoImpl flyDao = new FlyDaoImpl();
                User user = userdao.getByEMail(userName);

//                если человек только вошел, то нужно добавить этот полет в список
                if (req.getSession().getAttribute("flightAnonim") != null) {
                    int i = (int) req.getSession().getAttribute("flightAnonim");
                    boolean check1 = true;
//                    проверяем есть ли у него такой же полет
                    if (!flyDao.check(user.getId(),i,1)){
                        flyDao.save(user.getId(), i, 1);
                        System.out.println("net takogo poleta");
                    } else {
                        error = "У вас уже есть такой полет";
                    }
                }
                if (req.getAttribute("errorAccount") != null) error = (String) req.getAttribute("errorAccount");

                req.setAttribute("errorAccount", error);
                List<Fly> flies = flyDao.getAllById(user.getId());
//                отображаем все полеты
                req.setAttribute("flies", flies);
                System.out.println(flies.size());
                req.getRequestDispatcher("account.ftl").forward(req, resp);
            } else {
                req.getRequestDispatcher("login.ftl");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl dao = new UserDaoImpl();
        FlyDaoImpl flyDao = new FlyDaoImpl();

        String userName = null;
        Cookie[] cookies1 = req.getCookies();
        if (cookies1 != null) {
            for (Cookie c : cookies1) {
                if (c.getName().equals("username")) {
                    userName = c.getValue();
                }
            }
        }

        if ((req.getParameter("dataFlight") != null) && (req.getParameter("dataPriority") != null)) {
            User user1 = dao.getByEMail(userName);
//            удаляем по данным
            System.out.println("-------");
            System.out.println(user1.getId());
            System.out.println(Integer.parseInt(req.getParameter("dataFlight")));
            System.out.println(Integer.parseInt(req.getParameter("dataPriority")));
            flyDao.delete(user1.getId(),Integer.parseInt(req.getParameter("dataFlight")),Integer.parseInt(req.getParameter("dataPriority")));
            resp.sendRedirect("/account");
        }

        if ((req.getParameter("deleteAccount") != null)) {
            dao.delete(userName);
            resp.sendRedirect("/logout");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
