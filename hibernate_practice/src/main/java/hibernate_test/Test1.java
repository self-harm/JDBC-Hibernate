package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        /*Session - это обертка вокруг подключения к базе с помощью JDBC
        * Session мы получаем с помощью SessionFactory
        *
        * Session - это основа для работы с БД. Именно с ней мы будем добавлять, получать
        *  и делать другие операции с Java объектами в БД*/

        try{
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Kseniia", "Lebedeva", "IT", 9500);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
