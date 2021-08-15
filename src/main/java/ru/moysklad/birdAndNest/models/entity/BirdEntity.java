package ru.moysklad.birdAndNest.models.entity;

import ru.moysklad.birdAndNest.models.dto.createBirdDTO;
import ru.moysklad.birdAndNest.models.dto.editBirdDTO;

import javax.persistence.*;

@Entity
@Table(name = "bird")
public class BirdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String color;

    @ManyToOne()
    @JoinColumn(name = "nest_id")
    private NestEntity nest;

    public BirdEntity(editBirdDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.color = dto.getColor();
        this.nest = dto.getNest();
    }

    public void fly() {
        System.out.println("I'm bird " + name + " and I can fly!\n");
    }

    public BirdEntity(String name, String color, NestEntity nestEntity) {
        this.name = name;
        this.color = color;
        this.nest = nestEntity;
    }

    public BirdEntity(createBirdDTO dto){
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
    public NestEntity getNest() {
        return nest;
    }
    public void setNest(NestEntity nestEntity) {
        this.nest = nestEntity;
    }
    public BirdEntity() {
    }
}