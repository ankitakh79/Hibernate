package Util;

import Model.HAddress;
import Model.HEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session session;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(HEmployee.class).addAnnotatedClass(HAddress.class);
        factory = cfg.buildSessionFactory();
        session = factory.openSession();

        HAddress hAddress = new HAddress();
        hAddress.setAddLine("Pimpari");
        hAddress.setAddCity("Pune");
        hAddress.setPinCode(412534);

        HEmployee hEmployee = new HEmployee();
        hEmployee.setEmpName("Kajal");
        hEmployee.setEmpSal(2500.00);
        hEmployee.setAddRef(hAddress);

        tx = session.beginTransaction();
        session.save(hEmployee);
        tx.commit();
        session.close();
        factory.close();
        System.out.println("Data Saved!!!!");
    }
}
