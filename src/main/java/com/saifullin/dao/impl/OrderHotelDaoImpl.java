package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderHotelDaoImpl implements Dao<OrderHotel> {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public OrderHotel get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"orderhotel\" WHERE id = " + id;
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Room> dao = new RoomDaoImpl();

            if (resultSet.next()) {
                return new OrderHotel(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        dao.get(resultSet.getInt("id_room")),
                        resultSet.getInt("id_user"),
                        resultSet.getDate("date1"),
                        resultSet.getDate("date2")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OrderHotel getId(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"orderhotel\" WHERE id = " + id;
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Room> dao = new RoomDaoImpl();

            if (resultSet.next()) {
                return new OrderHotel(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        dao.get(resultSet.getInt("id_room")),
                        resultSet.getInt("id_user"),
                        resultSet.getDate("date1"),
                        resultSet.getDate("date2")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Boolean check(int id_user, int id_room, Date date1, Date date2) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"orderhotel\" WHERE id_user = " + id_user + " AND id_room = " +
                    id_room + " AND date1 = '" + date2 + "' AND date2 =  '" + date1 + "'";

            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Room> dao = new RoomDaoImpl();
            boolean check = false;
            if (resultSet.next()) check = true;
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderHotel> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"orderhotel\"";
            return getAllHelp(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(int id, int price) {
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE \"orderhotel\" SET price = " + price + " WHERE id = " + id;
            System.out.println(sql);

            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<OrderHotel> getAllHelp(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        Dao<Room> dao = new RoomDaoImpl();

        List<OrderHotel> orderHotels = new ArrayList<>();
        while (resultSet.next()) {
            OrderHotel orderHotel = new OrderHotel(
                    resultSet.getInt("id"),
                    resultSet.getInt("price"),
                    dao.get(resultSet.getInt("id_room")),
                    resultSet.getInt("id_user"),
                    resultSet.getDate("date1"),
                    resultSet.getDate("date2")
            );
            orderHotels.add(orderHotel);
        }

        return orderHotels;
    }


    public List<OrderHotel> getAllById( int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"orderhotel\" WHERE id_user = " + id;
            return getAllHelp(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM \"orderhotel\" WHERE id = " + id;
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(OrderHotel orderHotel) {
        String sql = "INSERT INTO \"orderhotel\" (price, id_room, id_user, date2 , date1) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderHotel.getPrice());
            preparedStatement.setInt(2, orderHotel.getRoom().getId());
            System.out.println("room" + orderHotel.getRoom().getId());
            preparedStatement.setInt(3, orderHotel.getId_user());
            preparedStatement.setDate(4, orderHotel.getDate());
            preparedStatement.setDate(5, orderHotel.getDate1());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}