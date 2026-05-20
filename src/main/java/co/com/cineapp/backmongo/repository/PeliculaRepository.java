package co.com.cineapp.backmongo.repository;

import co.com.cineapp.backmongo.model.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, String> {

    List<Pelicula> findByEstrenoTrue();

    List<Pelicula> findByCarteleraTrue();

    @Query("{ 'fechaEstreno': { $lte: ?0 }, 'fechaFinCartelera': { $gte: ?0 } }")
    List<Pelicula> findEnCartelera(LocalDate fecha);

    List<Pelicula> findByGenero(String genero);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<Pelicula> buscarPorTitulo(String titulo);
}