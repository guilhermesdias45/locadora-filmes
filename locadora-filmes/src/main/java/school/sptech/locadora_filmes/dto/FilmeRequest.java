package school.sptech.locadora_filmes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeRequest {
    private String titulo;
    private String genero;
    private String diretor;
}
