package ru.moysklad.birdAndNest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moysklad.birdAndNest.models.Bird;

import java.util.Optional;


@Repository
public interface BirdRepo extends JpaRepository<Bird, Integer> {

    Optional<Bird> findById(int id);


}
