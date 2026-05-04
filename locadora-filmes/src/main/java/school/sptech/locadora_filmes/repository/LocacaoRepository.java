package school.sptech.locadora_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.locadora_filmes.entidade.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    boolean existsByFilmeIdAndDevolvidoFalse(Long filmeId);
}
