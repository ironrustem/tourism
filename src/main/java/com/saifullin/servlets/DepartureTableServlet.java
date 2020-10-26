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
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DepartureTableServlet", urlPatterns = "/departure")
public class DepartureTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Dao<Flight> dao = new FlightDaoImpl();
        List<Flight> list = dao.getAll();
        List<Flight> flights = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Flight f = list.get(i);
            if ((f.getType().equals("departure")) && (i <= 20)) {
                flights.add(f);
            }
        }
        httpSession.setAttribute("flights", flights);
        req.getRequestDispatcher("departure.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies1 = req.getCookies();
        HttpSession httpSession = req.getSession();
        int i = Integer.parseInt(req.getParameter("data"));
        req.getSession().setAttribute("flightAnonim",i);

        boolean check = false;
        if (cookies1 != null) {
            for (Cookie c : cookies1) {
                if (c.getName().equals("username")) {
                    check = true;
                }
            }
        }

        String sessionUser = (String) httpSession.getAttribute("username");

        if ((sessionUser == null) && (!check)) {
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/account");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
