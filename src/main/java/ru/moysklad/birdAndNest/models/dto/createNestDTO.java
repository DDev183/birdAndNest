package ru.moysklad.birdAndNest.models.dto;

public class createNestDTO {

    private String name;
    private String address;

    public createNestDTO() {
    }
    public createNestDTO(String name, String address) {
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

    public boolean isValid(){
        return !name.isEmpty() && !address.isEmpty();
    }
}
