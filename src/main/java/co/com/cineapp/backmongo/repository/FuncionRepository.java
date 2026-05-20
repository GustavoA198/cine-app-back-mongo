package co.com.cineapp.backmongo.repository;

import co.com.cineapp.backmongo.model.Funcion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FuncionRepository extends MongoRepository<Funcion, String> {

    List<Funcion> findByPeliculaIdAndFechaBetween(String peliculaId, LocalDateTime inicio, LocalDateTime fin);

    @Query("{ 'salaId': ?0, 'fecha': { $gte: ?1, $lte: ?2 } }")
    List<Funcion> findBySalaIdAndFechaRange(String salaId, LocalDateTime inicio, LocalDateTime fin);

    List<Funcion> findByPeliculaIdAndActivoTrue(String peliculaId);
}