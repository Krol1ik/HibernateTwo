package models;

import javax.persistence.*;

@Entity
@Table (name = "TrainingApparatus")
public class TrainingApparatus {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "Model")
    private String model;

    @Column (name = "Color")
    private String color;

    @Column (name = "Price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "User_Id")
    private Users users;

    public TrainingApparatus() {
    }

    public TrainingApparatus(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nTraining Apparatus: " +
                "ID: " + id +
                "  | Model: " + model +
                "  | Color: " + color +
                "  | Price: " + price;
    }
}
