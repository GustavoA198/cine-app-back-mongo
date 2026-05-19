package co.com.cineapp.backmongo.dto;

import co.com.clients.parent.exception.AppException;
import lombok.Data;

@Data
public class ExampleResponseDTO {

  private String code;
  private String message;
  private Object data;

}