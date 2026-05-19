package co.com.cineapp.backmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleResponseDTO {

  private String code;
  private String message;
  private Object data;

}