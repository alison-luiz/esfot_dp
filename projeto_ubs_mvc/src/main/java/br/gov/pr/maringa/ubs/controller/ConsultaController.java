package br.gov.pr.maringa.ubs.controller;

import br.gov.pr.maringa.ubs.models.domain.Consulta;
import br.gov.pr.maringa.ubs.models.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public Consulta cadastrarConsulta(@RequestBody  Consulta consulta) {
        return consultaRepository.save(consulta);
    }

}
