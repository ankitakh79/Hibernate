package Model;

import javax.persistence.*;

@Entity
@Table(name = "bank_acc")
public class BankAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ba_generator")
    @SequenceGenerator(name = "ba_generator",initialValue = 1000,allocationSize = 10)
    @Column(name = "acc_No")
    private int accNo;
    @Column(name = "acc_name")
    private String accName;
    @Column(name = "acc_type")
    private String accType;
    @Column(name = "acc_bal")
    private double balance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_ref")
    private BankCustomer custRef;

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankCustomer getCustRef() {
        return custRef;
    }

    public void setCustRef(BankCustomer custRef) {
        this.custRef = custRef;
    }
}
