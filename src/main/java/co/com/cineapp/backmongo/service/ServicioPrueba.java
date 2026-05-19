package co.com.cineapp.backmongo.service;

import co.com.cineapp.backmongo.dto.ExampleResponseDTO;
import co.com.clients.parent.exception.BackendException;

public interface ServicioPrueba {
    ExampleResponseDTO ejemploMetodo() throws BackendException;
}
