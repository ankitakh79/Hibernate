package Util;

import Model.HAddress;
import Model.HEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
public class HqlCRUDOperation {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session session;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(HAddress.class).addAnnotatedClass(HEmployee.class);
        factory = cfg.buildSessionFactory();
        session = factory.openSession();

        tx = session.beginTransaction();
        //HQL pagination example
        Query query = session.createQuery("from HEmployee");
        query.setFirstResult(0); //starts with 0
        query.setFetchSize(2);
        List<HEmployee> empList = query.list();
        for(HEmployee emp : empList){
            System.out.println("Paginated Employees::"+emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getEmpSal());
        }
        System.out.println("------------------------UPDATE QUERY------------------------------------------------");

        //HQL Update Employee
        query = session.createQuery("update HEmployee set empName= :name where empId= :id");
        query.setParameter("name", "Kishor");
        query.setLong("id", 7);
        int result = query.executeUpdate();
        System.out.println("Employee Update Status="+result);

        System.out.println("------------------------DELETE QUERY-----------------------------------------------");

        //HQL Delete Employee, we need to take care of foreign key constraints too
        Query query1 = session.createQuery("delete from HAddress where addid= :id");
        query1.setLong("id", 6);
        result = query1.executeUpdate();
        System.out.println("Address Delete Status="+result);

        Query query2 = session.createQuery("delete from HEmployee where empId= :id");
        query2.setLong("id", 6);
        result = query2.executeUpdate();
        System.out.println("Employee Delete Status="+result);

        tx.commit();
        session.close();
        factory.close();
    }
}
