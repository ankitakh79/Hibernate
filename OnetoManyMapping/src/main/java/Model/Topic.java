package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int topicId;
    @Column(name = "topic_name")
    private String topicName;
    @OneToMany(mappedBy = "topicRef",cascade = CascadeType.ALL)
    private List<Questions> questions;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public void Add(Questions q){
        if(questions==null){
            questions=new LinkedList<>();
        }
        questions.add(q);
        q.setTopicRef(this);
    }
}
