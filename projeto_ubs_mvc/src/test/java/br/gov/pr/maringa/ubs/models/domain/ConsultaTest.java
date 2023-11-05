package br.gov.pr.maringa.ubs.models.domain;

import br.gov.pr.maringa.ubs.models.domain.users.Medico;
import br.gov.pr.maringa.ubs.models.domain.users.Usuario;
import br.gov.pr.maringa.ubs.models.enums.TipoDeConsulta;
import br.gov.pr.maringa.ubs.models.enums.TipoDeEndereco;
import br.gov.pr.maringa.ubs.models.enums.TipoDeMedico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConsultaTest {

    @Test
    public void testeMarcarConsulta() {
        Endereco enderecoPaciente = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pacientePessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoPaciente));
        Usuario paciente = new Usuario(1L, "joao", "123456", pacientePessoa);

        Endereco enderecoMedico = new Endereco(2L, "Rua 2", "456", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa medicoPessoa = new Pessoa(2L, "Maria", "Silva", "12345678910", "123456789", "maria@example.com", "24061998", "Feminino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoMedico));
        Medico medico = new Medico(1L, "123456-0", "123456", TipoDeMedico.CARDIOLOGISTA, medicoPessoa);

        Endereco enderecoUbs = new Endereco(3L, "Rua 3", "789", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs = new Ubs(1L, "UBS 1", "123456789", "ubs-1@example.com", 8, 18, List.of(enderecoUbs));

        Consulta consulta = new Consulta(1L, 10, TipoDeConsulta.ONLINE, medico, paciente, ubs);

        assert consulta.getId() == 1L;

    }

    @Test
    public void testeEditarConsultaMarcada() {
        Endereco enderecoPaciente = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pacientePessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoPaciente));
        Usuario paciente = new Usuario(1L, "joao", "123456", pacientePessoa);

        Endereco enderecoMedico = new Endereco(2L, "Rua 2", "456", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa medicoPessoa = new Pessoa(2L, "Maria", "Silva", "12345678910", "123456789", "maria@example.com", "24061998", "Feminino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoMedico));
        Medico medico = new Medico(1L, "123456-0", "123456", TipoDeMedico.CARDIOLOGISTA, medicoPessoa);

        Endereco enderecoUbs = new Endereco(3L, "Rua 3", "789", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs = new Ubs(1L, "UBS 1", "123456789", "ubs-1@example.com", 8, 18, List.of(enderecoUbs));

        Consulta consulta = new Consulta(1L, 10, TipoDeConsulta.ONLINE, medico, paciente, ubs);

        consulta.setHorarioMarcado(11);

        assert consulta.getHorarioMarcado() == 11;
    }

    @Test
    public void testeRemoverConsultaMarcada() {
        Endereco enderecoPaciente = new Endereco(1L, "Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa pacientePessoa = new Pessoa(1L, "João", "Silva", "12345678910", "123456789", "joao@example.com", "24061998", "Masculino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoPaciente));
        Usuario paciente = new Usuario(1L, "joao", "123456", pacientePessoa);

        Endereco enderecoMedico = new Endereco(2L, "Rua 2", "456", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);
        Pessoa medicoPessoa = new Pessoa(2L, "Maria", "Silva", "12345678910", "123456789", "maria@example.com", "24061998", "Feminino", "Solteiro", "Brasileira", "Maringaense", List.of(enderecoMedico));
        Medico medico = new Medico(1L, "123456-0", "123456", TipoDeMedico.CARDIOLOGISTA, medicoPessoa);

        Endereco enderecoUbs = new Endereco(3L, "Rua 3", "789", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs = new Ubs(1L, "UBS 1", "123456789", "ubs-1@example.com", 8, 18, List.of(enderecoUbs));

        Consulta consulta = new Consulta(1L, 10, TipoDeConsulta.ONLINE, medico, paciente, ubs);

        consulta = null;

        assert consulta == null;
    }

}
