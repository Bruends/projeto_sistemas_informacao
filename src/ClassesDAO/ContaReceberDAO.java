package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.ContaReceber;
import java.util.ArrayList;

public class ContaReceberDAO {
    
    public ContaReceberDAO(){
        
    }
    
    //retorna contas a receber
    public ArrayList<ContaReceber> buscarRecebimentos(){
        Connection con = Conexao.getConexao();
        PreparedStatement state = null;
        ResultSet resultado = null;
        ArrayList<ContaReceber> recebimentos = new ArrayList();
        
        String sql = "SELECT r.id, c.nome, r.data_vencimento ,r.valor, r.status "
                + "  FROM conta_receber as r, cliente as c "
                + " WHERE r.id_cliente = c.id; ";
        
        try {
            state = con.prepareStatement(sql);
            resultado = state.executeQuery();
            
            while(resultado.next()){
                // cod, cliente, data_venc, valor, parcela, status
                ContaReceber receber = new ContaReceber();
                receber.setCod(resultado.getInt("id"));
                receber.setCliente(resultado.getString("nome"));
                receber.setData_vencimento(resultado.getDate("data_vencimento"));
                receber.setValor(resultado.getDouble("valor"));
                receber.setStatus(resultado.getString("status"));
                
                recebimentos.add(receber);
                
            }
            
            Conexao.fecharConexao(con, state, resultado);
            
            return recebimentos;
            
        } catch (SQLException ex) {
            Conexao.fecharConexao(con, state, resultado);
            throw new RuntimeException("Erro: " + ex);
            
        }        
    }    
}
