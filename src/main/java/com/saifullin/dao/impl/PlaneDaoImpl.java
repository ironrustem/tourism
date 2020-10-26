package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaneDaoImpl implements Dao<Plane> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Plane get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"plane\" WHERE id = " + id + "";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Plane(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("places")

                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Plane> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"plane\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Plane> planes = new ArrayList<>();
            while (resultSet.next()) {
                Plane plane = new Plane(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("places")
                );
                planes.add(plane);
            }

            return planes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Plane plane) {
        String sql = "INSERT INTO \"plane\" (name, places) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, plane.getName());
            preparedStatement.setInt(2, plane.getPlaces());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}