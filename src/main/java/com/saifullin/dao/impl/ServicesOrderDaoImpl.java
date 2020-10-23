package com.saifullin.dao.impl;

import com.saifullin.dao.Dao;
import com.saifullin.helpers.PostgresConnectionHelper;
import com.saifullin.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesOrderDaoImpl implements Dao<ServicesOrder> {

    private final Connection connection = PostgresConnectionHelper.getConnection();


    public ServicesOrder get(int id_service) {
        return null;
    }

    @Override
    public List<ServicesOrder> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"serviceOrder\"";
            ResultSet resultSet = statement.executeQuery(sql);
            Dao<Service> dao = new ServiceDaoImpl();
            Dao<OrderHotel> dao1 = new OrderHotelDaoImpl();

            List<ServicesOrder> serviceOrders = new ArrayList<>();
            while (resultSet.next()) {
                ServicesOrder serviceOrder = new ServicesOrder(
                        dao.get(resultSet.getInt("id_service")),
                        dao1.get(resultSet.getInt("id_orderHotel"))
                );
                serviceOrders.add(serviceOrder);
            }

            return serviceOrders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(ServicesOrder servicesOrder) {
        String sql = "INSERT INTO \"serviceOrder\" (id_service, id_orderHotel) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, servicesOrder.getService().getId());
            preparedStatement.setInt(2, servicesOrder.getOrder().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}