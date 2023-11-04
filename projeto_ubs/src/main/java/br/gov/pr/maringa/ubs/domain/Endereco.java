package br.gov.pr.maringa.ubs.domain;

import br.gov.pr.maringa.ubs.enums.TipoDeEndereco;

public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String uf;
    private String cep;
    private TipoDeEndereco tipoDeEndereco;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String uf, String cep, TipoDeEndereco tipoDeEndereco) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.uf = uf;
        this.cep = cep;
        this.tipoDeEndereco = tipoDeEndereco;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public TipoDeEndereco getTipoDeEndereco() {
        return tipoDeEndereco;
    }
}
