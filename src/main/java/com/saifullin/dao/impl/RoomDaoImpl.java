package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements Dao<Room> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Room get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"room\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("about"),
                        resultSet.getString("image"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("persons"),
                        resultSet.getString("convenience")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Room> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"user\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("about"),
                        resultSet.getString("image"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("persons"),
                        resultSet.getString("convenience")
                );
                rooms.add(room);
            }

            return rooms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Room room) {

    }
}