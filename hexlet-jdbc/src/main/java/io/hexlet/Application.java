package io.hexlet;

import java.sql.*;

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
            var user = new User("Maria", "888888888");
            var user2 = new User("jama", "111111111");

            var user3 = new User("absaidov", "99999999");

//            var user2 = new User("absaid", "22222");
//            var user3 = new User("papa", "33333");
            System.out.println(user.getId());
            dao.save(user);
            dao.save(user2);
            dao.save(user3);

//            dao.save(user2);
//            dao.save(user3);
            System.out.println("DAO.SAVE");
            System.out.println(user.getId());
//            System.out.println(user2.getId());

//            var user2 = dao.find(user.getId()).get();
//            System.out.println(user2);
//            System.out.println(user2.getId() == user.getId());

            dao.delete(user2.getId());
//            System.out.println(user2.getName());
//            System.out.println(user.getId());

        }
    }
}