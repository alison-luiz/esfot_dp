package br.gov.pr.maringa.ubs.domain;

import br.gov.pr.maringa.ubs.enums.TipoDeConsulta;

public class Consulta {

    private Integer horarioMarcado;
    private TipoDeConsulta tipoDeConsulta;

    public Consulta(Integer horarioMarcado, TipoDeConsulta tipoDeConsulta) {
        this.horarioMarcado = horarioMarcado;
        this.tipoDeConsulta = tipoDeConsulta;
    }

    public Integer getHorarioMarcado() {
        return horarioMarcado;
    }

    public TipoDeConsulta getTipoDeConsulta() {
        return tipoDeConsulta;
    }

}
