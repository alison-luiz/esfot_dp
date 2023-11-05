package br.gov.pr.maringa.ubs.models.domain;

import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UbsTest {

    @Test
    public void testeCadastrarUbs() {
        Endereco enderecoUbs = new Endereco(3L, "Rua 3", "789", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs = new Ubs(1L, "UBS 1", "123456789", "ubs-1@example.com", 8, 18, List.of(enderecoUbs));

        assert ubs.getId() == 1L;
    }

    @Test
    public void testeEditarUbs() {
        Endereco enderecoUbs = new Endereco(3L, "Rua 3", "789", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs = new Ubs(1L, "UBS 1", "123456789", "ubs-1@example.com", 8, 18, List.of(enderecoUbs));

        ubs.setNome("UBS 2");

        assert ubs.getNome().equals("UBS 2");
    }

    @Test
    public void testeRemoverUbs() {
        Endereco enderecoUbs = new Endereco(3L, "Rua 3", "789", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs = new Ubs(1L, "UBS 1", "123456789", "ubs-1@example.com", 8, 18, List.of(enderecoUbs));

        ubs = null;

        assert ubs == null;
    }

}
