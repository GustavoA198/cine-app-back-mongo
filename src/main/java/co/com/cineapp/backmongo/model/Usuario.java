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
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String nombre;
    private String apellido;

    private String password;

    private String telefono;

    @Builder.Default
    private String rol = "USER";

    @Builder.Default
    private Boolean activo = true;

    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimoAcceso;

    @Builder.Default
    private Boolean emailConfirmado = false;
}