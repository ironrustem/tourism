package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;
import com.saifullin.models.Date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateHotelDaoImpl implements Dao<DateHotel> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    @Override
    public DateHotel get(int id) {
        return null;
    }

    public DateHotel get(String date) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM \"dateHotel\" WHERE date = " + date;
            ResultSet resultSet = statement.executeQuery(sql);

            Dao<Room> dao = new RoomDaoImpl();

            return new DateHotel(
                    resultSet.getInt("id"),
                    new Date(resultSet.getString("date1")),
                    dao.get(resultSet.getInt("id_room")),
                    resultSet.getInt("allNumberRoom"),
                    resultSet.getInt("freeNumberRoom")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<DateHotel> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"dateHotel\"";
            ResultSet resultSet = statement.executeQuery(sql);

            Dao<Room> dao = new RoomDaoImpl();

            List<DateHotel> dateHotels = new ArrayList<>();
            while (resultSet.next()) {
                DateHotel dateHotel = new DateHotel(
                        resultSet.getInt("id"),
                        new Date(resultSet.getString("date1")),
                        dao.get(resultSet.getInt("id_room")),
                        resultSet.getInt("allNumberRoom"),
                        resultSet.getInt("freeNumberRoom")
                );
                dateHotels.add(dateHotel);
            }

            return dateHotels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(DateHotel dateHotel) {
        String sql = "INSERT INTO \"dateHotel\" (date1, id_room, allNumberRoom, freeNumberRoom) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dateHotel.getDate().toString());
            preparedStatement.setInt(2, dateHotel.getRoom().getId());
            preparedStatement.setInt(3, dateHotel.getAllNumberRoom());
            preparedStatement.setInt(4, dateHotel.getFreeNumberRoom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
