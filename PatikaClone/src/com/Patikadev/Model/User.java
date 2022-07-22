package com.Patikadev.Model;

import com.Patikadev.Helper.Helper;
import com.Patikadev.Helper.postgreSqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int user_id;
    private String user_name;
    private String login_name;
    private String user_password;
    private String user_type;

    public User(){}

    public User(int user_id, String user_name, String login_name, String user_password, String user_type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.login_name = login_name;
        this.user_password = user_password;
        this.user_type = user_type;
    }

    public static ArrayList<User> getAllUsers(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        User user;
        try{
            Statement st = postgreSqlConnection.connectToDatabase().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setLogin_name(rs.getString("login_name"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_type(rs.getString("user_type"));
                userList.add(user);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    public static boolean addUser(String userName, String loginName, String userPassword, String userType){
        String query = "INSERT INTO Users (user_name,login_name,user_password,user_type) VALUES (?,?,?,CAST(? AS type_enum))";
        User obj = User.hasUser(loginName);
        if (obj  != null){
            Helper.showMessage("Kullanıcı adı kullanılıyor!");
            return false;
        }
        try {
            PreparedStatement prst = postgreSqlConnection.connectToDatabase().prepareStatement(query);
            prst.setString(1,userName);
            prst.setString(2,loginName);
            prst.setString(3,userPassword);
            prst.setString(4,userType);
            return  prst.executeUpdate() !=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static User hasUser(String login_name){
        User user = null;
        String query = "SELECT * FROM Users WHERE login_name = ?";
        try {
            PreparedStatement prst = postgreSqlConnection.connectToDatabase().prepareStatement(query);
            prst.setString(1,login_name);
            ResultSet rs = prst.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setLogin_name(rs.getString("login_name"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_type(rs.getString("user_type"));
                break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return user;
    }
    public static boolean deleteUser(int id){
        String query = "DELETE FROM Users WHERE user_id = ?";
        try {
            PreparedStatement st = postgreSqlConnection.connectToDatabase().prepareStatement(query);
            st.setInt(1,id);
            return st.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }return true;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
