/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela_estatisticas;

import classes.AnoContaPagar;
import classes.AnoContaReceber;
import classes.MesContaPagar;
import classes.MesContaReceber;
import classes.PercentualCrescimentoAno;
import classes.PercentualCrescimentoMes;
import classes.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lusca
 */
public class ExportarExcelContaReceber extends javax.swing.JFrame {
    private String mes;
    private double valor;
    private ArrayList<MesContaReceber> mesesContaReceber = new ArrayList<>();
    private ArrayList<AnoContaReceber> anosContaReceber = new ArrayList<>();
    private ArrayList<PercentualCrescimentoMes> crescimentoMeses = new ArrayList<>();
    ArrayList<PercentualCrescimentoAno> crescimentoAnos = new ArrayList<>();
    private Usuario usuario;
    /**
     * Creates new form ExportarExcel
     * @param anosContaReceber
     */
    
    public ExportarExcelContaReceber(ArrayList<MesContaReceber> mesesContaReceber,ArrayList<AnoContaReceber> anosContaReceber,ArrayList<PercentualCrescimentoMes> cresMes, ArrayList<PercentualCrescimentoAno> cresAno){        
        initComponents();        
        if(mesesContaReceber!=null){            
            this.mesesContaReceber = mesesContaReceber;                        
            DefaultTableModel tblModel = (DefaultTableModel)this.tblExcel.getModel();
            tblModel.setRowCount(0);
            Object colunas[] = {"Mês","Valor"};
            tblModel.setColumnIdentifiers( colunas );
            if( mesesContaReceber != null ){
                for (int i = 0; i < mesesContaReceber.size(); i++) {
                    Object dados[] = {
                        mesesContaReceber.get(i).getNome(),
                        mesesContaReceber.get(i).getContaReceber().getValor()
                    };
                    tblModel.addRow(dados);
                }
            }            
        }else if( cresMes != null ){
            this.crescimentoMeses = cresMes;                    
            DefaultTableModel tblModel = (DefaultTableModel)this.tblExcel.getModel();
            tblModel.setRowCount(0);
            Object colunas[] = {"Intervalo","Crescimento ( % )"};
            tblModel.setColumnIdentifiers( colunas );
            if( cresMes != null ){
                for (int i = 0; i < cresMes.size(); i++) {
                    Object dados[] = {
                        cresMes.get(i).getIntervaloMeses(),
                        cresMes.get(i).getCrescimentoPorcentagem()
                    };
                    tblModel.addRow(dados);
                }
            } 
        }else if( cresAno != null ){            
            this.crescimentoAnos = cresAno;                
            DefaultTableModel tblModel = (DefaultTableModel)this.tblExcel.getModel();
            tblModel.setRowCount(0);
            Object colunas[] = {"Intervalo","Crescimento ( % )"};
            tblModel.setColumnIdentifiers( colunas );
            if( anosContaReceber != null ){
                for (int i = 0; i < cresAno.size(); i++) {
                    Object dados[] = {
                        cresAno.get(i).getIntervaloDeAnos(),
                        cresAno.get(i).getPorcentagemDeCrescimento()
                    };
                    tblModel.addRow(dados);
                }
            }
        }
        if( anosContaReceber != null && cresAno == null && cresMes == null && mesesContaReceber == null ){            
            this.anosContaReceber = anosContaReceber;                
            DefaultTableModel tblModel = (DefaultTableModel)this.tblExcel.getModel();
            tblModel.setRowCount(0);
            Object colunas[] = {"Ano","Valor"};
            tblModel.setColumnIdentifiers( colunas );
            if( anosContaReceber != null ){
                for (int i = 0; i < anosContaReceber.size(); i++) {
                    Object dados[] = {
                        anosContaReceber.get(i).getAno(),
                        anosContaReceber.get(i).getSomaValores()
                    };
                    tblModel.addRow(dados);
                }
            }
        }
    }
    
    public ExportarExcelContaReceber(ArrayList<MesContaPagar> mesesContaPagar){
        initComponents();
        
    }
    
    public ExportarExcelContaReceber() {
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExcel = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("EXPORTAR PARA EXCEL");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/excel64px.png"))); // NOI18N

        tblExcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mês", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblExcel);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/addNewFile32px.png"))); // NOI18N
        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Pré-visualização");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(376, 580));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Btn gerar excel
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));        
        String absolutePath="";
        
        if( fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION ) {
            absolutePath = fileChooser.getCurrentDirectory().getAbsolutePath()+"\\"+fileChooser.getSelectedFile().getName()+".xls";
        }
            
            File file = new File(absolutePath);
            FileWriter out=null;
            try {
                TableModel model = this.tblExcel.getModel();
                out = new FileWriter(file);
                for(int i=0; i < model.getColumnCount(); i++) {
                    out.write(model.getColumnName(i) + "\t");
                }
                out.write("\n");

                for(int i=0; i< model.getRowCount(); i++) {
                    for(int j=0; j < model.getColumnCount(); j++) {
                        out.write(model.getValueAt(i,j).toString()+"\t");
                    }
                    out.write("\n");
            }
                JOptionPane.showMessageDialog(null, "Documento gerado com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao gerar documento!");
                Logger.getLogger(ExportarExcelContaReceber.class.getName()).log(Level.SEVERE, null, ex);
            }


            try {
                out.close();
            } catch (IOException ex) {                
                Logger.getLogger(ExportarExcelContaReceber.class.getName()).log(Level.SEVERE, null, ex);
            }             
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExportarExcelContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportarExcelContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportarExcelContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportarExcelContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportarExcelContaReceber().setVisible(true);
            }
        });
    }

                
    //Getters e Setters
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<MesContaReceber> getMesesContaReceber() {
        return mesesContaReceber;
    }

    public void setMesesContaReceber(ArrayList<MesContaReceber> mesesContaPagar) {
        this.mesesContaReceber = mesesContaPagar;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblExcel;
    // End of variables declaration//GEN-END:variables
}
