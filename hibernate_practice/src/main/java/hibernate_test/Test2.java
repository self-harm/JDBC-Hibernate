package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**получение объекта из БД:*/
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //используя лишь одну сессию вместо двух
        try{
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Alexandr", "Sidorov", "IT", 700);

            session.beginTransaction();
            session.save(emp);
            emp = session.get(Employee.class, emp.getId());
            session.getTransaction().commit();

            System.out.println(emp);

        }
        finally {
            factory.close();
        }

      /*  try{
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petrova", "Sales", 800);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            *//*получение объекта из БД*//*
            int myId = emp.getId();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }*/
    }
}
