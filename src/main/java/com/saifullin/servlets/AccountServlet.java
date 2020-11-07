package com.saifullin.servlets;

import com.google.gson.Gson;
import com.saifullin.dao.impl.*;
import com.saifullin.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AccountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {

    private HashMap<Integer, Boolean> mapService = new HashMap<>();
    private int editOrder = 0;

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

            if (userName != null) {
                if ((userName.equals(userDB.getMail())) && (checkConflict)) {
                    String error = " ";
                    FlyDaoImpl flyDao = new FlyDaoImpl();
                    OrderHotelDaoImpl orderHotelDao = new OrderHotelDaoImpl();
                    User user = userDao.getByEMail(userName);

//                если человек только вошел, то нужно добавить этот полет в список
                    if (httpSession.getAttribute("flightAnon") != null) {
                        int i = (int) httpSession.getAttribute("flightAnon");
//                    проверяем есть ли у него такой же полет
                        if (!flyDao.check(user.getId(), i)) {
                            flyDao.save(user.getId(), i);
                            System.out.println("add");
                        } else {
                            System.out.println("NOadd");
                            error = "У вас уже есть такой полет";
                        }
//                    удаляем использованный атрибут
                        httpSession.removeAttribute("flightAnon");
                    }

//                если человек только вошел, то нужно добавить этот отель в список
                    if ((httpSession.getAttribute("hotelAnon") != null) &&
                            (httpSession.getAttribute("date1hotelAnon") != null) && (httpSession.getAttribute("date1hotelAnon") != null)) {
                        int i = (int) httpSession.getAttribute("hotelAnon");
                        Date date1 = (Date) httpSession.getAttribute("date1hotelAnon");
                        Date date2 = (Date) httpSession.getAttribute("date2hotelAnon");
                        int n = (int) httpSession.getAttribute("daysAnon");


//                    проверяем есть ли у него такой же отель
                        if (!orderHotelDao.check(user.getId(), i, date1, date2)) {
                            RoomDaoImpl roomDao = new RoomDaoImpl();
                            Room room = roomDao.get(i);
                            orderHotelDao.save(new OrderHotel((n * room.getPrice()), room, user.getId(), date1, date2));
                        } else {
                            error = "У вас уже есть такая бронь отеля";
                        }
//                    удаляем использованный атрибут
                        httpSession.removeAttribute("hotelAnon");
                        httpSession.removeAttribute("date1hotelAnon");
                        httpSession.removeAttribute("date2hotelAnon");
                        httpSession.removeAttribute("services");
                    }

                    if (req.getAttribute("errorAccount") != null) {
                        error = (String) req.getAttribute("errorAccount");
                        httpSession.removeAttribute("errorAccount");
                    }
                    req.setAttribute("errorAccount", error);
                    List<Fly> flies = flyDao.getAllById(user.getId());
                    List<OrderHotel> orderHotels1 = orderHotelDao.getAllById(user.getId());
//                отображаем все полеты
                    req.setAttribute("flies", flies);
                    for (int i = 0; i < flies.size(); i++) {
                        System.out.println(flies.get(i).getFlight());
                    }
                    req.setAttribute("hotels", orderHotels1);

                    req.setAttribute("idUser", user.getId());
                    req.getRequestDispatcher("account.ftl").forward(req, resp);
                } else {
                    req.getRequestDispatcher("login.ftl");
                }
            } else {
                req.getRequestDispatcher("login.ftl");

            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FlyDaoImpl flyDao = new FlyDaoImpl();
        OrderHotelDaoImpl orderHotelDao = new OrderHotelDaoImpl();


        String userName = null;
        Cookie[] cookies1 = req.getCookies();
        if (cookies1 != null) {
            for (Cookie c : cookies1) {
                if (c.getName().equals("username")) {
                    userName = c.getValue();
                }
            }
        }
        if (userName == null) {
            HttpSession httpSession = req.getSession();
            userName = (String) httpSession.getAttribute("username");
        }

        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getByEMail(userName);

        if (req.getParameter("deleteFly") != null) {
            flyDao.delete(user.getId(), Integer.parseInt(req.getParameter("deleteFly")));
            List<Fly> flies = flyDao.getAllById(user.getId());
            System.out.println("test");
            String json = new Gson().toJson(flies);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }

        if (req.getParameter("deleteHot") != null) {
            orderHotelDao.delete(Integer.parseInt(req.getParameter("deleteHot")));
            List<OrderHotel> orderHotels = orderHotelDao.getAllById(user.getId());
            System.out.println("test1");
            String json = new Gson().toJson(orderHotels);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }

        if (req.getParameter("editHotel") != null) {
            System.out.println("point1");
            ServiceOrderDaoImpl serviceOrderDao = new ServiceOrderDaoImpl();
            ServiceDaoImpl serviceDao = new ServiceDaoImpl();

            System.out.println("point2");
            List<ServicesOrder> servicesOrder = serviceOrderDao.getAll(Integer.parseInt(req.getParameter("editHotel")));
            List<Service> services = serviceDao.getAll();

            editOrder = Integer.parseInt(req.getParameter("editHotel"));
            System.out.println("------" + editOrder);
            System.out.println("point3");
            mapService = new HashMap<>();

            System.out.println("point4");
            for (int i = 0; i < services.size(); i++) {
                mapService.put(services.get(i).getId(), false);
            }

            System.out.println("point5");
            for (int i = 0; i < servicesOrder.size(); i++) {
                System.out.println(servicesOrder.get(i).getService().getId());
                mapService.put(servicesOrder.get(i).getService().getId(), true);
                System.out.println(servicesOrder.get(i).getService().getId());
            }

            System.out.println("point5.5");
            List<ServiceOne> serviceOnes = new ArrayList<>();

            System.out.println("point6");
            for (Map.Entry<Integer, Boolean> entry : mapService.entrySet()) {
                String s = "";
                if (entry.getValue()) s = "checked";
                serviceOnes.add(new ServiceOne(serviceDao.get(entry.getKey()), s));
            }
            System.out.println("point7");

            System.out.println("test11111111");
            String json = new Gson().toJson(serviceOnes);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }

        if (req.getParameter("saveHotel") != null) {
            if (!req.getParameter("saveHotel").equals("-1")) {
                if (!req.getParameter("saveHotel").equals("")) {
                    System.out.println("point-1");
                    ServiceDaoImpl serviceDao = new ServiceDaoImpl();
                    System.out.println("point-2");


                    System.out.println("point-3");

                    System.out.println("+" + req.getParameter("saveHotel") + "+");

                    String[] split = req.getParameter("saveHotel").split("/");
                    System.out.println("point-4");

                    List<Service> services = serviceDao.getAll();
                    HashMap<Integer, Boolean> map2 = new HashMap<>();

                    System.out.println("point-5");
                    for (int i = 0; i < services.size(); i++) {
                        map2.put(services.get(i).getId(), false);
                    }

                    System.out.println("point-6");
                    System.out.println(split.length);
                    System.out.println(split[1]);
                    for (int i = 1; i < split.length; i++) {
                        System.out.println(split[i]);
                        map2.put(Integer.parseInt(split[i]) + 1, true);
                    }

                    System.out.println("point-7");
                    ServiceOrderDaoImpl serviceOrderDao = new ServiceOrderDaoImpl();

                    System.out.println("point-8");
                    for (Map.Entry<Integer, Boolean> entry : mapService.entrySet()) {
                        System.out.println("c " + entry.getKey() + " - " + entry.getValue() + " " + map2.get(entry.getKey()));
                        if (entry.getValue() != map2.get(entry.getKey())) {
                            System.out.println("not " + entry.getValue() + " - " + entry.getValue() + " " + map2.get(entry.getKey()));
                            if (map2.get(entry.getKey())) {
                                System.out.println("add");
                                int plus = 0;
                                serviceOrderDao.save(editOrder, entry.getKey());
                                if (serviceDao.get(entry.getKey()).isMultiply()) {
                                    plus = plus + (orderHotelDao.get(editOrder).getRoom().getPersons() * serviceDao.get(entry.getKey()).getPrice());
                                    System.out.println("multy");
                                    System.out.println(serviceDao.get(entry.getKey()).getPrice());
                                    System.out.println(orderHotelDao.get(editOrder).getRoom().getPersons());
                                } else {
                                    plus = plus + serviceDao.get(entry.getKey()).getPrice();
                                }

                                orderHotelDao.update(editOrder, orderHotelDao.get(editOrder).getPrice() + plus);
                                System.out.println(plus);
                            } else {
                                System.out.println("delete");
                                int plus = 0;
                                serviceOrderDao.delete(editOrder, entry.getKey());
                                if (!serviceDao.get(entry.getKey()).isMultiply()) {
                                    plus = plus - (orderHotelDao.get(editOrder).getRoom().getPersons() * serviceDao.get(entry.getKey()).getPrice());
                                    System.out.println("multy");
                                } else {
                                    plus = plus - serviceDao.get(entry.getKey()).getPrice();
                                }
                                orderHotelDao.update(editOrder, orderHotelDao.get(editOrder).getPrice() + plus);
                                System.out.println(plus);
                            }
                        }
                    }


                    System.out.println(services.size());
                    System.out.println(split.length);
                    for (int i = 0; i < split.length; i++) {
                        System.out.println(split[i]);
                    }
                }
            }
            OrderHotel orderHotel = orderHotelDao.getId(editOrder);
            System.out.println(editOrder);
            String json = new Gson().toJson(orderHotel);
            System.out.println(json);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        }


        if (req.getParameter("deleteAccount") != null) {
            userDao.delete(userName);
            resp.sendRedirect("/logout");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
