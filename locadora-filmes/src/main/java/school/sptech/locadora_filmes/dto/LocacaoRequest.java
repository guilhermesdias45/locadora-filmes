package school.sptech.locadora_filmes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocacaoRequest {
    private Long clienteId;
    private Long filmeId;
}
