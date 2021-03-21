package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements Dao<Flight> {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    public List<Flight> getArrival(int i, int hourTag, String s) {
        try {
            Statement statement = connection.createStatement();
            int i1 = 0;
            int i2 = 0;
            switch (hourTag) {
                case (1):
                    i1 = 0;
                    i2 = 6;
                    break;
                case (2):
                    i1 = 7;
                    i2 = 12;
                    break;
                case (3):
                    i1 = 13;
                    i2 = 18;
                    break;
                case (4):
                    i1 = 19;
                    i2 = 23;
                    break;
            }
            String sql;
            if (hourTag == 0) {
                int i3 = i + 1;
                sql = "SELECT * FROM \"flight\" WHERE type = 'arrival' AND date1 > 'today'::timestamp + INTERVAL '" + i + " day' AND date1 < 'today'::timestamp + INTERVAL '" + i3 + " day'";
            } else {
                sql = "SELECT * FROM \"flight\" WHERE type = 'arrival' AND date1 > 'today'::timestamp + INTERVAL '" + i + " day " + i1 + " hour' AND date1 < 'today'::timestamp + INTERVAL '" + i + " day " + i2 + " hour'";
            }

            if (s.equals("noBody")) {
                return getFlights(statement, sql);
            } else {
                CityDaoImpl city = new CityDaoImpl();
                FlightDaoImpl dao = new FlightDaoImpl();
                List<Integer> listCity = city.getIDs(s);
                List<Flight> result = new ArrayList<>();

                for (Integer integer : listCity) {
                    String sql1 = sql + "AND id_city = " + integer;
                    result.addAll(getFlights(statement, sql1));
                }

                for (Integer integer : listCity) {
                    String sql1 = sql + "AND id_city = " + integer;
                    result.addAll(getFlights(statement, sql1));
                }
                result.addAll(dao.getAllby(s));
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Flight> getDeparture(int i, int hourTag, String s) {
        try {
            Statement statement = connection.createStatement();
            int i1 = 0;
            int i2 = 0;
            switch (hourTag) {
                case (1):
                    i1 = 0;
                    i2 = 6;
                    break;
                case (2):
                    i1 = 7;
                    i2 = 12;
                    break;
                case (3):
                    i1 = 13;
                    i2 = 18;
                    break;
                case (4):
                    i1 = 19;
                    i2 = 23;
                    break;
            }
            String sql;
            if (hourTag == 0) {
                int i3 = i + 1;
                sql = "SELECT * FROM \"flight\" WHERE type = 'departure' AND date1 > 'today'::timestamp + INTERVAL '" + i + " day' AND date1 < 'today'::timestamp + INTERVAL '" + i3 + " day'";
            } else {
                sql = "SELECT * FROM \"flight\" WHERE type = 'departure' AND date1 > 'today'::timestamp + INTERVAL '" + i + " day " + i1 + " hour' AND date1 < 'today'::timestamp + INTERVAL '" + i + " day " + i2 + " hour'";
            }

            System.out.println(sql);



            if (s.equals("noBody")) {
                return getFlights(statement, sql);
            } else {
                CityDaoImpl city = new CityDaoImpl();
                FlightDaoImpl dao = new FlightDaoImpl();
                List<Integer> listCity = city.getIDs(s);
                List<Flight> result = new ArrayList<>();

                for (Integer integer : listCity) {
                    String sql1 = sql + "AND id_city = " + integer;
                    result.addAll(getFlights(statement, sql1));
                }
                result.addAll(dao.getAllby(s));
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
                        resultSet.getTimestamp("date1"),
                        resultSet.getTimestamp("date2"),
                        daoPlane.get(resultSet.getInt("id_plane")),
                        daoCity.get(resultSet.getInt("id_city")),
                        resultSet.getString("terminal"),
                        resultSet.getString("type"),
                        resultSet.getString("status"),
                        resultSet.getString("number"),
                        resultSet.getString("company")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Flight> getAllby(String id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"flight\" WHERE number LIKE '" + id.toUpperCase() + "%'";
            Dao<Plane> daoPlane = new PlaneDaoImpl();
            Dao<City> daoCity = new CityDaoImpl();

            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("date1"),
                        resultSet.getTimestamp("date2"),
                        daoPlane.get(resultSet.getInt("id_plane")),
                        daoCity.get(resultSet.getInt("id_city")),
                        resultSet.getString("terminal"),
                        resultSet.getString("type"),
                        resultSet.getString("status"),
                        resultSet.getString("number"),
                        resultSet.getString("company")
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
    public List<Flight> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"flight\"";
            return getFlights(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Flight> getFlights(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);

        Dao<Plane> daoPlane = new PlaneDaoImpl();
        Dao<City> daoCity = new CityDaoImpl();
        List<Flight> flights = new ArrayList<>();
        while (resultSet.next()) {
            Flight flight = new Flight(
                    resultSet.getInt("id"),
                    resultSet.getTimestamp("date1"),
                    resultSet.getTimestamp("date2"),
                    daoPlane.get(resultSet.getInt("id_plane")),
                    daoCity.get(resultSet.getInt("id_city")),
                    resultSet.getString("terminal"),
                    resultSet.getString("type"),
                    resultSet.getString("status"),
                    resultSet.getString("number"),
                    resultSet.getString("company")
            );
            flights.add(flight);
        }

        return flights;
    }

    @Override
    public void save(Flight flight) {
    }
}