package school.sptech.locadora_filmes.service;

import org.springframework.stereotype.Service;
import school.sptech.locadora_filmes.dto.FilmeRequest;
import school.sptech.locadora_filmes.entidade.Filme;
import school.sptech.locadora_filmes.exception.FilmeDuplicadoException;
import school.sptech.locadora_filmes.mapper.FilmeMapper;
import school.sptech.locadora_filmes.repository.FilmeRepository;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<Filme> listarFilmes(){
        return repository.findAll();
    }

    public Filme salvarFilme(FilmeRequest filme){
        if (repository.existsByTituloAndDiretor(filme.getTitulo(), filme.getDiretor())){
            throw new FilmeDuplicadoException();
        }
        return repository.save(FilmeMapper.toEntity(filme));
    }

    public Boolean validarFilme(FilmeRequest filme){
        return filme.getDiretor() != null &&
                !filme.getDiretor().isBlank() &&
                filme.getGenero() != null &&
                !filme.getGenero().isBlank() &&
                filme.getTitulo() != null &&
                !filme.getTitulo().isBlank();
    }
}
