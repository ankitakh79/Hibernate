package Model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "ContractEmp")
@Table(name = "emp_sal")
public class ContractEmployee extends Employee{
    @Column(name = "time_duration")
    private String timeDuration;
    @Column(name = "designation")
    private String Designation;

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
