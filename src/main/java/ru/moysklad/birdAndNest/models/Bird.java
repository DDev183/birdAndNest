package ru.moysklad.birdAndNest.models;

import ru.moysklad.birdAndNest.DTO.createBirdDTO;

import javax.persistence.*;

@Entity
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String color;

    @ManyToOne()
    @JoinColumn(name = "nest_id")
    private Nest nest;




    public void fly() {
        System.out.println("I'm bird " + name + " and I can fly!\n");
    }

    public Bird(String name, String color, Nest nest) {
        this.name = name;
        this.color = color;
        this.nest = nest;
    }

    public Bird(createBirdDTO dto){
        this.name = dto.getName();
        this.color = dto.getColor();
        this.nest = dto.getNest();
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Nest getNest() {
        return nest;
    }

    public void setNest(Nest nest) {
        this.nest = nest;
    }

    public Bird() {
    }
}