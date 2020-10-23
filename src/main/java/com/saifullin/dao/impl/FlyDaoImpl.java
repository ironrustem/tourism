package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlyDaoImpl implements Dao<Fly> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Fly get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM \"fly\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            Dao<User> daoUser = new UserDaoImpl();
            Dao<Flight> daoFlight = new FlightDaoImpl();
            Dao<PriorityFly> daoPriorityFly = new PriorityFlyDaoImpl();
            return new Fly(
                    daoUser.get(resultSet.getInt("id_user")),
                    daoFlight.get(resultSet.getInt("id_flight")),
                    daoPriorityFly.get(resultSet.getInt("id_priorityFly"))

            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
}