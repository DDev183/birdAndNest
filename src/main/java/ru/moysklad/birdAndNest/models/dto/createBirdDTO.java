package ru.moysklad.birdAndNest.models.dto;


import ru.moysklad.birdAndNest.models.entity.NestEntity;
import ru.moysklad.birdAndNest.repositories.NestRepository;

public class createBirdDTO {

    private String name;
    private String color;
    private NestEntity nest;

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
        return !name.isEmpty() && !color.isEmpty() && nestRepo.findById(nest.getId()).isPresent();
    }

}
