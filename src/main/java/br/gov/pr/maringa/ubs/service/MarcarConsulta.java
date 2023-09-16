package br.gov.pr.maringa.ubs.service;

import br.gov.pr.maringa.ubs.domain.Consulta;
import br.gov.pr.maringa.ubs.domain.Ubs;
import br.gov.pr.maringa.ubs.domain.users.Medico;
import br.gov.pr.maringa.ubs.domain.users.Usuario;

public class MarcarConsulta {

    public void marcarConsulta(Usuario usuario, Medico medico, Ubs ubs, Consulta consulta) {

        Integer horarioMarcado = consulta.getHorarioMarcado();
        Integer horarioFuncionamentoInicio = ubs.getHorarioFuncionamentoInicio();
        Integer horarioFuncionamentoFim = ubs.getHorarioFuncionamentoFim();

        String nomeUsuario = usuario.getPessoa().getNome();
        String nomeMedico = medico.getPessoa().getNome();
        String nomeUbs = ubs.getNome();

        if (horarioMarcado < horarioFuncionamentoInicio || horarioMarcado > horarioFuncionamentoFim) {
            throw new RuntimeException("Horário de funcionamento da UBS é das " + horarioFuncionamentoInicio + " às " + horarioFuncionamentoFim);
        }

        if (horarioMarcado >= horarioFuncionamentoInicio && horarioMarcado <= horarioFuncionamentoFim) {
            System.out.println("Consulta marcada com sucesso para o usuário " + nomeUsuario + " com o médico " + nomeMedico + " na UBS " + nomeUbs + " às " + horarioMarcado + " horas");
        }

    }

}
