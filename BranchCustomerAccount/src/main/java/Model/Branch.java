package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private int bId;
    @Column(name = "b_add")
    private String bAdd;
    @Column(name = "ifsc")
    private String ifscCode;

    @OneToMany(mappedBy = "bref",cascade = CascadeType.ALL)
    private List<BankCustomer> bankCustomerList;

    public void addCust(BankCustomer cref){
        if (bankCustomerList==null){
            bankCustomerList = new LinkedList<>();
        }
        bankCustomerList.add(cref);
        cref.setBref(this);
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbAdd() {
        return bAdd;
    }

    public void setbAdd(String bAdd) {
        this.bAdd = bAdd;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public List<BankCustomer> getBankCustomerList() {
        return bankCustomerList;
    }

    public void setBankCustomerList(List<BankCustomer> bankCustomerList) {
        this.bankCustomerList = bankCustomerList;
    }
}
