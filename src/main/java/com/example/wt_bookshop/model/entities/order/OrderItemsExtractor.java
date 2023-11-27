package com.example.wt_bookshop.model.entities.order;

import com.example.wt_bookshop.model.dao.PhoneDao;
import com.example.wt_bookshop.model.dao.impl.JdbcPhoneDao;
import com.example.wt_bookshop.model.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsExtractor {
    public List<OrderItem> extractData(ResultSet resultSet) throws SQLException, DaoException {
        List<OrderItem> orderItems = new ArrayList<>();
        PhoneDao phoneDao = JdbcPhoneDao.getInstance();
        while (resultSet.next()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setPhone(phoneDao.get(resultSet.getLong("phoneId")).orElse(null));
            orderItem.setQuantity(resultSet.getInt("quantity"));
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
