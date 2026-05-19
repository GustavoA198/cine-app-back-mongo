package co.com.cineapp.backmongo.consumer;

import co.com.cineapp.backmongo.service.ServicioPrueba;
import co.com.clients.parent.exception.BackendException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

import static co.com.cineapp.backmongo.utilities.Constants.CINE_APP_BACK_MONGO_QUEUE;
import static co.com.clients.parent.utility.ConstantField.RABBIT_MQ_ERROR_HANDLER;

@Component
@RequiredArgsConstructor
public class CineAppBackMongoConsumer {

  ServicioPrueba servicioPrueba;

  @RabbitListener(queues = CINE_APP_BACK_MONGO_QUEUE, errorHandler = RABBIT_MQ_ERROR_HANDLER)
    public Message<?> debitAdapter(
            Object request, @Headers Map<String, Object> headers) throws BackendException {

        return MessageBuilder.withPayload(servicioPrueba.ejemploMetodo()).copyHeaders(headers)
                .build();
    }
}