package Util;
import Model.AdharCard;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(AdharCard.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Person p1=ses.get(Person.class,1);
        System.out.println(p1.getPId()+"\t"+p1.getPName()+"\t"+p1.getPAdd()+"\t"+p1.getARef().getANo()+"\t"+p1.getARef().getNameOfAdharCard()+"\t"+p1.getARef().getUId());

        ses.close();
    }
}
