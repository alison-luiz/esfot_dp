package br.gov.pr.maringa.ubs.controller;

import br.gov.pr.maringa.ubs.models.domain.Endereco;
import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import br.gov.pr.maringa.ubs.models.domain.users.Medico;
import br.gov.pr.maringa.ubs.models.domain.users.Usuario;
import br.gov.pr.maringa.ubs.models.repository.EnderecoRepository;
import br.gov.pr.maringa.ubs.models.repository.MedicoRepository;
import br.gov.pr.maringa.ubs.models.repository.PessoaRepository;
import br.gov.pr.maringa.ubs.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubs")
public class CadastroUsuarioController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/medicos")
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    @PostMapping("/cadastrar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getPessoa() != null) {
            Pessoa pessoa = usuario.getPessoa();
            if (pessoa.getEndereco() != null && !pessoa.getEndereco().isEmpty()) {
                for (Endereco endereco : pessoa.getEndereco()) {
                    if (endereco.getId() == null) {
                        enderecoRepository.save(endereco);
                    }
                }
            }
            pessoaRepository.save(pessoa);
        }

        return usuarioRepository.save(usuario);
    }

    @PostMapping("/cadastrar-medico")
    public Medico cadastrarMedico(@RequestBody Medico medico) {
        if (medico.getPessoa() != null) {
            Pessoa pessoa = medico.getPessoa();
            if (pessoa.getEndereco() != null && !pessoa.getEndereco().isEmpty()) {
                for (Endereco endereco : pessoa.getEndereco()) {
                    if (endereco.getId() == null) {
                        enderecoRepository.save(endereco);
                    }
                }
            }
            pessoaRepository.save(pessoa);
        }

        return medicoRepository.save(medico);
    }

}
