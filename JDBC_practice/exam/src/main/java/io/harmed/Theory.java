package io.harmed;

import java.sql.*;

public class Theory {
    /*необходимо указать Timezone, иначе выдаст ошибку
    * ?key=value&key=value
    * ?useUnicode=true&serverTimezone=UTC*/
    private static final String URL = "jdbc:mysql://localhost:3306/exam_db?useUnicode=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
            /*As mentioned in this MySQL documentation, the warning Loading class ‘com.mysql.jdbc.Driver’.
            This is deprecated. The new driver class is com.mysql.cj.jdbc.Driver’. The driver is automatically
            registered via the SPI and manual loading of the driver class is generally unnecessary occurs due
            to the name of the class that implements “java.sql.Driver” in MySQL Connector/J has changed from
            com.mysql.jdbc.Driver to com.mysql.cj.jdbc.Driver. The old class name has been deprecated.*/

      /*  try {
            *//*use com.mysql.cj.jdbc.Driver()
            * instead of com.mysql.jdbc.Driver()*//*
            Driver driver = new com.mysql.cj.jdbc.Driver();
            *//*регистрируем драйвер в нашем драйвер-менеджере*//*
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

          *//*  проверка на закрытие/открытие*//*
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено!");
            }

            connection.close();

            if(connection.isClosed()){
                System.out.println("Соединение с БД закрыто!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Произошла ошибка с загрузкой драйвера");
        }*/

            //лучше использовать try catch с ресурсами, чтобы вручную не закрывать поток

        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()){
            String answer = !connection.isClosed() == true ? "да" : "нет";
            System.out.println("Соединение установлено? " + answer);

            /*с помощью команды execute() выполняем SQL-запросы*/
          /**  statement.execute(
                    "insert into users(name, age, email)\n" +
                            "values ('Naf', 9, 'rqwrraf@gmail.com');"
            );*/

            /*с помощью команды executeUpdate() выполняются запросы INSERT, UPDATE, DELETE
            * нельзя получать данные (SELECT)*/
           /** statement.executeUpdate(
                    "update users SET name='Aro' WHERE id=4;"
            );*/

           /*executeQuery() - SELECT*/
            /** ResultSet res = statement.executeQuery("SELECT * FROM users;");*/


            /*помещение несколько команд в один пакет, запускаем и очищаем пакет*/
            /** statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Omar', 26, 'oaf@gmail.com');");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Kate', 19, 'ogag@gmail.com');");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Little', 25, 'aaaf@gmail.com');");
            statement.executeBatch();
            statement.clear();
             */

            /*закрыт ли statement*/
            /**statement.isClosed();*/
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
