package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;
import com.saifullin.models.Date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderHotelDaoImpl implements Dao<OrderHotel> {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public OrderHotel get(int id_user) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM \"orderHotel\" WHERE id_user = " + id_user;
            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Room> dao = new RoomDaoImpl();

            return new OrderHotel(
                    resultSet.getInt("id"),
                    resultSet.getInt("price"),
                    dao.get(resultSet.getInt("id")),
                    resultSet.getInt("id_user"),
                    new Date(resultSet.getString("date1")),
                    resultSet.getInt("days")
                    );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderHotel> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"orderHotel\"";
            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Room> dao = new RoomDaoImpl();

            List<OrderHotel> orderHotels = new ArrayList<>();
            while (resultSet.next()) {
                OrderHotel orderHotel = new OrderHotel(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        dao.get(resultSet.getInt("id")),
                        resultSet.getInt("id_user"),
                        new Date(resultSet.getString("date1")),
                        resultSet.getInt("days")
                );
                orderHotels.add(orderHotel);
            }

            return orderHotels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(OrderHotel orderHotel) {
        String sql = "INSERT INTO \"orderHotel\" (price, id_room, id_user, date1 , days) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderHotel.getPrice());
            preparedStatement.setInt(2, orderHotel.getRoom().getId());
            preparedStatement.setInt(3, orderHotel.getId_user());
            preparedStatement.setString(4, orderHotel.getDate().toString());
            preparedStatement.setInt(5, orderHotel.getDays());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}