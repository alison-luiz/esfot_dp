package br.gov.pr.maringa.ubs.models.domain;

import br.gov.pr.maringa.ubs.models.domain.users.Medico;
import br.gov.pr.maringa.ubs.models.domain.users.Usuario;
import br.gov.pr.maringa.ubs.models.enums.TipoDeConsulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer horarioMarcado;

    private TipoDeConsulta tipoDeConsulta;

    @OneToOne(fetch = FetchType.EAGER)
    private Medico medico;

    @OneToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @OneToOne(fetch = FetchType.EAGER)
    private Ubs ubs;

}
