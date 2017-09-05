/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;

import java.util.ArrayList;
import classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class ClienteDAO {
    static Connection con = null;
    static PreparedStatement state = null;
    static ResultSet resultado = null;
        
    
    
    //retorna todos os clientes
    public static ArrayList<Cliente> retornarTodosClientes(){
        
        con = Conexao.getConexao();
        ArrayList<Cliente> clientesArray = new ArrayList();
        
        String sql = "SELECT * FROM cliente";
        
        try {
            state = con.prepareStatement(sql);
            resultado = state.executeQuery();
            
            while(resultado.next()){
                // cod, cliente, data_venc, valor, parcela, status
                Cliente cliente = new Cliente();
                cliente.setCod(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));                
                cliente.setEmail(resultado.getString("email"));
                cliente.setCnpj(resultado.getString("cnpj"));
                cliente.setCnpj(resultado.getString("endereco"));                
                
                clientesArray.add(cliente);
                
            }
            
            Conexao.fecharConexao(con, state, resultado);
            
            return clientesArray;
            
        } catch (SQLException ex) {
            Conexao.fecharConexao(con, state, resultado);
            throw new RuntimeException("Erro: " + ex);
            
        }        
    }
    
    public boolean inserirCliente(Cliente cliente) throws SQLException {
           con = Conexao.getConexao();
           String sql = "INSERT INTO cliente values(default, ?, ?, ?, ?);"; 
           state = con.prepareStatement(sql);
           
           state.setString(0,  cliente.getNome());
           state.setString(1,  cliente.getEmail());
           state.setString(2,  cliente.getCnpj());
           state.setString(3,  cliente.getEndereco());
                      
           state.execute();
           Conexao.fecharConexao(con, state);
           
           return true;
    }
}
