package Util;

import Model.Questions;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Questions.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Topic t1 = new Topic();
        t1.setTopicName("Constructor");

        Questions q1 = new Questions();
        q1.setQueStion("what are the types of Constructor");
        q1.setTopicRef(t1);

        Transaction tx= ses.beginTransaction();
        ses.save(q1);

        tx.commit();
        ses.close();
        System.out.println("Data inserted");
    }
}
