package hibernate_core;

import hibernate_core.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**Удаление объектов из БД*/
public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /**получение и удаление*/
          /*  Employee employee = session.get(Employee.class, 1);
            session.delete(employee);*/

            /**удаление, используя HQL*/
            session.createQuery("delete Employee " +
                    "where name = 'Alexandr'")
            .executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
