package br.gov.pr.maringa.ubs.models.domain.users;

import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import br.gov.pr.maringa.ubs.models.enums.TipoDeMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String crm;

    private String senha;

    private TipoDeMedico tipoDeMedico;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

}
