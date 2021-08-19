package ru.moysklad.birdAndNest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.moysklad.birdAndNest.models.dto.createBirdDTO;
import ru.moysklad.birdAndNest.models.dto.createNestDTO;
import ru.moysklad.birdAndNest.models.dto.editBirdDTO;
import ru.moysklad.birdAndNest.models.dto.editNestDTO;
import ru.moysklad.birdAndNest.models.entity.BirdEntity;
import ru.moysklad.birdAndNest.models.entity.NestEntity;
import ru.moysklad.birdAndNest.service.BirdService;
import ru.moysklad.birdAndNest.service.NestService;

@RestController
@RequestMapping(value = "/api")
public class GeneralController {


    @Autowired
    private BirdService birdService;

    @Autowired
    private NestService nestService;

    @GetMapping(value = "/getBird")
    public ResponseEntity getBird(@RequestParam(name = "id", required = false) Integer id){
        try {
            if (id != null) {
                BirdEntity bird = birdService.getBird(id);
                if (bird != null) {
                    return ResponseEntity.ok(bird);
                } else {
                    return ResponseEntity.status(404).build();
                }
            } else return ResponseEntity.ok(birdService.getAllBirds());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping(value = "/editBird")
    public ResponseEntity editBird(@RequestBody editBirdDTO dto){
        try {
            boolean status = birdService.editBird(dto);
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
            boolean status = birdService.createBird(dto);
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
            boolean status = birdService.dropBird(id);
            if (status){
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }



    @GetMapping(value = "/getNest")
    public ResponseEntity getNest(@RequestParam("id") int id){
        try {
            NestEntity nest = nestService.getNest(id);
            if (nest != null){
                return ResponseEntity.ok(nest);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping(value = "/editNest")
    public ResponseEntity editNest(@RequestBody editNestDTO dto) {
        try {
            boolean status = nestService.editNest(dto);
            if (status) {
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping(value = "/createNest")
    public ResponseEntity createNest(@RequestBody createNestDTO dto) {
        try {
            boolean status = nestService.createNest(dto);
            if (status) {
                return ResponseEntity.status(201).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping(value = "/dropNest")
    public ResponseEntity dropNest(@RequestParam("id") int id){
        try {
            boolean status = nestService.dropNest(id);
            if (status){
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }



}
