package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PriorityFlyDaoImpl implements Dao<PriorityFly> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    @Override
    public PriorityFly get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM \"priorityFly\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new PriorityFly(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("timePriority")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PriorityFly> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"priorityFly\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<PriorityFly> priorityFlies = new ArrayList<>();
            while (resultSet.next()) {
                PriorityFly priorityFly = new PriorityFly(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("timePriority")
                );
                priorityFlies.add(priorityFly);
            }

            return priorityFlies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(PriorityFly priorityFly) {
        String sql = "INSERT INTO \"priorityFly\" (name, timePriority) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, priorityFly.getName());
            preparedStatement.setInt(2, priorityFly.getTimePriority());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}