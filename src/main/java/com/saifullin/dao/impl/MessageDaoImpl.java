package com.saifullin.dao.impl;


import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements Dao<Message> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public Message get(int id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"message\"";
            return getMessages(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Message> getMessages(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        List<Message> messages = new ArrayList<>();
        while (resultSet.next()) {
            Message message = new Message(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_user"),
                    resultSet.getString("textm"),
                    resultSet.getString("file"),
                    resultSet.getTimestamp("date"),
                    resultSet.getString("type"),
                    resultSet.getString("status")
            );
            messages.add(message);
        }
        return messages;
    }

    public List<Message> getAll(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"message\" WHERE id_user = " + id;
            return getMessages(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Message message) {
        String sql = "INSERT INTO \"message\" (id_user, textm, file, date, type, status) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, message.getId_user());
            preparedStatement.setString(2, message.getText());
            preparedStatement.setString(3, message.getFile());
            preparedStatement.setTimestamp(4, message.getDate());
            preparedStatement.setString(5, message.getType());
            preparedStatement.setString(6, message.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}