/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;

import java.util.ArrayList;
import classes.Cliente;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class ClienteDAO {
    static Connection con = null;
    static PreparedStatement state = null;
    static ResultSet resultado = null;
    
    public static ArrayList<Cliente> selectClientes(String campo, String valor){        
        con = Conexao.getConexao();
        String sql = "";                               
        ArrayList<Cliente> clientes = new ArrayList<>();       
                          
        try{                
            if ( "todos".equals(campo) ) {
                 sql = "SELECT * FROM CLIENTE WHERE id = "+valor+" nome LIKE '%"+valor+"%' OR email LIKE '%"+valor+"%' OR cnpj LIKE '%"+valor+"%' OR endereco LIKE '%"+valor+"%' OR telefone LIKE '%"+valor+"%' OR cep LIKE '%"+valor+"%'" ;                                  
            }else{
                 sql = "SELECT * FROM cliente WHERE " + campo +  "LIKE '%"+valor+"%'";                                                        
            }
            state = con.prepareStatement(sql);                        
            resultado = state.executeQuery();                               
            while( resultado.next() ){                
            Cliente cliente = new Cliente();
            cliente.setCod(resultado.getInt("id"));
            cliente.setNome(resultado.getString("nome"));                
            cliente.setEmail(resultado.getString("email"));
            cliente.setCnpj(resultado.getString("cnpj"));
            cliente.setEndereco(resultado.getString("endereco"));   
            cliente.setTelefone(resultado.getString("telefone"));                   
            cliente.setCep(resultado.getString("cep")); 
                        
            clientes.add(cliente);      
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar!" + ex);
            return null;
        }finally{
            Conexao.fecharConexao(con,state,resultado);
        }
        return clientes;
    
    }
    
            
    public static boolean delete(ArrayList<Cliente> clientes){
        String codigos = "";
        for (int i = 0; i < clientes.size(); i++) {            
            if ((clientes.size()-1) == i) {                                                            
                codigos += clientes.get(i).getCod();
            }else{                
                codigos += " "+clientes.get(i).getCod() + " OR id = ";
            }
        }
        con = Conexao.getConexao();
        
        String sql = "DELETE FROM cliente WHERE id = "+codigos;
        try{
            state = con.prepareStatement(sql);            
            state.executeUpdate();
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir! " + ex);            
            //1451 = MySQLConstraintIntegrity.                        
            if ( ex.getErrorCode() == 1451 ) {
                JOptionPane.showMessageDialog(null, "Só é possível apagar clientes que não possuem pendências financeiras!");
            }
            return false;
        }finally{
            Conexao.fecharConexao(con,state);
        }
    }
        
    public static boolean update(Cliente cliente){
        con = Conexao.getConexao();
        String sql = "UPDATE cliente SET  nome = ?, email = ?, cnpj = ?, endereco = ?, telefone = ?, cep = ? WHERE id = ?";                       
        try {
            state = con.prepareStatement(sql);
            state.setString(1, cliente.getNome());
            state.setString(2, cliente.getEmail());
            state.setString(3, cliente.getCnpj());
            state.setString(4, cliente.getEndereco());
            state.setString(5, cliente.getTelefone());
            state.setString(6, cliente.getCep());
            state.setInt(7, cliente.getCod());            
            state.executeUpdate();  
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            Conexao.fecharConexao(con, state);
        }
        
        
    }
    
    
    //retorna todos os clientes
    public static ArrayList<Cliente> retornarTodosClientes(){        
        con = Conexao.getConexao();
        ArrayList<Cliente> clientesArray = new ArrayList();
        
        String sql = "SELECT id,nome,email,cnpj,endereco,telefone,cep FROM cliente";
        
        try {
            state = con.prepareStatement(sql);
            resultado = state.executeQuery();
            
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setCod(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));       
                cliente.setEmail(resultado.getString("email"));
                cliente.setCnpj(resultado.getString("cnpj"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setTelefone(resultado.getString("telefone"));           
                cliente.setCep(resultado.getString("cep"));
                
                clientesArray.add(cliente);
            }
            
            Conexao.fecharConexao(con, state, resultado);
            
            return clientesArray;
            
        } catch (SQLException ex) {
            Conexao.fecharConexao(con, state, resultado);
           JOptionPane.showMessageDialog(null, "Erro: " + ex);
           return null;
        }        
    }
    
    public static boolean inserirCliente(Cliente cliente) {
           con = Conexao.getConexao();
           
           String sql = "INSERT INTO cliente (nome,email,cnpj,endereco,telefone,cep) VALUES (?,?,?,?,?,?)"; 
           try{
           state = con.prepareStatement(sql);
           
           state.setString(1,  cliente.getNome());
           state.setString(2,  cliente.getEmail());
           state.setString(3,  cliente.getCnpj());
           state.setString(4,  cliente.getEndereco());
           state.setString(5,  cliente.getTelefone());
           state.setString(6,  cliente.getCep());
                      
           state.execute();
                      
           return true;
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: "+ex);
               return false;
           }finally{
               Conexao.fecharConexao(con, state);
           }
    }
}
