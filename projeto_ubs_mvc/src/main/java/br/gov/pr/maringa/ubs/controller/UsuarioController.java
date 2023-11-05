package br.gov.pr.maringa.ubs.controller;

import br.gov.pr.maringa.ubs.models.domain.Endereco;
import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import br.gov.pr.maringa.ubs.models.domain.users.Medico;
import br.gov.pr.maringa.ubs.models.domain.users.Usuario;
import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import br.gov.pr.maringa.ubs.models.repository.EnderecoRepository;
import br.gov.pr.maringa.ubs.models.repository.MedicoRepository;
import br.gov.pr.maringa.ubs.models.repository.PessoaRepository;
import br.gov.pr.maringa.ubs.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

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

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/medicos")
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    @PostMapping("/usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getPessoa() != null) {
            Pessoa pessoa = usuario.getPessoa();
            if (pessoa.getEndereco() != null && !pessoa.getEndereco().isEmpty()) {
                for (Endereco endereco : pessoa.getEndereco()) {
                    if (endereco.getId() == null && endereco.getTipoDeEndereco() == TipoDeEndereco.USUARIO) {
                        enderecoRepository.save(endereco);
                    } else {
                        throw new RuntimeException("Endereço de UBS não pode ser cadastrado como endereço de usuário");
                    }
                }
            }
            pessoaRepository.save(pessoa);
        }

        return usuarioRepository.save(usuario);
    }

    @PostMapping("/medico")
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

    @PutMapping("/usuario/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario.getPessoa() != null) {
            Pessoa pessoa = usuario.getPessoa();
            if (pessoa.getEndereco() != null && !pessoa.getEndereco().isEmpty()) {
                for (Endereco endereco : pessoa.getEndereco()) {
                    if (endereco.getId() == null && endereco.getTipoDeEndereco() == TipoDeEndereco.USUARIO) {
                        enderecoRepository.save(endereco);
                    } else {
                        throw new RuntimeException("Endereço de UBS não pode ser cadastrado como endereço de usuário");
                    }
                }
            }
            pessoaRepository.save(pessoa);
        }

        return usuarioRepository.save(usuario);
    }

    @PutMapping("/medico/{id}")
    public Medico atualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
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

    @DeleteMapping("/usuario/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @DeleteMapping("/medico/{id}")
    public void deletarMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }

}
