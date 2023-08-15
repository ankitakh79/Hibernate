package Util;
//Q.6) WAJP to display productName which has only 1 buyer.
import Model.Customer;
import Model.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Display1ProductName {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt = ses.createCriteria(Products.class);
        crt.add(Restrictions.sizeEq("customerList",1));
        List<Products> li = crt.list();
        for (Products c : li){
            System.out.println(c.getpName());
        }
    }
}
