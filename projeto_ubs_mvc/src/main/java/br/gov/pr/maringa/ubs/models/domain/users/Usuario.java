package br.gov.pr.maringa.ubs.models.domain.users;

import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

}
