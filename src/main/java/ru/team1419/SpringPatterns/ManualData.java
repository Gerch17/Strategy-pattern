package ru.team1419.SpringPatterns;


import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;

public class ManualData implements State{
    CoffeService coffeService;

    protected static Connection connection;
    protected static Statement stm;
    private static PreparedStatement ps;
    static final String DB_URL = "jdbc:postgresql://10.10.10.142/backtosch";
    static final String USER = "tambovcevgo";
    static final String PASS = "Tjed_913";

    public ManualData() {
        connect();
    }

    @Override
    public void setData(String name, int amount, Boolean milk) {

        try {
            stm = connection.createStatement();
            stm.executeUpdate("INSERT INTO coffe (name, amount, milk) VALUES(\'" + name + "\', " + amount + "," + milk + ");");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        try {
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    @Override
    public void getData(Context context) {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM coffe");
            for (int i = 0; rs.next(); i++) {
                dataList.add(i, rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Output by manual");
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList.get(i));
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        context.state = coffeService.getState(coffeService);
    }

    private static void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
