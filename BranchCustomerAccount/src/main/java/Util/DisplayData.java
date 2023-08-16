package Util;

import Model.BankAccounts;
import Model.BankCustomer;
import Model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(BankCustomer.class).addAnnotatedClass(BankAccounts.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number");
        int accNo = sc.nextInt();

        BankAccounts b1 = ses.load(BankAccounts.class,accNo);
        BankCustomer c1 = b1.getCustRef();
        Branch s1 = c1.getBref();

        System.out.println(b1.getAccName()+" " +b1.getAccType() + " " +b1.getBalance());
        System.out.println(c1.getcName()+c1.getcCity());
        System.out.println(s1.getbId()+s1.getIfscCode()+s1.getbAdd());


    }
}
