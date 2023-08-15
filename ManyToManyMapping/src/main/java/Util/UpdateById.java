package Util;
//Q.2)WAJP to update product price (accept product id from end user)
import Model.Customer;
import Model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateById {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product id");
        int id = sc.nextInt();
        System.out.println("Enter the product price");
        double nPrice = sc.nextDouble();
        Products p1 = ses.get(Products.class,id);
        p1.setpPrice(nPrice);

        Transaction tx = ses.beginTransaction();
        ses.update(p1);
        tx.commit();
        ses.close();
        System.out.println("Data updated successfully!!!!");

    }
}
