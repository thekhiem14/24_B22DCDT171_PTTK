package com.pttk.dao;

import com.pttk.model.Dish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO extends DAO {

    public DishDAO() {
        super();
    }

    public boolean addDish(Dish dish) {
        String sql = "INSERT INTO tblDish(name, description, price, discount) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, dish.getName());
            if (dish.getDescription() != null && !dish.getDescription().isEmpty()) {
                ps.setString(2, dish.getDescription());
            } else {
                ps.setNull(2, java.sql.Types.VARCHAR);
            }
            ps.setFloat(3, dish.getPrice());
            ps.setFloat(4, dish.getDiscount());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDishNameExists(String name) {
        String sql = "SELECT 1 FROM tblDish WHERE name = ?";
        boolean exists = false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    exists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
