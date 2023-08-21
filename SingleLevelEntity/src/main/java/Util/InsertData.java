package Util;

import Model.ContractEmployee;
import Model.Employee;
import Model.PermantEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(ContractEmployee.class).addAnnotatedClass(PermantEmployee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//        PermantEmployee p1 = new PermantEmployee();
//        p1.setEmpName("Sam");
//        p1.setEmpSal(40000.00);
//        p1.setPno(123);
//        p1.setPdesign("Developer");

        ContractEmployee p1 = new ContractEmployee();
        p1.setEmpName("Prateek");
        p1.setEmpSal(30000.00);
        p1.setDesignation("Tester");
        p1.setTimeDuration("1 Year");

        Transaction tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        ses.close();
        factory.close();
        System.out.println("data saved");
    }
}
