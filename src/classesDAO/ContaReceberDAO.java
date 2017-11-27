package classesDAO;

import classes.AnoContaReceber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.ContaReceber;
import classes.MesContaReceber;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public static ArrayList<String> retornaTodosAnos(){
        ArrayList<String> anos = new ArrayList<>();
        Connection con = null;
        String sql = "SELECT data_vencimento from conta_receber";
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
    
    //retorna ano
     public static AnoContaReceber retornaAno( String ano ){
        AnoContaReceber anoContaReceber = new AnoContaReceber();
        Connection con = null;        
        try {                                        
                String sql = "SELECT SUM(valor) AS valores FROM conta_receber WHERE data_vencimento LIKE '%"+ano+"%'";                        
                con = Conexao.getConexao();
                state = con.prepareStatement(sql);            
                resultado = state.executeQuery();            
                while ( resultado.next()  ) {                                   
                   //anoContaPagar  = new AnoContaPagar( ano, Float.parseFloat(resultado.getString("valores") ) );                       
                   if( resultado.getString("valores") != null ){
                       anoContaReceber.setAno(ano);
                       anoContaReceber.setSomaValores( Float.parseFloat(resultado.getString("valores") ) );}
                    
                } 
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar anos: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return anoContaReceber;
    }
    
     //Pesquisa intervalo de Meses por ano
    public static ArrayList<MesContaReceber> retornaMeses( String ano ){
        ArrayList<MesContaReceber> meses = new ArrayList<>();
        String sql = "SELECT * FROM conta_receber WHERE data_vencimento LIKE '%"+ano+"%'";        
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
                MesContaReceber mes = new MesContaReceber(mesString, new ContaReceber(valor) );
                
                if(meses.size() > 0){
                    for (int i = 0; i < meses.size(); i++) {                    
                        if ( !meses.get(i).getNome().equals( mesString ) ) {                            
                            meses.add(mes);
                            break;
                        }else{                            
                            meses.get(i).getContaReceber().addValor(valor);                            
                        }
                    }
                }else{
                    meses.add(mes);                    
                }
            }                    
                
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar meses: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return meses;
    }
         
    public static MesContaReceber retornaMesesUnique( String ano, String mes ) throws SQLException{        
        String mesNumero = "";
        MesContaReceber mesAtual = new MesContaReceber();
         switch(mes){
                    case "Janeiro": mesNumero = "01";
                        break;
                    case "Fevereiro": mesNumero = "02";
                        break;
                    case "Março": mesNumero = "03";
                        break;
                    case "Abril": mesNumero = "04";
                        break;
                    case "Maio": mesNumero = "05";
                        break;
                    case "Junho": mesNumero = "06";
                        break;
                    case "Julho": mesNumero = "07";
                        break;
                    case "Agosto": mesNumero = "08";
                        break;
                    case "Setembro": mesNumero = "09";
                        break;
                    case "Outubro": mesNumero = "10";
                        break;
                    case "Novembro": mesNumero = "11";
                        break;
                    case "Dezembro": mesNumero = "12";
                        break;                            
                }
        String sql = "SELECT SUM(valor) as somaValor,data_vencimento FROM conta_receber WHERE data_vencimento LIKE '%/"+mesNumero+"/%' AND data_vencimento LIKE '%/"+ano+"%'";        
        Connection con = null;
        try {
            con = Conexao.getConexao();
            state = con.prepareStatement(sql);            
            resultado = state.executeQuery();                        
                while ( resultado.next() ) {                           
                if( resultado.getString( "data_vencimento" ) != null ){
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
                double valor = Double.parseDouble( resultado.getString("somaValor") );                
                mesAtual = new MesContaReceber(mesString, new ContaReceber(valor) );                                       
                }else{
                    resultado.next();
                }
                                  
                }    
            
                                        
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erri ao retornar meses: "+e);
            JOptionPane.showMessageDialog(null, "Conctacte o administrador do sistema "+e);        
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return mesAtual;
    }
    
    //retorna anos
    public static ArrayList<AnoContaReceber> retornaAnos( String ano ){
        ArrayList<AnoContaReceber> anos = new ArrayList<>();
        Connection con = null;        
        try {                                        
                String sql = "SELECT SUM(valor) AS valores FROM conta_receber WHERE data_vencimento LIKE '%"+ano+"%'";                        
                con = Conexao.getConexao();
                state = con.prepareStatement(sql);            
                resultado = state.executeQuery();            
                while ( resultado.next()  ) {               
                    anos.add( new AnoContaReceber(ano, Double.parseDouble(resultado.getString("valores"))) );                
                }                            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao retornar anos: "+e);
        }finally{
            Conexao.fecharConexao(con, state, resultado);            
        }
        return anos;
    }
    
    public static ArrayList<AnoContaReceber> retornaAnos( ArrayList<Integer> anosParam ){
        ArrayList<AnoContaReceber> anos = new ArrayList<>();
        Connection con = null;        
        try {     
            for (int i = 0; i < anosParam.size() ; i++) {                            
                String sql = "SELECT SUM(valor) AS valores FROM conta_receber WHERE data_vencimento LIKE '%"+anosParam.get(i)+"%'";                        
                con = Conexao.getConexao();
                state = con.prepareStatement(sql);            
                resultado = state.executeQuery();            
                while ( resultado.next()  ) {    
                    //System.out.println( anosParam[i] );
                    if( anosParam.get(i)!=null ){
                    anos.add( new AnoContaReceber(anosParam.get(i).toString(), Double.parseDouble(resultado.getString("valores"))) );                
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
    
    //-----------SELECT AVANÇADO
    public static ArrayList<ContaReceber>  pesquisaAvancada(String whereArguments) throws SQLException{
        ArrayList<ContaReceber> recebimentos = new ArrayList();
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT r.id, c.nome, r.data_vencimento ,r.valor, r.status, r.total_parcelas, r.modo_pagamento"
                + "  FROM conta_receber as r, cliente as c "
                + " WHERE  r.id_cliente = c.id ";
        
        if(whereArguments != null && whereArguments != " ")
            sql += " AND " + whereArguments;        
            
        sql += ";";        
        
        //JOptionPane.showMessageDialog(null,  sql);
        
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

