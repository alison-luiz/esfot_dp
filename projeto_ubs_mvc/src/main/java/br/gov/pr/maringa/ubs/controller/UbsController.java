package br.gov.pr.maringa.ubs.controller;

import br.gov.pr.maringa.ubs.models.domain.Endereco;
import br.gov.pr.maringa.ubs.models.domain.Ubs;
import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import br.gov.pr.maringa.ubs.models.repository.EnderecoRepository;
import br.gov.pr.maringa.ubs.models.repository.UbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubs")
public class UbsController {

    @Autowired
    private UbsRepository ubsRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Ubs> listar() {
        return ubsRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public Ubs cadastrarUbs(@RequestBody  Ubs ubs) {
        if (ubs.getEndereco() != null && !ubs.getEndereco().isEmpty()) {
            for (Endereco endereco : ubs.getEndereco()) {
                if (endereco.getId() == null && endereco.getTipoDeEndereco() == TipoDeEndereco.UBS) {
                    enderecoRepository.save(endereco);
                } else if (endereco.getTipoDeEndereco() == TipoDeEndereco.USUARIO) {
                    throw new RuntimeException("Endereço de usuário não pode ser cadastrado como endereço de UBS");
                }
            }
        }

        return ubsRepository.save(ubs);
    }

    @PutMapping("/{id}")
    public Ubs atualizarUbs(@PathVariable("id") Long id, @RequestBody Ubs ubs) {
        Ubs ubsAtual = ubsRepository.findById(id).get();

        ubsAtual.setNome(ubs.getNome());
        ubsAtual.setEmail(ubs.getEmail());
        ubsAtual.setTelefone(ubs.getTelefone());
        ubsAtual.setHorarioFuncionamentoInicio(ubs.getHorarioFuncionamentoInicio());
        ubsAtual.setHorarioFuncionamentoFim(ubs.getHorarioFuncionamentoFim());

        if (ubs.getEndereco() != null && !ubs.getEndereco().isEmpty()) {
            for (Endereco endereco : ubs.getEndereco()) {
                if (endereco.getId() == null && endereco.getTipoDeEndereco() == TipoDeEndereco.UBS) {
                    enderecoRepository.save(endereco);
                } else if (endereco.getTipoDeEndereco() == TipoDeEndereco.USUARIO) {
                    throw new RuntimeException("Endereço de usuário não pode ser cadastrado como endereço de UBS");
                }
            }
        }

        return ubsRepository.save(ubsAtual);
    }

    @DeleteMapping("/{id}")
    public void deletarUbs(@PathVariable("id") Long id) {
        ubsRepository.deleteById(id);
    }

}
