/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela_estatisticas;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.FontConstants;

/**
 *
 * @author Lusca
 */
public class JanelaExportarPdf extends javax.swing.JFrame {
    ArrayList<File> imagens = new ArrayList<>();
    ArrayList<JButton> botoes = new ArrayList<>();
    /**
     * Creates new form JanelaExportarPdf
     */
    public JanelaExportarPdf() {
        initComponents();
        pnlImagens.setLayout(new BoxLayout(pnlImagens,BoxLayout.Y_AXIS) );
        
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaRelato = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaConclusao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblEndereco = new javax.swing.JLabel();
        btnSelecionarImgs = new javax.swing.JButton();
        pnlImagens = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("RELATÓRIO PDF");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Redigir"));

        txtAreaRelato.setColumns(20);
        txtAreaRelato.setRows(5);
        jScrollPane1.setViewportView(txtAreaRelato);

        jLabel2.setText("Relato:");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("(opcional)");

        jLabel4.setText("Impressões gerais:");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("(opcional)");

        txtAreaConclusao.setColumns(20);
        txtAreaConclusao.setRows(5);
        jScrollPane2.setViewportView(txtAreaConclusao);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Anexar gráficos"));

        lblEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblEndereco.setEnabled(false);

        btnSelecionarImgs.setText("Selecionar imagens");
        btnSelecionarImgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImgsActionPerformed(evt);
            }
        });

        pnlImagens.setPreferredSize(new java.awt.Dimension(0, 100));

        javax.swing.GroupLayout pnlImagensLayout = new javax.swing.GroupLayout(pnlImagens);
        pnlImagens.setLayout(pnlImagensLayout);
        pnlImagensLayout.setHorizontalGroup(
            pnlImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        pnlImagensLayout.setVerticalGroup(
            pnlImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/question16px.png"))); // NOI18N
        jLabel6.setToolTipText("Você pode gerar os gráficos na janela anterior");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecionarImgs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(pnlImagens, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecionarImgs)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(pnlImagens, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setForeground(new java.awt.Color(51, 102, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/pdf-file34px.png"))); // NOI18N
        jButton1.setText("Exportar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Título:");

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("(obrigatório)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/pdf-file-type-symbol64px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(861, 699));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarImgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImgsActionPerformed
        // btn selecionar imgs
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); 
        
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de imagem PNG","png"));
        String absolutePath="";
        String fileName="";
        JButton btnNovaImagem=null;
        
        if( fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) {
            absolutePath = fileChooser.getCurrentDirectory().getAbsolutePath()+"\\"+fileChooser.getSelectedFile().getName();
            fileName = fileChooser.getSelectedFile().getName();
            
            lblEndereco.setText(absolutePath);
            imagens.add( new File(absolutePath) );
            btnNovaImagem = new JButton(fileName);             
            try {
               Image img = ImageIO.read(getClass().getResource("/imgs/delete16px.png"));
               btnNovaImagem.setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                Logger.getLogger(JanelaExportarPdf.class.getName()).log(Level.SEVERE, null, ex);
            }            
            btnNovaImagem.setToolTipText("Remover imagem");
            btnNovaImagem.setHorizontalTextPosition(SwingConstants.LEFT);
            btnNovaImagem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    for (int i = botoes.size()-1; i >= 0; i--) {
                        if( ae.getActionCommand().equals(botoes.get(i).getText()) ){                            
                            //botoes.remove(i);                                                                                                                     
                            pnlImagens.remove(botoes.get(i));
                            pnlImagens.revalidate();
                            pnlImagens.repaint();
                        }
                        }
                    
                /*
                    for (int i = 0; i < botoes.size(); i++) {
                        if( ae.getActionCommand().equals(botoes.get(i).getText()) ){                            
                            //botoes.remove(i);                                                                                                                     
                            pnlImagens.remove(botoes.get(i));
                            pnlImagens.revalidate();
                            pnlImagens.repaint();
                        }
                    }
                    */
                }
            });            
            if ( botoes.size() < 5 ) {
                botoes.add(btnNovaImagem);                 
            }else{
                JOptionPane.showMessageDialog(null, "Não é possível adicionar mais do que 5 gráficos!");
            }
                       
        }else{
            pnlImagens.revalidate();
            pnlImagens.repaint();                                         
        }
                                                                
         for (int i = 0; i < botoes.size(); i++) {           
                pnlImagens.add(botoes.get(i));
                pnlImagens.revalidate();
                pnlImagens.repaint();                                         
        }
        
           
    }//GEN-LAST:event_btnSelecionarImgsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // btn gerar PDF
        Document document = new Document();
        JFileChooser fileChooser = new JFileChooser();
        String absolutePath="";
        if ( fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION ) {
            if ( fileChooser.getSelectedFile().getName().split(".")[fileChooser.getSelectedFile().getName().split(".").length].equals("pdf") ) {
                absolutePath = fileChooser.getCurrentDirectory().getAbsolutePath()+"\\"+fileChooser.getSelectedFile().getName();
            }else{
                absolutePath = fileChooser.getCurrentDirectory().getAbsolutePath()+"\\"+fileChooser.getSelectedFile().getName()+".pdf";
            }
            
            try {
                PdfWriter.getInstance(document, new FileOutputStream(absolutePath));
                document.open();
                
                if (!txtTitulo.getText().equals("")) {
                    Paragraph paragrafoTitulo = new Paragraph("Título: \n\n");
                    document.add(paragrafoTitulo);
                    document.add(new Paragraph(txtTitulo.getText()+"\n\n"));
                }else{
                    JOptionPane.showMessageDialog(null, "O campo título é obrigatório.");
                }
                
                if(!txtAreaRelato.getText().equals("")){                    
                    Paragraph paragrafoHeader = new Paragraph("Relato: \n\n");                    
                    document.add(paragrafoHeader);
                    document.add(new Paragraph(txtAreaRelato.getText()+"\n\n"));                      
                }
                if(!txtAreaConclusao.getText().equals("")){                    
                    Paragraph paragrafoHeader = new Paragraph("Considerações finais: \n\n"); 
                    document.add(paragrafoHeader);
                    document.add(new Paragraph(txtAreaConclusao.getText()+"\n\n"));                                        
                }                
                
                //É preciso adicionar pelo menos um paragrafo p criar um pagina
                if(txtAreaConclusao.getText().equals("") && txtAreaRelato.getText().equals("")){                    
                    document.add(new Paragraph(""));                                
                }
                document.newPage();
               //adiciona as imagens escolhidas pelo usuario no documento
                for (int i = 0; i < imagens.size(); i++) {
                    try {
                        com.lowagie.text.Image image = com.lowagie.text.Image.getInstance(imagens.get(i).getPath());                                                
                        document.add(image);
                        document.newPage();
                    } catch (BadElementException ex) {
                        Logger.getLogger(JanelaExportarPdf.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaExportarPdf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
               }
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro de Geração de relatorio: "+ ex.getMessage());
                Logger.getLogger(JanelaExportarPdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(null, "Erro de Geração de relatorio: "+ ex.getMessage());
                Logger.getLogger(JanelaExportarPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.close();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(JanelaExportarPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaExportarPdf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionarImgs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JPanel pnlImagens;
    private javax.swing.JTextArea txtAreaConclusao;
    private javax.swing.JTextArea txtAreaRelato;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
