package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**one-to-one
 * bi-directional relation*/
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

            Session session = null;
        try{

            /**добавление в базу*/
           /* session = factory.getCurrentSession();

            Employee employee = new Employee("Nikolay", "Ivanov", "IT", 10500);
            Detail detail = new Detail("NY", "4441165", "nikolay@gmail.com");
            *//*необходила добавить две зависимости через два сеттера, чтобы в таблице были ссылки друг на друга
            * если добавляем только 1 сеттер, то в одной колонке будет null*//*
            detail.setEmployee(employee);
            employee.setEmpDetail(detail);

            session.beginTransaction();
            session.save(detail);
            System.out.println("Done!");*/

            /**получение из БД*/
            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 5);
            System.out.println(detail.getEmployee());

            /**удаление из БД*/
            session.delete(detail);

            System.out.println("Done!");
        }
        finally {
            session.getTransaction().commit();
            factory.close();
        }
    }
}
