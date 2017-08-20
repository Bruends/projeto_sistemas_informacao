package janelas;
//importando classes
import classes.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    private  Usuario usuario;
    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal(){        
        initComponents();            
    } 
    
    public JanelaPrincipal(Usuario usuario){        
        initComponents();
        this.usuario = usuario;
        modoJanela(this.usuario.getNivel_acesso());
        //funções conta a receber
        ContaReceber cr = new ContaReceber(); 
        cr.dadosTabela(r_tabela);
    }
    
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // modo como a janela vai abrir dependendo do nivel de acesso
    //do usuario
    public void modoJanela(int nivel_acesso){
       switch(nivel_acesso){
           //nivel 1 de acesso (básico)
           case 1:
               //desabilitando tab adm
               tab_pane_principal.setEnabledAt(2,false);
               //desabilitando botões contas a receber
               r_btn_alterar.setEnabled(false);
               r_btn_registrar.setEnabled(false);
               r_btn_confirmar.setEnabled(false);
               //desabilitando botões contas a pagar
               p_btn_alterar.setEnabled(false);
               p_btn_registrar.setEnabled(false);
               p_btn_confirmar.setEnabled(false);
               break;
           //nivel 2 de accesso (operador)
           case 2:
               //desabilitando tab adm
               tab_pane_principal.setEnabledAt(2,false);
               break;
           //nivel 3 de acesso (adm)
           //todas as funções abilitadas
           default:
           
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_pane_principal = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        r_tabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        r_btn_alterar = new javax.swing.JButton();
        r_btn_calcular = new javax.swing.JButton();
        r_btn_registrar = new javax.swing.JButton();
        r_btn_pesquisa = new javax.swing.JButton();
        r_txt_pesquisa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        r_btn_confirmar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        p_table = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        p_btn_calcular = new javax.swing.JButton();
        p_btn_registrar = new javax.swing.JButton();
        p_btn_pesquisa = new javax.swing.JButton();
        p_txt_pesquisa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        p_btn_confirmar = new javax.swing.JButton();
        p_btn_alterar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        adm_btn_aprovar = new javax.swing.JButton();
        adm_btn_reprovar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        adm_table = new javax.swing.JTable();
        adm_btn_cadastrar_usuario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel4.setLayout(null);

        r_tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "código", "Cliente", "Data Vencimento", "Valor", "Parcelas", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(r_tabela);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(40, 110, 650, 390);

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contasReceber.png"))); // NOI18N
        jLabel7.setText("Contas a Receber");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(20, 40, 430, 80);

        r_btn_alterar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_btn_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contract.png"))); // NOI18N
        r_btn_alterar.setText("Alterar Recebimento");
        r_btn_alterar.setToolTipText("Para alterar registros selecione a linha correspondente e clique no botão alterar");
        r_btn_alterar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(r_btn_alterar);
        r_btn_alterar.setBounds(700, 210, 250, 90);

        r_btn_calcular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_btn_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/calculator.png"))); // NOI18N
        r_btn_calcular.setText("Calcular recebimentos");
        r_btn_calcular.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_calcularActionPerformed(evt);
            }
        });
        jPanel4.add(r_btn_calcular);
        r_btn_calcular.setBounds(700, 110, 250, 90);

        r_btn_registrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/add.png"))); // NOI18N
        r_btn_registrar.setText("Registrar Recebimento");
        r_btn_registrar.setActionCommand("");
        r_btn_registrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(r_btn_registrar);
        r_btn_registrar.setBounds(700, 310, 250, 90);

        r_btn_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/research.png"))); // NOI18N
        jPanel4.add(r_btn_pesquisa);
        r_btn_pesquisa.setBounds(660, 70, 30, 30);
        jPanel4.add(r_txt_pesquisa);
        r_txt_pesquisa.setBounds(480, 70, 180, 30);

        jLabel9.setText("Busca por cliente");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(480, 50, 110, 20);

        r_btn_confirmar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_btn_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/dollar-symbol.png"))); // NOI18N
        r_btn_confirmar.setText("Confirmar Recebimento");
        r_btn_confirmar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(r_btn_confirmar);
        r_btn_confirmar.setBounds(700, 410, 250, 90);

        tab_pane_principal.addTab("Contas a Receber", jPanel4);

        jPanel6.setLayout(null);

        p_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "código", "Titulo da divida", "Data Vencimento", "Valor", "Parcelas", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(p_table);

        jPanel6.add(jScrollPane5);
        jScrollPane5.setBounds(40, 110, 650, 390);

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contasPagar.png"))); // NOI18N
        jLabel13.setText("Contas a Pagar");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(20, 50, 440, 70);

        p_btn_calcular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        p_btn_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/calculator.png"))); // NOI18N
        p_btn_calcular.setText("Calcular Pagamentos");
        p_btn_calcular.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        p_btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_btn_calcularActionPerformed(evt);
            }
        });
        jPanel6.add(p_btn_calcular);
        p_btn_calcular.setBounds(700, 110, 250, 90);

        p_btn_registrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        p_btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/add.png"))); // NOI18N
        p_btn_registrar.setText("Registrar Conta a Pagar");
        p_btn_registrar.setActionCommand("");
        p_btn_registrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel6.add(p_btn_registrar);
        p_btn_registrar.setBounds(700, 310, 250, 90);

        p_btn_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/research.png"))); // NOI18N
        jPanel6.add(p_btn_pesquisa);
        p_btn_pesquisa.setBounds(660, 70, 30, 30);
        jPanel6.add(p_txt_pesquisa);
        p_txt_pesquisa.setBounds(480, 70, 180, 30);

        jLabel15.setText("Busca por cliente");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(480, 50, 110, 20);

        p_btn_confirmar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        p_btn_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/dollar-symbol.png"))); // NOI18N
        p_btn_confirmar.setText("Confirmar Pagamento");
        p_btn_confirmar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel6.add(p_btn_confirmar);
        p_btn_confirmar.setBounds(700, 410, 250, 90);

        p_btn_alterar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        p_btn_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contract.png"))); // NOI18N
        p_btn_alterar.setText("Alterar Pagamento");
        p_btn_alterar.setToolTipText("Para alterar registros selecione a linha correspondente e clique no botão alterar");
        p_btn_alterar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel6.add(p_btn_alterar);
        p_btn_alterar.setBounds(700, 210, 250, 90);

        tab_pane_principal.addTab("Contas a Pagar", jPanel6);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/businessman.png"))); // NOI18N
        jLabel1.setText("Área Administrativa");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 20, 250, 70);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitações de compra pendentes"));
        jPanel2.setLayout(null);

        adm_btn_aprovar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        adm_btn_aprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/correct-symbol.png"))); // NOI18N
        adm_btn_aprovar.setText("Aprovar");
        adm_btn_aprovar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(adm_btn_aprovar);
        adm_btn_aprovar.setBounds(20, 240, 150, 60);

        adm_btn_reprovar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        adm_btn_reprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/remove-symbol.png"))); // NOI18N
        adm_btn_reprovar.setText("Reprovar");
        adm_btn_reprovar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(adm_btn_reprovar);
        adm_btn_reprovar.setBounds(270, 240, 150, 60);

        adm_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(adm_table);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 30, 400, 190);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 120, 450, 330);

        adm_btn_cadastrar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/man.png"))); // NOI18N
        adm_btn_cadastrar_usuario.setText("Cadastrar Novo Usuário");
        jPanel1.add(adm_btn_cadastrar_usuario);
        adm_btn_cadastrar_usuario.setBounds(40, 470, 200, 60);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações Gerais"));
        jPanel3.setLayout(null);

        jLabel2.setText("TOTAL EM CAIXA: R$");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(240, 290, 210, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(500, 120, 450, 330);

        tab_pane_principal.addTab("Admin", jPanel1);

        getContentPane().add(tab_pane_principal);
        tab_pane_principal.setBounds(0, 0, 980, 630);

        setSize(new java.awt.Dimension(990, 626));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void r_btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_calcularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_btn_calcularActionPerformed

    private void p_btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_btn_calcularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_btn_calcularActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {              
              new JanelaPrincipal().setVisible(true);
              
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adm_btn_aprovar;
    private javax.swing.JButton adm_btn_cadastrar_usuario;
    private javax.swing.JButton adm_btn_reprovar;
    private javax.swing.JTable adm_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton p_btn_alterar;
    private javax.swing.JButton p_btn_calcular;
    private javax.swing.JButton p_btn_confirmar;
    private javax.swing.JButton p_btn_pesquisa;
    private javax.swing.JButton p_btn_registrar;
    private javax.swing.JTable p_table;
    private javax.swing.JTextField p_txt_pesquisa;
    private javax.swing.JButton r_btn_alterar;
    private javax.swing.JButton r_btn_calcular;
    private javax.swing.JButton r_btn_confirmar;
    private javax.swing.JButton r_btn_pesquisa;
    private javax.swing.JButton r_btn_registrar;
    private javax.swing.JTable r_tabela;
    private javax.swing.JTextField r_txt_pesquisa;
    private javax.swing.JTabbedPane tab_pane_principal;
    // End of variables declaration//GEN-END:variables
}
