package Model;

import javax.persistence.*;

@Entity
@Table(name = "emp_add")
public class HAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private int addid;
    @Column(name = "add_line")
    private String addLine;
    @Column(name = "add_city")
    private String addCity;
    @Column(name = "pin_code")
    private int pinCode;

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public String getAddLine() {
        return addLine;
    }

    public void setAddLine(String addLine) {
        this.addLine = addLine;
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
