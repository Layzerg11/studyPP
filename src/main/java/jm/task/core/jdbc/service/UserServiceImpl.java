//package jm.task.core.jdbc.service;
//
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
//import jm.task.core.jdbc.model.User;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class UserServiceImpl implements UserService {
//    UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
//
//    public UserDaoJDBCImpl getUserDaoJDBCImpl() {
//        return userDaoJDBCImpl;
//    }
//
//    public void createUsersTable() throws SQLException {
//        getUserDaoJDBCImpl().createUsersTable();
//    }
//
//    public void dropUsersTable() throws SQLException {
//        getUserDaoJDBCImpl().dropUsersTable();
//    }
//
//    public void saveUser(String name, String lastName, byte age) throws SQLException {
//        getUserDaoJDBCImpl().saveUser(name, lastName, age);
//    }
//
//    public void removeUserById(long id) throws SQLException {
//        getUserDaoJDBCImpl().removeUserById(id);
//    }
//
//    public List<User> getAllUsers() throws SQLException {
//
//        return getUserDaoJDBCImpl().getAllUsers();
//
//    }
//
//    public void cleanUsersTable() throws SQLException {
//        getUserDaoJDBCImpl().cleanUsersTable();
//    }
//}