package Util;

import Model.BankAccounts;
import Model.BankCustomer;
import Model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(BankCustomer.class).addAnnotatedClass(BankAccounts.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Branch b1 = new Branch();
        b1.setbAdd("Pune");
        b1.setIfscCode("HDFC)PUNE");

        BankCustomer c1 = new BankCustomer();
        c1.setcCity("Pune");
        c1.setcName("Sam");
        c1.setBref(b1);

        BankAccounts a1 = new BankAccounts();
        a1.setAccName("Asmi");
        a1.setAccType("saving");
        a1.setBalance(10000.00);
        a1.setCustRef(c1);


        Transaction tx = ses.beginTransaction();
        ses.save(a1);
        tx.commit();
        ses.close();
    }
}
