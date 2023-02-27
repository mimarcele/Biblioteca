package main.dto;

import lombok.Data;

@Data
public class LivrosRequestDto {

    public Long id;
    public String autor;
    public String tema;
    public Number paginas;
}
