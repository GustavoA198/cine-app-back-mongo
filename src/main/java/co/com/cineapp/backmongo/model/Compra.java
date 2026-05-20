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
@Document(collection = "compras")
public class Compra {

    @Id
    private String id;

    private String usuarioId;
    private String reservaId;

    private String numeroTransaccion;

    @Builder.Default
    private String metodoPago = "TARJETA_CREDITO";

    private Double subtotal;
    private Double iva;
    private Double total;

    @Builder.Default
    private String estado = "COMPLETADA";

    @Indexed
    private LocalDateTime fecha;
}