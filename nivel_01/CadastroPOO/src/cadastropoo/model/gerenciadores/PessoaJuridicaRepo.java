package cadastropoo.model.gerenciadores;

import cadastropoo.model.PessoaJuridica;
import java.util.ArrayList;

/**
 *
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
    }

    //Método alterar que tem como parâmetro tipo = PessoaJuridica (classe)
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == pessoaJuridica.getId()) {
                pessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }

    //Método excluir que tem como parâmetro um int que identificará o id a ser excluido
    public void excluir(int id) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == id) {
                pessoasJuridicas.remove(i);
                break;
            }
        }
    }
    
    //Método obter que tem como parâmetro um int que identificará o id a ser excluido
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoajuridica : pessoasJuridicas) {
            if (pessoajuridica.getId() == id) {
                return pessoajuridica;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }
    
    
    
    
    
    
    
    
}
