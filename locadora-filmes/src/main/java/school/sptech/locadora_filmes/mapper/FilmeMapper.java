package school.sptech.locadora_filmes.mapper;

import school.sptech.locadora_filmes.dto.FilmeRequest;
import school.sptech.locadora_filmes.entidade.Filme;

public class FilmeMapper {
    public static Filme toEntity(FilmeRequest dto){
        if (dto == null){
            return null;
        }

        return new Filme(
                dto.getTitulo(),
                dto.getGenero(),
                dto.getDiretor()
        );
    }
}
