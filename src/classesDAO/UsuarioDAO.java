package classesDAO;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    static Connection con = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    
    
    public static boolean inserirUsuario(Usuario usuario) {
           con = Conexao.getConexao();
           
           String sql = "INSERT INTO usuario (email,senha,nivel_acesso,nome,cpf,ano_nascimento,cargo,departamento,salario,telefone,endereco,email_contato) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; 
           try{
           preparedStatement = con.prepareStatement(sql);
           
           preparedStatement.setString(1,  usuario.getEmail());
           preparedStatement.setString(2,  usuario.getSenha());
           preparedStatement.setInt(3,  usuario.getNivel_acesso());
           preparedStatement.setString(4,  usuario.getNome());
           preparedStatement.setString(5,  usuario.getCpf());
           preparedStatement.setInt(6,  usuario.getAno_nascimento());
           preparedStatement.setString(7,  usuario.getCargo());
           preparedStatement.setString(8,  usuario.getDepartamento());
           preparedStatement.setFloat(9,  usuario.getSalario());
           preparedStatement.setString(10,  usuario.getTelefone());
           preparedStatement.setString(11,  usuario.getEndereco());
           preparedStatement.setString(12,  usuario.getEmail_Acesso());
                      
           preparedStatement.execute();
                      
           return true;
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: "+ex);
               return false;
           }finally{
               Conexao.fecharConexao(con, preparedStatement);
           }
    }
    
    //retorna todos os usuarios
    public static ArrayList<Usuario> retornarTodosUsuarios(){        
        con = Conexao.getConexao();
        ArrayList<Usuario> usuariosArray = new ArrayList();
        
        String sql = "SELECT id,email,nivel_acesso,nome,cpf,ano_nascimento,cargo,departamento,salario,telefone,endereco FROM usuario";
        
        try {
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){                
                Usuario usuario = new Usuario();
                usuario.setEmail(resultSet.getString("email"));
                usuario.setNivel_acesso(resultSet.getInt("nivel_acesso"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setAno_nascimento(resultSet.getInt("ano_nascimento"));
                usuario.setCargo(resultSet.getString("cargo"));
                usuario.setDepartamento(resultSet.getString("departamento"));
                usuario.setSalario(resultSet.getFloat("salario"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setEndereco(resultSet.getString("endereco"));
                usuario.setCod(resultSet.getInt("id"));
                
                                 
                
                usuariosArray.add(usuario);                
            }
            
            Conexao.fecharConexao(con, preparedStatement, resultSet);
            
            return usuariosArray;
            
        } catch (SQLException ex) {
            Conexao.fecharConexao(con, preparedStatement, resultSet);
            throw new RuntimeException("Erro: " + ex);            
        }        
    }
    
    public static boolean update(Usuario usuario) {        
        con = Conexao.getConexao();
        PreparedStatement pstmt = null;
        String sql = "UPDATE usuario SET  email_contato = ?,nivel_acesso = ?,nome = ?, cpf = ?, ano_nascimento = ?, cargo = ?, departamento = ?, salario = ?, telefone = ?, endereco = ? WHERE id = ?";                       
        try {            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usuario.getEmail());            
            pstmt.setInt(2, usuario.getNivel_acesso());
            pstmt.setString(3, usuario.getNome());
            pstmt.setString(4, usuario.getCpf());
            pstmt.setInt(5, usuario.getAno_nascimento());                                  
            pstmt.setString(6, usuario.getCargo());                                  
            pstmt.setString(7, usuario.getDepartamento());                                  
            pstmt.setFloat(8, usuario.getSalario());                                  
            pstmt.setString(9, usuario.getTelefone());                                  
            pstmt.setString(10,usuario.getEndereco());                                  
            pstmt.setInt(11, usuario.getCod());  
           
            pstmt.executeUpdate();              
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar usuario! ERRO: " + ex);
            return false;
        }finally{
            Conexao.fecharConexao(con, preparedStatement);
        }
        
        
    }
    
    public static boolean delete(ArrayList<Usuario> usuarios){
        String codigos = "";
        for (int i = 0; i < usuarios.size(); i++) {            
            if ((usuarios.size()-1) == i) {                                                            
                codigos += usuarios.get(i).getCod();
            }else{                
                codigos += " "+usuarios.get(i).getCod() + " OR id = ";
            }
        }
        con = Conexao.getConexao();
        
        String sql = "DELETE FROM usuario WHERE id = "+codigos;
        try{
            preparedStatement = con.prepareStatement(sql);            
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir! " + ex);            
            //1451 = MySQLConstraintIntegrity.                        
            if ( ex.getErrorCode() == 1451 ) {
                JOptionPane.showMessageDialog(null, "Só é possível apagar clientes que não possuem pendências financeiras!");
            }
            return false;
        }finally{
            Conexao.fecharConexao(con,preparedStatement);
        }
    }
    
    public static ArrayList<Usuario> selectUsuarios(String campo, String valor){        
        con = Conexao.getConexao();
        String sql = "";                               
        ArrayList<Usuario> usuarios = new ArrayList<>();                                   
        try{                
            if ( "todos".equals(campo) ) {
                 sql = "SELECT * FROM usuario WHERE  nome LIKE '%"+valor+"%' OR email LIKE '%"+valor+"%' OR cpf LIKE '%"+valor+"%' OR endereco LIKE '%"+valor+"%' OR telefone LIKE '%"+valor+"%' OR cargo LIKE '%"+valor+"%' OR departamento LIKE '%"+valor+"%'" ;                 
            }else{
                sql = "SELECT * FROM usuario WHERE " + campo + " LIKE '%"+valor+"%'";                                        
            }            
            preparedStatement = con.prepareStatement(sql);                        
            resultSet = preparedStatement.executeQuery();
                            
            while( resultSet.next() ){                
                Usuario usuario = new Usuario();
                usuario.setCod(resultSet.getInt("id"));
                usuario.setEmail(resultSet.getString("email"));                
                usuario.setNivel_acesso(resultSet.getInt("nivel_acesso"));
                usuario.setNome(resultSet.getString("nome")); 
                usuario.setCpf(resultSet.getString("cpf")); 
                usuario.setAno_nascimento(resultSet.getInt("ano_nascimento")); 
                usuario.setCargo(resultSet.getString("cargo")); 
                usuario.setDepartamento(resultSet.getString("departamento")); 
                usuario.setSalario(resultSet.getFloat("salario")); 
                usuario.setTelefone(resultSet.getString("telefone")); 
                usuario.setEndereco(resultSet.getString("endereco")); 
                        
                usuarios.add(usuario);                                
            } 
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar usuarios!" + ex);
            return null;
        }finally{
            Conexao.fecharConexao(con,preparedStatement,resultSet);
        }
        return usuarios;
    }
}
