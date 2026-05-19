package co.com.cineapp.backmongo.gateway;

import java.util.concurrent.CompletableFuture;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import co.com.cineapp.backmongo.dto.ExampleRequestDTO;
import co.com.cineapp.backmongo.dto.ExampleResponseDTO;
import static co.com.cineapp.backmongo.utilities.Constants.CINE_APP_BACK_MONGO_INPUT_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.CINE_APP_BACK_MONGO_OUTPUT_CHANNEL;

@MessagingGateway(asyncExecutor = "gatewayExecutor")
public interface CineAppBackMongoGateway {

  @Gateway(requestChannel = CINE_APP_BACK_MONGO_INPUT_CHANNEL, replyChannel = CINE_APP_BACK_MONGO_OUTPUT_CHANNEL)
  CompletableFuture<ExampleResponseDTO> exampleMethod(ExampleRequestDTO request);

}