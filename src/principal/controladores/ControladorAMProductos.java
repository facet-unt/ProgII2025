/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstado;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;

/**
 *
 * @author Esteban
 */
public class ControladorAMProductos implements IControladorAMProducto{

    private final VentanaAMProducto ventana;
    private static ControladorAMProductos instancia;
    private Producto productoAModificar;
    
    private ControladorAMProductos() {
        this.ventana = new VentanaAMProducto(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
        this.productoAModificar = null;
        agregarEnterListener(this.ventana.verTxtCodigo(), this.ventana.verTxtDescripcion());
        agregarEnterListener(this.ventana.verTxtDescripcion(), this.ventana.verTxtPrecio());
    }
    
    public static ControladorAMProductos instanciar(Producto producto) {
        if (instancia == null) {
            instancia = new ControladorAMProductos();
        }
        
        instancia.productoAModificar = producto;
        
        if (producto == null) {
            instancia.ventana.setTitle(TITULO_NUEVO);
            instancia.ventana.limpiarCampos();
        }
        else {
            instancia.ventana.setTitle(TITULO_MODIFICAR);
            
            // LLeno los datos del producto que quiero modificar
            instancia.ventana.verTxtCodigo().setText(String.valueOf(producto.verCodigo()));
            instancia.ventana.verTxtDescripcion().setText(producto.verDescripcion());
            instancia.ventana.verTxtPrecio().setText(String.valueOf(producto.verPrecio()));
            instancia.ventana.verTxtCategoria().setName(producto.verCategoria().name());
            instancia.ventana.verTxtEstado().setName(producto.verEstado().name());
        }
        
        instancia.ventana.setVisible(true);
        
        return instancia;
    }
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }
   
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorProductos gp = GestorProductos.instanciar();
        String resultado;
        
        // Variables locales para almacenar los datos convertidos
        int codigo = 0;
        float precio = 0.0f;
        String codigoTexto = this.ventana.verTxtCodigo().getText().trim();
        String precioTexto = this.ventana.verTxtPrecio().getText().trim();
        String descripcion = this.ventana.verTxtDescripcion().getText().trim();
        Categoria categoria = ((ModeloComboCategorias)this.ventana.verTxtCategoria().getModel()).obtenerCategoria();
        Estado estado = ((ModeloComboEstado)this.ventana.verTxtEstado().getModel()).obtenerEstado();
        
        try {
            if (codigoTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this.ventana, "El campo Código no puede estar vacío.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return; // Detenemos la ejecución
            }
            if (precioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this.ventana, "El campo Precio no puede estar vacío.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return; // Detenemos la ejecución
            }
            codigo = Integer.parseInt(codigoTexto);
            precio = Float.parseFloat(precioTexto);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.ventana, 
                    "Error: El Código y el Precio deben ser valores numéricos.\n" +
                    "Por favor verifique que no haya letras ni símbolos.", 
                    "Error de Conversión", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (this.productoAModificar == null) {
           resultado = gp.crearProducto(codigo, descripcion, precio, categoria, estado);
        }
        else {
            resultado = gp.modificarProducto(productoAModificar, codigo, descripcion, precio, categoria, estado);
        }
        
        if (!resultado.equals(IGestorProductos.EXITO)){
            JOptionPane.showMessageDialog(this.ventana, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this.ventana, resultado, "Éxito", JOptionPane.INFORMATION_MESSAGE); 
            this.ventana.limpiarCampos();
        } 
    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
    }
    
    private void agregarEnterListener(JTextField currentField, JTextField nextField) {
            currentField.addKeyListener(new KeyAdapter() {
             @Override
             public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                  nextField.requestFocus();
                  }
             }
         });
        }
    
}
