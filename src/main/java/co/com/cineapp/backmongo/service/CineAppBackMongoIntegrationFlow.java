package co.com.cineapp.backmongo.service;

import co.com.clients.rabbitmq.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;

import co.com.clients.parent.exception.IntegrationException;
import co.com.clients.parent.handlers.LogHandler;
import static co.com.clients.parent.utility.ConstantField.ERROR_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.CINE_APP_BACK_MONGO_INPUT_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.CINE_APP_BACK_MONGO_OUTPUT_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.CINE_APP_BACK_MONGO_QUEUE;

@Configuration
@EnableIntegration
@ConditionalOnProperty(name = "parent.gateway.async.timeout")
public class CineAppBackMongoIntegrationFlow {

    @Autowired(required = false)
    private RabbitMQService rabbitMQService;

    @Bean
    IntegrationFlow transferAdapterFlow() {
    if (rabbitMQService == null) {
        return IntegrationFlow.from(CINE_APP_BACK_MONGO_INPUT_CHANNEL)
                .handle(new LogHandler())
                .channel(CINE_APP_BACK_MONGO_OUTPUT_CHANNEL)
                .get();
    }
    return IntegrationFlow.from(CINE_APP_BACK_MONGO_INPUT_CHANNEL)
            .handle(new LogHandler())
            .filter(message -> !(message instanceof IntegrationException),
                    e -> e.discardChannel(ERROR_CHANNEL))
            .handle(rabbitMQService.sendAndReceive(CINE_APP_BACK_MONGO_QUEUE))
            .handle(new LogHandler())
            .channel(CINE_APP_BACK_MONGO_OUTPUT_CHANNEL)
            .get();
    }

}