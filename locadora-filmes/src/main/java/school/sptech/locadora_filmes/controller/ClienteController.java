package school.sptech.locadora_filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.locadora_filmes.dto.ClienteRequest;
import school.sptech.locadora_filmes.entidade.Cliente;
import school.sptech.locadora_filmes.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){
        List<Cliente> clientes = service.listarClientes();
        if (clientes.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteRequest cliente){
        if (service.validarCliente(cliente)){
            return ResponseEntity.status(201).body(service.cadastrarCliente(cliente));
        }
        return ResponseEntity.status(404).build();
    }
}
