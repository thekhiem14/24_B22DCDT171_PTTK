// File: CustomerStatDAO.java
package com.pttk.dao;

import com.pttk.model.CustomerStat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CustomerStatDAO extends DAO {

    public CustomerStatDAO() {
        super();
    }

    public List<CustomerStat> getCustomer(Date startDate, Date endDate) {
        List<CustomerStat> customers = new ArrayList<>();
        java.sql.Date sqlStartDate = startDate != null ? new java.sql.Date(startDate.getTime()) : java.sql.Date.valueOf("1970-01-01");
        java.sql.Date sqlEndDate = endDate != null ? new java.sql.Date(endDate.getTime()) : new java.sql.Date(System.currentTimeMillis());

        String sql = """
        SELECT
           p.id AS person_id,
           p.name,
           p.phoneNumber,
           p.email,
           IFNULL(SUM(d.amount), 0) AS total_revenue
       FROM tblCustomer c
       JOIN tblPerson p ON c.tblPersonid = p.id
       LEFT JOIN tblOrder o\s
           ON o.tblCustomertblPersonid = c.tblPersonid AND o.date BETWEEN ? AND ?\s
       LEFT JOIN tblDetailOrder d ON d.tblOrderid = o.id
       GROUP BY p.id, p.name, p.phoneNumber, p.email
       ORDER BY total_revenue DESC
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, sqlStartDate);
            ps.setDate(2, sqlEndDate);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerStat cs = new CustomerStat();
                cs.setId(rs.getInt("person_id"));
                cs.setName(rs.getString("name"));
                cs.setPhoneNumber(rs.getString("phoneNumber"));
                cs.setEmail(rs.getString("email"));
                cs.setTotalRevenue(rs.getFloat("total_revenue"));
                customers.add(cs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


}
