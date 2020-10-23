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
            String sql = "SELECT 1 FROM \"room\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Room(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("price"),
                    resultSet.getInt("quantity"),
                    resultSet.getInt("persons"),
                    resultSet.getString("roomConvenience")
            );

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
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("persons"),
                        resultSet.getString("roomConvenience")
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
        String sql = "INSERT INTO \"user\" (name, price, quantity, persons, roomConvenience) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, room.getName());
            preparedStatement.setInt(2, room.getPrice());
            preparedStatement.setInt(3, room.getQuantity());
            preparedStatement.setInt(4, room.getPersons());
            preparedStatement.setString(5, room.getConvenience());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}