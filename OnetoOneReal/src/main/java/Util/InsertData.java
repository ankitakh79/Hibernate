package Util;

import Model.AdharCard;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(AdharCard.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        AdharCard ad=new AdharCard();
        ad.setNameOfAdharCard("sam");
        ad.setUId(5001);

        Person p1=new Person();
        p1.setPName("sam");
        p1.setPAdd("Pune");
        p1.setARef(ad);

        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
