package br.gov.pr.maringa.ubs.domain;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String sexo;
    private String estadoCivil;
    private String nacionalidade;
    private String naturalidade;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String cpf, String telefone, String email, String dataNascimento, String sexo, String estadoCivil, String nacionalidade, String naturalidade, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
