package com.pttk.dao;

import com.pttk.model.Invoice;
import com.pttk.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO extends DAO {

    public InvoiceDAO() {
        super();
    }

    public List<Invoice> getExpense(int idCustomer, Date startDate, Date endDate) {
        List<Invoice> invoices = new ArrayList<>();

        String sql = "SELECT i.id, i.date, " +
                "p.name AS customerName, " +
                "COUNT(do.id) AS totalItem, " +
                "SUM(do.amount) AS totalAmount " +
                "FROM tblInvoice i " +
                "LEFT JOIN tblOrder o ON o.tblInvoiceid = i.id " +
                "LEFT JOIN tblDetailOrder do ON do.tblOrderid = o.id " +
                "JOIN tblCustomer c ON i.tblCustomertblPersonid = c.tblPersonid " +
                "JOIN tblPerson p ON c.tblPersonid = p.id " +
                "WHERE i.tblCustomertblPersonid = ? AND i.date BETWEEN ? AND ? " +
                "GROUP BY i.id, i.date, p.name";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCustomer);
            ps.setDate(2, startDate);
            ps.setDate(3, endDate);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Invoice i = new Invoice();
                i.setId(rs.getInt("id"));
                i.setDate(rs.getDate("date"));
                i.setTotalItem(rs.getInt("totalItem"));
                i.setTotalAmount(rs.getFloat("totalAmount"));

                Customer c = new Customer();
                c.setName(rs.getString("customerName"));
                i.setCustomer(c);

                invoices.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }
}