package br.gov.pr.maringa.ubs.domain.users;

import br.gov.pr.maringa.ubs.domain.Pessoa;

public class Usuario extends Pessoa {

    private String login;
    private String senha;
    private Pessoa pessoa;

    public Usuario(String login, String senha, Pessoa pessoa) {
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
