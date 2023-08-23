package Util;

import Model.Employe;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class GreaterThan {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        cfg = new Configuration().configure().addAnnotatedClass(Employe.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();
        Criteria crt = ses.createCriteria(Employe.class);
        crt.add(Restrictions.gt("empSal",1400.0));
        List<Employe> data = crt.list();
        for (Employe d : data){
            System.out.println(d.getEmpName()+"\t"+d.getEmpSal() + "\t"+d.getEmpDept());
        }
    }
}
