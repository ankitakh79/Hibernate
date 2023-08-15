package Util;
//Inserting the data
import Model.Customer;
import Model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Customer c1= new Customer();
        c1.setcName("Sam");

        Products p1 = new Products();
        p1.setpName("Books");
        p1.setpPrice(239.90);

        Products p2 = new Products();
        p2.setpName("Bag");
        p2.setpPrice(2000.00);

        c1.addProd(p1);
        c1.addProd(p2);

        Transaction tx = ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
