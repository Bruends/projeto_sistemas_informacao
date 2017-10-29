package classesDAO;

import classes.ContaPagar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContaPagarDAO 
{          
   
    private static PreparedStatement state = null;
    private static ResultSet resultado = null;
    
    
    //-----PESQUISAR
    public static ArrayList<ContaPagar> pesquisarPagamentos(String pesquisa){        
        
        ArrayList<ContaPagar> pagamentos = new ArrayList();
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT p.id, p.titulo, p.data_vencimento, p.valor, p.status, p.total_parcelas, p.modo_pagamento"
                + "  FROM conta_pagar as p "
                + " WHERE  c.titulo LIKE(?) OR status LIKE(?);";
        
        try {
            state = con.prepareStatement(sql);
            state.setString(1, "%" + pesquisa + "%");
            state.setString(2, "%" + pesquisa + "%");
            state.setString(3, "%" + pesquisa + "%");
            
            resultado = state.executeQuery();
            
            while( resultado.next() ){
                // cod, cliente, data_venc, valor, parcela, status
                ContaPagar pagar = new ContaPagar();
                pagar.setCod(resultado.getInt("id"));
                pagar.setTitulo(resultado.getString("titulo"));
                pagar.setData_vencimento(resultado.getString("data_vencimento"));
                pagar.setParcela_total(resultado.getInt("total_parcelas"));
                pagar.setValor(resultado.getDouble("valor"));                
                pagar.setStatus(resultado.getString("status"));
                
                pagamentos.add(pagar);                
            }
            
            Conexao.fecharConexao(con, state, resultado);
            
            return pagamentos;
            
        } catch (SQLException ex) {
            Conexao.fecharConexao(con, state, resultado);
            throw new RuntimeException("Erro: " + ex);
            
        }        
    }
    
    //-----SELECT ALL
    public static ArrayList<ContaPagar> retornarTodosPagamentos() throws SQLException{        
        ArrayList<ContaPagar> pagamentos = new ArrayList();
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT p.id, p.titulo, p.data_vencimento, p.valor, p.status, p.total_parcelas "
                + "  FROM conta_pagar as p; ";
                      
            state = con.prepareStatement(sql);
            resultado = state.executeQuery(  );
            
            while(resultado.next()){
                // cod, titulo, data_venc, valor, parcela, status
                ContaPagar pagar = new ContaPagar();
                pagar.setCod( resultado.getInt("id") );
                pagar.setTitulo( resultado.getString("titulo") );
                pagar.setData_vencimento( resultado.getString("data_vencimento") );
                pagar.setParcela_total( resultado.getInt("total_parcelas") );
                pagar.setValor( resultado.getDouble("valor") );
                pagar.setStatus( resultado.getString("status") );
                
                pagamentos.add(pagar);                
            }
            
            Conexao.fecharConexao( con,  state,  resultado );
            
            return pagamentos;
            
             
    }
    
    
    //-----SELECT AVANÇADO
    public static ArrayList<ContaPagar> pesquisaAvancada(String whereArguments) throws SQLException{        
        ArrayList<ContaPagar> pagamentos = new ArrayList();
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT p.id, p.titulo, p.data_vencimento, p.valor, p.status, p.total_parcelas "
                + "  FROM conta_pagar as p ";
                      
        
            if(whereArguments != null && whereArguments != " ")
               sql += " WHERE " + whereArguments;        
            
            sql += ";";                
        
            state = con.prepareStatement(sql);
            resultado = state.executeQuery(  );
            
            while(resultado.next()){
                // cod, titulo, data_venc, valor, parcela, status
                ContaPagar pagar = new ContaPagar();
                pagar.setCod( resultado.getInt("id") );
                pagar.setTitulo( resultado.getString("titulo") );
                pagar.setData_vencimento( resultado.getString("data_vencimento") );
                pagar.setParcela_total( resultado.getInt("total_parcelas") );
                pagar.setValor( resultado.getDouble("valor") );
                pagar.setStatus( resultado.getString("status") );
                
                pagamentos.add(pagar);                
            }
            
            Conexao.fecharConexao( con,  state,  resultado );
            
            return pagamentos;
            
             
    }
    
    
    //----------iINSERIR Pagamento
       public static boolean inserirPagamento(ContaPagar pagamento) throws SQLException {
            Connection  con = Conexao.getConexao();
           String sql = "INSERT INTO conta_pagar(titulo, valor, status , total_parcelas, data_vencimento ,obs ) values( ?, ?, ?, ?, ?, ?);"; 
           state = con.prepareStatement(sql);
           
           state.setString( 1,  pagamento.getTitulo() );
           state.setDouble( 2,  pagamento.getValor() );
           state.setString( 3,  "pendente" );
           state.setInt( 4,  pagamento.getParcela_total() );
           state.setString( 5,  pagamento.getData_vencimento());
           state.setString( 6,  pagamento.getObs() );
                                 
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //----------ALTERAR
       public static boolean alterarPagamento(ContaPagar pagamento) throws SQLException {
            Connection  con = Conexao.getConexao();
           String sql = "UPDATE conta_pagar SET titulo = ?, valor = ? , total_parcelas = ? ,  status = ?,   obs = ? "
                   + "WHERE id = ? ;"; 
           state = con.prepareStatement(sql);
           
           state.setString(1, pagamento.getTitulo()  );
           state.setDouble(2 ,pagamento.getValor() );
           state.setInt(3,  pagamento.getParcela_total() );
           state.setString(4, pagamento.getStatus() );
           state.setString(5, pagamento.getObs() );
           state.setInt(6,  pagamento.getCod() );
           
                                 
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //------EXCLUIR    
       public static boolean excluirPagamento(int id) throws SQLException {
            Connection  con = Conexao.getConexao();
           String sql = "DELETE FROM conta_pagar WHERE id = ? "; 
           state = con.prepareStatement(sql);           
           
           state.setInt( 1,  id );
           
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
       
       //-------CONFIRMAR
       public static boolean confirmarPagamento(int cod) throws SQLException {
           Connection  con = Conexao.getConexao();
           String sql = "UPDATE conta_pagar SET  status = 'Confirmado'  WHERE id = ? ;";
           
           state = con.prepareStatement(sql);
           state.setInt(1, cod);
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
        }
    }

