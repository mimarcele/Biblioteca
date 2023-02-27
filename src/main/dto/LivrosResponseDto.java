package main.dto;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LivrosResponseDto {

//    @ApiModelProperty(value = "Codigo do livro")
    private Long id;
    private String nome;
}
