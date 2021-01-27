package hibernate_one_to_many_Bi;

import hibernate_one_to_many_Bi.entity.Department;
import hibernate_one_to_many_Bi.entity.Employee;
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /**saving into tables*/
//            Department department = new Department("IT", 900, 6000);
//            Employee emp1 = new Employee("Kseniia", "Lebedeva", 6000);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.save(department);

            /**getting from the table*/
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
