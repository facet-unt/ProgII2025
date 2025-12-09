package usuarios.vistas;

import interfaces.IControladorAMUsuario;

public class VentanaAMUsuario extends javax.swing.JDialog {
    
    private IControladorAMUsuario controlador;
    private VentanaAMUsuario ventana;

    public VentanaAMUsuario(java.awt.Frame parent, boolean modal, IControladorAMUsuario controlador) {
        super(parent, modal);
        this.controlador = controlador;
        initComponents();
    }
     public VentanaAMUsuario(java.awt.Dialog parent, boolean modal, IControladorAMUsuario controlador) {
        this.ventana = ventana;
        this.controlador = controlador;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelApellido = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelClave = new javax.swing.JLabel();
        jLabelRepeti = new javax.swing.JLabel();
        jLabelPerfil = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        ClaveUsuario = new javax.swing.JPasswordField();
        repetirClave = new javax.swing.JPasswordField();
        cmbPerfil = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelApellido.setText("Apellido:");

        jLabelNombre.setText("Nombre:");

        jLabelCorreo.setText("Correo:");

        jLabelClave.setText("Clave:");

        jLabelRepeti.setText("Repetir Clave:");

        jLabelPerfil.setText("Perfil:");

        btnGuardar.setMnemonic('G');
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        txtApellido.addActionListener(this::txtApellidoActionPerformed);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre.addActionListener(this::txtNombreActionPerformed);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCorreo.addActionListener(this::txtCorreoActionPerformed);
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        ClaveUsuario.addActionListener(this::ClaveUsuarioActionPerformed);
        ClaveUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ClaveUsuarioKeyTyped(evt);
            }
        });

        repetirClave.addActionListener(this::repetirClaveActionPerformed);
        repetirClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                repetirClaveKeyTyped(evt);
            }
        });

        cmbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPerfil.addActionListener(this::cmbPerfilActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelClave)
                    .addComponent(jLabelRepeti)
                    .addComponent(jLabelCorreo)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelApellido)
                    .addComponent(jLabelPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(repetirClave)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ClaveUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClaveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repetirClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRepeti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPerfil))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         this.controlador.btnGuardarClic(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void ClaveUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveUsuarioActionPerformed

    private void repetirClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repetirClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repetirClaveActionPerformed

    private void cmbPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPerfilActionPerformed

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        this.controlador.txtApellidoPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        this.controlador.txtNombrePresionarTecla(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        this.controlador.txtCorreoPresionarTecla(evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void ClaveUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClaveUsuarioKeyTyped
        this.controlador.passClavePresionarTecla(evt);
    }//GEN-LAST:event_ClaveUsuarioKeyTyped

    private void repetirClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repetirClaveKeyTyped

        this.controlador.passClaveRepetidaPresionarTecla(evt);
    }//GEN-LAST:event_repetirClaveKeyTyped

    /**
     * @param args the command line arguments

* */
    public javax.swing.JTextField verTxtApellido() {
        return txtApellido; 
    }

    public javax.swing.JTextField verTxtNombre() {
        return txtNombre; 
    }

    public javax.swing.JTextField verTxtCorreo() {
        return txtCorreo;
    }

    public javax.swing.JPasswordField verPswClave() {
        return ClaveUsuario;
    }

    public javax.swing.JPasswordField verPswRepetida() {
        return repetirClave; 
    }
    public javax.swing.JComboBox verCmbPerfil() {
        return cmbPerfil;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ClaveUsuario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPerfil;
    private javax.swing.JLabel jLabelRepeti;
    private javax.swing.JPasswordField repetirClave;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}