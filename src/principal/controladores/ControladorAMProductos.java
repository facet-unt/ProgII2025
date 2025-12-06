/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import static interfaces.IControladorAMProducto.TITULO_MODIFICAR;
import static interfaces.IControladorAMProducto.TITULO_NUEVO;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import principal.vistas.VentanaPrincipal;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;

/**
 *
 * @author rocio
 */
public class ControladorAMProductos implements IControladorAMProducto {

    private VentanaAMProducto ventanaAMProductos;
    private VentanaPrincipal ventanaPadre;
    private Producto producto;
    
    public ControladorAMProductos(VentanaPrincipal ventanaPadre, Producto producto) {
        System.out.println("SE INICIA CONTROLADORamPRODUCTOS ---");
        
        this.ventanaPadre= ventanaPadre;
        this.producto = producto;
        this.ventanaAMProductos = new VentanaAMProducto(ventanaPadre, this);
    
        /* ControladorAM crea el modelo de Categoria y Estado */
        ModeloComboCategorias modeloCategorias = new ModeloComboCategorias();
        ModeloComboEstados modeloEstados = new ModeloComboEstados();
         
        /*ControladorAM se encarga de dar el modelo a la ventanaAM */
        this.ventanaAMProductos.configurarCategorias(modeloCategorias);
        this.ventanaAMProductos.configurarEstados(modeloEstados);
        
        /*Control dependiendo si hay o no productos */
        if(producto == null){
           this.ventanaAMProductos.setTitle(TITULO_NUEVO);
        } 
         
        else {
        /*En caso de que la ventana sea para modificar, el controlador hace esto*/
            this.ventanaAMProductos.setTitle(TITULO_MODIFICAR);
            this.ventanaAMProductos.setCodigo(producto.verCodigo());
            this.ventanaAMProductos.setDescripcion(producto.verDescripcion());
            this.ventanaAMProductos.setPrecio(producto.verPrecio());

            // Seleccionamos los items correctos en los combos
            this.ventanaAMProductos.setCategoria(producto.verCategoria());
            this.ventanaAMProductos.setEstado(producto.verEstado());
        
            //this.ventanaAMProductos.deshabilitarCampoCodigo();
        }

        this.ventanaAMProductos.setLocationRelativeTo(null); /* Centra la ventana */
        this.ventanaAMProductos.setVisible(true); /* La hace visible */
    }
    
    
    /*Metodo para que destruye la ventana cuando se pulse el boton Cancelar */
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaAMProductos.dispose();
    }
    
    /*Metodo que guarda los datos ingresados por el usuario*/
    @Override
    public void btnGuardarClic(ActionEvent evt) {
            String resultado; 
//        int codigo = Integer.parseInt(this.txtCodigo.getText().trim());
//        String descripcion = this.txtDescripcion.getText().trim();        
//        float precio = Float.parseFloat(this.txtPrecio.getText().trim());
//        Categoria categoria = (Categoria) this.comboCategorias.getSelectedItem();
//        Estado estado = (Estado) this.comboEstados.getSelectedItem();
         
//        int codigo = this.ventanaAMProductos.obtenerCodigo();
//        String descripcion = this.ventanaAMProductos.obtenerDescripcion();
//        float precio = this.ventanaAMProductos.obtenerPrecio();
        
        JTextField txtCod = this.ventanaAMProductos.obtenerCodigo();
        JTextField txtDesc = this.ventanaAMProductos.obtenerDescripcion();
        JTextField txtPrec = this.ventanaAMProductos.obtenerPrecio();
        
        /*Como la ventana me entrega todos los datos de tipo String se lo convierte en sus respectivos tipos*/
        int codigo = Integer.parseInt(txtCod.getText().trim());
        String descripcion = txtDesc.getText().trim();
        float precio = Float.parseFloat(txtPrec.getText().trim());
        Categoria categoria = this.ventanaAMProductos.comboCategoria();
        Estado estado = this.ventanaAMProductos.comboEstado();
        
        GestorProductos gp =  GestorProductos.instanciar();
        if(this.producto == null)
        {
            resultado = gp.crearProducto(codigo, descripcion, precio, categoria, estado);
        }
        else {
            resultado = gp.modificarProducto(producto, codigo, descripcion, precio, categoria, estado);
        }
        
        System.out.println(resultado); /* muestra el problema al crear/modificar el producto*/
        if(resultado.equals("Producto creado/modificado con exito "))
        {
            System.out.println("Producto creado exitosamente");
            this.ventanaAMProductos.dispose(); /* Destruye la ventanaAMProductos */
        }
        else
        {
            System.out.println("Error al crear/modificar");
        }

    
    }
    
}
