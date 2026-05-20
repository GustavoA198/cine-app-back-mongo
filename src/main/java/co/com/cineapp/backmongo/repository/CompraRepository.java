package co.com.cineapp.backmongo.repository;

import co.com.cineapp.backmongo.model.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompraRepository extends MongoRepository<Compra, String> {

    List<Compra> findByUsuarioId(String usuarioId);

    Optional<Compra> findByNumeroTransaccion(String numeroTransaccion);

    List<Compra> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    List<Compra> findByUsuarioIdAndFechaBetween(String usuarioId, LocalDateTime inicio, LocalDateTime fin);
}