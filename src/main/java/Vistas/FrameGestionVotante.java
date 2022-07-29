
package Vistas;

import Clases.ClsMensaje;
import Clases.ClsVotante;
import Controladores.CtlVotante;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameGestionVotante extends javax.swing.JFrame {

    CtlVotante controladorVotante;
    //CtlVotante controladorProbarVotante;
    
    LinkedList<ClsVotante> votantes;
    
    public FrameGestionVotante() {
        initComponents();
        this.controladorVotante = new CtlVotante();
        //this.controladorProbarVotante = new CtlVotante();
        this.ObtenerVotante();
        
    }
    public void ObtenerVotante() {

        this.votantes = this.controladorVotante.ObtenerVotante();
        this.ActualizarTabla(votantes);

    }
    public void ActualizarTabla(LinkedList<ClsVotante> lista) {

        DefaultTableModel model = (DefaultTableModel) this.tablaVotantes.getModel();

        model.setRowCount(0);

        for (ClsVotante votante : lista) {

            Object[] row = {votante.getNumeroDocumento(), votante.getNombre(), votante.getTelefono(), votante.getCorreo()};
            model.addRow(row);
        }

    }   
    public ClsVotante BuscarVotante(String id) {

        for (ClsVotante votante : this.votantes) {

            if (votante.getNumeroDocumento().equals(id)) {
                return votante;
            }
        }

        return null;

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campoCedulaVotante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoNombreVotante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoTelefonoVotante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoCorreoVotante = new javax.swing.JTextField();
        botonRegistrarVotante = new javax.swing.JButton();
        botonActualizarVotante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVotantes = new javax.swing.JTable();
        botonEliminarVotante = new javax.swing.JButton();
        botonEditarVotante = new javax.swing.JButton();
        botonVolverRV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro de Votacion");

        jLabel6.setText("Cedula");

        jLabel7.setText("Nombre");

        jLabel8.setText("Telefono");

        jLabel9.setText("Correo");

        botonRegistrarVotante.setText("Registrar");
        botonRegistrarVotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarVotanteActionPerformed(evt);
            }
        });

        botonActualizarVotante.setText("Actualizar");
        botonActualizarVotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarVotanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(campoCedulaVotante, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(campoTelefonoVotante))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(campoNombreVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(campoCorreoVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonRegistrarVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonActualizarVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCedulaVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombreVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTelefonoVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCorreoVotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonActualizarVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrarVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Formulario", jPanel1);

        tablaVotantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Telefono", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tablaVotantes);

        botonEliminarVotante.setText("Eliminar");
        botonEliminarVotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarVotanteActionPerformed(evt);
            }
        });

        botonEditarVotante.setText("Editar");
        botonEditarVotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarVotanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(botonEditarVotante)
                .addGap(49, 49, 49)
                .addComponent(botonEliminarVotante)
                .addGap(163, 163, 163))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarVotante)
                    .addComponent(botonEditarVotante))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lista de votantes registrados", jPanel2);

        botonVolverRV.setText("Volver");
        botonVolverRV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverRVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolverRV)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botonVolverRV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarVotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarVotanteActionPerformed
        
        String numeroDocumento = campoCedulaVotante.getText();
        String nombre = campoNombreVotante.getText();
        String telefono = campoTelefonoVotante.getText();
        String correo = campoCorreoVotante.getText();
        

        ClsVotante votante = new ClsVotante(numeroDocumento, nombre, telefono, correo);

        ClsMensaje mensaje = this.controladorVotante.AgregarVotante(votante);

        if (mensaje.getTipo().equals(mensaje.OK)) {
            
           JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion());
            
            }
        
    }//GEN-LAST:event_botonRegistrarVotanteActionPerformed

    private void botonEditarVotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarVotanteActionPerformed
        int column = 0;
        int row = this.tablaVotantes.getSelectedRow();
        String cedula = this.tablaVotantes.getModel().getValueAt(row, column).toString();
        ClsVotante votante = this.BuscarVotante(cedula);

        if (votante != null) {

            this.campoCedulaVotante.setText(votante.getNumeroDocumento());
            this.campoNombreVotante.setText(votante.getNombre());
            this.campoTelefonoVotante.setText(votante.getTelefono());
            this.campoCorreoVotante.setText(votante.getCorreo());
            
            this.campoCedulaVotante.disable();
            this.jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_botonEditarVotanteActionPerformed

    private void botonEliminarVotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarVotanteActionPerformed
        int column = 0;
        int row = this.tablaVotantes.getSelectedRow();
        String cedula = this.tablaVotantes.getModel().getValueAt(row, column).toString();

        ClsMensaje mensaje = this.controladorVotante.EliminarVotante(cedula);

        if (mensaje.getTipo().equals(mensaje.OK)) {
            this.ObtenerVotante();
        }

        JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion());
    }//GEN-LAST:event_botonEliminarVotanteActionPerformed

    private void botonActualizarVotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarVotanteActionPerformed
        String cedula = this.campoCedulaVotante.getText();
        ClsVotante votante = this.BuscarVotante(cedula);

        String nombre = this.campoNombreVotante.getText();
        votante.setNombre(nombre);

        String telefono = this.campoTelefonoVotante.getText();
        votante.setTelefono(telefono);

        String correo = this.campoCorreoVotante.getText();
        votante.setCorreo(correo);
       
        ClsMensaje mensaje = this.controladorVotante.ActualizarVotante(votante);

        if (mensaje.getTipo().equals(mensaje.OK)) {
            this.ObtenerVotante();
        }

        JOptionPane.showMessageDialog(rootPane, mensaje.getDescripcion());
    }//GEN-LAST:event_botonActualizarVotanteActionPerformed

    private void botonVolverRVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverRVActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverRVActionPerformed

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
            java.util.logging.Logger.getLogger(FrameGestionVotante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameGestionVotante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameGestionVotante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameGestionVotante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGestionVotante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarVotante;
    private javax.swing.JButton botonEditarVotante;
    private javax.swing.JButton botonEliminarVotante;
    private javax.swing.JButton botonRegistrarVotante;
    private javax.swing.JButton botonVolverRV;
    private javax.swing.JTextField campoCedulaVotante;
    private javax.swing.JTextField campoCorreoVotante;
    private javax.swing.JTextField campoNombreVotante;
    private javax.swing.JTextField campoTelefonoVotante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaVotantes;
    // End of variables declaration//GEN-END:variables
}
