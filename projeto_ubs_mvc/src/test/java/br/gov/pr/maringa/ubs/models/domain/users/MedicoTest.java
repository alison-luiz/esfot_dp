package br.gov.pr.maringa.ubs.models.domain.users;

import br.gov.pr.maringa.ubs.models.domain.Endereco;
import br.gov.pr.maringa.ubs.models.domain.Pessoa;
import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import br.gov.pr.maringa.ubs.models.enums.TipoDeMedico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MedicoTest {

    @Test
    public void testeCriarPessoaMedico() {
        Endereco enderecoMedico = new Endereco(2L, "Rua 2", "456", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa medicoPessoa = new Pessoa(2L, "Maria", "Silva", "12345678910", "123456789", "maria@example.com", "24061998", "Feminino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoMedico));
        Medico medico = new Medico(1L, "123456-0", "123456", TipoDeMedico.CARDIOLOGISTA, medicoPessoa);

        assert medico.getId() == 1L;
    }

}
