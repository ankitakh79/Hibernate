package Util;
//Q.4) WAJP to display the product name whose price less than 15k.
import Model.Customer;
import Model.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DisplayPNameLessThan {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt = ses.createCriteria(Products.class);
        crt.add(Restrictions.le("pPrice",15000.00));
        List<Products> li = crt.list();
        for (Products p : li){
            System.out.println(p.getpName());
        }

    }
}
