package io.harmed;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "SELECT * FROM workusers;";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet res = statement.executeQuery(query);

            while (res.next()){
                User user = new User();
                user.setId(res.getInt(1));
                user.setName(res.getString(2));
                user.setPassword(res.getString(3));
                System.out.println(user.toString());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Произошла ошибка при подключении к БД!");
        }

    }
}
