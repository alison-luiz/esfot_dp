package br.gov.pr.maringa.ubs;

import br.gov.pr.maringa.ubs.domain.Consulta;
import br.gov.pr.maringa.ubs.domain.Endereco;
import br.gov.pr.maringa.ubs.domain.Pessoa;
import br.gov.pr.maringa.ubs.domain.Ubs;
import br.gov.pr.maringa.ubs.domain.users.Medico;
import br.gov.pr.maringa.ubs.domain.users.Usuario;
import br.gov.pr.maringa.ubs.enums.TipoDeConsulta;
import br.gov.pr.maringa.ubs.enums.TipoDeEndereco;
import br.gov.pr.maringa.ubs.enums.TipoDeMedico;
import br.gov.pr.maringa.ubs.service.MarcarConsulta;

public class Main {
    public static void main(String[] args) {

        // Cadastrando UBSs no sistema

        Endereco enderecoUbs1 = new Endereco("Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs1 = new Ubs("UBS 1", "44999999999", "ubs1@gmail.com", 8, 18,  enderecoUbs1);

        Endereco enderecoUbs2 = new Endereco("Rua 2", "456", "Zona 07", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs2 = new Ubs("UBS 2", "44999999999", "ubs2@gmail.com", 9, 17, enderecoUbs2);

        Endereco enderecoUbs3 = new Endereco("Rua 3", "789", "Zona 05", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.UBS);
        Ubs ubs3 = new Ubs("UBS 3", "44999999999", "ubs3@gmail.com", 8, 22, enderecoUbs3);



        // Criando um novo registro de usuario no banco de dados

        Endereco enderecoUsuario = new Endereco("Rua 1", "123", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.USUARIO);

        Pessoa pessoaUsuario = new Pessoa("João", "da Silva", "12345678900", "44999999999", "joao@gmail.com", "01/01/2000", "M", "Solteiro", "Brasileiro", "Maringaense", enderecoUsuario);

        Usuario usuario = new Usuario("joao", "123456", pessoaUsuario);



        // Criando um novo registro de médico no banco de dados

        Endereco enderecoMedico = new Endereco("Rua 2", "456", "Centro", "Maringá", "Paraná", "PR", "87000000", TipoDeEndereco.MEDICO);

        Pessoa pessoaMedico = new Pessoa("Maria", "da Silva", "98765432100", "44999999999", "maria@gmail.com", "01/01/2000", "F", "Solteiro", "Brasileiro", "Maringaense", enderecoMedico);

        Usuario usuarioMedico = new Usuario("maria", "123456", pessoaMedico);

        Medico medico = new Medico("123456", TipoDeMedico.CLINICO_GERAL, usuarioMedico);



        // Criando um novo registro de consulta no banco de dados

        MarcarConsulta marcarConsulta = new MarcarConsulta();


        Consulta consulta1 = new Consulta(14, TipoDeConsulta.PRESENCIAL);
        marcarConsulta.marcarConsulta(usuario, medico, ubs1, consulta1);

        Consulta consulta2 = new Consulta(7, TipoDeConsulta.PRESENCIAL);
        marcarConsulta.marcarConsulta(usuario, medico, ubs1, consulta2);


    }
}