package co.com.cineapp.backmongo.repository;

import co.com.cineapp.backmongo.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {

    List<Reserva> findByUsuarioIdAndActivaTrue(String usuarioId);

    List<Reserva> findByFuncionIdAndActivaTrue(String funcionId);

    Optional<Reserva> findByCodigoConfirmacion(String codigoConfirmacion);

    boolean existsByFuncionIdAndNumeroAsientosContainingAndActivaTrue(String funcionId, String numeroAsiento);
}