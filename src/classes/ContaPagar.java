package classes;

import classesDAO.ContaPagarDAO;
import classesDAO.ContaReceberDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ContaPagar {
    private int cod; 
    private int cod_cliente;
    private String titulo;
    private String data_vencimento;
    private double valor;
    private int parcela_atual;
    private int parcela_total;  
    //parcelas no formato que será mostrado na tabela
    private String parecelas; 
    private String status;
    private String modo_pagamento;
    private String obs;

    public ContaPagar(String titulo, double valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public ContaPagar() {
    }
      
    
    
    
    //criando tabela com os dados necessários
    public void makeTable(JTable table, ArrayList<ContaPagar> pagamentos){
         DefaultTableModel tbl = (DefaultTableModel) table.getModel();
            tbl.setRowCount(0);
            //ordem das colunas na tabela recebimentos:
            // cod, cliente, data_venc, valor, parcela, status
            for (int i = 0; i < pagamentos.size(); i++) {
                
                ContaPagar pagamento = pagamentos.get(i);
                
                                
                //colocando os recebimentos na tabela
                Object[] dados = {
                    pagamento.getCod(),
                    pagamento.getTitulo(),
                    pagamento.getValor(),
                    pagamento.getData_vencimento(),
                    pagamento.getParcela_total(),                    
                    pagamento.getStatus(),
                };
                
                //adicionando linha na tabela
                tbl.addRow(dados);
            }
    }
    
    //faz tabela com todos os recebimentos
    public void todosPagamentosTabela(JTable table){
        
        ArrayList<ContaPagar> pagamentos;
        
        try {
            pagamentos = ContaPagarDAO.retornarTodosPagamentos();
             if(pagamentos.size() > 0){
            this.makeTable(table, pagamentos);           
        } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
       
    }
    
    public void pesquisarTabela(JTable table, String pesquisa){
        ArrayList<ContaPagar> pagamentos;
        
        pagamentos = ContaPagarDAO.pesquisarPagamentos(pesquisa);
        
        if(pagamentos.size() > 0){
           this.makeTable(table, pagamentos);          
        
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        } 
        
    }
    
    
    //getters e setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    
    

    public int getCod_cliente() {
        return cod_cliente;
    }

   
    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void addValor(double valor) {                
        this.valor += valor;        
    }

    public int getParcela_atual() {
        return parcela_atual;
    }

    public void setParcela_atual(int parcela_atual) {
        this.parcela_atual = parcela_atual;
    }

    public int getParcela_total() {
        return parcela_total;
    }

    public void setParcela_total(int parcela_total) {
        this.parcela_total = parcela_total;
    }

    public String getParecelas() {
        return parecelas;
    }

    public void setParecelas(String parecelas) {
        this.parecelas = parecelas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModo_pagamento() {
        return modo_pagamento;
    }

    public void setModo_pagamento(String modo_pagamento) {
        this.modo_pagamento = modo_pagamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}