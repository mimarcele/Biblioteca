package main.mapper;

import main.dto.LivrosRequestDto;

import main.entity.LivrosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperLivrosRequestDtoTo {

    LivrosEntity toEntity(LivrosRequestDto livrosRequestDto);

   // LivrosResponseDto toDto(LivrosEntity livros);

    LivrosEntity toEntityUpdate(LivrosRequestDto livrosRequestDto, @MappingTarget LivrosEntity livros);

}
