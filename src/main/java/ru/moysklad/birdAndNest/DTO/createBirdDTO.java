package ru.moysklad.birdAndNest.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import ru.moysklad.birdAndNest.models.Nest;
import ru.moysklad.birdAndNest.repositories.NestRepo;

@JsonIgnoreProperties(value = { "nestRepo" })
public class createBirdDTO {

    @Autowired
    private NestRepo nestRepo;

    private String name;
    private String color;
    private Nest nest;



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

    public boolean isValid(NestRepo nestRepo){
        return !name.isEmpty() && !color.isEmpty() && nestRepo.findById(nest.getId()).isPresent();
    }


}
