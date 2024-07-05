package com.xhoang.tourofspring.dao;


import com.xhoang.tourofspring.dao.jpa.JpaUserDao;
import com.xhoang.tourofspring.dao.interfaces.UserDaoInterface;
import com.xhoang.tourofspring.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Repository
public class UserDao implements UserDaoInterface {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    private JpaUserDao lpaUserDao;

    @Override
    public Optional<User> save(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, email) VALUES (?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));

                return Optional.of(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Implement other CRUD methods similarly...
}
