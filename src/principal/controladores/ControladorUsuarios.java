package principal.controladores;


import Interfaces.IGestorUsuarios;
import Interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;
import usuarios.vistas.VentanaAMUsuarios; 



public class ControladorUsuarios implements IControladorUsuarios, ActionListener, WindowFocusListener, KeyListener {

    private VentanaUsuarios vista;
    private IGestorUsuarios gestor;
    
    public ControladorUsuarios(VentanaUsuarios vista) {
        this.vista = vista;
        this.gestor = GestorUsuarios.instanciar();
        
        this.vista.getBtnNuevo().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnBorrar().addActionListener(this);
        this.vista.getBtnVolver().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        
        actualizarTabla("");
        
        this.vista.getTxtBuscar().addKeyListener(this);
        
        this.vista.addWindowFocusListener(this);
    }

    
    
    private void actualizarTabla(String apellidoBuscar) {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaUsuarios().getModel();
        modelo.setRowCount(0);

        List<Usuario> lista;
        if (apellidoBuscar == null || apellidoBuscar.isEmpty()) {
            lista = gestor.verUsuarios();
        } else {
            lista = gestor.buscarUsuarios(apellidoBuscar);
        }

        for (Usuario u : lista) {
            modelo.addRow(new Object[]{ 
                u.verCorreo(), 
                u.verApellido(), 
                u.verNombre() 
            });
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnNuevo()) {
            this.btnNuevoClic(e);
        } else if (e.getSource() == vista.getBtnModificar()) {
            this.btnModificarClic(e);
        } else if (e.getSource() == vista.getBtnBorrar()) {
            this.btnBorrarClic(e);
        } else if (e.getSource() == vista.getBtnVolver()) {
            this.btnVolverClic(e);
        } else if (e.getSource() == vista.getBtnBuscar()) {
            this.btnBuscarClic(e);
        }
    }

 

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        VentanaAMUsuarios v = new VentanaAMUsuarios(vista);
        ControladorAMUsuario c = new ControladorAMUsuario(v, null);
        v.setVisible(true);
        actualizarTabla(vista.getTxtBuscar().getText());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int fila = vista.getTablaUsuarios().getSelectedRow();
        if (fila != -1) {
            String correo = (String) vista.getTablaUsuarios().getValueAt(fila, 0); 
            Usuario u = gestor.obtenerUsuario(correo);
            
            if (u != null) {
                    VentanaAMUsuarios v = new VentanaAMUsuarios(vista); 
                    ControladorAMUsuario c = new ControladorAMUsuario(v, u);
                    v.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un usuario");
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila = vista.getTablaUsuarios().getSelectedRow();
        if (fila != -1) {
            int confirm = JOptionPane.showConfirmDialog(vista, "¿Borrar usuario?", "Borrar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String correo = (String) vista.getTablaUsuarios().getValueAt(fila, 0);
                Usuario u = gestor.obtenerUsuario(correo);
                
                String resultado = gestor.borrarUsuario(u); // El gestor borra y actualiza el TXT
                JOptionPane.showMessageDialog(vista, resultado);
                
                if (resultado.equals(IGestorUsuarios.EXITO)) {
                    actualizarTabla(vista.getTxtBuscar().getText());
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un usuario para borrar");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
    }
    
    
    @Override 
    public void keyReleased(KeyEvent e) { 
        actualizarTabla(vista.getTxtBuscar().getText());
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
    }
    
    
    @Override 
    public void keyTyped(KeyEvent e) { 
        txtApellidoPresionarTecla(e); 
    }
    @Override 
    public void keyPressed(KeyEvent e) {
    }
    @Override 
    public void windowGainedFocus(WindowEvent e) { 
        ventanaObtenerFoco(e); 
    }
    @Override 
    public void windowLostFocus(WindowEvent e) {
    }
}