package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "bank_customer")
public class BankCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "b_c_Generator")
    @SequenceGenerator(name = "b_c_Generator",initialValue = 1000,allocationSize = 10)
    @Column(name = "c_id")
    private int cId;
    @Column(name = "c_name")
    private String cName;
    @Column(name = "c_city")
    private String cCity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bref")
    private Branch bref;

    @OneToMany(mappedBy = "custRef",cascade = CascadeType.ALL)
    private List<BankAccounts> bankAccountsList ;

    public  void addAcc(BankAccounts accref){
        if(bankAccountsList == null){
            bankAccountsList = new LinkedList<>();
        }
        bankAccountsList.add(accref);
        accref.setCustRef(this);
    }
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public Branch getBref() {
        return bref;
    }

    public void setBref(Branch bref) {
        this.bref = bref;
    }

    public List<BankAccounts> getBankAccountsList() {
        return bankAccountsList;
    }

    public void setBankAccountsList(List<BankAccounts> bankAccountsList) {
        this.bankAccountsList = bankAccountsList;
    }
}
