package school.sptech.locadora_filmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmeAlugadoException extends RuntimeException {
    public FilmeAlugadoException() {
        super("Filme já está alugado, precisa ser devolvido.");
    }
}
