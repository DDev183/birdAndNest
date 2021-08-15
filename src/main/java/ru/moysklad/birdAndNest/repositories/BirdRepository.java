package ru.moysklad.birdAndNest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moysklad.birdAndNest.models.entity.BirdEntity;

import java.util.Optional;


@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, Integer> {
    Optional<BirdEntity> findById(int id);
}
