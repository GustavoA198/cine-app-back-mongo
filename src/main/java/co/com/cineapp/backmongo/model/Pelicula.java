package co.com.cineapp.backmongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "peliculas")
public class Pelicula {

    @Id
    private String id;

    @Indexed
    private String titulo;

    private String descripcion;
    private String sinopsis;

    private String genero;
    private Integer duracionMinutos;

    private String director;
    private String[] actores;

    private String posterUrl;
    private String bannerUrl;
    private String trailerUrl;

    private LocalDate fechaEstreno;
    private LocalDate fechaFinCartelera;

    @Builder.Default
    private Boolean activo = true;

    @Builder.Default
    private Boolean estreno = false;

    @Builder.Default
    private Boolean cartelera = false;

    private String clasificacion;
    private Double promedioVotacion;
    private Integer totalVotaciones;
}