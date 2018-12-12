package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryJDBC {
    private DataSource dataSource;

    public UserRepositoryJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getAllUsers(){
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            String SQL = "SELECT * FROM d_user WHERE status IS TRUE";
            PreparedStatement  preparedStatement= connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getBoolean(8),
                        resultSet.getTimestamp(9)
                );
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public int save(User user){
        try {
            Connection connection = dataSource.getConnection();
            String SQL = "INSERT INTO d_user(fullname, username, password, image_url, phone, email) VALUES (?,?,md5(?),?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getImage_url());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            int status = preparedStatement.executeUpdate();
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(User user){
        try {
            Connection connection = dataSource.getConnection();
            String SQL = "UPDATE d_user SET fullname = ?, username = ?, password = md5(?)," +
                    "image_url = ?, phone = ?, email = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getImage_url());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setInt(7, user.getId());
            int status = preparedStatement.executeUpdate();
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Integer id){
        try {
            Connection connection = dataSource.getConnection();
            String SQL ="UPDATE d_user SET status = FALSE WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            int status = preparedStatement.executeUpdate();
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
