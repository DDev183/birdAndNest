package ru.moysklad.birdAndNest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moysklad.birdAndNest.models.entity.NestEntity;

import java.util.Optional;

@Repository
public interface NestRepository extends JpaRepository<NestEntity, Integer> {
    Optional<NestEntity> findById(int id);
}
