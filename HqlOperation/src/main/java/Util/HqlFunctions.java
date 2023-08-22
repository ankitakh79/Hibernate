package Util;

import Model.HAddress;
import Model.HEmployee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlFunctions {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session session;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(HAddress.class).addAnnotatedClass(HEmployee.class);
        factory = cfg.buildSessionFactory();
        session = factory.openSession();

        tx = session.beginTransaction();

        //Total salary of all employee
        Query query =session.createQuery("select sum(e.empSal) from HEmployee as e ");
        Double sal= (Double) query.uniqueResult();
        System.out.println("Summation " + sal);

        //Max salary
        Query query1 = session.createQuery("select max(e.empSal) from HEmployee as e");
        Double maxSal = (Double) query1.uniqueResult();
        System.out.println("Maximum sal : " +maxSal);

        //Min salary
        Query query2 = session.createQuery("select min(e.empSal) from HEmployee as e");
        Double minSal = (Double) query2.uniqueResult();
        System.out.println("Minimum sal : " +minSal);

        //Average salary
        Query query3 = session.createQuery("select avg(e.empSal) from HEmployee as e");
        Double avgSal = (Double) query2.uniqueResult();
        System.out.println("Average sal : " +avgSal);

        //Count
        Query query4 = session.createQuery("select count(e) from HEmployee as e");
        Long count = (Long) query4.uniqueResult();
        System.out.println("Total count of Employee : " +count);


        tx.commit();
        session.close();
        factory.close();
    }
}
