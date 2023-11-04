package br.gov.pr.maringa.ubs.models.repository;

import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
