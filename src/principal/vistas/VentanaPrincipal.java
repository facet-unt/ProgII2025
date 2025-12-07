package principal.vistas;

import javax.swing.*;
import java.awt.*;
import usuarios.vistas.VentanaUsuarios;

public class VentanaPrincipal extends JFrame {

    private JButton btnUsuarios = new JButton("Usuarios");
    private JButton btnProductos = new JButton("Productos");
    private JButton btnPedidos = new JButton("Pedidos");
    private JButton btnSalir = new JButton("Salir");

    public VentanaPrincipal() {
        setTitle("Bar"); // 
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         
        //mensaje de botones
        btnUsuarios.setToolTipText("Crear usuario"); 
        btnProductos.setToolTipText("Administrar lista de productos");
        btnPedidos.setToolTipText("Gestionar los pedidos activos");
        btnSalir.setToolTipText("Cerrar la aplicación");
        
        //subrrayar primer letra
        btnUsuarios.setMnemonic('U');
        btnProductos.setMnemonic('P');
        btnPedidos.setMnemonic('P');
        btnSalir.setMnemonic('S');
        
        // Panel principal con GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(btnUsuarios);
        panel.add(btnProductos);
        panel.add(btnPedidos);
        panel.add(btnSalir);

        add(panel);
        
        
    }

    // Métodos getter para respetar encapsulación
    public JButton getBtnUsuarios() { 
        return btnUsuarios; 
    }
    public JButton getBtnProductos() { 
        return btnProductos; 
    }
    public JButton getBtnPedidos() { 
        return btnPedidos; 
    }
    public JButton getBtnSalir() { 
        return btnSalir; 
    }
}
