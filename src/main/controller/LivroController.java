package main.controller;

import main.dto.LivrosRequestDto;
import main.dto.LivrosResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import main.service.LivrosService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LivroController {

    private final LivrosService livrosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar livro no banco de dados")
    public LivrosResponseDto cadastroLivro(@RequestBody final LivrosRequestDto livrosRequestDto){
        return livrosService.criar(livrosRequestDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Buscar livros cadastradps no banco de dados")
    public List<LivrosResponseDto> listar(){
        return livrosService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Buscar livro no banco de dados")
    public LivrosResponseDto buscar(@PathVariable final Long id){
        return livrosService.buscar(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deletar livro do banco de dados")
    public void deletar(@PathVariable final Long id){
        livrosService.deletar(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Atualizar livro no banco de dados")
    public LivrosResponseDto atualizar(@RequestBody final LivrosRequestDto livrosRequestDto){
        return livrosService.atualizar(livrosRequestDto);
    }
}
