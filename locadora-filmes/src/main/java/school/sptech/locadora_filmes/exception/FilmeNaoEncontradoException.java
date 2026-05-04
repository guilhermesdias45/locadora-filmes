package school.sptech.locadora_filmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmeNaoEncontradoException extends RuntimeException {
    public FilmeNaoEncontradoException() {
        super("Filme não encontrado.");
    }
}
