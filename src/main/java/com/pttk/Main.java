package com.pttk;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pttk";
        String user = "root";
        String password = "123456";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối MySQL thành công!");

            conn.close();
        } catch (Exception e) {
            System.out.println("Lỗi kết nối MySQL: " + e.getMessage());
        }
    }
}
