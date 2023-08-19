package Util;

import Model.BankAccounts;
import Model.BankCustomer;
import Model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;
import java.util.List;
//Update the data
public class UpdateData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(BankCustomer.class).addAnnotatedClass(BankAccounts.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the branch id");
        int bid = sc.nextInt();
        System.out.println("Enter the customer id");
        int cid = sc.nextInt();
        System.out.println("Enter the account no:");
        int accNo = sc.nextInt();
        System.out.println("Enter the new account type");
        String nType = sc.next();

        Branch b1 = ses.get(Branch.class,bid);
        List<BankCustomer> blist= b1.getBankCustomerList();
        for (BankCustomer b:blist){
            if(b.getcId()==cid){
                BankCustomer customer = ses.get(BankCustomer.class,cid);
                 List<BankAccounts> accountsList=b.getBankAccountsList();
                 for (BankAccounts a : accountsList){
                     if (a.getAccNo()==accNo){
                         BankAccounts accounts = ses.get(BankAccounts.class,accNo);
                         accounts.setAccType(nType);

                     Transaction tx = ses.beginTransaction();
                     ses.update(accounts);
                     tx.commit();
                     ses.close();
                     factory.close();
                     System.out.println("Data updated successfully!!!!");
                     }
                 }
            }
        }
    }
}
