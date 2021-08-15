package ru.moysklad.birdAndNest.service;

import org.springframework.stereotype.Service;
import ru.moysklad.birdAndNest.models.dto.createNestDTO;
import ru.moysklad.birdAndNest.models.dto.editNestDTO;
import ru.moysklad.birdAndNest.models.entity.NestEntity;
import ru.moysklad.birdAndNest.repositories.NestRepository;

@Service
public class NestService {


    public NestEntity getNest(int id, NestRepository nestRepository){
        try {
            if (nestRepository.findById(id).isPresent()){
                return nestRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public boolean editNest(editNestDTO dto, NestRepository nestRepo){
        try {
            if (dto.isValid(nestRepo)) {
                nestRepo.save(new NestEntity(dto));
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

    public boolean createNest(createNestDTO dto, NestRepository nestRepository){
        try {
            if (dto.isValid()) {
                nestRepository.save(new NestEntity(dto));
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

    public boolean dropNest(int id, NestRepository nestRepository){
        try {
            if (nestRepository.findById(id).isPresent()){
                nestRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

}
