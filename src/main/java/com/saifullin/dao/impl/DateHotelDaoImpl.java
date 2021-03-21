package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateHotelDaoImpl implements Dao<DateHotel> {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public DateHotel get(int id) {
        return null;
    }

    public List<DateHotel> get(String date) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"datehotel\" WHERE date1 = '" + date + "' AND freenumberroom > 0";
            return getDateHotels(statement, sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<DateHotel> getDateHotels(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);

        Dao<Room> dao = new RoomDaoImpl();

        List<DateHotel> dateHotels = new ArrayList<>();
        while (resultSet.next()) {
            DateHotel dateHotel = new DateHotel(
                    resultSet.getDate("date1"),
                    dao.get(resultSet.getInt("id_room")),
                    resultSet.getInt("freenumberroom")
            );
            dateHotels.add(dateHotel);
        }
        return dateHotels;
    }


    @Override
    public List<DateHotel> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"datehotel\"";
            return getDateHotels(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void save(DateHotel dateHotel) {
        String sql = "INSERT INTO \"datehotel\" (date1, id_room, freenumberroom) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, dateHotel.getDate());
            preparedStatement.setInt(2, dateHotel.getRoom().getId());
            preparedStatement.setInt(3, dateHotel.getFreeNumberRoom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
