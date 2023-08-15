package Util;
//Q.3) WAJP to display customer name who has purchase exactly two products.
import Model.Customer;
import Model.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DisplayOnlyTwoProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt = ses.createCriteria(Customer.class);
        crt.add(Restrictions.sizeEq("productsList",2));
        List<Customer> li = crt.list();
        for (Customer c : li){
            System.out.println(c.getcName());
        }


    }

}
