package cadastropoo.model.gerenciadores;

import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaJuridica;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/** *
 * @author HervalDantas
 */
public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoasJuridicas;

    //construtor
    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<>();
    }

    //Método inserir que tem como parâmetro tipo = PessoaJuridica (classe)
    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
        System.out.println("\n====== Dados Adicionadas =======");
        pessoaJuridica.exibir();
    }

    //Método alterar que tem como parâmetro tipo = PessoaJuridica (classe)
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == pessoaJuridica.getId()) {
                pessoasJuridicas.set(i, pessoaJuridica);
                System.out.println("\n ==== Dados Alterados =======");
                pessoasJuridicas.get(i).exibir();
               // break;
            }
        }
    }

    //Método excluir que tem como parâmetro um int que identificará o id a ser excluido
    public void excluir(int id) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == id) {
                System.out.println("\n Estamos removendo ==> "+ pessoasJuridicas.get(i).getNome()); 
                pessoasJuridicas.remove(i);
                break;
            }else {
                System.out.println("\n Id inexistente! ");
                break;
            }
        }
    }

    //Método obter que tem como parâmetro um int que identificará o id a ser excluido
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoajuridica : pessoasJuridicas) {
            if (pessoajuridica.getId() == id) {
                return pessoajuridica;
            }else {
                //System.out.println("ID inexistente!");
                return null;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException  {
        // Create a file input stream
        File arquivoPJ = new File(nomeArquivo);
        FileOutputStream fos = new FileOutputStream(arquivoPJ);
        
        try (ObjectOutputStream objOutput = new ObjectOutputStream(fos)){
                       
            objOutput.writeObject(pessoasJuridicas);
            objOutput.close();           
            
            System.out.println("Dados de Pessoa Jurídica amazendados com sucesso!\n");
            
        } catch (IOException e) {
            System.out.println("Algo deu errado.");
        }
    }

    public ArrayList<PessoaJuridica> recuperar(String nomeArquivo) throws IOException, FileNotFoundException {

        //ArrayList<Object> lista = new ArrayList();
        ArrayList<PessoaJuridica> listaRecuperada = new ArrayList();
        File arq = new File(nomeArquivo);
        FileInputStream fis = new FileInputStream(arq);
        try {
            if (arq.exists()) {
                try (ObjectInputStream objInput = new ObjectInputStream(fis)) {
                    listaRecuperada = (ArrayList<PessoaJuridica>) objInput.readObject();

                    System.out.println("Dados de Pessoa Jurídica recuperados com sucesso!");
                    for (PessoaJuridica pessoa : listaRecuperada) {
                        pessoasJuridicas.add(pessoa);
                        pessoa.exibir();
                    }
                }
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return listaRecuperada;
    }
}
