package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe {
    @Id
    @Column(name="emp_id")
    private int empId;
    @Column(name="emp_name")
    private String empName;
    @Column(name="emp_dept")
    private String empDept;
    @Column(name="emp_sal")
    private double empSal;
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

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDept='" + empDept + '\'' +
                ", empSal=" + empSal +
                '}';
    }
}
