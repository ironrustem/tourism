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
            return getFlies(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Fly> getFlies(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);

        List<Fly> flies = new ArrayList<>();

        Dao<User> daoUser = new UserDaoImpl();
        Dao<Flight> daoFlight = new FlightDaoImpl();
        while (resultSet.next()) {
            Fly fly = new Fly(
                    daoUser.get(resultSet.getInt("id_user")),
                    daoFlight.get(resultSet.getInt("id_flight"))
            );
            flies.add(fly);
        }

        return flies;
    }

    public boolean check(int user, int flight) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"fly\" WHERE id_user = " + user
                    + " AND id_flight = " + flight;
            ResultSet resultSet = statement.executeQuery(sql);
            boolean check = false;
            if (resultSet.next()) check = true;
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


    public void delete(int user, int flight) {
        System.out.println("ddddd");
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM \"fly\" WHERE id_user = " + user
                    + " AND id_flight = " + flight;
            System.out.println(sql);
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
            return getFlies(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Fly fly) {
        String sql = "INSERT INTO \"fly\" (id_user, id_flight) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, fly.getUser().getId());
            preparedStatement.setInt(2, fly.getFlight().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(int id_user, int id_flight) {
        String sql = "INSERT INTO \"fly\" (id_user, id_flight) VALUES (?, ?);";
        System.out.println("addFly");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_user);
            preparedStatement.setInt(2, id_flight);
            preparedStatement.executeUpdate();
            System.out.println("go");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}