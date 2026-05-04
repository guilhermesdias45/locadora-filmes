package school.sptech.locadora_filmes.service;

import org.springframework.stereotype.Service;
import school.sptech.locadora_filmes.dto.LocacaoRequest;
import school.sptech.locadora_filmes.entidade.Cliente;
import school.sptech.locadora_filmes.entidade.Filme;
import school.sptech.locadora_filmes.entidade.Locacao;
import school.sptech.locadora_filmes.exception.ClienteNaoEncontradoException;
import school.sptech.locadora_filmes.exception.FilmeAlugadoException;
import school.sptech.locadora_filmes.exception.FilmeNaoEncontradoException;
import school.sptech.locadora_filmes.exception.LivroDevolvidoException;
import school.sptech.locadora_filmes.repository.ClienteRepository;
import school.sptech.locadora_filmes.repository.FilmeRepository;
import school.sptech.locadora_filmes.repository.LocacaoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocacaoService {
    private final LocacaoRepository repository;
    private final FilmeRepository filmeRepository;
    private final ClienteRepository clienteRepository;

    public LocacaoService(LocacaoRepository repository, FilmeRepository filmeRepository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.filmeRepository = filmeRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Locacao> listarLocacoes(){
        return repository.findAll();
    }

    public Locacao encontrarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado!"));
    }

    public Locacao alugarFilme(LocacaoRequest locacao){
        if (repository.existsByFilmeIdAndDevolvidoFalse(locacao.getFilmeId())){
            throw new FilmeAlugadoException();
        }
        Filme filmeRelacionado = filmeRepository.findById(locacao.getFilmeId()).orElseThrow(
                FilmeNaoEncontradoException::new
        );
        Cliente clienteRelacionado = clienteRepository.findById(locacao.getClienteId()).orElseThrow(
                ClienteNaoEncontradoException::new
        );

        Locacao locacaoRealizada = new Locacao();

        locacaoRealizada.setCliente(clienteRelacionado);
        locacaoRealizada.setFilme(filmeRelacionado);
        locacaoRealizada.setDataLocacao(LocalDate.now());
        locacaoRealizada.setDevolvido(false);

        return repository.save(locacaoRealizada);
    }

    public Locacao devolverFilme(Long id){
        Locacao locacaoEncontrada = encontrarPorId(id);
        if (locacaoEncontrada.getDevolvido() == true){
            throw new LivroDevolvidoException();
        }

        locacaoEncontrada.setDataDevolucao(LocalDate.now());
        locacaoEncontrada.setDevolvido(true);

        return repository.save(locacaoEncontrada);
    }

    public Boolean validarLocacao(LocacaoRequest dto){
        return dto.getClienteId() != null &&
                dto.getFilmeId() != null;
    }
}
