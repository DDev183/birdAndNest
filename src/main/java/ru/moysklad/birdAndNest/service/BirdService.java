package ru.moysklad.birdAndNest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.moysklad.birdAndNest.models.dto.createBirdDTO;
import ru.moysklad.birdAndNest.models.dto.editBirdDTO;
import ru.moysklad.birdAndNest.models.entity.BirdEntity;
import ru.moysklad.birdAndNest.repositories.BirdRepository;
import ru.moysklad.birdAndNest.repositories.NestRepository;

import java.util.List;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    @Autowired
    private NestRepository nestRepository;

    public BirdEntity getBird(int id){
        try {
            if (birdRepository.findById(id).isPresent()){
                return birdRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public boolean editBird(editBirdDTO dto){
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

    public boolean createBird(createBirdDTO dto){
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

    public boolean dropBird(int id){
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

    public List<BirdEntity> getAllBirds(){
        try {
            return birdRepository.findAll();
        } catch (Exception e){
            return null;
        }
    }
}
