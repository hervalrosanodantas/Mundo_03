package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author HervalDantas
 */
public class PessoaFisica extends Pessoa implements Serializable {
    
    private String cpf;
    private int idade;    
    
    public PessoaFisica() {
    }
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    public void exibir() {
        //super.exibir();        
        System.out.println("Nome:      "+nome);
        System.out.println("Código ID: "+id);
        System.out.println("CPF:       "+cpf);
        System.out.println("Idade:     "+idade);
        System.out.println("===================================\n"); 
        
        
    }
    /*
    @Override
    public String toString() {
        return new StringBuffer("\nCódigo ID : ")
                .append(this.id).append(" - Nome : ").append(this.nome).append("\nCPF: ").append(this.cpf).append("\nIdade: ").append(this.idade).append("\n=======================").toString();
    }*/
    
}
