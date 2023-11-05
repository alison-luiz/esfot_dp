package br.gov.pr.maringa.ubs.models.domain;

import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PessoaTest {

    @Test
    public void testeCadastroPessoa() {
        Endereco endereco = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(endereco));

        assert pessoa.getId() == 1L;

    }

    @Test
    public void testeEditarPessoa() {
        Endereco endereco = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(endereco));

        pessoa.setNome("João da Silva");

        assert pessoa.getNome().equals("João da Silva");
    }

    @Test
    public void testeRemoverPessoa() {
        Endereco endereco = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(endereco));

        pessoa = null;

        assert pessoa == null;
    }

}
