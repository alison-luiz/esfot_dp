package br.gov.pr.maringa.ubs.domain.users;

import br.gov.pr.maringa.ubs.enums.TipoDeMedico;

public class Medico extends Usuario {

    private String crm;
    private TipoDeMedico tipoDeMedico;
    private Usuario usuario;

    public Medico(String crm, TipoDeMedico tipoDeMedico, Usuario usuario) {
        super(usuario.getLogin(), usuario.getSenha(), usuario.getPessoa());
        this.crm = crm;
        this.tipoDeMedico = tipoDeMedico;
        this.usuario = usuario;
    }

    public String getCrm() {
        return crm;
    }

    public TipoDeMedico getTipoDeMedico() {
        return tipoDeMedico;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

