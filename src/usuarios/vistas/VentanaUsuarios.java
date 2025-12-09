package usuarios.vistas;
/**
 *
 * @author Usuario
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaUsuarios extends JDialog {

    
    private JLabel lblDescripcion = new JLabel("Descripción:"); 
    private JTextField txtBuscar = new JTextField(20);
    private JButton btnBuscar = new JButton("Buscar");

    
    private DefaultTableModel modeloTabla;
    private JTable tablaUsuarios;
    private JScrollPane scrollTabla;

    
    private JButton btnNuevo = new JButton("Nuevo");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnBorrar = new JButton("Borrar");
    private JButton btnVolver = new JButton("Volver");

    
    public VentanaUsuarios(Frame padre, boolean modal) {
        super(padre, modal);
        setTitle("Usuarios"); 
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

       
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(lblDescripcion);
        panelNorte.add(txtBuscar);
        panelNorte.add(btnBuscar);
        add(panelNorte, BorderLayout.NORTH);

        
        String[] columnas = {"Apellido", "Nombre", "Tipo", "Correo"}; 
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaUsuarios = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaUsuarios);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Lista de Usuarios")); 
        add(scrollTabla, BorderLayout.CENTER);

        JPanel panelEste = new JPanel(new GridLayout(5, 1, 10, 10));
        panelEste.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEste.add(btnNuevo);
        panelEste.add(btnModificar);
        panelEste.add(btnBorrar);
        panelEste.add(new JLabel("")); 
        panelEste.add(btnVolver);
        
        add(panelEste, BorderLayout.EAST);
    }


    public JButton getBtnBuscar() { 
        return btnBuscar; 
    }
    public JButton getBtnNuevo() { 
        return btnNuevo; 
    }
    public JButton getBtnModificar() { 
        return btnModificar; 
    }
    public JButton getBtnBorrar() { 
        return btnBorrar; 
    }
    public JButton getBtnVolver() { 
        return btnVolver; 
    }
    public JTextField getTxtBuscar() { 
        return txtBuscar; 
    }
    public JTable getTablaUsuarios() { 
        return tablaUsuarios; 
    }
    public DefaultTableModel getModeloTabla() { 
        return modeloTabla; 
    }
}