package Util;


import Model.Employe;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaMethod {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        cfg = new Configuration().configure().addAnnotatedClass(Employe.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt = ses.createCriteria(Employe.class);

       List<Employe> data  = crt.list();


    for(Employe e : data){
        System.out.println(e.getEmpId() + "\t" + e.getEmpName());
    }}
}
