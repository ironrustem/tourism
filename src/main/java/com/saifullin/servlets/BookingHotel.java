package com.saifullin.servlets;

import com.saifullin.dao.impl.DateHotelDaoImpl;
import com.saifullin.dao.impl.RoomDaoImpl;
import com.saifullin.dao.impl.ServiceDaoImpl;
import com.saifullin.models.DateHotel;
import com.saifullin.models.Room;
import com.saifullin.models.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

@WebServlet(name = "bookingServlet", urlPatterns = "/booking")
public class BookingHotel extends HttpServlet {

    Date date1 = null;
    Date date2 = null;

    int n;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        date1 = (Date) httpSession.getAttribute("date1");
        date2 = (Date) httpSession.getAttribute("date2");

        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        cal.setTime(date1);
        cal1.setTime(date2);
        DateHotelDaoImpl daoHotel = new DateHotelDaoImpl();
        HashMap<Integer, Integer> map = new HashMap<>();
        n = 0;
        while (cal.compareTo(cal1) < 1) {
            n++;
            Date date = new Date(cal.getTime().getTime());
            List<DateHotel> dateHotels = daoHotel.get(date.toString());
            for (DateHotel dateHotel : dateHotels) {
                int j = dateHotel.getRoom().getId();
                if (map.containsKey(j)) {
                    map.put(j, map.get(j) + 1);
                } else {
                    map.put(j, 1);
                }
            }
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }

        List<Room> rooms = new ArrayList<>();
        RoomDaoImpl roomHotel = new RoomDaoImpl();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == n) {
                rooms.add(roomHotel.get(pair.getKey()));
            }
        }


        req.setAttribute("rooms", rooms);

        req.getRequestDispatcher("bookingHotel.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        Cookie[] cookies1 = req.getCookies();
        HttpSession httpSession = req.getSession();
        if (req.getParameter("idRoom") != null) {
            httpSession.setAttribute("hotelAnon", Integer.parseInt(req.getParameter("idRoom")));
            httpSession.setAttribute("date1hotelAnon", date1);
            httpSession.setAttribute("date2hotelAnon", date2);
            httpSession.setAttribute("daysAnon", n);

            loginOrAccount(resp, cookies1, httpSession);
        }
    }

    static void loginOrAccount(HttpServletResponse resp, Cookie[] cookies1, HttpSession httpSession) throws IOException {
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
