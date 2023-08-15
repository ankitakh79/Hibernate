package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name = "product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prod_cust")
    @SequenceGenerator(name = "prod_cust",initialValue = 1000,allocationSize = 10)
    @Column(name = "p_id")
    private int pid;
    @Column(name = "p_name")
    private String pName;
    @Column(name = "p_price")
    private double pPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_product",joinColumns = @JoinColumn(name = "cust_ref"),inverseJoinColumns = @JoinColumn(name = "prod_ref"))
    private List<Customer> customerList;

    public void addCust(Customer custRef){
        if(customerList==null){
            customerList =new LinkedList<>();
        }
        customerList.add(custRef);
    }
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
