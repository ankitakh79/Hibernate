package Util;

import Model.Questions;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Updatedata {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Questions.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the topic id no you wanted to update");
        int id = sc.nextInt();

        Topic t1 = ses.load(Topic.class,id);
        List<Questions> temp = t1.getQuestions();
        for(Questions data : temp){
            Questions q1 = ses.load(Questions.class, data.getQueId());
            System.out.println(data.getQueStion());
            System.out.println("Do you want to update the question : Yes/No");
            String res = sc.next();
            if(res.equalsIgnoreCase("yes")){
                System.out.println("Enter the new question");
                sc.nextLine();
                String newQues = sc.nextLine();
                q1.setQueStion(newQues);
                Transaction tx = ses.beginTransaction();
                ses.update(q1);
                tx.commit();
                System.out.println("Data Updated");
            }else{
                System.out.println("Thank you !!!");
            }
        }

    }
}
