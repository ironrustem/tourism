package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceOrderDaoImpl implements Dao<ServicesOrder> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public ServicesOrder get(int id_service) {
        return null;
    }

    @Override
    public List<ServicesOrder> getAll() {
        return null;
    }

    public List<ServicesOrder> getAll(int id_orderHotel) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"serviceorder\" WHERE id_order = " + id_orderHotel ;
            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Service> dao = new ServiceDaoImpl();
            Dao<OrderHotel> dao1 = new OrderHotelDaoImpl();

            List<ServicesOrder> serviceOrders = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("serviceOrder = " + resultSet.getInt("id_service"));
                ServicesOrder serviceOrder = new ServicesOrder(
                        dao.get(resultSet.getInt("id_service")),
                        dao1.get(resultSet.getInt("id_order"))
                );
                serviceOrders.add(serviceOrder);
            }

            return serviceOrders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(int id_orderHotel, int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM \"serviceorder\" WHERE id_order = " + id_orderHotel + " AND id_service = " + id ;
            System.out.println(sql);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } }

    @Override
    public void save(ServicesOrder servicesOrder) {
        String sql = "INSERT INTO \"serviceorder\" (id_service, id_order) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, servicesOrder.getService().getId());
            preparedStatement.setInt(2, servicesOrder.getOrder().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(int id_order, int id_service) {
        String sql = "INSERT INTO \"serviceorder\" (id_service, id_order) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_service);
            preparedStatement.setInt(2, id_order);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}