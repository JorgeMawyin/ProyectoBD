/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import com.mysql.cj.xdevapi.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Daniel
 */
public class LogIn extends javax.swing.JFrame {

    conexion.Conexion con = new Conexion();
    Connection cn = con.conectar();
    String correo="";
    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    public void validarIngreso() {
        int resultado = 0;
        String pass = String.valueOf(txtcontraI.getPassword());
        String correo = String.valueOf(txtcorreoI.getText());
        Usuario.correo=correo;
        String nroCuenta = "";
        String saldo = "";
        String tipoCuenta = "";
        String SQL = "SELECT * FROM usuario WHERE correo='" + correo + "' and clave='" + pass + "';";
        String SQLCONTRASEÑA = "SELECT * FROM usuario WHERE clave='" + pass + "';";
        String SQLUSUARIO = "SELECT * FROM usuario WHERE correo='" + correo + "';";
        String SQLcuenta = "SELECT C.nro_Cuenta, C.saldo, C.tipoCuenta, C.nombreBanco, C.id_usuario, U.correo FROM cuenta C JOIN usuario U ON C.id_usuario = U.id_usuario WHERE U.correo = '"+correo+"';";
        
        
        try {
            PreparedStatement ps1 = cn.prepareStatement(SQL);
            ResultSet rs1 = ps1.executeQuery();
            PreparedStatement ps2 = cn.prepareStatement(SQLCONTRASEÑA);
            ResultSet rs2 = ps2.executeQuery();
            PreparedStatement ps3 = cn.prepareStatement(SQLUSUARIO);
            ResultSet rs3 = ps3.executeQuery();
            PreparedStatement ps4;
            ps4 = cn.prepareStatement(SQLcuenta);
            ResultSet rs4 = ps4.executeQuery();
            if(rs4.next()){
                Usuario.nroCuenta = rs4.getString("nro_Cuenta");
                Usuario.saldo = rs4.getFloat("saldo");
                Usuario.tipoCuenta = rs4.getString("tipoCuenta");
                Usuario.banco = rs4.getString("nombreBanco");
                Usuario.idUsuario = rs4.getInt("id_usuario");
            }
            
            if (!rs3.next()) {
                JOptionPane.showMessageDialog(null, "ERROR DE ACCESO, USUARIO NO REGISTRADO");
            } else if (!rs2.next()) {
                JOptionPane.showMessageDialog(null, "ERROR DE ACCESO, CONTRASEÑA INCORRECTA");
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO IDENTIFICADO");
                
                CuentaCiudadano cuenta = new CuentaCiudadano();
                cuenta.setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        }
    }

    public String returnCorreo(){
        return Usuario.correo;
    }
    
    public int returnIdUsuario(){
        return Usuario.idUsuario;
    }
    
    public String returnNroCuenta(){
        String nroCuenta = "";
        nroCuenta = Usuario.nroCuenta;
        return nroCuenta;
    }
    
    public String returnSaldo(){
        String saldo = "";
        saldo = String.valueOf(Usuario.saldo);
        return saldo;
    }
    
    public String returnTipoCuenta(){
        String tipoCuenta = "";
        tipoCuenta = Usuario.tipoCuenta;
        return tipoCuenta;
    }
    
    public String returnBanco(){
        String banco = "";
        banco = Usuario.banco;
        return banco;
    }
    
    public String returnNombres() {
        String nombres = "";
        String consulta = "SELECT C.nombres FROM ciudadano C JOIN usuario U ON c.id_usuario = U.id_usuario WHERE U.correo = '" + Usuario.correo + "';";
        try {
            PreparedStatement ps1 = cn.prepareStatement(consulta);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                nombres = rs.getString("nombres");
                return nombres;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nombres;
    }

    public String returnApellidos() {
        String apellidos = "";
        String consulta = "SELECT C.apellidos FROM ciudadano C JOIN usuario U ON c.id_usuario = U.id_usuario WHERE U.correo = '" + Usuario.correo + "';";
        try {
            PreparedStatement ps1 = cn.prepareStatement(consulta);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                apellidos = rs.getString("apellidos");
                return apellidos;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return apellidos;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcorreoI = new javax.swing.JTextField();
        txtcontraI = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btingresar = new javax.swing.JButton();
        btregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/FondoLogIn.png"))); // NOI18N
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Roboto Cn", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("INICIAR SESIÓN");

        jLabel3.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CORREO");

        jLabel4.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CONTRASEÑA");

        txtcorreoI.setForeground(new java.awt.Color(102, 102, 102));
        txtcorreoI.setText("Ingrese su correo");
        txtcorreoI.setToolTipText("");
        txtcorreoI.setBorder(null);
        txtcorreoI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoIKeyTyped(evt);
            }
        });

        txtcontraI.setForeground(new java.awt.Color(102, 102, 102));
        txtcontraI.setText("jPasswordField1");
        txtcontraI.setBorder(null);
        txtcontraI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraIKeyTyped(evt);
            }
        });

        btingresar.setBackground(new java.awt.Color(27, 122, 190));
        btingresar.setFont(new java.awt.Font("Roboto Cn", 0, 14)); // NOI18N
        btingresar.setForeground(new java.awt.Color(255, 255, 255));
        btingresar.setText("INGRESAR");
        btingresar.setBorder(null);
        btingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btingresarActionPerformed(evt);
            }
        });

        btregresar.setBackground(new java.awt.Color(27, 122, 190));
        btregresar.setFont(new java.awt.Font("Roboto Cn", 0, 14)); // NOI18N
        btregresar.setForeground(new java.awt.Color(255, 255, 255));
        btregresar.setText("REGRESAR");
        btregresar.setBorder(null);
        btregresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                .addComponent(txtcorreoI)
                                .addComponent(txtcontraI)))
                        .addGap(0, 175, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcorreoI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtcontraI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btingresarActionPerformed
        validarIngreso();
    }//GEN-LAST:event_btingresarActionPerformed

    private void btregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregresarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btregresarActionPerformed

    private void txtcorreoIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoIKeyTyped
        String correo = String.valueOf(evt.getKeyChar());
        if (!correo.matches("[0-9a-zA-Z ´áéíóú@_.]")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcorreoIKeyTyped

    private void txtcontraIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraIKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraIKeyTyped

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btingresar;
    private javax.swing.JButton btregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtcontraI;
    private javax.swing.JTextField txtcorreoI;
    // End of variables declaration//GEN-END:variables
}
