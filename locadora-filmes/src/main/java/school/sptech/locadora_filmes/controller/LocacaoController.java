package school.sptech.locadora_filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.locadora_filmes.dto.LocacaoRequest;
import school.sptech.locadora_filmes.entidade.Locacao;
import school.sptech.locadora_filmes.service.LocacaoService;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService service;

    public LocacaoController(LocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Locacao>> listarLocacoes(){
        List<Locacao> locacoes = service.listarLocacoes();
        if (locacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(locacoes);
    }

    @PostMapping
    public ResponseEntity<Locacao> alugarFilme(@RequestBody LocacaoRequest locacao){
        if (service.validarLocacao(locacao)){
            return ResponseEntity.status(200).body(service.alugarFilme(locacao));
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<Locacao> devolverFilme(@PathVariable Long id){
        if (id != null && id > 0){
            return ResponseEntity.status(200).body(service.devolverFilme(id));
        }
        return ResponseEntity.status(404).build();
    }
}
