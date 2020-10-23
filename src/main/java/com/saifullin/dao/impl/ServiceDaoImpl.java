package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements Dao<Service> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Service get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM \"service\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            return new Service(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("price")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Service> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"service\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Service> services = new ArrayList<>();
            while (resultSet.next()) {
                Service service = new Service(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );
                services.add(service);
            }

            return services;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Service service) {
        String sql = "INSERT INTO \"user\" (name, price) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}