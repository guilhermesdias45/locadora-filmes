package school.sptech.locadora_filmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LivroDevolvidoException extends RuntimeException {
    public LivroDevolvidoException() {
        super("Este livro já foi devolvido anteriormente!");
    }
}
