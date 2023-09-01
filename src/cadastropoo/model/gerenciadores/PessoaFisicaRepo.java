package cadastropoo.model.gerenciadores;

import cadastropoo.model.PessoaFisica;
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
public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pessoasFisicas;

    //construtor
    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    //Método inserir que tem como parâmetro tipo = PessoaFisica (classe)
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);

        System.out.println("\n ==== Dados Adicionadas =======");
        pessoaFisica.exibir();
    }

    //Método alterar que tem como parâmetro tipo = PessoaFisica (classe)
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
                System.out.println("\n ==== Dados Alterados =======");
                pessoasFisicas.get(i).exibir();
                //break;
            }
        }
    }

    //Método excluir que tem como parâmetro um int que identificará o id a ser excluido
    public void excluir(int id) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == id) {
                System.out.println("\n Estamos removendo ==> "+ pessoasFisicas.get(i).getNome());                
                pessoasFisicas.remove(i);
                break;
            } else {
                System.out.println("\n Id inexistente! ");
                break;
            }
        }
    }

    //Método obter que tem como parâmetro um int que identificará o id a ser excluido
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            } else {
                //System.out.println("ID inexistente!");
                return null;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        // Create a file input stream       
        File arquivoPF = new File(nomeArquivo);
        FileOutputStream fos = new FileOutputStream(arquivoPF);
        
        try (ObjectOutputStream objOutput = new ObjectOutputStream(fos)){
                       
            objOutput.writeObject(pessoasFisicas);
            objOutput.close();           
            
            System.out.println("Dados de Pessoa Física amazendados com sucesso!\n");
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }    
    
    // desserialização: recuperando os objetos gravados no arquivo binário "nomeArquivo"
    public ArrayList<PessoaFisica> recuperar(String nomeArquivo) throws IOException, FileNotFoundException {

        //ArrayList<Object> lista = new ArrayList();
        ArrayList<PessoaFisica> listaRecuperada = new ArrayList();
        File arq = new File(nomeArquivo);
        FileInputStream fis = new FileInputStream(arq);
        try {
            if (arq.exists()) {
                try (ObjectInputStream objInput = new ObjectInputStream(fis)) {
                    listaRecuperada = (ArrayList<PessoaFisica>) objInput.readObject();

                    System.out.println("Dados de Pessoa Física recuperados com sucesso!");
                    for (PessoaFisica pessoa : listaRecuperada) {
                        pessoasFisicas.add(pessoa);
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
