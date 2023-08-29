package cadastropoo.model;

import java.io.Serializable;

/**
 *
 * @author HervalDantas
 */
public class PessoaJuridica extends Pessoa implements Serializable {

    protected String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        
        System.out.println("Nome da Empresa: " + nome);
        System.out.println("Código ID:       " + id);
        System.out.println("CNPJ:            " + cnpj);
        System.out.println("===================================");
    }

}
