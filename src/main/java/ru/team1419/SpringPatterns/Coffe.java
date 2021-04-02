package ru.team1419.SpringPatterns;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name="coffe")
public class Coffe {
    @Id
    @Column(name="id", nullable = false)
    @JsonProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    @JsonProperty(value = "name")
    private String name;

    @Column(name="amount", nullable = false)
    @JsonProperty(value = "amount")
    private int amount;

    @Column(name="milk", nullable = false)
    @JsonProperty(value = "milk")
    private Boolean milk;


    public Coffe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Boolean getMilk() {
        return milk;
    }

    public void setMilk(Boolean milk) {
        this.milk = milk;
    }
}
