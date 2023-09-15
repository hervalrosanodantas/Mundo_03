/* 
    Autor: Herval Rosano Dantas
 */
package cadastro.model.util;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastroBD {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

            boolean continuar = true;
            while (continuar) {
                displayOpcoes();

                int opcao = lerOpcao(scanner);

                switch (opcao) {
                    case 1 -> {
                        doInclusao(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                        break;
                    }
                    case 2 -> {
                        doAlteracao(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                        break;
                    }
                    case 3 -> {
                        doExclusao(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                        break;
                    }
                    case 4 -> {
                        doObtencaoPorID(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                        break;
                    }
                    case 5 -> {
                        doListagem(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                        break;
                    }
                    case 0 ->
                        continuar = false;
                    default ->
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    public static void displayOpcoes() {
        System.out.println("\nMenu do programa:");
        System.out.println("---------------------------------");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo Id");
        System.out.println("5 - Exibir todos");
        System.out.println("0 - Sair do Programa");
        System.out.println("---------------------------------");
    }

    public static int lerOpcao(Scanner scanner) {
        int opcao = -1;
        boolean opcaoValida = false;
        while (!opcaoValida) {
            try {
                System.out.print("\nEscolha uma opção: ");
                opcao = scanner.nextInt();
                opcaoValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Opcao inválida. Favor digitar um número válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
        return opcao;
    }

    public static String escolherTipo(Scanner scanner) {
        String tipo = "";
        boolean tipoValido = false;
        while (!tipoValido) {
            System.out.print("\nF - Pessoa Física | J - Pessoa Jurídica ");
            tipo = scanner.next();
            if (tipo.equalsIgnoreCase("F") || tipo.equalsIgnoreCase("J")) {
                tipoValido = true;
            } else {
                System.out.println("Tipo inválido. Digite F ou J.");
            }
        }
        return tipo;
    }

    public static void doInclusao(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoInclusao = escolherTipo(scanner);
        if (tipoInclusao.equalsIgnoreCase("F")) {
            incluirPessoaFisica(scanner, pessoaFisicaDAO);
        } else if (tipoInclusao.equalsIgnoreCase("J")) {
            incluirPessoaJuridica(scanner, pessoaJuridicaDAO);
        }
    }

    public static void doExclusao(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoExclusao = escolherTipo(scanner);
        if (tipoExclusao.equalsIgnoreCase("F")) {
            int idPessoa = selecionarIdPessoa(scanner);
            pessoaFisicaDAO.excluir(idPessoa);
            System.out.println("Pessoa Física excluida com sucesso!");

            doListagem(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
        } else if (tipoExclusao.equalsIgnoreCase("J")) {
            int idPessoa = selecionarIdPessoa(scanner);
            pessoaJuridicaDAO.excluir(idPessoa);
            System.out.println("Pessoa Jurídica excluída com sucesso!");

            doListagem(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
        }
    }

    public static void doAlteracao(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoAlteracao = escolherTipo(scanner);
        if (tipoAlteracao.equalsIgnoreCase("F")) {
            alterarPessoaFisica(scanner, pessoaFisicaDAO);
        } else if (tipoAlteracao.equalsIgnoreCase("J")) {
            alterarPessoaJuridica(scanner, pessoaJuridicaDAO);
        }
    }

    public static void doObtencaoPorID(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoObtencao = escolherTipo(scanner);
        if (tipoObtencao.equalsIgnoreCase("F")) {
            exibirPessoaFisicaPorID(scanner, pessoaFisicaDAO);
        } else if (tipoObtencao.equalsIgnoreCase("J")) {
            exibirPessoaJuridicaPorID(scanner, pessoaJuridicaDAO);
        }
    }

    public static void doListagem(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoListagem = escolherTipo(scanner);
        if (tipoListagem.equalsIgnoreCase("F")) {
            List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.listarTodasPessoasFisicas();
            System.out.println("""
                           Exibindo dados Pessoa Física...
                           -------------------------------------------""");
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                System.out.println(pessoaFisica.toString());
            }
        } else if (tipoListagem.equalsIgnoreCase("J")) {
            List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.listarTodasPessoasJuridicas();
            System.out.println("""
                           Exibindo dados Pessoa Jurídica...
                           -------------------------------------------""");
            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                System.out.println(pessoaJuridica.toString());
            }
        }
    }

    // --- Pessoa ---
    public static int selecionarIdPessoa(Scanner scanner) {
        System.out.println("Digite o ID da Pessoa Física a ser excluída:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine();

        return idPessoa;
    }
    
    // --- Pessoa Física ---
    public static void alterarPessoaFisica(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO) {
        System.out.print("Digite o ID da pessoa Física a ser alterada: ");
        int id = scanner.nextInt();

        PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(id);
        if (pessoaFisica != null) {
            System.out.println("Pessoa Física localizada:");
            System.out.println(pessoaFisica);

            scanner.nextLine();

            System.out.print("Digite o nome da Pessoa Física: ");
            String nome = scanner.nextLine();
            pessoaFisica.setNome(nome);

            System.out.print("Digite o CPF da Pessoa Física: ");
            String cpf = scanner.nextLine();
            pessoaFisica.setCpf(cpf);

            System.out.print("Digite o Logradouro da Pessoa Física: ");
            String logradouro = scanner.nextLine();
            pessoaFisica.setLogradouro(logradouro);

            System.out.print("Digite a cidade da Pessoa Física: ");
            String cidade = scanner.nextLine();
            pessoaFisica.setCidade(cidade);

            System.out.print("Digite o estado da Pessoa Física: ");
            String estado = scanner.nextLine();
            pessoaFisica.setEstado(estado);

            System.out.print("Digite o telefone da Pessoa Física: ");
            String telefone = scanner.nextLine();
            pessoaFisica.setTelefone(telefone);

            System.out.print("Digite o email da Pessoa Física: ");
            String email = scanner.nextLine();
            pessoaFisica.setEmail(email);

            pessoaFisicaDAO.incluir(pessoaFisica);
            System.out.println("Pessoa Física incluída com sucesso!");

            pessoaFisicaDAO.alterar(pessoaFisica);
            System.out.println("Pessoa Física alterada com sucesso!");
        } else {
            System.out.println("ID Pessoa Física informado não foi localizado!");
        }
    }

    public static void incluirPessoaFisica(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        scanner.nextLine();

        System.out.print("Digite o nome da Pessoa Física: ");
        String nome = scanner.nextLine();
        pessoaFisica.setNome(nome);

        System.out.print("Digite o CPF da Pessoa Física: ");
        String cpf = scanner.nextLine();
        pessoaFisica.setCpf(cpf);

        System.out.print("Digite o Logradouro da Pessoa Física: ");
        String logradouro = scanner.nextLine();
        pessoaFisica.setLogradouro(logradouro);

        System.out.print("Digite a cidade da Pessoa Física: ");
        String cidade = scanner.nextLine();
        pessoaFisica.setCidade(cidade);

        System.out.print("Digite o estado da Pessoa Física: ");
        String estado = scanner.nextLine();
        pessoaFisica.setEstado(estado);

        System.out.print("Digite o telefone da Pessoa Física: ");
        String telefone = scanner.nextLine();
        pessoaFisica.setTelefone(telefone);

        System.out.print("Digite o email da Pessoa Física: ");
        String email = scanner.nextLine();
        pessoaFisica.setEmail(email);

        pessoaFisicaDAO.incluir(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");
    }

    public static void listarPessoasFisicas(PessoaFisicaDAO pessoaFisicaDAO) {
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.listarTodasPessoasFisicas();
        if (pessoasFisicas.isEmpty()) {
            System.out.println("Pessoas Físicas não cadastradas.");
        } else {
            System.out.println("""
                           Exibindo dados Pessoa Física...
                           -------------------------------------------""");
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                System.out.println(pessoaFisica.toString());
            }
        }
    }

    public static void exibirPessoaFisicaPorID(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO) {
        System.out.println("Digite o ID da Pessoa Física a ser exibida:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        PessoaFisica pessoaFisica = pessoaFisicaDAO.buscarPorId(idPessoa);
        if (pessoaFisica != null) {
            System.out.println(pessoaFisica); // Exibir os dados da pessoa física
        } else {
            System.out.println("ID Pessoa Física informado não foi localizado!");
        }
    }
    
    
    // --- Pessoa Jurídica ---

    public static void incluirPessoaJuridica(Scanner scanner, PessoaJuridicaDAO pessoaJuridicaDAO) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Digite o nome da Pessoa Jurídica: ");
        String nome = scanner.nextLine();
        pessoaJuridica.setNome(nome);

        System.out.print("Digite o CNPJ da Pessoa Jurídica: ");
        String cnpj = scanner.nextLine();
        pessoaJuridica.setCnpj(cnpj);

        System.out.print("Digite o Logradouro da Pessoa Jurídica: ");
        String logradouro = scanner.nextLine();
        pessoaJuridica.setLogradouro(logradouro);

        System.out.print("Digite a cidade da Pessoa Jurídica: ");
        String cidade = scanner.nextLine();
        pessoaJuridica.setCidade(cidade);

        System.out.print("Digite o estado da Pessoa Jurídica: ");
        String estado = scanner.nextLine();
        pessoaJuridica.setEstado(estado);

        System.out.print("Digite o telefone da Pessoa Jurídica: ");
        String telefone = scanner.nextLine();
        pessoaJuridica.setTelefone(telefone);

        System.out.print("Digite o email da Pessoa Jurídica: ");
        String email = scanner.nextLine();
        pessoaJuridica.setEmail(email);

        pessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");
    }

    public static void listarPessoasJuridicas(PessoaJuridicaDAO pessoaJuridicaDAO) {
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.listarTodasPessoasJuridicas();
        System.out.println("""
                       Exibindo dados Pessoa Jurídica...
                       -------------------------------------------""");
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            System.out.println(pessoaJuridica.toString());
        }
    }

    public static void exibirPessoaJuridicaPorID(Scanner scanner, PessoaJuridicaDAO pessoaJuridicaDAO) {
        System.out.println("Digite o ID da Pessoa Jurídica a ser exibida:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine();
        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.buscarPorId(idPessoa);
        if (pessoaJuridica != null) {
            System.out.println(pessoaJuridica);
        } else {
            System.out.println("ID Pessoa Jurídica informado não foi localizado!");
        }
    }

    public static void alterarPessoaJuridica(Scanner scanner, PessoaJuridicaDAO pessoaJuridicaDAO) {
        System.out.print("Digite o ID da Pessoa Jurídica a ser alterada: ");
        int id = scanner.nextInt();

        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(id);
        if (pessoaJuridica != null) {
            System.out.println("Pessoa Jurídica localizada:");
            System.out.println(pessoaJuridica);

            scanner.nextLine(); // Limpar o buffer do scanner

            System.out.print("Digite o nome da Pessoa Jurídica: ");
            String nome = scanner.nextLine();
            pessoaJuridica.setNome(nome);

            System.out.print("Digite o CNPJ da Pessoa Jurídica: ");
            String cnpj = scanner.nextLine();
            pessoaJuridica.setCnpj(cnpj);

            System.out.print("Digite o Logradouro da Pessoa Jurídica: ");
            String logradouro = scanner.nextLine();
            pessoaJuridica.setLogradouro(logradouro);

            System.out.print("Digite a cidade da Pessoa Jurídica: ");
            String cidade = scanner.nextLine();
            pessoaJuridica.setCidade(cidade);

            System.out.print("Digite o estado da Pessoa Jurídica: ");
            String estado = scanner.nextLine();
            pessoaJuridica.setEstado(estado);

            System.out.print("Digite o telefone da Pessoa Jurídica: ");
            String telefone = scanner.nextLine();
            pessoaJuridica.setTelefone(telefone);

            System.out.print("Digite o email da Pessoa Jurídica: ");
            String email = scanner.nextLine();
            pessoaJuridica.setEmail(email);

            pessoaJuridicaDAO.alterar(pessoaJuridica);
            System.out.println("Pessoa Jurídica alterada com sucesso!");
        } else {
            System.out.println("ID Pessoa Jurídica informado não foi localizado!");
        }
    }

}
