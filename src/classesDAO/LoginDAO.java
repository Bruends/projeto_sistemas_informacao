package classesDAO;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginDAO {      
    private Usuario usuario;
    private String email;
    private String senha;
    
    
    
    public LoginDAO(String email, String senha){
        this.email   = email;
        this.senha = senha;
        
    }
    
    public static ArrayList<String> retornaEmailsUsuarios(){
        ArrayList<String> emails = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "SELECT email FROM usuario";
        try{
            con = Conexao.getConexao();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            
            while( rs.next() ){
                emails.add( rs.getString("email") );
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar emails: "+ex);
            JOptionPane.showMessageDialog(null, "Contacte o admnistrador do sistema.");
        }finally{            
            try {
                if( rs != null )rs.close();
                if( stmt != null )stmt.close();
                if( con != null )con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return emails;
    }
    
    //realiza login    
    public boolean logar(){
        Connection con = Conexao.getConexao();
        PreparedStatement state = null;
        
        //sql para busca
        String sql = "SELECT * FROM usuario"
                + " WHERE email = '" + this.email + "'  "
                + " AND senha = '" + this.senha + "';";
         
        //realizando busca
        try {
            state = con.prepareStatement(sql);
            
            ResultSet resultado = state.executeQuery();
            
            //caso o email e senha não batam 
            if(!resultado.next()){
                //fechando conexão
                Conexao.fecharConexao(con, state);
                return false;
             
             //caso o login seja efetuado com sucesso 
             //cria o objeto usuario
            } else {
                 int nivel_acesso = resultado.getInt("nivel_acesso");
                 String nome = resultado.getString("nome");
                 this.usuario = new Usuario(this.email, this.senha, nivel_acesso);
                 this.usuario.setNome(nome);                 
                 
                 //fechando conexão
                Conexao.fecharConexao(con, state);
                 
                 return true;       
                
            }
            
        } catch (SQLException ex) {
            //fechando conexão
            Conexao.fecharConexao(con, state);
                
            throw new RuntimeException("Erro ao Logar: " + ex);
            
        }
    }
    
    //retorna usuario
    public Usuario getUsuario(){
        return this.usuario;
    
    }
    
    
}
