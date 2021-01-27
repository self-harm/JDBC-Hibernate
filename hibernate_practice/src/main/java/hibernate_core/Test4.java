package hibernate_core;

import hibernate_core.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**Изменение Java объектов в БД*/
public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /**меняем в setter'е значение*/
        /*    Employee employee = session.get(Employee.class, 1);
            employee.setSalary(1900);*/

            /**обновляем через HQL*/
            session.createQuery("update Employee set salary = 1000 " +
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
