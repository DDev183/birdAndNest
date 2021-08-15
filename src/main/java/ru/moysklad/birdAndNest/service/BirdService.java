package ru.moysklad.birdAndNest.service;

import org.springframework.stereotype.Service;
import ru.moysklad.birdAndNest.models.dto.createBirdDTO;
import ru.moysklad.birdAndNest.models.dto.editBirdDTO;
import ru.moysklad.birdAndNest.models.entity.BirdEntity;
import ru.moysklad.birdAndNest.repositories.BirdRepository;
import ru.moysklad.birdAndNest.repositories.NestRepository;

@Service
public class BirdService {

    public BirdEntity getBird(int id, BirdRepository birdRepo){
        try {
            if (birdRepo.findById(id).isPresent()){
                return birdRepo.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public boolean editBird(editBirdDTO dto, BirdRepository birdRepo, NestRepository nestRepo){
        try {
            if (dto.isValid(nestRepo)) {
                birdRepo.save(new BirdEntity(dto));
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

    public boolean createBird(createBirdDTO dto, NestRepository nestRepository, BirdRepository birdRepository){
        try {
            if (dto.isValid(nestRepository)) {
                birdRepository.save(new BirdEntity(dto));
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

    public boolean dropBird(int id, NestRepository nestRepository, BirdRepository birdRepository){

        try {
            if (birdRepository.findById(id).isPresent()){
                birdRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
