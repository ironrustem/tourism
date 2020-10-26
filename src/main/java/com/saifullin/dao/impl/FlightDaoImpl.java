package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;
import com.saifullin.models.Date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements Dao<Flight> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Flight get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"flight\" WHERE id = '" + id + "'";
            Dao<Plane> daoPlane = new PlaneDaoImpl();
            Dao<City> daoCity = new CityDaoImpl();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return new Flight(
                        resultSet.getInt("id"),
                        new Date(resultSet.getString("date1")),
                        new Date(resultSet.getString("date2")),
                        daoPlane.get(resultSet.getInt("id_plane")),
                        daoCity.get(resultSet.getInt("id_city")),
                        resultSet.getString("terminal"),
                        resultSet.getString("type"),
                        resultSet.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"flight\"";
            ResultSet resultSet = statement.executeQuery(sql);

            Dao<Plane> daoPlane = new PlaneDaoImpl();
            Dao<City> daoCity = new CityDaoImpl();
            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        new Date(resultSet.getString("date1")),
                        new Date(resultSet.getString("date2")),
                        daoPlane.get(resultSet.getInt("id_plane")),
                        daoCity.get(resultSet.getInt("id_city")),
                        resultSet.getString("terminal"),
                        resultSet.getString("type"),
                        resultSet.getString("status")
                );
                flights.add(flight);
            }

            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Flight flight) {
        String sql = "INSERT INTO \"flight\" (date1, date2, id_plane, id_city, terminal, status, type) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flight.getDate1().toString());
            preparedStatement.setString(2, flight.getDate2().toString());
            preparedStatement.setInt(3, flight.getPlane().getId());
            preparedStatement.setInt(4, flight.getCity().getId());
            preparedStatement.setString(5, flight.getTerminal());
            preparedStatement.setString(6, flight.getType());
            preparedStatement.setString(7, flight.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}