package br.gov.pr.maringa.ubs.models.domain;

import jakarta.persistence.*;
import liquibase.license.LicenseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ubs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private Integer horarioFuncionamentoInicio;

    private Integer horarioFuncionamentoFim;

    @OneToMany
    private List<Endereco> endereco;

}
