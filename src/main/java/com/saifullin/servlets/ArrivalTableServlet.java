package com.saifullin.servlets;

import com.google.gson.Gson;
import com.saifullin.dao.impl.FlightDaoImpl;
import com.saifullin.models.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "ArrivalTableServlet", urlPatterns = "/arrival")
public class ArrivalTableServlet extends HttpServlet {

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

        req.setAttribute("day", day);
        req.setAttribute("type", "Вылеты");
        req.setAttribute("hourTag", hourTag);
        req.getRequestDispatcher("table.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("gogogogog");
        DepartureTableServlet.flightPost(req, resp);
        Comparator<Flight> comparator = Comparator.comparing(obj -> obj.getDate2());
        System.out.println("1");
        if (req.getParameter("day") != null) day = Integer.parseInt(req.getParameter("day"));
        System.out.println("2");

        if(req.getParameter("hourTag") != null) {
            hourTag = Integer.parseInt(req.getParameter("hourTag"));
        }

        System.out.println("3");

        if(((req.getParameter("hourTag")) == null)&&(req.getParameter("day") != null)) {
            hourTag = 0;
        }
        System.out.println("4");


        String search = "noBody";
        if(req.getParameter("search") != null){
            search = req.getParameter("search");
            System.out.println("search = " + req.getParameter("search") );
        }
        System.out.println("5");

        FlightDaoImpl dao = new FlightDaoImpl();
        System.out.println("hourTag = " + hourTag);
        System.out.println(hourTag);
        System.out.println(day);
        System.out.println(search);
        List<Flight> list = dao.getArrival(day,hourTag, search);
        list.sort(comparator);
        String json = new Gson().toJson(list);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
