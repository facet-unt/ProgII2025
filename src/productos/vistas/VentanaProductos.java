package productos.vistas;

import Interfaces.IControladorProductos;
import productos.modelos.Producto;
import javax.swing.*;
import java.awt.*; // Necesario para BorderLayout, FlowLayout, GridLayout
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import principal.controladores.ControladorProductos;
import principal.vistas.VentanaPrincipal;
import javax.swing.table.AbstractTableModel;

public class VentanaProductos extends JDialog {

    public final IControladorProductos controlador; 
    private int filaSeleccionada = -1; 
    
    // --- Componentes de la Vista ---
    private JTextField txtDescripcion;
    private JTable tablaProductos;
    private JButton btnBuscar;
    private JButton btnNuevo;
    private JButton btnModificar;
    private JButton btnBorrar;
    private JButton btnVolver;

    /**
     * Constructor para ser llamado desde la Ventana Principal (JFrame padre).
     */
    public VentanaProductos(VentanaPrincipal vista, ControladorProductos controladorProductos) {
        super(vista, IControladorProductos.TITULO, true); 
        
        // *** INYECCIÓN: La Vista se inyecta a sí misma en el Controlador ***
        controladorProductos.setVista(this); 
        
        this.controlador = controladorProductos; 
        
        iniciarComponentesYEnlaces();
    }
    
    /**
     * Constructor auxiliar para JDialog padre.
     */
    public VentanaProductos(JDialog padre, IControladorProductos controlador) {
        super(padre, IControladorProductos.TITULO, true); 
        this.controlador = controlador;
        iniciarComponentesYEnlaces();
    }
    
    private void iniciarComponentesYEnlaces() {
        initComponents();
        asignarControladorComoListener();
        setLocationRelativeTo(null); 
    }
    
    private void initComponents() {
        // 1. Inicialización de componentes
        txtDescripcion = new JTextField(20);
        tablaProductos = new JTable(new MiModeloTablaProductos()); 
        JScrollPane scrollPane = new JScrollPane(tablaProductos); 
        
        btnBuscar = new JButton("Buscar");
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnBorrar = new JButton("Borrar");
        btnVolver = new JButton("Volver");
        
        // --- LÓGICA DE LAYOUT ---
        
        this.setLayout(new BorderLayout()); 
        
        // Panel Norte: Búsqueda
        JPanel panelNorte = new JPanel();
        panelNorte.add(new JLabel("Descripción:"));
        panelNorte.add(txtDescripcion);
        panelNorte.add(btnBuscar);
        
        // Panel Este: Botones de Acción en Columna (GRID LAYOUT)
        // 5 filas, 1 columna, 10px de espaciado vertical
        JPanel panelEste = new JPanel(new GridLayout(5, 1, 10, 10)); 
        
        panelEste.add(btnNuevo);
        panelEste.add(btnModificar);
        panelEste.add(btnBorrar);
        // Box.createVerticalStrut agrega un espacio fijo para separar Volver (Opcional)
        panelEste.add(Box.createVerticalStrut(20)); 
        panelEste.add(btnVolver);

        // Agregar paneles al JDialog
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER); 
        this.add(panelEste, BorderLayout.EAST); // Los botones en columna a la derecha

        // Configuración final
        agregarListenerATabla(tablaProductos);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
        pack(); 
    }
    
    // ⚙️ Lógica de Eventos y Getters/Setters (Se mantienen igual)

    private void agregarListenerATabla(JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                this.filaSeleccionada = tabla.getSelectedRow();
            }
        });
    }

    private void asignarControladorComoListener() {
        btnBuscar.addActionListener(controlador::btnBuscarClic);
        btnNuevo.addActionListener(controlador::btnNuevoClic);
        btnModificar.addActionListener(controlador::btnModificarClic);
        btnBorrar.addActionListener(controlador::btnBorrarClic);
        btnVolver.addActionListener(controlador::btnVolverClic);
        
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                controlador.txtDescripcionPresionarTecla(evt); 
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                controlador.ventanaObtenerFoco(e);
            }
        });
    }

    public String getDescripcionBusqueda() {
        return txtDescripcion.getText().trim();
    }
    
    public Producto getProductoSeleccionado() {
        if (this.filaSeleccionada != -1) {
            MiModeloTablaProductos modelo = (MiModeloTablaProductos) tablaProductos.getModel();
            return modelo.getProductoEnFila(this.filaSeleccionada);
        }
        return null;
    }
    
    public void setProductos(List<Producto> productos) {
        MiModeloTablaProductos modelo = (MiModeloTablaProductos) tablaProductos.getModel();
        modelo.setProductos(productos);
        this.filaSeleccionada = -1; 
    }

    // 📊 Modelo de la Tabla (Table Model)
    private class MiModeloTablaProductos extends AbstractTableModel {
        private final String[] COLUMNAS = {"Categoría", "Descripción", "Precio"};
        private List<Producto> productos;

        public Producto getProductoEnFila(int fila) {
            if (productos != null && fila >= 0 && fila < productos.size()) {
                return productos.get(fila);
            }
            return null;
        }
        
        public void setProductos(List<Producto> productos) {
            this.productos = productos;
            fireTableDataChanged(); 
        }

        @Override
        public int getRowCount() {
            return productos != null ? productos.size() : 0;
        }

        @Override
        public int getColumnCount() {
            return COLUMNAS.length;
        }

        @Override
        public String getColumnName(int col) {
            return COLUMNAS[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (productos == null || row >= productos.size()) return null;
            
            Producto p = productos.get(row);
            switch (col) {
                case 0: return p.verCategoria();
                case 1: return p.verDescripcion();
                case 2: return p.verPrecio();
                default: return null;
            }
        }
    }
}