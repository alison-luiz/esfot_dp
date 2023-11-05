package br.gov.pr.maringa.ubs.models.domain.users;

import br.gov.pr.maringa.ubs.models.domain.Endereco;
import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsuarioTest {

    @Test
    private void testeCriarPessoaUsuario() {
        Endereco enderecoPaciente = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pacientePessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoPaciente));
        Usuario paciente = new Usuario(1L, "joao", "123456", pacientePessoa);

        assert paciente.getId() == 1L;
    }

}
