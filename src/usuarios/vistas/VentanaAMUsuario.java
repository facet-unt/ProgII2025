/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package usuarios.vistas;

import interfaces.IControladorAMUsuario;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author
 */
public class VentanaAMUsuario extends javax.swing.JDialog {

    private VentanaUsuarios Ventana;
    private IControladorAMUsuario Controlador;

    /**
     * Creates new form VentanaAMUsuario1
     *
     * @param Controlador
     */
    public VentanaAMUsuario(IControladorAMUsuario Controlador, javax.swing.JDialog padre, boolean modal) {
        super(padre, modal);
        initComponents();
        this.Controlador = Controlador;

        ComboBoxPerfil.removeAllItems();
        for (Perfil p : Perfil.values()) {
            ComboBoxPerfil.addItem(p.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        passClave = new javax.swing.JTextField();
        passClaveRepetida = new javax.swing.JTextField();
        ComboBoxPerfil = new javax.swing.JComboBox<>();
        BtnGuardarClic = new javax.swing.JButton();
        Btn_Cancelar_Clic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        jLabel1.setText("Correo: ");

        jLabel2.setText("Apellido: ");

        jLabel3.setText("Nombre: ");

        jLabel4.setText("Clave: ");

        jLabel5.setText("Clave Repetida: ");

        jLabel6.setText("Perfil");

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        passClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClaveKeyTyped(evt);
            }
        });

        passClaveRepetida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passClaveRepetidaActionPerformed(evt);
            }
        });
        passClaveRepetida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClaveRepetidaKeyTyped(evt);
            }
        });

        ComboBoxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtnGuardarClic.setText("Guardar");
        BtnGuardarClic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarClicActionPerformed(evt);
            }
        });

        Btn_Cancelar_Clic.setText("Cancelar");
        Btn_Cancelar_Clic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarClicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnGuardarClic, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Cancelar_Clic, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo)
                            .addComponent(txtApellido)
                            .addComponent(txtNombre)
                            .addComponent(passClave)
                            .addComponent(passClaveRepetida)
                            .addComponent(ComboBoxPerfil, 0, 278, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passClaveRepetida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Cancelar_Clic)
                    .addComponent(BtnGuardarClic))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public String getApellido() {
        return txtApellido.getText();
    }

    public void setApellido(String apellido) {
        txtApellido.setText(apellido);
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public void setNombre(String nombre) {
        txtNombre.setText(nombre);
    }

    public String getCorreo() {
        return txtCorreo.getText();
    }

    public void setCorreo(String correo) {
        txtCorreo.setText(correo);
    }

    public String getClave() {
        return passClave.getText();
    }

    public void setClave(String clave) {
        passClave.setText(clave);
    }

    public String getClaveRepetida() {
        return passClaveRepetida.getText();
    }

    public void setClaveRepetida(String clave) {
        passClaveRepetida.setText(clave);
    }

    public Perfil getPerfil() {
        int index = ComboBoxPerfil.getSelectedIndex();
        if (index >= 0 && index < Perfil.values().length) {
            return Perfil.values()[index];
        }
        return Perfil.values()[0];
    }

    public void setPerfil(Perfil perfil) {
        for (int i = 0; i < Perfil.values().length; i++) {
            if (Perfil.values()[i].equals(perfil)) {
                ComboBoxPerfil.setSelectedIndex(i);
                break;
            }
        }
    }

    public void setCorreoEditable(boolean editable) {
        txtCorreo.setEnabled(editable);
    }

    private void BtnGuardarClicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarClicActionPerformed
        this.Controlador.btnGuardarClic(evt);

    }//GEN-LAST:event_BtnGuardarClicActionPerformed

    private void BtnCancelarClicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarClicActionPerformed
        this.Controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_BtnCancelarClicActionPerformed

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        this.Controlador.txtCorreoPresionarTecla(evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        this.Controlador.txtApellidoPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        this.Controlador.txtNombrePresionarTecla(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void passClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClaveKeyTyped
        this.Controlador.passClavePresionarTecla(evt);
    }//GEN-LAST:event_passClaveKeyTyped

    private void passClaveRepetidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClaveRepetidaKeyTyped
        this.Controlador.passClaveRepetidaPresionarTecla(evt);
    }//GEN-LAST:event_passClaveRepetidaKeyTyped

    private void passClaveRepetidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passClaveRepetidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passClaveRepetidaActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardarClic;
    private javax.swing.JButton Btn_Cancelar_Clic;
    private javax.swing.JComboBox<String> ComboBoxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passClave;
    private javax.swing.JTextField passClaveRepetida;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
