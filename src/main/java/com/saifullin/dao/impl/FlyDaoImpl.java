package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlyDaoImpl implements Dao<Fly> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public List<Fly> getAllById(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"fly\" WHERE id_user = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            List<Fly> flies = new ArrayList<>();

            Dao<User> daoUser = new UserDaoImpl();
            Dao<Flight> daoFlight = new FlightDaoImpl();
            Dao<PriorityFly> daoPriorityFly = new PriorityFlyDaoImpl();
            while (resultSet.next()) {
                Fly fly = new Fly(
                        daoUser.get(resultSet.getInt("id_user")),
                        daoFlight.get(resultSet.getInt("id_flight")),
                        daoPriorityFly.get(resultSet.getInt("id_priorityFly"))
                );
                flies.add(fly);
            }

            return flies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean check(int user, int flight, int priorityFly) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"fly\" WHERE id_user = " + user
                    + " AND id_flight = " + flight
                    + " AND id_priorityfly = " + priorityFly;
            ResultSet resultSet = statement.executeQuery(sql);
            boolean check = false;
            if (resultSet.next()) check = true;
            System.out.println(resultSet.next());
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




    @Override
    public Fly get(int id) {
        return null;
    }


    public void delete(int user, int flight, int priorityFly) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM \"fly\" WHERE id_user = " + user
                    + " AND id_flight = " + flight
                    + " AND id_priorityfly = " + priorityFly;
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Fly> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"fly\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Fly> flies = new ArrayList<>();

            Dao<User> daoUser = new UserDaoImpl();
            Dao<Flight> daoFlight = new FlightDaoImpl();
            Dao<PriorityFly> daoPriorityFly = new PriorityFlyDaoImpl();
            while (resultSet.next()) {
                Fly fly = new Fly(
                        daoUser.get(resultSet.getInt("id_user")),
                        daoFlight.get(resultSet.getInt("id_flight")),
                        daoPriorityFly.get(resultSet.getInt("id_priorityFly"))
                );
                flies.add(fly);
            }

            return flies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Fly fly) {
        String sql = "INSERT INTO \"fly\" (id_user, id_flight, id_priorityFly) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, fly.getUser().getId());
            preparedStatement.setInt(2, fly.getFlight().getId());
            preparedStatement.setInt(3, fly.getPriorityFly().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(int id_user, int id_flight, int id_priorityFly) {
        String sql = "INSERT INTO \"fly\" (id_user, id_flight, id_priorityFly) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_user);
            preparedStatement.setInt(2, id_flight);
            preparedStatement.setInt(3, id_priorityFly);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}