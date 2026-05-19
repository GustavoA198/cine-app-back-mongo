package co.com.cineapp.backmongo.service;

import co.com.cineapp.backmongo.dto.ExampleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ServicioPruebaImpl implements ServicioPrueba {

    @Override
    public ExampleResponseDTO ejemploMetodo() {
        log.info("Ejecutando ejemploMetodo en ServicioPruebaImpl");
        return new ExampleResponseDTO();
    }




}
