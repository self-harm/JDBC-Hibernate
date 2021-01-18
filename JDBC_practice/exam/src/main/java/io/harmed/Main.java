package io.harmed;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    /*необходимо указать Timezone, иначе выдаст ошибку
    * ?key=value&key=value
    * ?useUnicode=true&serverTimezone=UTC*/
    private static final String URL = "jdbc:mysql://localhost:3306/exam_db?useUnicode=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection;

        try {
            /*As mentioned in this MySQL documentation, the warning Loading class ‘com.mysql.jdbc.Driver’.
            This is deprecated. The new driver class is com.mysql.cj.jdbc.Driver’. The driver is automatically
            registered via the SPI and manual loading of the driver class is generally unnecessary occurs due
            to the name of the class that implements “java.sql.Driver” in MySQL Connector/J has changed from
            com.mysql.jdbc.Driver to com.mysql.cj.jdbc.Driver. The old class name has been deprecated.*/

            /*use com.mysql.cj.jdbc.Driver()
            * instead of com.mysql.jdbc.Driver()*/
            Driver driver = new com.mysql.cj.jdbc.Driver();
            /*регистрируем драйвер в нашем драйвер-менеджере*/
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            /*проверка на закрытие/открытие*/
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
        }
    }
}
