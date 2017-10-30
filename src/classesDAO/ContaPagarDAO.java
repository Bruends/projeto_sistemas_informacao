package classesDAO;

import classes.AnoContaPagar;
import classes.ContaPagar;
import classes.MesContaPagar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    //Pesquisa intervalo de Meses por ano
    public static ArrayList<MesContaPagar> retornaMeses( String ano ){
        ArrayList<MesContaPagar> meses = new ArrayList<>();
        String sql = "SELECT * from conta_pagar WHERE data_vencimento LIKE '%"+ano+"%'";        
        Connection con = null;
        try {
            con = Conexao.getConexao();
            state = con.prepareStatement(sql);            
            resultado = state.executeQuery();            
            while ( resultado.next() ) {                
                String mesNum = resultado.getString( "data_vencimento" ).split("/")[1];                
                String mesString = "";
                switch(mesNum){
                    case "01": mesString = "Janeiro";
                        break;
                    case "02": mesString = "Fevereiro";
                        break;
                    case "03": mesString = "Março";
                        break;
                    case "04": mesString = "Abril";
                        break;
                    case "05": mesString = "Maio";
                        break;
                    case "06": mesString = "Junho";
                        break;
                    case "07": mesString = "Julho";
                        break;
                    case "08": mesString = "Agosto";
                        break;
                    case "09": mesString = "Setembro";
                        break;
                    case "10": mesString = "Outubro";
                        break;
                    case "11": mesString = "Novembro";
                        break;
                    case "12": mesString = "Dezembro";
                        break;                            
                }
                double valor = resultado.getDouble("valor");
                String titulo = resultado.getString("Titulo");
                MesContaPagar mes = new MesContaPagar(mesString, new ContaPagar(titulo,valor) );
                meses.add(mes);
            }
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar meses: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return meses;
    }
    
    //retorna ano
     public static AnoContaPagar retornaAno( String ano ){
        AnoContaPagar anoContaPagar = new AnoContaPagar();
        Connection con = null;        
        try {                                        
                String sql = "SELECT SUM(valor) AS valores FROM conta_pagar WHERE data_vencimento LIKE '%"+ano+"%'";                        
                con = Conexao.getConexao();
                state = con.prepareStatement(sql);            
                resultado = state.executeQuery();            
                while ( resultado.next()  ) {                                   
                   //anoContaPagar  = new AnoContaPagar( ano, Float.parseFloat(resultado.getString("valores") ) );                       
                   if( resultado.getString("valores") != null ){
                       anoContaPagar.setAno(ano);
                       anoContaPagar.setSomaValores( Float.parseFloat(resultado.getString("valores") ) );}
                    
                } 
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar anos: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return anoContaPagar;
    }
    
     public static ArrayList<AnoContaPagar> retornaAnos( ArrayList<Integer> anosParam ){
        ArrayList<AnoContaPagar> anos = new ArrayList<>();
        Connection con = null;        
        try {     
            for (int i = 0; i < anosParam.size() ; i++) {                            
                String sql = "SELECT SUM(valor) AS valores FROM conta_pagar WHERE data_vencimento LIKE '%"+anosParam.get(i)+"%'";                        
                con = Conexao.getConexao();
                state = con.prepareStatement(sql);            
                resultado = state.executeQuery();            
                while ( resultado.next()  ) {    
                    //System.out.println( anosParam[i] );
                    if( anosParam.get(i)!=null ){
                    anos.add( new AnoContaPagar(anosParam.get(i).toString(), Double.parseDouble(resultado.getString("valores"))) );                
                    }
                }                         
            }    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar anos: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return anos;
    }
    
    //retorna anos
    public static ArrayList<AnoContaPagar> retornaAnos( String ano ){
        ArrayList<AnoContaPagar> anos = new ArrayList<>();
        Connection con = null;        
        try {                                        
                String sql = "SELECT SUM(valor) AS valores FROM conta_pagar WHERE data_vencimento LIKE '%"+ano+"%'";                        
                con = Conexao.getConexao();
                state = con.prepareStatement(sql);            
                resultado = state.executeQuery();            
                while ( resultado.next()  ) {               
                    anos.add( new AnoContaPagar(ano, Double.parseDouble(resultado.getString("valores"))) );                
                }                            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar anos: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return anos;
    }
    
    
    //PESQUISAR ANOS
    public static ArrayList<String> retornaTodosAnos(){
        ArrayList<String> anos = new ArrayList<>();
        Connection con = null;
        String sql = "SELECT data_vencimento from conta_pagar";
        try {
            con = Conexao.getConexao();
            state = con.prepareStatement(sql);
            resultado = state.executeQuery();
            
            while ( resultado.next() ) { 
                String ano = resultado.getString("data_vencimento").split("/")[2];
                if( !anos.contains(ano) )anos.add( ano );                
            }
            
        } catch (SQLException e) {            
            JOptionPane.showMessageDialog(null,"Erro ao retornar anos: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);
        }
        return anos;
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
           state.setString(6, pagamento.getObs() );
           state.setInt(7,  pagamento.getCod() );
           
                                 
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

