/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;


import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;

/**
 *
 * @author irica
 */
public class ControladorAMProducto implements IControladorAMProducto{

    private VentanaAMProducto vp; //se instancia en constructor
    private Producto productoAEditar;
    private boolean esModificacion = false;
    Producto p;
    
     public ControladorAMProducto() {
        this.vp = new VentanaAMProducto(null, this);
        this.esModificacion = false; //por defecto
    }
     
     public void mostrarVentanaProducto() {
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
        vp.setVisible(true);
        this.vp.verComboCategorias().setModel(new ModeloComboCategorias());
        this.vp.verComboEstado().setModel(new ModeloComboEstados());

    }

    public void inicializarModificacion(Producto p) {
        this.productoAEditar = p;
        this.esModificacion = true;

        vp.setTitle("Modificar Producto");

        vp.verTxtCodigo().setText(String.valueOf(p.verCodigo()));
        vp.verTxtCodigo().setEditable(false);
        vp.verTxtDescripcion().setText(p.verDescripcion());
        vp.verTxtPrecio().setText(String.valueOf(p.verPrecio()));
        vp.verComboCategorias().setSelectedItem(p.verCategoria().toString());
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vp.dispose();    
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
       try {
                    String codigoStr = vp.verTxtCodigo().getText().trim();
                    String descripcion = vp.verTxtDescripcion().getText().trim();
                    String precioStr = vp.verTxtPrecio().getText().trim();
                    System.out.println(codigoStr);
                    System.out.println(precioStr);
                    Categoria categoriaSeleccionada = (Categoria) vp.verComboCategorias().getSelectedItem();
                    Estado estadoSeleccionado = (Estado) vp.verComboEstado().getSelectedItem();
                    // --- INICIO DE CORRECCIÓN ---
                    // 1. Reemplazar coma por punto si existe (para asegurar el formato en Java)
                    String precioLimpio = precioStr.replace(',', '.');

                    // 2. Intentar la conversión con el string limpio
                    float precio = Float.parseFloat(precioLimpio);
                    int codigo = Integer.parseInt(codigoStr);
                    if (precioLimpio.isEmpty() || precioStr.contains(" ")) {
                    System.out.println("Problemas en el precio");
                    }
                    // --- FIN DE CORRECCIÓN ---
                    IGestorProductos gestor = GestorProductos.instanciar();
                    String resultado;

                    if (this.esModificacion==true) {
                        resultado = gestor.modificarProducto(this.productoAEditar, codigo, descripcion, precio, categoriaSeleccionada, estadoSeleccionado);
                    
                    } else {
                        resultado = gestor.crearProducto(codigo, descripcion, precio, categoriaSeleccionada, estadoSeleccionado);
              
                    }

                    JOptionPane.showMessageDialog(vp, resultado);

                    if (resultado.equals(GestorProductos.EXITO)) {
                        vp.dispose();
                    }

                } catch (NumberFormatException e) {
                   JOptionPane.showMessageDialog(vp, "El código y el precio deben ser números válidos.");
                } catch (Exception e) {
                    System.out.println("Error en guardarclic: " + e);
                }    
    }


    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        vp.verTxtDescripcion().requestFocus();
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         vp.verTxtPrecio().requestFocus();
        }
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        vp.verComboCategorias().requestFocus();
                }
    }

    public void comboCategoriasPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verComboEstado().requestFocus();
        }
    }

    public void comboEstadoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnGuardarClic(null);
        }
    }
    
    
}
