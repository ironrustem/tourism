package com.saifullin.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet(name = "hotelServlet", urlPatterns = "/hotel")
public class HotelServlet extends HttpServlet {

    private String date1Str = "";
    private String date2Str = "";
    private String error = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("date1Str", date1Str);
        req.setAttribute("date2Str", date2Str);
        req.setAttribute("error", error);
        req.getRequestDispatcher("hotel.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        java.util.Date selectedDate1;
        Date date1 = null;
        java.util.Date selectedDate2;
        Date date2 = null;
        try {
            selectedDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date1"));
            date1 =  new Date(selectedDate1.getTime());
            selectedDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date2"));
            date2 =  new Date(selectedDate2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date dateCurrent = new Date(Calendar.getInstance().getTime().getTime());


        if((date1.compareTo(date2) == -1)&&((date1.compareTo(dateCurrent) >= 0)||(date1.toString().equals(dateCurrent.toString())))){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("date1", date1);
            httpSession.setAttribute("date2", date2);
            resp.sendRedirect("booking");
        } else {
            date1Str = date1.toString();
            date2Str = date2.toString();
            error = "Укажите актуальные даты";
            resp.sendRedirect("hotel");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
