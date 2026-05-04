package school.sptech.locadora_filmes.mapper;

import school.sptech.locadora_filmes.dto.ClienteRequest;
import school.sptech.locadora_filmes.entidade.Cliente;

public class ClienteMapper {
    public static Cliente toEntity(ClienteRequest dto){
        if (dto == null){
            return null;
        }

        return new Cliente(
                dto.getNome(),
                dto.getEmail()
        );
    }
}
