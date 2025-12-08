/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.vistas;

/**
 *
 * @author Usuario
 */

import javax.swing.*;
import java.awt.*;
import usuarios.modelos.Perfil;

public class VentanaAMUsuarios extends JDialog {
    private JTextField txtCorreo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JPasswordField txtClave;
    private JPasswordField txtClaveRepetida;
    private JComboBox<Perfil> comboPerfil;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public VentanaAMUsuarios(Window owner) {
        super(owner, "Usuario", ModalityType.APPLICATION_MODAL);
        initComponentes();
        this.setLocationRelativeTo(null);
    }

    private void initComponentes() {
        this.setLayout(new GridLayout(7, 2, 10, 10)); 
        this.setSize(400, 350);

        this.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        this.add(txtCorreo);

        this.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        this.add(txtNombre);

        this.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        this.add(txtApellido);

        this.add(new JLabel("Perfil:"));
        comboPerfil = new JComboBox<>(Perfil.values());
        this.add(comboPerfil);

        this.add(new JLabel("Contraseña:"));
        txtClave = new JPasswordField();
        this.add(txtClave);

        this.add(new JLabel("Repetir Contraseña:"));
        txtClaveRepetida = new JPasswordField();
        this.add(txtClaveRepetida);

        btnGuardar = new JButton("Guardar");
        this.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        this.add(btnCancelar);
    }

    
    public JTextField getTxtCorreo() { return txtCorreo; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JPasswordField getTxtClave() { return txtClave; }
    public JPasswordField getTxtClaveRepetida() { return txtClaveRepetida; }
    public JComboBox<Perfil> getComboPerfil() { return comboPerfil; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnCancelar() { return btnCancelar; }
}