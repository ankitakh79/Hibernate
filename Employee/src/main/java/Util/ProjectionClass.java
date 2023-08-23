package Util;

import Model.Employe;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.*;
import java.util.List;


public class ProjectionClass {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        cfg = new Configuration().configure().addAnnotatedClass(Employe.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//        For only one column we need to use setprojection method
        System.out.println("Name column");
        Criteria crt = ses.createCriteria(Employe.class);
        crt.setProjection(Projections.property("empName"));
        List<String> data=crt.list();

        Iterator itr = data.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

//        for fetching two or more columns we need to use projectionList and adding that plist into setProjection method
//        By using for loop we cannot fetch the record so we need to use iterator
//        this two coloumns are non generic so we havent specified it as non generic one
        System.out.println("Dept column");
        Criteria ct = ses.createCriteria(Employe.class);
        ProjectionList plist = Projections.projectionList();
        plist.add(Projections.property("empName"));
        plist.add(Projections.property("empSal"));
        ct.setProjection(plist);
        ArrayList dept= (ArrayList) ct.list();

        Iterator it = dept.iterator();
        while (it.hasNext()){
            Object[] result = (Object[]) it.next();//downcasting
            System.out.println(result[0] + "\t" + result[1]);
        }

    }
}
