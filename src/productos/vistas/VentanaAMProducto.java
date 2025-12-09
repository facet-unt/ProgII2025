package productos.vistas;

import productos.modelos.Producto;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import principal.controladores.ControladorAMProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaAMProducto extends JDialog {

    private ControladorAMProducto controlador; // Controlador inyectado después
    private Producto producto; // Producto a editar o null para Alta

    // Componentes de la ventana
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JComboBox<Categoria> comboCategoria;
    private JComboBox<Estado> comboEstados;
    private JButton btnGuardar;
    private JButton btnCancelar;

    // Constructor
    public VentanaAMProducto(JFrame parent, ControladorAMProducto controladorInicial, Producto producto) {
        super(parent, true);
        this.producto = producto;

        if (controladorInicial != null) {
            this.controlador = controladorInicial;
        }

        inicializarComponentes();
        iniciarComponentesYEnlaces();
    }

    /** Inyecta el controlador después de crear la ventana */
    public void inicializarControlador(ControladorAMProducto controlador) {
        this.controlador = controlador;
        asignarListeners();
    }

    private void inicializarComponentes() {
        setTitle(producto == null ? "Nuevo Producto" : "Modificar Producto");
        setSize(450, 300);
        setLayout(null);
        setLocationRelativeTo(getParent());
        setResizable(false);

        // Etiquetas
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 20, 100, 25);
        add(lblCodigo);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(30, 60, 100, 25);
        add(lblDescripcion);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 100, 100, 25);
        add(lblPrecio);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(30, 140, 100, 25);
        add(lblCategoria);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 180, 100, 25);
        add(lblEstado);

        // Campos
        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 20, 250, 25);
        add(txtCodigo);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(140, 60, 250, 25);
        add(txtDescripcion);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(140, 100, 250, 25);
        add(txtPrecio);

        comboCategoria = new JComboBox<>();
        comboCategoria.setBounds(140, 140, 250, 25);
        comboCategoria.setModel(new ModeloComboCategorias());
        add(comboCategoria);

        comboEstados = new JComboBox<>();
        comboEstados.setBounds(140, 180, 250, 25);
        comboEstados.setModel(new ModeloComboEstados());
        add(comboEstados);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(80, 220, 120, 30);
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 220, 120, 30);
        add(btnCancelar);

        // Si es modificación, cargar datos del producto
        if (producto != null) {
            txtCodigo.setText(String.valueOf(producto.verCodigo()));
            txtCodigo.setEditable(false); // No se puede cambiar el código
            txtDescripcion.setText(producto.verDescripcion());
            txtPrecio.setText(String.valueOf(producto.verPrecio()));
            comboCategoria.setSelectedItem(producto.verCategoria());
            comboEstados.setSelectedItem(producto.verEstado());
        }
    }

    private void iniciarComponentesYEnlaces() {
        if (controlador != null) {
            asignarListeners();
        }
    }

    private void asignarListeners() {
        if (controlador == null) return;

        btnGuardar.addActionListener(e -> controlador.btnGuardarClic(e));
        btnCancelar.addActionListener(e -> controlador.btnCancelarClic(e));

        txtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                controlador.txtCodigoPresionarTecla(e);
            }
        });

        txtDescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                controlador.txtDescripcionPresionarTecla(e);
            }
        });

        txtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                controlador.txtPrecioPresionarTecla(e);
            }
        });

        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                controlador.ventanaObtenerFoco(e);
            }
        });
    }

    // --- GETTERS para que el controlador acceda a los datos ---

    public String getTxtCodigo() { return txtCodigo.getText().trim(); }
    public String getTxtDescripcion() { return txtDescripcion.getText().trim(); }
    public String getTxtPrecio() { return txtPrecio.getText().trim(); }
    public Categoria getCategoriaSeleccionada() { return (Categoria) comboCategoria.getSelectedItem(); }
    public Estado getEstadoSeleccionado() { return (Estado) comboEstados.getSelectedItem(); }
    public Producto getProductoAEditar() { return producto; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    public JComboBox<Categoria> getComboCategoria() { return comboCategoria; }
    public JComboBox<Estado> getComboEstados() { return comboEstados; }

    public void cerrarVentana() {
        this.dispose();
    }
}
