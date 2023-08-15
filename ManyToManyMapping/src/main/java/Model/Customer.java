package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int cId;

    @Column(name = "c_name")
    private  String cName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_product",joinColumns = @JoinColumn(name = "prod_ref"),inverseJoinColumns = @JoinColumn(name = "cust_ref"))
   private List<Products> productsList;

    public void addProd(Products pref){
        if(productsList==null){
            productsList=new LinkedList<>();
        }
        productsList.add(pref);
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

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
