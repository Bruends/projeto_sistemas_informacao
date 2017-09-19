package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.ContaReceber;
import java.util.ArrayList;

public class ContaReceberDAO 
{          
   
    private static PreparedStatement state = null;
    private static ResultSet resultado = null;
    
    
    //-----PESQUISAR
    public static ArrayList<ContaReceber> pesquisarRecebimentos(String pesquisa){        
        
        ArrayList<ContaReceber> recebimentos = new ArrayList();
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT r.id, c.nome, r.data_vencimento ,r.valor, r.status, r.total_parcelas, r.modo_pagamento"
                + "  FROM conta_receber as r, cliente as c "
                + " WHERE r.id_cliente = c.id AND ( c.nome LIKE(?) OR status LIKE(?) OR modo_pagamento LIKE(?) );";
        
        try {
            state = con.prepareStatement(sql);
            state.setString(1, "%" + pesquisa + "%");
            state.setString(2, "%" + pesquisa + "%");
            state.setString(3, "%" + pesquisa + "%");
            
            resultado = state.executeQuery();
            
            while( resultado.next() ){
                // cod, cliente, data_venc, valor, parcela, status
                ContaReceber receber = new ContaReceber();
                receber.setCod(resultado.getInt("id"));
                receber.setCliente(resultado.getString("nome"));
                receber.setData_vencimento(resultado.getString("data_vencimento"));
                receber.setParcela_total(resultado.getInt("total_parcelas"));
                receber.setValor(resultado.getDouble("valor"));
                receber.setModo_pagamento(resultado.getString("modo_pagamento"));
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
    
    //-----SELECT ALL
    public static ArrayList<ContaReceber> retornarTodosRecebimentos() throws SQLException{        
        ArrayList<ContaReceber> recebimentos = new ArrayList();
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT r.id, c.nome, r.data_vencimento ,r.valor, r.status, r.total_parcelas, r.modo_pagamento"
                + "  FROM conta_receber as r, cliente as c "
                + " WHERE r.id_cliente = c.id ORDER BY r.id; ";
        
       
            state = con.prepareStatement(sql);
            resultado = state.executeQuery();
            
            while(resultado.next()){
                // cod, cliente, data_venc, valor, parcela, status
                ContaReceber receber = new ContaReceber();
                receber.setCod(resultado.getInt("id"));
                receber.setCliente(resultado.getString("nome"));
                receber.setData_vencimento( resultado.getString("data_vencimento") );
                receber.setParcela_total(resultado.getInt("total_parcelas"));
                receber.setValor(resultado.getDouble("valor"));
                receber.setModo_pagamento(resultado.getString("modo_pagamento"));
                receber.setStatus(resultado.getString("status"));
                
                recebimentos.add(receber);                
            }
            
            Conexao.fecharConexao(con, state, resultado);
            
            return recebimentos;
            
             
    }
    
    //----------iINSERIR RECEBIMENTO
       public static boolean inserirRecebimento(ContaReceber recebimento) throws SQLException {
            Connection  con = Conexao.getConexao();
           String sql = "INSERT INTO conta_receber(id_cliente, valor, status , total_parcelas, modo_pagamento, data_vencimento ,obs ) values( ?, ?, ?, ?, ?, ?, ?);"; 
           state = con.prepareStatement(sql);
           
           state.setInt( 1,  recebimento.getCod_cliente() );
           state.setDouble( 2,  recebimento.getValor() );
           state.setString( 3,  "pendente" );
           state.setInt( 4,  recebimento.getParcela_total() );
           state.setString( 5,  recebimento.getModo_pagamento() );
           state.setString( 6,  recebimento.getData_vencimento());
           state.setString( 7,  recebimento.getObs());
                                 
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //----------ALTERAR RECEBIMENTO
       public static boolean alterarRecebimento(ContaReceber recebimento) throws SQLException {
            Connection  con = Conexao.getConexao();
           String sql = "UPDATE conta_receber SET valor = ? , total_parcelas = ? ,  status = ?,  modo_pagamento = ?, obs = ? "
                   + "WHERE id = ? ;"; 
           state = con.prepareStatement(sql);
           
           state.setDouble( 1,  recebimento.getValor() );
           state.setInt( 2,  recebimento.getParcela_total() );
           state.setString( 3, recebimento.getStatus() );
           state.setString( 4, recebimento.getModo_pagamento() );
           state.setString( 5, recebimento.getObs() );
           state.setInt( 6,  recebimento.getCod() );
           
                                 
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //------EXCLUIR    
       public static boolean excluirRecebimento(int id) throws SQLException {
            Connection  con = Conexao.getConexao();
           String sql = "DELETE FROM conta_receber WHERE id = ? "; 
           state = con.prepareStatement(sql);           
           
           state.setInt( 1,  id );
           
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //-------CONFIRMAR RECEBIMENTO
       public static boolean confirmarRecebimento(int cod) throws SQLException {
           Connection  con = Conexao.getConexao();
           String sql = "UPDATE conta_receber SET  status = 'Confirmado'  WHERE id = ? ;";
           
           state = con.prepareStatement(sql);
           state.setInt(1, cod);
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
    }

