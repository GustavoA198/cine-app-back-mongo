package co.com.cineapp.backmongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reservas")
public class Reserva {

    @Id
    private String id;

    private String usuarioId;
    private String funcionId;

    private String[] numeroAsientos;

    private Double total;

    @Indexed(unique = true)
    private String codigoConfirmacion;

    @Builder.Default
    private String estado = "PENDIENTE";

    @Builder.Default
    private Boolean activa = true;

    private LocalDateTime fechaReserva;
    private LocalDateTime fechaExpiracion;
}