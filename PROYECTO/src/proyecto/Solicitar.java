/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Daniel
 */
public class Solicitar extends javax.swing.JFrame {

    /**
     * Creates new form Solicitar
     */
    conexion.Conexion con = new Conexion();
    Connection cn = con.conectar();
    
    public Solicitar() {
        String nombres = lg.returnNombres();
        String apellidos = lg.returnApellidos();
        initComponents();
        llenarCombo();
        txtusuario.setText(nombres + " " + apellidos);

    }
    LogIn lg = new LogIn();

    public void llenarCombo() {
        CBsistema.addItem("");
        CBsistema.addItem("Francés");
    }
    
    CuentaCiudadano cs = new CuentaCiudadano();
    
    public void ValidarPrestamo() {
        double monto = Float.valueOf(txtmonto.getText());
        Usuario.cuota = monto;
        String sistema = CBsistema.getSelectedItem().toString();
        double ingreso = Float.valueOf(txtingreso.getText());
        double egreso = Float.valueOf(txtegreso.getText());
        double tasa_interes = 0.014;
        int idusuario = cs.returnIDusuario();
        if (txtmonto.getText().isEmpty() || sistema.isEmpty() || txtingreso.getText().isEmpty() || txtegreso.getText().isEmpty() || sistema.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
        }
        if (CBsistema.getSelectedItem().toString() == "Francés") {
            double resta = ingreso - egreso;
            double comparacion = ingreso / 4;
            if (resta >= comparacion) {
                JOptionPane.showMessageDialog(null, "USTED CUMPLE LOS REQUERIMIENTOS PARA ACCEDER A UN PRÉSTAMO");
            } else {
                JOptionPane.showMessageDialog(null, "USTED NO CUMPLE LOS REQUERIMIENTOS PARA ACCEDER A UN PRÉSTAMO");
            }
        }
        
        try{
            String SQLidciudadano = "SELECT id_ciudadano FROM ciudadano WHERE id_usuario = "+idusuario+";";
            PreparedStatement ps = cn.prepareStatement(SQLidciudadano);
            int idciudadano = 0;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idciudadano = rs.getInt("id_ciudadano");
            }
            String SQL = "UPDATE ciudadano SET ingresos ="+ingreso+" WHERE id_ciudadano = "+idciudadano+";";
            ps = cn.prepareStatement(SQL);
            ps.executeUpdate();
            String SQL2 = "UPDATE ciudadano SET egresos ="+egreso+" WHERE id_ciudadano = "+idciudadano+";";
            ps = cn.prepareStatement(SQL2);
            ps.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ex);
        }
    }
    public double TasaInteres(){
        return 0.014;
    }
    
    public double monto(){
        return Usuario.cuota;
    }
    
    public double return12MesesFrances() {
        double monto = Usuario.cuota;
        double Tasainteres = 0.014;
        double interes = 0;
        double amortizacion = 0;
        int periodo = 12;
        double cuota = ((Tasainteres * (Math.pow((1 + Tasainteres), periodo))) * monto) / ((Math.pow((1 + Tasainteres), periodo)) - 1);
        return (cuota);
    }

    public double return12TotalFrances() {
        double monto = Usuario.cuota;
        int periodo = 12;
        return monto * periodo;
    }

    public double return24MesesFrances() {
        double monto = Usuario.cuota;
        double Tasainteres = 0.014;
        double interes = 0;
        double amortizacion = 0;
        int periodo = 24;
        double cuota = ((Tasainteres * (Math.pow((1 + Tasainteres), periodo))) * monto) / ((Math.pow((1 + Tasainteres), periodo)) - 1);
        return (cuota);
    }

    public double return24TotalFrances() {
        double monto = Usuario.cuota;
        int periodo = 24;
        return monto * periodo;
    }

    public double return36MesesFrances() {
        double monto = Usuario.cuota;
        double Tasainteres = 0.014;
        double interes = 0;
        double amortizacion = 0;
        int periodo = 36;
        double cuota = ((Tasainteres * (Math.pow((1 + Tasainteres), periodo))) * monto) / ((Math.pow((1 + Tasainteres), periodo)) - 1);
        return (cuota);
    }

    public double return36TotalFrances() {
        double monto = Usuario.cuota;
        int periodo = 36;
        return monto * periodo;
    }

    public double return48MesesFrances() {
        double monto = Usuario.cuota;
        double Tasainteres = 0.014;
        double interes = 0;
        double amortizacion = 0;
        int periodo = 48;
        double cuota = ((Tasainteres * (Math.pow((1 + Tasainteres), periodo))) * monto) / ((Math.pow((1 + Tasainteres), periodo)) - 1);
        return (cuota);
    }

    public double return48TotalFrances() {
        double monto = Usuario.cuota;
        int periodo = 48;
        return monto * periodo;
    }

    public double return60MesesFrances() {
        double monto = Usuario.cuota;
        double Tasainteres = 0.014;
        double interes = 0;
        double amortizacion = 0;
        int periodo = 60;
        double cuota = ((Tasainteres * (Math.pow((1 + Tasainteres), periodo))) * monto) / ((Math.pow((1 + Tasainteres), periodo)) - 1);
        return (cuota);
    }

    public double return60TotalFrances() {
        double monto = Usuario.cuota;
        int periodo = 60;
        return monto * periodo;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CBsistema = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtmonto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtingreso = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtegreso = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtusuario1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logoCuenta.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconouser.png"))); // NOI18N

        txtusuario.setEditable(false);
        txtusuario.setBackground(new java.awt.Color(0, 204, 153));
        txtusuario.setFont(new java.awt.Font("Roboto Cn", 0, 12)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(255, 255, 255));
        txtusuario.setToolTipText("");
        txtusuario.setBorder(null);
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconoSalir.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("SISTEMA DE AMORTIZACIÓN:");

        CBsistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBsistemaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("FORMULARIO PARA SOLICITAR PRÉSTAMO");

        jLabel13.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("MONTO DESEADO:");

        txtmonto.setForeground(new java.awt.Color(102, 102, 102));
        txtmonto.setText("Ingrese el monto deseado");
        txtmonto.setToolTipText("");
        txtmonto.setBorder(null);
        txtmonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoActionPerformed(evt);
            }
        });
        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontoKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("INGRESO ANUAL:");

        txtingreso.setForeground(new java.awt.Color(102, 102, 102));
        txtingreso.setText("Ingrese su ingreso anual");
        txtingreso.setToolTipText("");
        txtingreso.setBorder(null);
        txtingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresoActionPerformed(evt);
            }
        });
        txtingreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtingresoKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("EGRESO ANUAL:");

        txtegreso.setForeground(new java.awt.Color(102, 102, 102));
        txtegreso.setText("Ingrese su egreso anual");
        txtegreso.setToolTipText("");
        txtegreso.setBorder(null);
        txtegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtegresoActionPerformed(evt);
            }
        });
        txtegreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtegresoKeyTyped(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/messi.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 204, 153));
        jButton1.setFont(new java.awt.Font("Roboto Cn", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SOLICITAR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto Cn", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("TASA INTERÉS:");

        txtusuario1.setEditable(false);
        txtusuario1.setBackground(new java.awt.Color(255, 255, 255));
        txtusuario1.setFont(new java.awt.Font("Roboto Cn", 0, 14)); // NOI18N
        txtusuario1.setForeground(new java.awt.Color(0, 0, 0));
        txtusuario1.setText("14%");
        txtusuario1.setToolTipText("");
        txtusuario1.setBorder(null);
        txtusuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario1ActionPerformed(evt);
            }
        });
        txtusuario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuario1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(241, 241, 241))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmonto, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(CBsistema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtingreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtegreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(CBsistema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(txtegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(txtusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ValidarPrestamo();
        FinalSolicitudFrances FS = new FinalSolicitudFrances();
        FS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtegresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtegresoKeyTyped
        String egreso = String.valueOf(evt.getKeyChar());
        if (!egreso.matches("[0-9.]")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtegresoKeyTyped

    private void txtegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtegresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtegresoActionPerformed

    private void txtingresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtingresoKeyTyped
        String ingreso = String.valueOf(evt.getKeyChar());
        if (!ingreso.matches("[0-9.]")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtingresoKeyTyped

    private void txtingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtingresoActionPerformed

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped
        String cedula = String.valueOf(evt.getKeyChar());
        if (!cedula.matches("[0-9.]")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtmontoKeyTyped

    private void txtmontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoActionPerformed

    private void CBsistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBsistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBsistemaActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        LogIn log = new LogIn();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        String telefono = String.valueOf(evt.getKeyChar());
        if (!telefono.matches("[0-9]")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed

    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario1ActionPerformed

    private void txtusuario1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuario1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario1KeyTyped

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
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solicitar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBsistema;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField txtegreso;
    private javax.swing.JTextField txtingreso;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextField txtusuario1;
    // End of variables declaration//GEN-END:variables
}
