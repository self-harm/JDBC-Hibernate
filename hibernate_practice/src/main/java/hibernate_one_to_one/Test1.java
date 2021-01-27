package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**one-to-one
 * uni-directional relation*/
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try{
            /**занесение рабоников/деталей в таблицу*/
            /*Session session = factory.getCurrentSession();


            Employee employee = new Employee("Kseniia", "Lebedeva", "IT", 10500);
            Detail detail = new Detail("Vancouver", "9255480027", "lightgraywrite@gmail.com");
            employee.setEmpDetail(detail);

            Employee employee1 = new Employee("Oleg", "Smirnov", "Sales", 5200);
            Detail detail1 = new Detail("Moscow", "464822", "olejka@gmail.com");
            employee1.setEmpDetail(detail1);

            session.beginTransaction();
            *//*достаточно просто сохранить employee, т.к. благодаря каскаду
            * идет сохранение и details в соответствующей таблице*//*
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Done!");*/


            /**получение работника по id*/
            /*Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2);
            System.out.println(emp.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Done!");*/


            /**удаление работника по id*/
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
