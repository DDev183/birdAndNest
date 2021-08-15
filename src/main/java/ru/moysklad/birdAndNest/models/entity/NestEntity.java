package ru.moysklad.birdAndNest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.moysklad.birdAndNest.models.dto.createNestDTO;
import ru.moysklad.birdAndNest.models.dto.editNestDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nest")
public class NestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "nest")
    private List<BirdEntity> linkedBirds;

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
    public List<BirdEntity> getLinkedBirds() {
        return linkedBirds;
    }
    public void setLinkedBirds(List<BirdEntity> linkedBirds) {
        this.linkedBirds = linkedBirds;
    }
    public NestEntity() {
    }

    public NestEntity(createNestDTO dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
    }

    public NestEntity(editNestDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.address = dto.getAddress();
    }
}