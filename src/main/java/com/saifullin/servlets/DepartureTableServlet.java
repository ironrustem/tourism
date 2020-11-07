package com.saifullin.servlets;

import com.google.gson.Gson;
import com.saifullin.dao.impl.FlightDaoImpl;
import com.saifullin.models.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "DepartureTableServlet", urlPatterns = "/departure")
public class DepartureTableServlet extends HttpServlet {

    int day = 0;
    int hourTag = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlightDaoImpl dao = new FlightDaoImpl();

        int hourNow = Integer.parseInt(new java.util.Date().toString().substring(11,13));
        day = 0;
        if((0 <= hourNow)&&(6 >= hourNow)) hourTag = 1;
        if((6 < hourNow)&&(12 >= hourNow)) hourTag = 2;
        if((12 < hourNow)&&(18 >= hourNow)) hourTag = 3;
        if((18 < hourNow)&&(24 >= hourNow)) hourTag = 4;

        req.setAttribute("type", "Прилеты");
        req.setAttribute("day", day);
        req.setAttribute("hourTag", hourTag);
        req.getRequestDispatcher("table.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        DepartureTableServlet.flightPost(req, resp);
        Comparator<Flight> comparator = Comparator.comparing(obj -> obj.getDate1());
        if (req.getParameter("day") != null) day = Integer.parseInt(req.getParameter("day"));
        if(req.getParameter("hourTag") != null) {
            hourTag = Integer.parseInt(req.getParameter("hourTag"));
        }

        if(((req.getParameter("hourTag")) == null)&&(req.getParameter("day") != null)) {
            hourTag = 0;
        }


        String search = "noBody";
        if(req.getParameter("search") != null){
            search = req.getParameter("search");
            System.out.println("search = " + req.getParameter("search") );
        }

        FlightDaoImpl dao = new FlightDaoImpl();
        List<Flight> list = dao.getDeparture(day,hourTag, search);
        list.sort(comparator);
        String json = new Gson().toJson(list);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    static void flightPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies1 = req.getCookies();
        HttpSession httpSession = req.getSession();
        if (req.getParameter("data") != null) {
            System.out.println("data = " + req.getParameter("data"));
            int i = Integer.parseInt(req.getParameter("data"));
            System.out.println(req.getParameter("data"));
            httpSession.setAttribute("flightAnon", i);

            BookingHotel.loginOrAccount(resp, cookies1, httpSession);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
