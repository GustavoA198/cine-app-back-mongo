package co.com.cineapp.backmongo.repository;

import co.com.cineapp.backmongo.model.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends MongoRepository<Sala, String> {

    List<Sala> findByCineIdAndActivoTrue(String cineId);

    List<Sala> findByCapacidadGreaterThanEqual(int capacidad);
}