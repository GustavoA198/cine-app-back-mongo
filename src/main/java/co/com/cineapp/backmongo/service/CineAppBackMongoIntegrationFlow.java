package co.com.cineapp.backmongo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;

import co.com.clients.parent.service.rabbitmq.RabbitMQService;
import co.com.clients.parent.exception.IntegrationException;
import co.com.clients.parent.handlers.LogHandler;
import static co.com.clients.parent.utility.ConstantField.ERROR_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.INPUT_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.OUTPUT_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.QUEUE;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableIntegration
@RequiredArgsConstructor
public class CineAppBackMongoIntegrationFlow {

    private final RabbitMQService rabbitMQService;

    @Bean
    IntegrationFlow transferAdapterFlow() {
    return IntegrationFlow.from(INPUT_CHANNEL)
            .handle(new LogHandler())
            .filter(message -> !(message instanceof IntegrationException),
                    e -> e.discardChannel(ERROR_CHANNEL))
            .handle(rabbitMQService.sendAndReceive(QUEUE))
            .handle(new LogHandler())
            .channel(OUTPUT_CHANNEL)
            .get();
    }

}