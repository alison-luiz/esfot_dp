package br.gov.pr.maringa.ubs.models.domain;

import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String uf;

    private String cep;

    private TipoDeEndereco tipoDeEndereco;

}
