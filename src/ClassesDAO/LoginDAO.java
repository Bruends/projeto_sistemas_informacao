package ClassesDAO;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {      
    private Usuario usuario;
    private String email;
    private String senha;
    
    
    
    public LoginDAO(String email, String senha){
        this.email   = email;
        this.senha = senha;
        
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
                return false;
             
             //caso o login seja efetuado com sucesso 
             //cria o objeto usuario
            } else {
                 int nivel_acesso = resultado.getInt("nivel_acesso");
                 String nome = resultado.getString("nome");
                 this.usuario = new Usuario(this.email, this.senha, nivel_acesso);
                 this.usuario.setNome(nome);                 
                 return true;
                
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Logar: " + ex);
            
        }
    }
    
    //retorna usuario
    public Usuario getUsuario(){
        return this.usuario;
    
    }
    
    
}
