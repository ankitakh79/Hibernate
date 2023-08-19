package Model;
import javax.persistence.*;

@Entity
@Table(name = "adharcard")
public class AdharCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "adhar_generator")
    @SequenceGenerator(name = "adhar_generator",initialValue = 1000,allocationSize = 10)
    @Column(name = "ANo")
    private int ANo;
    @Column(name = "NameOfAdharCard")
    private String NameOfAdharCard;
    @Column(name = "UId")
    private int UId;

    public int getANo() {
        return ANo;
    }

    public void setANo(int ANo) {
        this.ANo = ANo;
    }

    public String getNameOfAdharCard() {
        return NameOfAdharCard;
    }

    public void setNameOfAdharCard(String nameOfAdharCard) {
        NameOfAdharCard = nameOfAdharCard;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }
}
