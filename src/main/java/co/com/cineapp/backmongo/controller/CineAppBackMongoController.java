package co.com.cineapp.backmongo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cineapp.backmongo.dto.ExampleRequestDTO;
import co.com.cineapp.backmongo.dto.ExampleResponseDTO;
import co.com.cineapp.backmongo.gateway.CineAppBackMongoGateway;
import co.com.clients.parent.utility.AsyncGateway;
import io.micrometer.observation.annotation.Observed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@ApiResponses(value = {
		@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
		@ApiResponse(responseCode = "403", description = "Forbidden. Cuando el usuario no tiene el rol adecuado para esta operación", content = @Content),
		@ApiResponse(responseCode = "404", description = "Not found", content = @Content) })
@Observed(name = "cineappbackmongo.controller", contextualName = "cineappbackmongo.controller")
@RequiredArgsConstructor
public class CineAppBackMongoController {

	private final CineAppBackMongoGateway cineAppBackMongoGateway;
	private final AsyncGateway asyncGateway;

	@Operation(summary = "Ejemplo de servicio", description = "Servicio de ejemplo para demostrar la estructura base")
	@ApiResponse(responseCode = "200", description = "Se ha realizado la consulta exitosamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ExampleResponseDTO.CanonicalExampleResponseDto.class)) })
	@PostMapping
	public ResponseEntity<ExampleResponseDTO> performExample(
			@RequestBody ExampleRequestDTO request,
			HttpServletRequest webRequest) {
		return asyncGateway.makeRequest(() -> cineAppBackMongoGateway.exampleMethod(request),
				request, webRequest);
	}

}