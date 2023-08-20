package Util;

import Model.Questions;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Questions.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Topic t1 = ses.get(Topic.class,3);
        Transaction tx = ses.beginTransaction();
        ses.delete(t1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
