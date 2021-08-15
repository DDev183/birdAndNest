package ru.moysklad.birdAndNest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.moysklad.birdAndNest.models.dto.createBirdDTO;
import ru.moysklad.birdAndNest.models.dto.editBirdDTO;
import ru.moysklad.birdAndNest.models.entity.BirdEntity;
import ru.moysklad.birdAndNest.repositories.BirdRepository;
import ru.moysklad.birdAndNest.repositories.NestRepository;
import ru.moysklad.birdAndNest.service.BirdService;

@RestController
@RequestMapping(value = "/api")
public class GeneralController {

    @Autowired
    private NestRepository nestRepo;

    @Autowired
    private BirdRepository birdRepo;

    @GetMapping(value = "/getBird")
    public ResponseEntity getBird(@RequestParam("id") int id){
        try {
            BirdService birdService = new BirdService();
            BirdEntity bird = birdService.getBird(id, birdRepo);
            if (bird != null){
                return ResponseEntity.ok(bird);
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
            BirdService birdService = new BirdService();
            boolean status = birdService.editBird(dto, birdRepo, nestRepo);
            if (status){
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
            BirdService birdService = new BirdService();
            boolean status = birdService.createBird(dto, nestRepo, birdRepo);
            if (status) {
                return ResponseEntity.status(201).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }


    @GetMapping(value = "/dropBird")
    public ResponseEntity dropBird(@RequestParam("id") int id){
        try {
            BirdService birdService = new BirdService();
            boolean status = birdService.dropBird(id, nestRepo, birdRepo);
            if (status){
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
