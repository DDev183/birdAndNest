package ru.moysklad.birdAndNest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Nest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "nest")
    private List<Bird> linkedBirds;



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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bird> getLinkedBirds() {
        return linkedBirds;
    }

    public void setLinkedBirds(List<Bird> linkedBirds) {
        this.linkedBirds = linkedBirds;
    }

    public Nest() {
    }
}