package Util;

import Model.HAddress;
import Model.HEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
public class HqlGroupBy {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session session;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(HAddress.class).addAnnotatedClass(HEmployee.class);
        factory = cfg.buildSessionFactory();
        session = factory.openSession();

        tx = session.beginTransaction();

        //HQL group by and like example
       Query query = session.createQuery("select e.empName, sum(e.empSal), count(e)"
                + " from HEmployee e where e.empName like '%K%' group by e.empName");
        List<Object[]> groupList = query.list();
        for(Object[] arr : groupList){
            System.out.println(Arrays.toString(arr));
        }
        tx.commit();
        session.close();
        factory.close();
    }
}
