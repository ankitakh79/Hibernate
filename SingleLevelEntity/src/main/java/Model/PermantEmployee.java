package Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "permantType")
@Table(name = "employee_data")
public class PermantEmployee extends Employee{
    @Column(name = "p_desgn")
    private String  pdesign;
    @Column(name = "p_no")
    private int pno;

    public String getPdesign() {
        return pdesign;
    }

    public void setPdesign(String pdesign) {
        this.pdesign = pdesign;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }
}
