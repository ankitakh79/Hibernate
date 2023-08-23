package Util;

import Model.Employe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpUtil {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(Employe.class);
        factory= cfg.buildSessionFactory();
        ses = factory.openSession();
        Employe e1 = new Employe();
        e1.setEmpId(101);
        e1.setEmpName("Akash");
        e1.setEmpDept("DEVELOPER");
        e1.setEmpSal(29900.9);

        tx = ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        ses.close();
        System.out.println("Data entered");
    }
}
