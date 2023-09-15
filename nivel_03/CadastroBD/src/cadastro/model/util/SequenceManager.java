/* 
    Autor: Herval Rosano Dantas
*/

package cadastro.model.util;
import java.sql.ResultSet;
import java.sql.Statement;

public class SequenceManager {

    private final ConectorBD conectorBD; // Declaração de variável

    public SequenceManager() {
        this.conectorBD = new ConectorBD(); // Inicialização do objeto ConectorBD no construtor
    }

    public int getValue(String sequenceName) throws java.sql.SQLException {
        // Armazena o próximo valor da sequência
        int nextValue = 0; 
        
        // SQL para obter o próximo valor da sequência
        String sql = "SELECT nextval('" + sequenceName + "')"; 
        
        // Estancia o objeto ResultSet que armazenará o resultado da consulta
        ResultSet rs = null; 
        
        // Estancia o objeto Statement que fará a consulta
        Statement statement = null;
        
        // pega um objeto Statement do ConectorBD
        statement = conectorBD.getStatement(); 
        
        // Executa a consulta SQL e armazena o resultado no ResultSet
        rs = statement.executeQuery(sql); 
        
        // Verifica se há um próximo resultado no ResultSet
        // caso verdadeiro, pega o valor da primeira coluna do resultado e joga na variável nextValue
        if (rs.next()) { 
            nextValue = rs.getInt(1); 
        }
        
        // Fecha as conexões e statement 
        conectorBD.closeRs(rs); 
        conectorBD.closeSt(statement);
        
        // Retorna a variável nextValue
        return nextValue;
    }
}
