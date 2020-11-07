package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public void delete(String email) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM \"users\" WHERE email = '" + email + "'";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User getByEMail(String eMail1) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"users\" WHERE eMail ='" + eMail1 + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("eMail"),
                        resultSet.getString("telephoneNumber"),
                        resultSet.getString("priority"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean check(String eMail) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"users\" WHERE eMail ='" + eMail + "'";
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
    public User get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"users\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("eMail"),
                        resultSet.getString("telephoneNumber"),
                        resultSet.getString("priority"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"users\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("eMail"),
                        resultSet.getString("telephoneNumber"),
                        resultSet.getString("priority"),
                        resultSet.getString("password")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO \"users\" (name, surname, eMail, telephoneNumber, priority, password) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setString(4, user.getTelephoneNumber());
            preparedStatement.setString(5, user.getPriority());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}