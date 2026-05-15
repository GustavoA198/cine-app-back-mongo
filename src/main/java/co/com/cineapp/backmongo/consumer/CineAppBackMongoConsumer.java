package co.com.cineapp.backmongo.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import co.com.clients.parent.exception.IntegrationException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CineAppBackMongoConsumer {

  private final String QUEUE = "example";
  private final String RABBIT_MQ_ERROR_HANDLER = "rabbitMqErrorHandler";

  @RabbitListener(queues = QUEUE, errorHandler = RABBIT_MQ_ERROR_HANDLER)
    public Message<?> debitAdapter(
            Object canonicalRequest, @Headers Map<String, Object> headers) throws IntegrationException {

        return MessageBuilder.withPayload("aqui va el llamodo del servicio ejmplo hola.saludo(canonicalRequest)").copyHeaders(headers)
                .build();
    }
}