/* 
    Autor: Herval Rosano Dantas
*/

package cadastro.model.util;
import java.sql.ResultSet;
import java.sql.Statement;

public class SequenceManager {

    private final ConectorBD conectorBD; // Declara��o de vari�vel

    public SequenceManager() {
        this.conectorBD = new ConectorBD(); // Inicializa��o do objeto ConectorBD no construtor
    }

    public int getValue(String sequenceName) throws java.sql.SQLException {
        // Armazena o pr�ximo valor da sequ�ncia
        int nextValue = 0; 
        
        // SQL para obter o pr�ximo valor da sequ�ncia
        String sql = "SELECT nextval('" + sequenceName + "')"; 
        
        // Estancia o objeto ResultSet que armazenar� o resultado da consulta
        ResultSet rs = null; 
        
        // Estancia o objeto Statement que far� a consulta
        Statement statement = null;
        
        // pega um objeto Statement do ConectorBD
        statement = conectorBD.getStatement(); 
        
        // Executa a consulta SQL e armazena o resultado no ResultSet
        rs = statement.executeQuery(sql); 
        
        // Verifica se h� um pr�ximo resultado no ResultSet
        // caso verdadeiro, pega o valor da primeira coluna do resultado e joga na vari�vel nextValue
        if (rs.next()) { 
            nextValue = rs.getInt(1); 
        }
        
        // Fecha as conex�es e statement 
        conectorBD.closeRs(rs); 
        conectorBD.closeSt(statement);
        
        // Retorna a vari�vel nextValue
        return nextValue;
    }
}
