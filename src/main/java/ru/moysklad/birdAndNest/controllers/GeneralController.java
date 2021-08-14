package ru.moysklad.birdAndNest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.moysklad.birdAndNest.DTO.createBirdDTO;
import ru.moysklad.birdAndNest.DTO.editBirdDTO;
import ru.moysklad.birdAndNest.models.Bird;
import ru.moysklad.birdAndNest.repositories.BirdRepo;
import ru.moysklad.birdAndNest.repositories.NestRepo;

@RestController
@RequestMapping(value = "/api")
public class GeneralController {

    @Autowired
    private NestRepo nestRepo;

    @Autowired
    private BirdRepo birdRepo;

    @GetMapping(value = "/getBird")
    public ResponseEntity getBird(@RequestParam("id") int id){

        try {
            if (birdRepo.findById(id).isPresent()){
                return ResponseEntity.ok(birdRepo.findById(id).get());
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }


    }


    @PostMapping(value = "/editBird")
    public ResponseEntity editBird(@RequestBody editBirdDTO dto){

        try {
            if (dto.isValid(birdRepo)){
                Bird bird = birdRepo.findById(dto.getId()).get();
                bird = dto.changeBird(nestRepo, bird);
                birdRepo.save(bird);
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(404).build();
            }

        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }

    }


    @PostMapping(value = "/createBird")
    public ResponseEntity createBird(@RequestBody createBirdDTO dto) {

        try {
            if (dto.isValid(nestRepo)) {
                Bird bird = new Bird(dto);
                birdRepo.save(bird);
                return ResponseEntity.status(201).build();
            } else {
                return ResponseEntity.status(404).build();
            }

        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return ResponseEntity.status(400).build();
        }


    }


    @GetMapping(value = "/dropBird")
    public ResponseEntity dropBird(@RequestParam("id") int id){

        try {
            if (birdRepo.findById(id).isPresent()){
                birdRepo.deleteById(id);
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }

    }

    @GetMapping(value = "/getAllBirds")
    public ResponseEntity getAllBirds(){
        return ResponseEntity.ok(birdRepo.findAll());
    }


}
