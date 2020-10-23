package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;
import com.saifullin.models.Date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements Dao<Message> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Message get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM \"message\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            return new Message(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_user"),
                    resultSet.getString("textM"),
                    resultSet.getString("file"),
                    new Date(resultSet.getString("date1")),
                    resultSet.getString("type"),
                    resultSet.getString("status")

            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Message> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"message\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Message> messages = new ArrayList<>();

            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_user"),
                        resultSet.getString("textM"),
                        resultSet.getString("file"),
                        new Date(resultSet.getString("date1")),
                        resultSet.getString("type"),
                        resultSet.getString("status")
                );
                messages.add(message);
            }

            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Message message) {
        String sql = "INSERT INTO \"message\" (id_user, textM, file, date1, type, status) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, message.getId_user());
            preparedStatement.setString(2, message.getText());
            preparedStatement.setString(3, message.getFile());
            preparedStatement.setString(4, message.getDate().toString());
            preparedStatement.setString(5, message.getType());
            preparedStatement.setString(5, message.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}