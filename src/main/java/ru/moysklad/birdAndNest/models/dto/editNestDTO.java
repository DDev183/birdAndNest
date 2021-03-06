package ru.moysklad.birdAndNest.models.dto;

import ru.moysklad.birdAndNest.repositories.NestRepository;

public class editNestDTO {

    private int id;
    private String name;
    private String address;

    public editNestDTO() {
    }
    public editNestDTO(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid(NestRepository nestRepository){
        return !name.isEmpty() && !address.isEmpty() && nestRepository.findById(id).isPresent();
    }

}
