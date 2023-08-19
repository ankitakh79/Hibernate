package Util;

import Model.AdharCard;
import Model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;
public class DisplayMultipleData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(AdharCard.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt=ses.createCriteria(Person.class);
        List<Person> data=crt.list();
        for(Person p1:data)
        {
            System.out.println(p1.getPId()+"\t"+p1.getPName()+"\t"+p1.getPAdd()+"\t"+p1.getARef().getANo()+"\t"+p1.getARef().getNameOfAdharCard()+"\t"+p1.getARef().getUId());
        }
    }
}
