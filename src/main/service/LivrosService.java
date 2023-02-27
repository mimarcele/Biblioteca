package main.service;

import main.dto.LivrosRequestDto;
import main.dto.LivrosResponseDto;

import java.util.List;

public interface LivrosService {

    LivrosResponseDto criar(LivrosRequestDto livrosRequestDto);

    List<LivrosResponseDto> listar();

    LivrosResponseDto buscar(Long id);

    void deletar(Long id);

    LivrosResponseDto atualizar(LivrosRequestDto livrosRequestDto);
}
