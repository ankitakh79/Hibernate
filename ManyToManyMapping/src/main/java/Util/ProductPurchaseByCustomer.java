package Util;

//Q.7)WAJP to accept product name from end user and display the customer info who has purchased the product.
import Model.Customer;
import Model.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class ProductPurchaseByCustomer {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory = cfg.buildSessionFactory();;
        ses = factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product name");
        String name = sc.next();

        Criteria crt = ses.createCriteria(Products.class);
        crt.add(Restrictions.eq("pName",name));
        List<Products> plist = crt.list();
        for (Products p : plist){
            List<Customer> clist =p.getCustomerList();
            for (Customer c:clist){
                System.out.println(c.getcId() + " " + c.getcName());
            }
        }


    }
}
