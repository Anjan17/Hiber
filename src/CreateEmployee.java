import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by beheraa on 7/24/2017.
 */
public class CreateEmployee {
    private static SessionFactory factory;
    public static void main(String[] args) {

        //PropertyConfigurator.configure("c:\\log4j.properties");

        //creating configuration object
        //Configuration cfg=new Configuration();
        //cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        CreateEmployee ME = new CreateEmployee();

      /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("testname4444444", "Ali", 18000,"Hyderabad","1234");
        Integer empID2 = ME.addEmployee("testname55555", "Das", 19000,"Chennai","3456");
        Integer empID3 = ME.addEmployee("testname66666", "Paul", 111000,"Mumbai","5678");

      /* List down all the employees */
       // ME.listEmployees();

      /* Update employee's records */
        //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      //  ME.deleteEmployee(empID2);

      /* List down new list of the employees */
       // ME.listEmployees();
    }
    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary,String addr,String extension){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary,addr,extension);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }
}
