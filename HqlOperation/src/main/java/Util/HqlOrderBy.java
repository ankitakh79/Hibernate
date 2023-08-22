package Util;

import Model.HAddress;
import Model.HEmployee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class HqlOrderBy {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session session;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(HAddress.class).addAnnotatedClass(HEmployee.class);
        factory = cfg.buildSessionFactory();
        session = factory.openSession();

        Query query =session.createQuery("from HEmployee as e order by e.empSal desc");
        ArrayList<HEmployee> list = (ArrayList<HEmployee>) query.list();
        for (HEmployee emp : list){
            System.out.println(emp.getEmpName() +" "+emp.getEmpSal());
        }

        System.out.println("------------------------------------------------------------------------");

        //Second highest Salary
        Query query1=session.createQuery("from HEmployee as e order by e.empSal desc ");
        query1.setMaxResults(2);
        ArrayList<HEmployee> list1 = (ArrayList<HEmployee>) query1.getResultList();
        HEmployee employee=list1.get(1);
        System.out.println(employee.getEmpName()+" " + employee.getEmpSal());


    }
}
