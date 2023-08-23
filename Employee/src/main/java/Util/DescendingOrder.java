package Util;

import Model.Employe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;

public class DescendingOrder {
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

        Query q = ses.createQuery("from Employe e where empSal = (select max(empSal) from Employe where empSal < (select max(empSal) from Employe))");
        ArrayList<Employe> res1 = (ArrayList<Employe>) q.getResultList();

        if (res1.size() > 0) {
            Employe secondHighest = res1.get(0);
            System.out.println("Second Highest Salary Employee:");
            System.out.println("Employee ID: " + secondHighest.getEmpId());
            System.out.println("Employee Name: " + secondHighest.getEmpName());
            System.out.println("Employee Department: " + secondHighest.getEmpDept());
            System.out.println("Employee Salary: " + secondHighest.getEmpSal());
        }





    }
}
