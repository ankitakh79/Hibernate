package Util;

import Model.Questions;
import Model.Topic;
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

        cfg = new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Questions.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//     for the topic which have 2 questions
            Criteria crt1 = ses.createCriteria(Topic.class);
            List<Topic> li1 = crt1.list();
            for (Topic q1 : li1) {
                System.out.println(q1.getTopicName());
                List<Questions> q3 = q1.getQuestions();
                if(q3.size()>=2)
                for (Questions i : q3) {
                    System.out.println(i.getQueStion());
                }
            }
        }
}
