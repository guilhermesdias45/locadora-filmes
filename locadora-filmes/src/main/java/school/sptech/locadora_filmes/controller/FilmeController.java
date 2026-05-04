package school.sptech.locadora_filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.locadora_filmes.dto.FilmeRequest;
import school.sptech.locadora_filmes.entidade.Filme;
import school.sptech.locadora_filmes.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos(){
        List<Filme> filmes = service.listarFilmes();
        if (filmes.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody FilmeRequest filme){
        if (service.validarFilme(filme)){
            return ResponseEntity.status(201).body(service.salvarFilme(filme));
        }
        return ResponseEntity.status(404).build();
    }
}
