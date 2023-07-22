package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        Connection connection = getConnection();
        Statement createTable = connection.createStatement();
        String sql = "CREATE TABLE instructor ( + ID INT, name VARCHAR(20), lastname VARCHAR(20), age INT, PRIMARY KEY (ID))";

        try {
            createTable.executeUpdate("CREATE TABLE USER"
                    + " (ID INTEGER NOT NULL AUTO_INCREMENT, NAME VARCHAR(20), LASTNAME VARCHAR(20), AGE INT, PRIMARY KEY (ID)) ");
        } catch (SQLSyntaxErrorException e) {

        } finally {
            if (createTable != null) {
                createTable.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void dropUsersTable() throws SQLException {
        Connection connection = getConnection();
        Statement dropTable = connection.createStatement();

        try {
            dropTable.executeUpdate("DROP TABLE USER");
        } catch (SQLSyntaxErrorException e) {

        } finally {
            if (dropTable != null) {
                dropTable.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USER (NAME, LASTNAME, AGE) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void removeUserById(long id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USER WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = getConnection();
        List<User> userList = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = "SELECT ID, NAME, LASTNAME, AGE FROM user";

        try {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        Connection connection = getConnection();
        Statement cleanTable = connection.createStatement();

        try {
            cleanTable.executeUpdate("TRUNCATE TABLE USER");
        } finally {
            if (cleanTable != null) {
                cleanTable.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
