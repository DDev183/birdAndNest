package ru.moysklad.birdAndNest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.moysklad.birdAndNest.models.Nest;

import java.util.Optional;


@Repository
public interface NestRepo extends JpaRepository<Nest, Integer> {


    Optional<Nest> findById(int id);


}
