package school.sptech.locadora_filmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FilmeDuplicadoException extends RuntimeException {
    public FilmeDuplicadoException() {
        super("Já existe um filme com mesmo nome, diretor e gênero!");
    }
}
