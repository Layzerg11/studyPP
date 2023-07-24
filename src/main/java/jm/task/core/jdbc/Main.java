package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        try {
            userService.createUsersTable();
            userService.saveUser("One", "First", (byte) 1);
            userService.saveUser("Two", "Second", (byte) 2);
            userService.saveUser("Three", "Third", (byte) 3);
            userService.saveUser("Four", "Fourth", (byte) 4);
            userService.getAllUsers();
            userService.cleanUsersTable();
            userService.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
