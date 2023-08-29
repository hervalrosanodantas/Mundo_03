package cadastropoo.model.gerenciadores;

import cadastropoo.model.PessoaFisica;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
    }

    //Método alterar que tem como parâmetro tipo = PessoaFisica (classe)
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }

    //Método excluir que tem como parâmetro um int que identificará o id a ser excluido
    public void excluir(int id) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == id) {
                pessoasFisicas.remove(i);
                break;
            }
        }
    }

    //Método obter que tem como parâmetro um int que identificará o id a ser excluido
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    /*
    public void persistir(String nomeArquivo) {
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (PessoaFisica pessoa : pessoasFisicas) {
                escrever.write(pessoa.toString());
                escrever.newLine();                
            }
            System.out.println("Dados de Pessoas Fisicas Armazenados.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados!" + e.getMessage());
        }*/
    
    
    public void persistir(String nomeArquivo) {
        // Create a file input stream
        File arquivoPF = new File(nomeArquivo);
        try {
            
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arquivoPF));
            objOutput.writeObject(pessoasFisicas);
            objOutput.close();           
            
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }    

    }
    
        // desserialização: recuperando os objetos gravados no arquivo binário "nomeArquivo"
    
    public ArrayList<Object> recuperar(String nomeArquivo) {
        
        ArrayList<Object> lista = new ArrayList();
        try {
            File arq = new File(nomeArquivo);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }

        return (lista);
    }
    
    
    
    

}
