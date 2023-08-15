package Util;
//Q.1)WAJP to accept product info from the end user and no. of customer info who want to buy that product.
import Model.Customer;
import Model.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;

public class DisplayUsingProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product name");
        String pname = sc.next();
        System.out.println("Enter the product price");
        double pPrice = sc.nextDouble();
        Products p = new Products();
        p.setpName(pname);
        p.setpPrice(pPrice);

        System.out.println("Enter the number of customer you wanted to enter ");
        int num = sc.nextInt();

        for(int i=1;i<=num;i++){
            System.out.println("Enter the customer name");
            String cName = sc.next();

            Customer c1 = new Customer();
            c1.setcName(cName);
            c1.addProd(p);

            Transaction tx = ses.beginTransaction();
            ses.save(c1);
            tx.commit();
            ses.close();
            System.out.println("Data saved");
        }

    }
}
