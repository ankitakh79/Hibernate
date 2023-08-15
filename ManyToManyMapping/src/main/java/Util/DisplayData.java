package Util;
//Display the data.
import Model.Customer;
import Model.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt = ses.createCriteria(Customer.class);
        List<Customer> li = crt.list();

        for (Customer c : li){
            System.out.println(c.getcId() +"\t"+c.getcName());
            List<Products> pli = c.getProductsList();
            for(Products p : pli){
                System.out.println(p.getPid()+"\t"+p.getpName()+"\t"+p.getpPrice());
            }

        }
    }
}
