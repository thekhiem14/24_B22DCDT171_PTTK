package com.pttk.dao;

import com.pttk.model.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OrderDAO extends DAO {

    public Order getOrder(int invoiceId) {
        Order order = null;

        String sql = "SELECT "
                + "o.id AS order_id, o.Date, "
                + "p.name AS customer_name, "
                + "d.id AS detail_id, d.quantity AS detail_quantity, d.unitprice AS detail_unitprice, "
                + "di.id AS dish_id, di.name AS dish_name, di.description AS dish_description, "
                + "co.id AS comboorder_id, c.id AS combo_id, c.name AS combo_name, "
                + "dc.id AS dishcombo_id, dc.displayNumber AS display_number, d2.id AS combo_dish_id, d2.name AS combo_dish_name, d2.description AS combo_dish_description "
                + "FROM tblOrder o "
                + "LEFT JOIN tblInvoice i ON o.tblInvoiceid = i.id "
                + "LEFT JOIN tblCustomer cust ON i.tblCustomertblPersonid = cust.tblPersonid "
                + "LEFT JOIN tblPerson p ON cust.tblPersonid = p.id "
                + "LEFT JOIN tblDetailOrder d ON o.id = d.tblOrderid "
                + "LEFT JOIN tblDishOrder do ON d.id = do.tblDetailOrderid "
                + "LEFT JOIN tblDish di ON do.tblDishid = di.id "
                + "LEFT JOIN tblComboOrder co ON d.id = co.tblDetailOrderid "
                + "LEFT JOIN tblCombo c ON co.tblComboid = c.id "
                + "LEFT JOIN tblDishCombo dc ON c.id = dc.tblComboid "
                + "LEFT JOIN tblDish d2 ON dc.tblDishid = d2.id "
                + "WHERE o.tblInvoiceid = ? "
                + "ORDER BY d.id, c.id, dc.displayNumber";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, invoiceId);
            ResultSet rs = ps.executeQuery();

            int prevDetailId = -1;
            int prevComboId = -1;
            DetailOrder currentDetail = null;
            Combo currentCombo = null;

            List<DetailOrder> detailOrders = new ArrayList<>();

            while (rs.next()) {
                if (order == null) {
                    order = new Order();
                    order.setId(rs.getInt("order_id"));
                    order.setDate(rs.getDate("Date"));
                    order.setTotalAmount(0);

                    Customer customer = new Customer();
                    customer.setName(rs.getString("customer_name"));
                    order.setCustomer(customer);
                }

                int detailId = rs.getInt("detail_id");
                if (detailId != 0 && detailId != prevDetailId) {
                    currentDetail = new DetailOrder();
                    currentDetail.setId(detailId);
                    currentDetail.setQuantity(rs.getInt("detail_quantity"));
                    currentDetail.setUnitPrice(rs.getFloat("detail_unitprice"));
                    currentDetail.setAmount(currentDetail.getQuantity() * currentDetail.getUnitPrice());
                    order.setTotalAmount(order.getTotalAmount() + currentDetail.getAmount());

                    detailOrders.add(currentDetail);
                    prevDetailId = detailId;
                    prevComboId = -1;
                }

                if (currentDetail != null) {
                    int dishId = rs.getInt("dish_id");
                    if (dishId != 0) {
                        DishOrder dishOrder = new DishOrder();
                        Dish dish = new Dish();
                        dish.setId(dishId);
                        dish.setName(rs.getString("dish_name"));
                        dish.setDescription(rs.getString("dish_description"));

                        dishOrder.setDish(dish);
                        currentDetail.setDishOrder(dishOrder);
                    }

                    int comboOrderId = rs.getInt("comboorder_id");
                    if (comboOrderId != 0) {
                        int comboId = rs.getInt("combo_id");
                        if (comboId != 0 && comboId != prevComboId) {
                            ComboOrder comboOrder = new ComboOrder();
                            comboOrder.setId(comboOrderId);

                            currentCombo = new Combo();
                            currentCombo.setId(comboId);
                            currentCombo.setName(rs.getString("combo_name"));
                            currentCombo.setDishCombos(new ArrayList<>());

                            comboOrder.setCombo(currentCombo);
                            currentDetail.setComboOrder(comboOrder);

                            prevComboId = comboId;
                        }

                        if (currentCombo != null) {
                            int dishComboId = rs.getInt("dishcombo_id");
                            if (dishComboId != 0) {
                                DishCombo dishCombo = new DishCombo();
                                dishCombo.setId(dishComboId);

                                Dish dishInCombo = new Dish();
                                dishInCombo.setId(rs.getInt("combo_dish_id"));
                                dishInCombo.setName(rs.getString("combo_dish_name"));
                                dishInCombo.setDescription(rs.getString("combo_dish_description"));

                                dishCombo.setDish(dishInCombo);
                                currentCombo.getDishCombos().add(dishCombo);
                            }
                        }
                    }
                }
            }

            if (order != null) {
                order.setDetailOrder(detailOrders);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}