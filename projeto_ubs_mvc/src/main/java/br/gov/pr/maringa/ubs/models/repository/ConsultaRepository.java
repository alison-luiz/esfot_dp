package br.gov.pr.maringa.ubs.models.repository;

import br.gov.pr.maringa.ubs.models.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
