package Util;


import Model.HAddress;
import Model.HEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import java.util.Arrays;
import java.util.List;

public class HqlOperations {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session session;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(HAddress.class).addAnnotatedClass(HEmployee.class);
        factory = cfg.buildSessionFactory();
        session = factory.openSession();

        //Get All the employee
        String qEmp = "from HEmployee as e";
        Query query =session.createQuery(qEmp);
        List<HEmployee> employeeList = query.getResultList();
        System.out.println("---------------------------Employee List :---------------");
        for (HEmployee emp : employeeList){
            System.out.println(emp.getEmpId() + " " + emp.getEmpName()+ " " + emp.getEmpSal());
        }

        System.out.println("------------------------------------------------------------------------");
        //Get employee with id
        Query query1 = session.createQuery("from HEmployee as e where e.empId=:id");
        query1.setParameter("id",2);
        HEmployee emp = (HEmployee) query1.uniqueResult();
        System.out.println("---------------------------Employee with id :"+emp.getEmpId()+"---------------");
        System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getEmpSal());


        System.out.println("------------------------------------------------------------------------");

        // using Inner Join
        Query query2=session.createQuery("select e.empName,a.addCity from HEmployee as e INNER JOIN e.addRef as a");
        List<Object[]> list = query2.list();
        for (Object[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("------------------------------------------------------------------------");

        //Count of employee
        Query query3  =session.createQuery("select count(e) ,e.empName from HEmployee as e group by e.empName");
        List<Object[]> datalist= query3.list();
        for (Object[] arr : datalist){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("------------------------------------------------------------------------");

        //Count having greater than 2
        Query query4  =session.createQuery("select count(e), e.empName from HEmployee as e group by e.empName having count(e)>2");
        List<Object[]> datalist1= query4.list();
        for (Object[] arr : datalist1){
            System.out.println(Arrays.toString(arr));
        }

    }
}
