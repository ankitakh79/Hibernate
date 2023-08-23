package Util;

import Model.Employe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;


public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employe.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query data = ses.createQuery("from Employe e1 order by e1.empName desc");
        ArrayList<Employe> res = (ArrayList<Employe>) data.getResultList();
        for (Employe emp : res){
            System.out.print(emp.getEmpId()+"\t");
            System.out.print(emp.getEmpName()+"\t");
            System.out.print(emp.getEmpDept()+"\t");
            System.out.print(emp.getEmpSal()+"\t");
        }

        System.out.println("Printing values:");
        for(Employe emp:res){
            System.out.println(emp);
        }

        Query q = ses.createQuery("from Employe  ");
        ArrayList<Employe> res1 = (ArrayList<Employe>) q.getResultList();
        for (Employe emp : res1){
            System.out.print(emp.getEmpId()+"\t");
            System.out.print(emp.getEmpName()+"\t");
            System.out.print(emp.getEmpDept()+"\t");
            System.out.print(emp.getEmpSal()+"\t");
        }

        Query q1 = ses.createQuery("from Employe order by empSal desc");
        q.setMaxResults(2); // Retrieve the top 2 results

        ArrayList<Employe> res3 = (ArrayList<Employe>) q1.getResultList();

        if (res3.size() >= 2) {
            Employe secondHighest = res3.get(1);
            System.out.println("Second Highest Salary Employee:");
            System.out.println("Employee ID: " + secondHighest.getEmpId());
            System.out.println("Employee Name: " + secondHighest.getEmpName());
            System.out.println("Employee Department: " + secondHighest.getEmpDept());
            System.out.println("Employee Salary: " + secondHighest.getEmpSal());
        } else {
            System.out.println("Not enough employees to determine the second highest salary.");
        }
//        Query q2 = ses.createQuery("from Employe e1 order by e1.empSal desc limit 2");
//        ArrayList<Employe> res2 = (ArrayList<Employe>) q2.getResultList();
//        for (Employe emp : res1){
//            System.out.print(emp.getEmpId()+"\t");
//            System.out.print(emp.getEmpName()+"\t");
//            System.out.print(emp.getEmpDept()+"\t");
//            System.out.print(emp.getEmpSal()+"\t");
//        }
    }
}
