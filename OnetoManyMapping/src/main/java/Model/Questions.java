package Model;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "q_generator")
    @SequenceGenerator(name="q_generator",initialValue = 1000,allocationSize = 10)
    @Column(name = "que_id")
    private int queId;
    @Column(name = "que_ques")
    private String queStion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="topic_ref")
    private Topic topicRef;

    public int getQueId() {
        return queId;
    }

    public void setQueId(int queId) {
        this.queId = queId;
    }

    public String getQueStion() {
        return queStion;
    }

    public void setQueStion(String queStion) {
        this.queStion = queStion;
    }

    public Topic getTopicRef() {
        return topicRef;
    }

    public void setTopicRef(Topic topicRef) {
        this.topicRef = topicRef;
    }
}
