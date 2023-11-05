package br.gov.pr.maringa.ubs.models.domain;

import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoTest {

    @Test
    public void testeCadastrarEndereco() {
        Endereco endereco = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);

        assert endereco.getId() == 1L;
    }

    @Test
    public void testeEditarEndereco() {
        Endereco endereco = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        endereco.setBairro("Zona 7");

        assert endereco.getBairro().equals("Zona 7");
    }

    @Test
    public void testeRemoverEndereco() {
        Endereco endereco = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        endereco = null;

        assert endereco == null;
    }
}
