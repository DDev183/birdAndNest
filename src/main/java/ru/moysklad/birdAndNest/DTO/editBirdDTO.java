package ru.moysklad.birdAndNest.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import ru.moysklad.birdAndNest.models.Bird;
import ru.moysklad.birdAndNest.models.Nest;
import ru.moysklad.birdAndNest.repositories.BirdRepo;
import ru.moysklad.birdAndNest.repositories.NestRepo;


public class editBirdDTO {



    private int id;
    private String name;
    private String color;
    private Nest nest;

    @Autowired
    NestRepo birdRepo;


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


    public boolean isValid(BirdRepo birdRepo){
        return id != 0 && birdRepo.findById(id).isPresent();
    }

    public Bird changeBird(NestRepo nestRepo, Bird bird){

        if (name != bird.getName() && !name.isEmpty()) bird.setName(name);
        if (color != bird.getColor() && !color.isEmpty()) bird.setColor(color);
        if (nest != bird.getNest() && nestRepo.findById(nest.getId()).isPresent()) bird.setNest(nest);

        return bird;

    }
}
