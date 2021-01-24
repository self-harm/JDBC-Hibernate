package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**получение объекта из БД c помощью HQL
 * Для получение объектов из базы используется HQL(Hibernate Query Language)
 * HQL очень схож с SQL*/
public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /**получение списка всех работников:*/
        /*    List<Employee> emps = session.createQuery("from Employee")
                    .getResultList();
            for(Employee each: emps){
                System.out.println(each);
            }*/

           /**получение работников по имени(или другому полю)*/
           //важно! name это название поля в java коде, а НЕ поля в БД
            List<Employee> emps = session.createQuery("from Employee " +
                    "where name = 'Alexandr' AND salary>1000")
                    .getResultList();
            for(Employee each: emps){
                System.out.println(each);
            }


            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
