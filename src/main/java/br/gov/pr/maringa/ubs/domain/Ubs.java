package br.gov.pr.maringa.ubs.domain;

public class Ubs {

    private String nome;
    private String telefone;
    private String email;
    private Integer horarioFuncionamentoInicio;
    private Integer horarioFuncionamentoFim;
    private Endereco endereco;

    public Ubs(String nome, String telefone, String email, Integer horarioFuncionamentoInicio, Integer horarioFuncionamentoFim, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.horarioFuncionamentoInicio = horarioFuncionamentoInicio;
        this.horarioFuncionamentoFim = horarioFuncionamentoFim;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getHorarioFuncionamentoInicio() {
        return horarioFuncionamentoInicio;
    }

    public Integer getHorarioFuncionamentoFim() {
        return horarioFuncionamentoFim;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
