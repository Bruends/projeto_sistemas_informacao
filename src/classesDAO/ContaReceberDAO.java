package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.ContaReceber;
import java.util.ArrayList;

public class ContaReceberDAO 
{          
    private static Connection con = Conexao.getConexao();
    private static PreparedStatement state = null;
    private static ResultSet resultado = null;
    
    //retorna todas contas a receber
    public static ArrayList<ContaReceber> retornarTodosRecebimentos(){
        
        ArrayList<ContaReceber> recebimentos = new ArrayList();
        
        String sql = "SELECT r.id, c.nome, r.data_vencimento ,r.valor, r.status, r.total_parcelas"
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
               receber.setParcela_total(resultado.getInt("total_parcelas"));
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
    
    //insere novo recebimento no db   
       public static boolean inserirRecebimento(ContaReceber recebimento) throws SQLException {
           con = Conexao.getConexao();
           String sql = "INSERT INTO conta_receber(id_cliente, valor, status , total_parcelas) values( ?, ?, ?, ?);"; 
           state = con.prepareStatement(sql);
           
           state.setInt( 1,  recebimento.getCod_cliente() );
           state.setDouble( 2,  recebimento.getValor() );
           state.setString( 3,  "pendente" );
           state.setInt( 4,  recebimento.getParcela_total() );
                                 
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //altera recebimento
       public static boolean alterarRecebimento(ContaReceber recebimento) throws SQLException {
           con = Conexao.getConexao();
           String sql = "UPDATE conta_receber SET valor = ? , total_parcelas = ? ,  status = ? "
                   + "WHERE id = ? ;"; 
           state = con.prepareStatement(sql);
           
           state.setDouble( 1,  recebimento.getValor() );
           state.setInt( 2,  recebimento.getParcela_total() );
           state.setString( 3, recebimento.getStatus() );
           state.setInt( 4,  recebimento.getCod() );
                                 
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //excluir recebimento
       //altera recebimento
       public static boolean excluirRecebimento(int id) throws SQLException {
           con = Conexao.getConexao();
           String sql = "DELETE FROM conta_receber WHERE id = ? "; 
           state = con.prepareStatement(sql);           
           
           state.setInt( 1,  id );
           
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
    }

