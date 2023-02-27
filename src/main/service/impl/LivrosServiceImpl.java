package main.service.impl;

import main.dto.LivrosRequestDto;
import main.dto.LivrosResponseDto;
import main.entity.LivrosEntity;
import main.exception.LivroNaoEncontradoException;
import main.exception.LivroCreateException;
import lombok.RequiredArgsConstructor;
import main.mapper.MapperLivrosRequestDtoTo;
import main.mapper.MapperLivrosResponseDtoTo;
import org.springframework.stereotype.Service;
import main.repository.LivroRepository;
import main.service.LivrosService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivrosServiceImpl implements LivrosService {

    private final MapperLivrosResponseDtoTo mapperLivrosResponseDtoTo;
    private final MapperLivrosRequestDtoTo mapperLivrosRequestDtoTo;
    private final LivroRepository livroRepository;
    @Override
    public LivrosResponseDto criar(LivrosRequestDto livrosRequestDto) {
        return Optional.of(livrosRequestDto)
                .map(mapperLivrosRequestDtoTo::toEntity)
                .map(livros -> criar(livrosRequestDto))
                .orElseThrow( () -> new LivroCreateException("Falha ao cadastrar o livro:" + livrosRequestDto));
    }

    @Override
    public List<LivrosResponseDto> listar() {
        return livroRepository.findAll()
                .stream()
                .map(livros -> mapperLivrosResponseDtoTo.toDto(livros))
                .collect(Collectors.toList());
    }

    @Override
    public LivrosResponseDto buscar(Long id) {
        return mapperLivrosResponseDtoTo.toDto(livroRepository.getOne(id));
    }

    @Override
    public void deletar(Long id) {
        try{
            livroRepository.deleteById(id);
        } catch (Exception e){
            throw new LivroNaoEncontradoException("Livro não encontrado");
        }
    }

    @Override
    public LivrosResponseDto atualizar(LivrosRequestDto livrosRequestDto) {
        return Optional.of(getLivro(livrosRequestDto.getId()))
                .map(livros -> {
                    mapperLivrosRequestDtoTo.toEntityUpdate(livrosRequestDto, livros);
                    return livros;
                })
                .map(this::criarLivroEToDto)
                .orElseThrow(() -> new LivroNaoEncontradoException("Falha ao atualizar o livro com id " + livrosRequestDto));
    }

    private LivrosEntity getLivro(final Long id){
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado"));
    }

    private LivrosResponseDto criarLivroEToDto(final LivrosEntity livros){
        return Optional.of(livroRepository.save(livros))
                .map(mapperLivrosResponseDtoTo::toDto)
                .orElseThrow(() -> new LivroNaoEncontradoException("Falha no processo de atualizar e salvar livro"));
    }
}
