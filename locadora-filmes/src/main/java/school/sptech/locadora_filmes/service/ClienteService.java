package school.sptech.locadora_filmes.service;

import org.springframework.stereotype.Service;
import school.sptech.locadora_filmes.dto.ClienteRequest;
import school.sptech.locadora_filmes.entidade.Cliente;
import school.sptech.locadora_filmes.mapper.ClienteMapper;
import school.sptech.locadora_filmes.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    public Cliente cadastrarCliente(ClienteRequest cliente){
        return repository.save(ClienteMapper.toEntity(cliente));
    }

    public Boolean validarCliente(ClienteRequest cliente){
        return cliente.getEmail() != null &&
                !cliente.getEmail().isBlank() &&
                cliente.getNome() != null &&
                !cliente.getNome().isBlank();
    }
}
