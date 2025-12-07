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
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaUsuarios extends JDialog {

    // Panel Superior (Búsqueda)
    private JLabel lblDescripcion = new JLabel("Descripción:"); // O Apellido, según prefieras
    private JTextField txtBuscar = new JTextField(20);
    private JButton btnBuscar = new JButton("Buscar");

    // Panel Central (Tabla)
    private DefaultTableModel modeloTabla;
    private JTable tablaUsuarios;
    private JScrollPane scrollTabla;

    // Panel Derecho (Botones de Acción)
    private JButton btnNuevo = new JButton("Nuevo");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnBorrar = new JButton("Borrar");
    private JButton btnVolver = new JButton("Volver");

    // Constructor
    public VentanaUsuarios(Frame padre, boolean modal) {
        super(padre, modal);
        setTitle("Usuarios"); // Título según imagen del PDF
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        // 1. ZONA NORTE: Buscador
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(lblDescripcion);
        panelNorte.add(txtBuscar);
        panelNorte.add(btnBuscar);
        add(panelNorte, BorderLayout.NORTH);

        // 2. ZONA CENTRAL: Tabla
        // Definimos columnas según PDF (aunque la imagen es de productos, adaptamos a usuarios)
        String[] columnas = {"Apellido", "Nombre", "Tipo", "Correo"}; 
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacemos que no se pueda editar directo en la tabla
            }
        };
        tablaUsuarios = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaUsuarios);
        // Borde con título "Menú" como en el PDF 
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Lista de Usuarios")); 
        add(scrollTabla, BorderLayout.CENTER);

        // 3. ZONA ESTE: Botones
        JPanel panelEste = new JPanel(new GridLayout(5, 1, 10, 10));
        panelEste.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEste.add(btnNuevo);
        panelEste.add(btnModificar);
        panelEste.add(btnBorrar);
        panelEste.add(new JLabel("")); // Espaciador
        panelEste.add(btnVolver);
        
        add(panelEste, BorderLayout.EAST);
    }

    // Getters necesarios para el Controlador
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnNuevo() { return btnNuevo; }
    public JButton getBtnModificar() { return btnModificar; }
    public JButton getBtnBorrar() { return btnBorrar; }
    public JButton getBtnVolver() { return btnVolver; }
    public JTextField getTxtBuscar() { return txtBuscar; }
    public JTable getTablaUsuarios() { return tablaUsuarios; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
}