package Util;

import Model.ContractEmployee;
import Model.Employee;
import Model.PermantEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(ContractEmployee.class).addAnnotatedClass(PermantEmployee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee id");
        int id  = sc.nextInt();
        System.out.println("select \n 1.Permanant Employee \n 2.ContractEmployee Employee");
        int num = sc.nextInt();
//       Employee e1 = ses.get(Employee.class,id);
//        System.out.println(e1.getEmpName() + " "+e1.getEmpSal() + " " );

        if(num == 1) {
           PermantEmployee e2 = ses.get(PermantEmployee.class, id);
           System.out.println(e2.getEmpName()+" "+e2.getPdesign()+" "+e2.getEmpSal() +" " + e2.getPno());

       }else{
           ContractEmployee e3 = ses.get(ContractEmployee.class,id);
           System.out.println(e3.getEmpId()+" " + e3.getEmpName()+" "+e3.getEmpSal()+" "+e3.getDesignation()+" " + e3.getTimeDuration());

       }


    }
}
