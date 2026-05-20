package co.com.cineapp.backmongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "salas")
public class Sala {

    @Id
    private String id;

    private String nombre;
    private Integer capacidad;

    @Builder.Default
    private String tipo = "NORMAL";

    @Builder.Default
    private Boolean activo = true;

    private String cineId;
    private String ubicacion;
}