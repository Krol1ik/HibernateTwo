package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Users")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "First_Name")
    private String first_name;

    @Column (name = "Last_name")
    private String last_name;

    @Column (name = "Age")
    private int age;

    @OneToMany (mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingApparatus> trainingApparatuses;

    public List<TrainingApparatus> getTrainingApparatuses() {
        return trainingApparatuses;
    }

    public Users() {
    }

    public Users(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        trainingApparatuses = new ArrayList<>();
    }

    public void addTrainingApparatuses (TrainingApparatus trainingApparatus){
        trainingApparatus.setUsers(this);
        trainingApparatuses.add(trainingApparatus);
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nUser ID: " + id +
                "  | First name: " + first_name +
                "  | Last name: " + last_name +
                "  | Age: " + age + getTrainingApparatuses().toString();
    }
}
