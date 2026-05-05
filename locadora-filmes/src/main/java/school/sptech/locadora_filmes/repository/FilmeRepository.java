package school.sptech.locadora_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.locadora_filmes.entidade.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    boolean existsByTituloAndDiretor(String titulo, String diretor);
}
