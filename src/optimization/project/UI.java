/*
 * UI.java
 *
 * Created on 10 июл. 2019 г., 1:05:18
 *
 * Copyright(c) AkioSarkiz Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AkioSarkiz Company.
 *
 */
package optimization.project;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main UI class
 * @author Akio Sarkiz
 */
public class UI extends javax.swing.JFrame {
    
    public final String PATH_CFG_APP = System.getProperty("user.home") + "\\opmization_project.cfg";
    private String def_path_result;
    private String def_path_source;
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/icon.png")));
    }
    
    private void setTheme(){
        try {
            // get system theme
            String systemLookAndFeelClassName = javax.swing.UIManager.getSystemLookAndFeelClassName();
            // set here
            javax.swing.UIManager.setLookAndFeel(systemLookAndFeelClassName);
        } catch (javax.swing.UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.err.println(e);
        }
    }
    
    /**
     * set bar value
     * @param set 
     */
    private void setProgressBar(int set){
        this.jProgressBar.setValue(set);
    }
    
    /**
     * test have a fooder or not
     * @param path
     * @return boolean
     */
    private boolean test_dir(String path){
        File file = new File(path);
        return file.isDirectory();
    }
    
    /**
     * Test user input and start optimization
     * @throws IOException 
     */
    private void start_optimization_project() throws IOException{
        
        
        this.setProgressBar(0);
        if (test_dir(this.jt_pth_source.getText()) && test_dir(this.jt_pth_result.getText())) {
            ScanFolder scan_folder = new ScanFolder();
            scan_folder.setCnsl(this.jl_cnsl); 
            scan_folder.setPathSource(this.jt_pth_source.getText());
            scan_folder.setPathResult(this.jt_pth_result.getText());
            scan_folder.setProgressbar(this.jProgressBar);
            scan_folder.setMaxFiles(this.js_max_files.getValue());
            scan_folder.run();
        }else{
            this.cnslPrint("Error! Don't have path: " + this.jt_pth_source.getText() + " or " + this.jt_pth_result.getText(), Color.red);
        }

        this.finish();
    }
    
    private void cnslPrint(String s, Color color){
        this.jl_cnsl.setText(s);
        this.jl_cnsl.setForeground(color);
    }
    
    private void finish(){
        this.jb_start.setEnabled(true);
        this.jb_start.setText("start");
        this.jl_status_app.setText("Completed");
        this.jl_status_app.setForeground(Color.green);
    }
    
    /**
     * Main method app. He first start the run app
     * @param args the command line arguments
     */
    public void run(String args[]) {
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    
    /**
     * Creates new form UI
     */
    public UI() {
        this.setTheme();
        initComponents();
        this.setIcon();
    }  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jl_status_app = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jl_path_source = new javax.swing.JLabel();
        jt_pth_source = new javax.swing.JTextField();
        jl_path_result = new javax.swing.JLabel();
        jt_pth_result = new javax.swing.JTextField();
        jb_start = new javax.swing.JButton();
        jp_slider = new javax.swing.JPanel();
        jl_slider_value = new javax.swing.JLabel();
        js_max_files = new javax.swing.JSlider();
        jl_cnsl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Optimization Project");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tunga", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Optimization your Project");

        jl_status_app.setForeground(new java.awt.Color(51, 255, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_status_app)
                .addGap(301, 301, 301))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_status_app))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jl_path_source.setText("Path source");

        jl_path_result.setText("Path result");

        jb_start.setBackground(new java.awt.Color(0, 153, 255));
        jb_start.setForeground(new java.awt.Color(0, 153, 255));
        jb_start.setText("start");
        jb_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_startActionPerformed(evt);
            }
        });

        jp_slider.setBackground(new java.awt.Color(255, 255, 255));
        jp_slider.setBorder(javax.swing.BorderFactory.createTitledBorder("Max files"));

        jl_slider_value.setBackground(new java.awt.Color(255, 255, 255));
        jl_slider_value.setText("10000");

        js_max_files.setBackground(new java.awt.Color(255, 255, 255));
        js_max_files.setMaximum(10000);
        js_max_files.setValue(10000);
        js_max_files.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                js_max_filesMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jp_sliderLayout = new javax.swing.GroupLayout(jp_slider);
        jp_slider.setLayout(jp_sliderLayout);
        jp_sliderLayout.setHorizontalGroup(
            jp_sliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_sliderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(js_max_files, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_sliderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_slider_value)
                .addGap(273, 273, 273))
        );
        jp_sliderLayout.setVerticalGroup(
            jp_sliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_sliderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(js_max_files, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_slider_value)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_cnsl.setText(" ");

        jButton1.setText("select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_path_source)
                            .addComponent(jl_path_result))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jt_pth_source)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jt_pth_result)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jl_cnsl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jp_slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_start, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_path_source)
                    .addComponent(jt_pth_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_path_result)
                    .addComponent(jt_pth_result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(48, 48, 48)
                .addComponent(jl_cnsl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jb_start, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jProgressBar.setToolTipText("");
        jProgressBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setBounds(0, 0, 660, 492);
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Click btn user and start app! 
     * @param evt 
     */
    private void jb_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_startActionPerformed
        
        this.jb_start.setEnabled(false);
        this.jb_start.setText("error");
        this.jl_status_app.setText("ERROR");
        this.jl_status_app.setForeground(Color.red);
        try {
            start_optimization_project();
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_startActionPerformed
    
    /**
     * Set value slider and send value other classes
     * @param evt 
     */
    private void js_max_filesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_js_max_filesMouseMoved
        this.jl_slider_value.setText("" + this.js_max_files.getValue());
    }//GEN-LAST:event_js_max_filesMouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String str = "";
        if (this.def_path_source != null) str += this.def_path_source;
        this.chooserSetTextField(this.jt_pth_source, str);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String str = "";
        if (this.def_path_result != null) str += this.def_path_result;
        this.chooserSetTextField(this.jt_pth_result, str);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void chooserSetTextField(javax.swing.JTextField jt, String path){
        
        File file;
        
        if (!"".equals(path)) {
            file = new File(path);
        }else{
            file = new File(System.getProperty("user.home"));
        }
        
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select project");
        chooser.setApproveButtonText("Select");
        chooser.setCurrentDirectory(file);
        chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
            jt.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JProgressBar jProgressBar;
    public javax.swing.JButton jb_start;
    public javax.swing.JLabel jl_cnsl;
    public javax.swing.JLabel jl_path_result;
    public javax.swing.JLabel jl_path_source;
    public javax.swing.JLabel jl_slider_value;
    public javax.swing.JLabel jl_status_app;
    public javax.swing.JPanel jp_slider;
    public javax.swing.JSlider js_max_files;
    public javax.swing.JTextField jt_pth_result;
    public javax.swing.JTextField jt_pth_source;
    // End of variables declaration//GEN-END:variables
}
