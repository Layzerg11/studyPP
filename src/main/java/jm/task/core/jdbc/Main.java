package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("One", "First", (byte) 1);
        userDaoHibernate.saveUser("Two", "Second", (byte) 2);
        userDaoHibernate.saveUser("Three", "Third", (byte) 3);
        userDaoHibernate.saveUser("Four", "Fourth", (byte) 4);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();

        /*UserServiceImpl userService = new UserServiceImpl();

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
        }*/

    }
}

