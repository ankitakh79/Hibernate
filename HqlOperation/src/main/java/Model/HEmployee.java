package Model;

import Model.HAddress;

import javax.persistence.*;

@Entity
@Table(name = "h_emp")
public class HEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private int empId;
    @Column(name = "e_name")
    private String empName;
    @Column(name = "e_sal")
    private double empSal;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "add_ref")
    private HAddress addRef;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public HAddress getAddRef() {
        return addRef;
    }

    public void setAddRef(HAddress addRef) {
        this.addRef = addRef;
    }
}
