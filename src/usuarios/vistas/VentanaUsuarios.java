package usuarios.vistas;

import java.awt.GridLayout;
import javax.swing.*;

public class VentanaUsuarios extends JFrame {
    
    private JButton btnCliente = new JButton("Cliente");
    private JButton btnEmpleado = new JButton("Empleado");
    private JButton btnEncargado = new JButton("Enacargado");
    private JButton btnVolver = new JButton ("Volver");
    
    
    public VentanaUsuarios() {
        setTitle("Usuarios");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        

        
        //mensaje de botones
        btnCliente.setToolTipText("Crear cliente"); 
        btnEmpleado.setToolTipText("Crear Empleado");
        btnEncargado.setToolTipText("Crear Encargado");
        btnVolver.setToolTipText("Volver a la seccion anterior");
        
        //subrrayar primer letra
         btnCliente.setMnemonic('C');
        btnEmpleado.setMnemonic('E');
        btnEncargado.setMnemonic('E');
        btnVolver.setMnemonic('V');
        
        // Panel principal con GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(btnCliente);
        panel.add(btnEmpleado);
        panel.add(btnEncargado);
        panel.add(btnVolver);

        add(panel);
        
        
        
            btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // 'this' no funcionaría aquí adentro porque estamos en una clase anónima
                // así que usamos VentanaUsuarios.this para referirnos a la ventana principal

                // Creamos la ventana de cliente, pasándole esta ventana como padre y 'true' para que sea modal
                VentanaAMCliente ventanaCliente = new VentanaAMCliente(VentanaUsuarios.this, true); 

                // La hacemos visible
                ventanaCliente.setVisible(true);
            }
        });
    }
        // Métodos getter para respetar encapsulación
        public JButton getBtnCliente() { 
        return btnCliente; 
        }
        public JButton getBtnEmpleado() { 
            return btnEmpleado; 
        }
        public JButton getBtnEncargado() { 
            return btnEncargado; 
        }
        public JButton getBtnVolver() { 
            return btnVolver; 
        }
}

