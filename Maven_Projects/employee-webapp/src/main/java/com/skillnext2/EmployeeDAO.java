package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/skillnext2_db";

    private static final String USER = "root";
    private static final String PASSWORD = "pavan2416";

    public static void save(Employee emp) {

        String sql = "INSERT INTO employee(name,email,salary) VALUES(?,?,?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
