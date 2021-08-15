package ru.moysklad.birdAndNest.models.dto;

import ru.moysklad.birdAndNest.models.entity.NestEntity;
import ru.moysklad.birdAndNest.repositories.NestRepository;


public class editBirdDTO {

    private int id;
    private String name;
    private String color;
    private NestEntity nest;



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

    public boolean isValid(NestRepository nestRepo){

        return id != 0 && !name.isEmpty() && !color.isEmpty() && nestRepo.findById(nest.getId()).isPresent();
    }
}
