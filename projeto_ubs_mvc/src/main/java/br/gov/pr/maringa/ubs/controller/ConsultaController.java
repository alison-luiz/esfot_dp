package br.gov.pr.maringa.ubs.controller;

import br.gov.pr.maringa.ubs.models.domain.Consulta;
import br.gov.pr.maringa.ubs.models.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping
    public Consulta[] listarConsultas() {
        return consultaRepository.findAll().toArray(new Consulta[0]);
    }

    @GetMapping("/{id}")
    public Consulta consultarConsulta(@PathVariable("id") Long id) {
        return consultaRepository.findById(id).get();
    }

    @PostMapping
    public Consulta cadastrarConsulta(@RequestBody  Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @PutMapping("/{id}")
    public Consulta atualizarConsulta(@PathVariable("id") Long id, @RequestBody Consulta consulta) {
        Consulta consultaAtual = consultaRepository.findById(id).get();

        consultaAtual.setHorarioMarcado(consulta.getHorarioMarcado());
        consultaAtual.setTipoDeConsulta(consulta.getTipoDeConsulta());
        consultaAtual.setUsuario(consulta.getUsuario());
        consultaAtual.setMedico(consulta.getMedico());
        consultaAtual.setUbs(consulta.getUbs());

        return consultaRepository.save(consultaAtual);
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable("id") Long id) {
        consultaRepository.deleteById(id);
    }

}
