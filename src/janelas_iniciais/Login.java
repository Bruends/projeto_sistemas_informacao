package janelas_iniciais;

import classesDAO.LoginDAO;
import classes.*;


import janela_gerenciar_contas.JanelaPrincipal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
       initComponents();    
       
       //Carrega combo emails
        DefaultComboBoxModel cmbEmailModel = (DefaultComboBoxModel)l_txt_email.getModel() ;        
        ArrayList<String> emails = new ArrayList<>();
        emails = LoginDAO.retornaEmailsUsuarios();
        for (int i = 0; i < emails.size(); i++) {
            cmbEmailModel.addElement( emails.get(i) );
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        l_txt_senha = new javax.swing.JPasswordField();
        l_txt_email = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Senha:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 260, 50, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("E-Mail:  ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 210, 50, 30);

        btn_login.setFont(new java.awt.Font("Microsoft JhengHei", 0, 11)); // NOI18N
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/login-sketch32px.png"))); // NOI18N
        btn_login.setText("Login");
        btn_login.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login);
        btn_login.setBounds(610, 300, 100, 40);
        getContentPane().add(l_txt_senha);
        l_txt_senha.setBounds(470, 260, 240, 30);

        getContentPane().add(l_txt_email);
        l_txt_email.setBounds(470, 210, 240, 30);

        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 52, 84));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/graphLogin64px.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 20, 70, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/universidade_cruzeiro-do-sul-ins-log-g.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 340, 270, 120);

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(17, 52, 84));
        jLabel5.setText("SETOR FINANEIRO");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 30, 220, 40);

        jSeparator1.setBackground(new java.awt.Color(17, 52, 84));
        jSeparator1.setForeground(new java.awt.Color(17, 52, 84));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(110, 70, 190, 10);

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel6.setText("LOGIN");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(180, 80, 50, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(17, 52, 84));
        jLabel7.setText("Grupo 1");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(290, 410, 50, 14);

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 0, 10)); // NOI18N
        jLabel10.setText("CONTAS A PAGAR E A RECEBER");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(120, 110, 160, 16);

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/circular-shape-silhouette16px.png"))); // NOI18N
        jLabel11.setText("LUCAS SOUSA ALVES - 16203453");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(40, 220, 200, 20);

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/circular-shape-silhouette16px.png"))); // NOI18N
        jLabel13.setText("FELIPE ALGUMA COISA - ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(40, 240, 170, 20);

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/circular-shape-silhouette16px.png"))); // NOI18N
        jLabel14.setText("BRUNO MENDES - ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(40, 200, 170, 20);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ABSTRACT-Aquarius_1600x1200.png"))); // NOI18N
        jPanel1.add(lblBackground);
        lblBackground.setBounds(-610, 5, 1600, 1200);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/circular-shape-silhouette16px.png"))); // NOI18N
        jLabel12.setText("BRUNO MENDES - ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 160, 170, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 450);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clerk-with-tie128pxBlack.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 60, 120, 140);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/circular-shape-silhouette256px.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(460, 50, 260, 150);

        setSize(new java.awt.Dimension(813, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // Botão Login
        String email  = l_txt_email.getItemAt( l_txt_email.getSelectedIndex() );
        String senha = l_txt_senha.getText();
        
        //evento login
        try{
             LoginDAO login = new LoginDAO(email, senha);
             //se confirmar o login
             if(login.logar()){
               
                Usuario usuario =  login.getUsuario();
               
                
                
                //abrindo janela menu e passando o usuário
                MenuPrincipal menu = new MenuPrincipal(usuario);
                menu.setVisible(true);
                //mostrando mensagem de boas vindas
                JOptionPane.showMessageDialog(null,"Bem vindo(a) " +  usuario.getNome() + " !");
                //fechando janela de login
                this.dispose();
             
             } else {
                 JOptionPane.showMessageDialog(null, "Email ou senha invalido");
                 
             }
             
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
       
    }//GEN-LAST:event_btn_loginActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> l_txt_email;
    private javax.swing.JPasswordField l_txt_senha;
    private javax.swing.JLabel lblBackground;
    // End of variables declaration//GEN-END:variables
}
