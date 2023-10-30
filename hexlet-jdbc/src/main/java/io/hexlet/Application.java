package io.hexlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import io.hexlet.User;


public class Application {
    public static void main(String[] args) throws SQLException {
        // BEGIN (write your solution here)
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet")) {

            var sql = "CREATE TABLE users "
                    + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";

            try (var statement = conn.createStatement()) {
                statement.execute(sql);
            }
            var dao = new UserDAO(conn);
            var user = new User("jamal", "90999");
            System.out.println(user.getId());
            dao.save(user);
//            System.out.println(dao.find(1L));
        }
//        var conn =  DriverManager.getConnection("jdbc:h2:mem:hexlet");
//            System.out.println(user.getName());
    }
}