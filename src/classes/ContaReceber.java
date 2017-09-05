package classes;

import classesDAO.ContaReceberDAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class ContaReceber {
    private int cod;
    private String cliente;
    private int cod_cliente;
    private Date data_vencimento;
    private double valor;
    private int parcela_atual;
    private int parcela_total;  
    //parcelas no formato que será mostrado na tabela
    private String parecelas; 
    private String status;  
      
    
    public void dadosTabela(JTable table){
        
        ArrayList<ContaReceber> recebimentos;
        
        ContaReceberDAO buscar_recebimentos = new ContaReceberDAO();       
        
        recebimentos = buscar_recebimentos.retornarTodosRecebimentos();
        
        if(recebimentos.size() > 0){
                    
            DefaultTableModel tbl = (DefaultTableModel) table.getModel();
            //ordem das colunas na tabela recebimentos:
            // cod, cliente, data_venc, valor, parcela, status
            for (int i = 0; i < recebimentos.size(); i++) {
                
                ContaReceber recebimento_atual = recebimentos.get(i);
                
                                
                //colocando os recebimentos na tabela
                Object[] dados = {
                    recebimento_atual.getCod(),
                    recebimento_atual.getCliente(),
                    recebimento_atual.getData_vencimento(),
                    recebimento_atual.getValor(),
                    recebimento_atual.getParcela_total(),
                    recebimento_atual.getStatus()
                };
                
                //adicionando linha na tabela
                tbl.addRow(dados);
            }
        } 
    }
    
    //getters e setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
}