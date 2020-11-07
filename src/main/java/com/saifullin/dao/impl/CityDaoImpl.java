package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements Dao<City> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    @Override
    public City get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"city\" WHERE id =" + id;
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> getIDs(String name) {
        String name1 = name.substring(0,1).toUpperCase() +  name.substring(1,name.length()).toLowerCase() + "%";
        try {
            System.out.println("serchCity = " + name1);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"city\" WHERE name LIKE '" + name1 + "'";
            System.out.println("serchCitySQL = " + sql);
            ResultSet resultSet = statement.executeQuery(sql);

            List<Integer> cities = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("1");
                System.out.println("cityID = " + resultSet.getInt("id"));
                cities.add(resultSet.getInt("id"));
            }
            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"city\"";
            ResultSet resultSet = statement.executeQuery(sql);

            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country")
                );
                cities.add(city);
            }

            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(City city) {
        String sql = "INSERT INTO \"city\" (name, country) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}