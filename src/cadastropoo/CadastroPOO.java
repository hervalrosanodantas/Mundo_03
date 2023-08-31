package cadastropoo;

import cadastropoo.model.Pessoa;
import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaJuridica;
import cadastropoo.model.gerenciadores.PessoaFisicaRepo;
import cadastropoo.model.gerenciadores.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HervalDantas
 */
public class CadastroPOO {

    public static void main(String[] args) throws IOException {
        //instanciando os objetos
        PessoaFisica pessoaF = new PessoaFisica();
        PessoaJuridica pessoaJ = new PessoaJuridica();
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();
        //Scannear
        Scanner optionIn = new Scanner(System.in);
        //iniciando as 2 variáveis do looping while
        boolean inicio = true;
        boolean caso = true;

        while (inicio == true) {

            //Display Menu
            System.out.println("           M  E  N  U");
            System.out.println("================================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir conforme ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar");
            System.out.println("7 - Recuperar");
            System.out.println("0 - Finalizar programa");
            System.out.println("================================");

            String opcao = optionIn.nextLine();

            switch (opcao) {

                case "1":
                    caso = true;
                    while (caso == true) {
                        System.out.println("Foi Selecionado ==> Incluir Pessoa");
                        System.out.println("F - Pessoa Física  |  J - Pessoa Jurídica");
                        String entity = optionIn.nextLine().toUpperCase();

                        if (entity.equals("F")) {
                            System.out.println("Digite o Número do ID: ");
                            int inputId = optionIn.nextInt();
                            //Consumir a linha pendente
                            optionIn.nextLine();

                            System.out.println("Digite o Nome: ");
                            String inputNome = optionIn.nextLine();
                            System.out.println("Digite o CPF: ");
                            String inputCPF = optionIn.nextLine();
                            System.out.println("Digite sua Idade: ");
                            int inputIdade = optionIn.nextInt();
                            optionIn.nextLine();

                            //atribui os valores no objeto pessoaFisica
                            pessoaF.setNome(inputNome);
                            pessoaF.setId(inputId);
                            pessoaF.setCpf(inputCPF);
                            pessoaF.setIdade(inputIdade);

                            //usa o pessoaFisicaRepo para inserir os dados
                            repo1.inserir(pessoaF);

                            caso = false;
                        } else if (entity.equals("J")) {
                            System.out.println("Digite o Número do ID: ");
                            int inputId = optionIn.nextInt();
                            optionIn.nextLine();
                            System.out.println("Digite o Nome da Empresa: ");
                            String inputNome = optionIn.nextLine();
                            System.out.println("Digite o CNPJ: ");
                            String inputCNPJ = optionIn.nextLine();

                            pessoaJ.setNome(inputNome);
                            pessoaJ.setId(inputId);
                            pessoaJ.setCnpj(inputCNPJ);

                            repo2.inserir(pessoaJ);

                            caso = false;
                        } else {
                            System.out.println("Opção inválida!");
                            caso = true;
                        }
                    }
                    break;
                case "2":
                    caso = true;
                    while (caso == true) {
                        System.out.println("Foi Selecionado ==> Alterar Pessoa");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                        String entity = optionIn.nextLine().toUpperCase();

                        if (entity.equals("F")) {
                            System.out.println("Informe o ID da pessoa que deseja alterar: ");
                            PessoaFisica pessoaFisAlterada = new PessoaFisica();
                            int inputId = optionIn.nextInt();
                            PessoaFisica pessoaFisicaMostrar = repo1.obter(inputId);
                            if (pessoaFisicaMostrar != null) {
                                pessoaFisicaMostrar.exibir();

                                //Consumir a linha pendente
                                optionIn.nextLine();

                                System.out.println("Digite o Nome: ");
                                String inputNome = optionIn.nextLine();
                                System.out.println("Digite o CPF: ");
                                String inputCPF = optionIn.nextLine();
                                System.out.println("Digite sua Idade: ");
                                int inputIdade = optionIn.nextInt();
                                optionIn.nextLine();

                                //Alterar os valores no objeto pessoaFisica                            
                                pessoaFisAlterada.setId(inputId);
                                pessoaFisAlterada.setNome(inputNome);
                                pessoaFisAlterada.setCpf(inputCPF);
                                pessoaFisAlterada.setIdade(inputIdade);

                                //usa o pessoaFisicaRepo para inserir os dados
                                repo1.alterar(pessoaFisAlterada);

                            } else {
                                System.out.println("ID inexistente!");
                            }

                            caso = false;

                        } else if (entity.equals("J")) {
                            System.out.println("Informe o ID da Empresa que deseja alterar: ");
                            PessoaJuridica pessoaJurAlterada = new PessoaJuridica();
                            int inputId = optionIn.nextInt();
                            PessoaJuridica pessoaJuridicaMostrar = repo2.obter(inputId);
                            if (pessoaJuridicaMostrar != null) {
                                pessoaJuridicaMostrar.exibir();

                                //Consumir a linha pendente
                                optionIn.nextLine();

                                System.out.println("Digite o Nome da Empresa: ");
                                String inputNome = optionIn.nextLine();
                                System.out.println("Digite o CNPJ: ");
                                String inputCNPJ = optionIn.nextLine();

                                pessoaJurAlterada.setNome(inputNome);
                                pessoaJurAlterada.setId(inputId);
                                pessoaJurAlterada.setCnpj(inputCNPJ);

                                repo2.alterar(pessoaJurAlterada);

                            } else {
                                System.out.println("ID inexistente!");
                            }

                            caso = false;

                        } else {
                            System.out.println("Opção inválida!");
                            caso = true;
                        }
                    }
                    break;
                case "3":
                    caso = true;
                    while (caso == true) {
                        System.out.println("Foi selecionado ==> Excluir Pessoa");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                        String entity = optionIn.nextLine().toUpperCase();
                        if (entity.equals("F")) {
                            System.out.println("Digite o ID da pessoa que deseja excluir: ");
                            int inputId = optionIn.nextInt();
                            repo1.excluir(inputId);

                            caso = false;
                        } else if (entity.equals("J")) {
                            System.out.println("Digite o ID da Empresa que deseja excluir: ");
                            int inputId = optionIn.nextInt();
                            repo2.excluir(inputId);
                            caso = false;
                        } else {
                            System.out.println("Opção inavalida!");
                            caso = true;
                        }
                    }
                    break;
                case "4":
                    caso = true;
                    while (caso == true) {
                        System.out.println("Foi Selecionado ==> Exibir pelo Id");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                        String entity = optionIn.nextLine().toUpperCase();

                        if (entity.equals("F")) {
                            System.out.println("Digite o ID da pessoa que deseja obter: ");
                            int inputId = optionIn.nextInt();

                            PessoaFisica pessoaFisica = repo1.obter(inputId);
                            //System.out.println(pessoaFisica);
                            pessoaFisica.exibir();

                            System.out.println("Pessoa obtida com sucesso!");

                            caso = false;
                                    
                        } else if (entity.equals("J")) {

                            System.out.println("Digite o ID da Empresa que deseja obter: ");
                            int inputId = optionIn.nextInt();

                            PessoaJuridica pessoaJuridica = repo2.obter(inputId);
                            //System.out.println(pessoaJuridica);
                            pessoaJuridica.exibir();
                            System.out.println("Pessoa obtida com sucesso!");

                            caso = false;
                        } else {
                            System.out.println("Opção inválida!");
                            caso = true;
                        }
                    }
                    break;
                case "5":
                    caso = true;
                    while (caso == true) {
                        System.out.println("Foi Selecionado ==> Exibir Todos");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                        String entity = optionIn.nextLine().toUpperCase();
                        if (entity.equals("F")) {

                            for (PessoaFisica pessoa : repo1.obterTodos()) {
                                pessoa.exibir();
                            }
                            caso = false;
                        } else if (entity.equals("J")) {
                            for (PessoaJuridica pessoa : repo2.obterTodos()) {
                                pessoa.exibir();
                            }
                            caso = false;
                        } else {
                            System.out.println("Opção inválida!");
                            caso = true;
                        }
                    }
                    break;

                case "6":
                    //optionIn.nextLine();
                    System.out.println("Foi Selecionado ==> Salvar Dados");
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                    String entity = optionIn.nextLine().toUpperCase();
                    String prefixo = " ";

                    if (entity.equals("F")) {
                        prefixo = "fisica";
                        repo1.persistir(prefixo + "_persistente.bin");

                    } else if (entity.equals("J")) {
                        prefixo = "juridica";
                        repo2.persistir(prefixo + "_persistente.bin");
                    } else {
                        System.out.println("Opção inválida!");
                    }

                    //repo2.persistir(prefixo + "_persistente.bin");
                    break;

                case "7":
                    System.out.println("Foi Selecionado ==> Recuperar Dados");
                    //optionIn.nextLine();
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                    entity = optionIn.nextLine().toUpperCase();
                    prefixo = " ";

                    if (entity.equals("F")) {
                        prefixo = "fisica";
                        repo1.recuperar(prefixo + "_persistente.bin");

                    } else if (entity.equals("J")) {
                        prefixo = "juridica";
                        repo2.recuperar(prefixo + "_persistente.bin");

                    } else {
                        System.out.println("Opção inválida!");
                    }

                    break;

                case "0":
                    System.out.println("Programa Finalizado!");
                    inicio = false;
                    break;
            }

        }

        // ============== Repositório Pessoa Física ================
        /* PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pessoaF = new PessoaFisica(1001, "Herval Rosano Dantas", "8240330000", 59);
        PessoaFisica pessoaF1 = new PessoaFisica(1002, "Antonio Dantas", "00009700", 15);
        PessoaFisica pessoaF2 = new PessoaFisica(1003, "Angela Agostinho da Costa Dantas", "82411122253", 53);

        repo1.inserir(pessoaF);
        repo1.inserir(pessoaF1);
        repo1.inserir(pessoaF2);

        for (PessoaFisica pessoaFisica : repo1.obterTodos()) {
            System.out.println("ID: " + pessoaFisica.getId() + "\nNome: " + pessoaFisica.getNome() + "\nCPF: " + pessoaFisica.getCpf() + " ==> Idade: " + pessoaFisica.getIdade() + "\n==============\n ");
        }

        repo1.persistir("pessoaFisica.txt");
        //repo1.recuperar("pessoaFisica.txt");

        ArrayList persona = repo1.recuperar("pessoaFisica.txt");

        //System.out.println("Recuperando arquivo: " + persona); 
        for (var pessoaRecuperadas : persona) {

            System.out.println("Recuperado: " + pessoaRecuperadas);

            //pessoaRecuperadas(0).exibir();
            //System.out.println("Empresa ID: " + pesona.getId() + "\nEmpresa: " + persona.getNome()+ "\nCNPJ: " + pessoaJuridica.getCnpj()+"\n==============\n " );            
        }

        // =========== Pessoa Jurídica ==========================
        /* PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();        
        
        PessoaJuridica pessoaJ = new PessoaJuridica(3001, "Herval MEI", "82403309753/0001");
        PessoaJuridica pessoaJ2 = new PessoaJuridica(3002, "Antonio MEI", "82403309753/0002");
        PessoaJuridica pessoaJ3 = new PessoaJuridica(3002, "Antonio MEI", "82403309753/0002");
        
        repo2.inserir(pessoaJ);
        repo2.inserir(pessoaJ2);
        repo2.inserir(pessoaJ3);
        
        for (PessoaJuridica pessoaJuridica : repo2.obterTodos()) {            
            System.out.println("Empresa ID: " + pessoaJuridica.getId() + "\nEmpresa: " + pessoaJuridica.getNome()+ "\nCNPJ: " + pessoaJuridica.getCnpj()+"\n==============\n " );            
        }
         */
    }

}
