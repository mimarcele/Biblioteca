package main.mapper;


import main.dto.LivrosResponseDto;
import main.entity.LivrosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperLivrosResponseDtoTo {

   // LivrosEntity toEntity(LivrosResponseDto livrosResponseDto);

    LivrosResponseDto toDto(LivrosEntity livros);

  //  LivrosEntity tpEntityUpdate(LivrosResponseDto livrosResponseDto, @MappingTarget LivrosEntity livros);
}
