package br.gov.pr.maringa.ubs.controller;

import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import br.gov.pr.maringa.ubs.models.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
public class PessoaControlle {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);

        if (pessoa == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Pessoa não encontrada");
            errorResponse.put("message", "A pessoa com o ID especificado não foi encontrada.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtual = pessoaRepository.findById(id).orElse(null);

        if (pessoaAtual == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Pessoa não encontrada");
            errorResponse.put("message", "A pessoa com o ID especificado não foi encontrada.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        pessoaAtual.setNome(Objects.requireNonNullElse(pessoa.getNome(), pessoaAtual.getNome()));
        pessoaAtual.setDocumento(Objects.requireNonNullElse(pessoa.getDocumento(), pessoaAtual.getDocumento()));

        return new ResponseEntity<>(pessoaRepository.save(pessoaAtual), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);

        if (pessoa == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Pessoa não encontrada");
            errorResponse.put("message", "A pessoa com o ID especificado não foi encontrada.");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        pessoaRepository.delete(pessoa);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
