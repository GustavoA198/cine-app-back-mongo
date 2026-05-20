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
@Document(collection = "funciones")
public class Funcion {

    @Id
    private String id;

    @Indexed
    private String peliculaId;

    private String salaId;
    private String cineId;

    private LocalDateTime fecha;

    private Double precioBoleta;

    @Builder.Default
    private Boolean activo = true;

    @Builder.Default
    private Integer asientosDisponibles = 0;
}