package co.com.cineapp.backmongo.validator;

import co.com.cineapp.backmongo.dto.ExampleRequestDTO;
import co.com.clients.parent.exception.BackendException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.integration.core.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import static co.com.cineapp.backmongo.utilities.ConstantFields.REQUEST;
import static co.com.clients.parent.utility.UtilitiesErrors.validateNullOrBlank;

@Log4j2
@Component
@RequiredArgsConstructor
public class CineAppBackMongoExampleValidator implements GenericHandler<Object> {

    private final ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
    }

    @Override
    public Object handle(Object payload, MessageHeaders headers) {

        try  {
            ExampleRequestDTO request = objectMapper.convertValue(payload, ExampleRequestDTO.class);

            log.debug("Inicio validación request en CineAppBackMongoExampleValidator: {}", request);
            validateRequest(request);
            return request;
        }
        catch (Exception e) {
            log.error("Error de validación en CineAppBackMongoExampleValidator: {}", e.getMessage());
            return e;
        }
    }

    /**
     * Valida los campos del request
     * @param request
     * @throws BackendException
     */
    private void validateRequest(ExampleRequestDTO request) throws BackendException {
        validateNullOrBlank(request, REQUEST);
        validateNullOrBlank(request.getExampleField1(), "exampleField1");
    }


}
