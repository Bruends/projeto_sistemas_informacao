package classesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {
    //Constantes de conexão
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String BANCO = "projeto_si";
    private static final String DRIVER = "com.mysql.jdbc.Driver";    
    private static final String URL = "jdbc:mysql://localhost:3306/" + BANCO  + "?useUnicode=true&amp;amp;characterEncoding =UTF-8";
    
    //criando conexão
    public static Connection getConexao(){
         try {             
            Class.forName(DRIVER);
             return DriverManager.getConnection(URL, USUARIO, SENHA);
             
        } catch (ClassNotFoundException | SQLException ex) {
             throw new RuntimeException("Erro: " + ex);        
        }
         
    }
    
    //fechando conexão
    public static void fecharConexao(Connection con){
        if(con != null){
            try {
                con.close();
                
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão: " + ex);
                
            }
        }
    }
    
    //fechando conexão + statement
    public static void fecharConexao(Connection con, Statement state){
        if(con != null){
            try {
               con.close();                
               if(state != null){
                  state.close();
               }                 
                
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão: " + ex);                
            }
        }
    }
    
     //fechando conexão + statement + resultset
    public static void fecharConexao(Connection con, Statement state, ResultSet resultado){
        if(con != null){
            try {
               con.close();                
               if(state != null){
                  state.close();
               }
               
               if(resultado != null){
                   resultado.close();
               }
                
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão: " + ex);
            }
        }
    }
    
}