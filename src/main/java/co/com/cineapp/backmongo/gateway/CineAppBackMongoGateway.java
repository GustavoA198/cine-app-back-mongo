package co.com.cineapp.backmongo.gateway;

import java.util.concurrent.CompletableFuture;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import co.com.cineapp.backmongo.dto.ExampleRequestDTO;
import co.com.cineapp.backmongo.dto.ExampleResponseDTO;
import static co.com.cineapp.backmongo.utilities.Constants.INPUT_CHANNEL;
import static co.com.cineapp.backmongo.utilities.Constants.OUTPUT_CHANNEL;

@MessagingGateway(asyncExecutor = "gatewayExecutor")
public interface CineAppBackMongoGateway {

  @Gateway(requestChannel = INPUT_CHANNEL, replyChannel = OUTPUT_CHANNEL)
  CompletableFuture<ExampleResponseDTO> exampleMethod(ExampleRequestDTO request);

}