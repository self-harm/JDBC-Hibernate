package io.harmed;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

/**prepared statements*/

public class Theory2 {
    private static final String URL = "jdbc:mysql://localhost:3306/exam_db?useUnicode=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id=?";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            /*DELETE*/
          /** preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();*/


            /*SELECT*/
          /**  preparedStatement = connection.prepareStatement(SELECT);
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                int id = set.getInt("id");
                String title = set.getString("title");

                System.out.println(id + " - " + title);
            }*/

          /*INSERT*/
          /**  preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2, "Inserted title");
            preparedStatement.setString(3, "Inserted desc");
            preparedStatement.setDouble(4, 0.2d);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            *//*добавление файла(картинки)*//**
            preparedStatement.setBlob(7, new FileInputStream("icon.png"));
            preparedStatement.execute();*/
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
}
