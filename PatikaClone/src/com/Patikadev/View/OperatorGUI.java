package com.Patikadev.View;

import com.Patikadev.Helper.*;
import com.Patikadev.Model.Operator;
import com.Patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class OperatorGUI extends JFrame{
    private JPanel wrapper;
    private static final Dimension MIN_SIZE = new Dimension(750,450);
    private JTabbedPane tab_operator;
    private JPanel panel_userlist;
    private JPanel panel_top;
    private JLabel label_welcome;
    private JButton btn_close;
    private JScrollPane scroll_userList;
    private JTable table_userList;
    private JTextField text_username;
    private JTextField text_loginname;
    private JTextField text_userpassword;
    private JComboBox combo_usertype;
    private JButton btn_addUser;
    private JLabel label_username;
    private JLabel label_loginname;
    private JLabel label_userpassword;
    private JLabel label_usertype;
    private JButton btn_refresh;
    private JLabel label_userid;
    private JTextField text_userID;
    private JButton btn_delete;
    private DefaultTableModel model_userList;
    private Object[] row_userList;
    private final Operator OPERATOR;

    public OperatorGUI(){
        ResultSet resultSet = pullUser();
        try {
            resultSet.next();
            this.OPERATOR = new Operator(resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("login_name"),
                    resultSet.getString("user_password"),
                    resultSet.getString("user_type"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        label_welcome.setText("Hoşgeldin : " + this.OPERATOR.getUser_name());
        add(wrapper);
        setVisible(true);
        setMinimumSize(MIN_SIZE);
        setSize(750,450);
        setLocation(Helper.centerOfWindow("x",getSize()),Helper.centerOfWindow("y",getSize()));
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Modelling User List
        model_userList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0)return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] column_userList = {"ID","Ad Soyad", "Kullanıcı Adı","Şifre","Üyelik Tipi"};
        model_userList.setColumnIdentifiers(column_userList);
        table_userList.setModel(model_userList);
        table_userList.getTableHeader().setReorderingAllowed(false);

        refreshUserList();

        btn_addUser.addActionListener(e -> {
            if (Helper.isFieldEmpty(text_username) || Helper.isFieldEmpty(text_loginname) || Helper.isFieldEmpty(text_userpassword) ){
                Helper.showMessage("fill");
            }else {
                if (User.addUser(text_username.getText().trim(),text_loginname.getText().trim(),text_userpassword.getText().trim(),combo_usertype.getSelectedItem().toString())){
                    Helper.showMessage("done");
                }
                refreshUserList();
            }
            Helper.clearAllFields(text_username,text_loginname,text_userpassword);
        });
        btn_refresh.addActionListener(e -> {
            refreshUserList();
        });
        btn_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(text_userID)){
                Helper.showMessage("fill");
            }else {
                int text_user_id = Integer.parseInt(text_userID.getText());
                if (User.deleteUser(text_user_id)){
                    Helper.clearAllFields(text_userID);
                    refreshUserList();
                    Helper.showMessage("done");
                }else Helper.showMessage("error");
            }

        });
        table_userList.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selected_user_id = table_userList.getValueAt(table_userList.getSelectedRow(),0).toString();
                text_userID.setText(selected_user_id);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        });
    }
    private void refreshUserList(){
        model_userList.setRowCount(0);
        for (User obj: User.getAllUsers()) {
            Object[] user = {obj.getUser_id()
                    , obj.getUser_name()
                    , obj.getLogin_name()
                    , obj.getUser_password()
                    , obj.getUser_type()};
            model_userList.addRow(user);
        }
    }
    private static ResultSet pullUser(){
        String selectq = "SELECT * FROM Users WHERE login_name = 'barografi08'";
        try {
            Statement pull_Statement = postgreSqlConnection.connectToDatabase().createStatement();
            return pull_Statement.executeQuery(selectq);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        OperatorGUI operatorGUI = new OperatorGUI();
    }


}
