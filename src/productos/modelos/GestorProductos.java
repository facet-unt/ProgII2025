package productos.modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.IGestorPedidos;


public class GestorProductos implements IGestorProductos{
    private List<Producto> productos = leerProductos();
    
    private static GestorProductos instancia;
    
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    public static final String LECTURA_ERROR = "Error al leer los productos";
    public static final String CREACION_ERROR = "Error al crear el archivo de productos";
    public static final String LECTURA_OK = "Se pudieron leer los productos";
    public static final String CREACION_OK = "Se pudo crear el archivo de productos";
    public static final String ESCRITURA_OK = "Se pudieron guardar los productos";
    public static final String ESCRITURA_ERROR = "Error al guardar los productos";
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!(codigo>0))
            return ERROR_CODIGO;
        if(descripcion == null || descripcion == "")
            return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if(productos.contains(p))
            return PRODUCTOS_DUPLICADOS;
        
        guardarProducto(p);
        
        productos.add(p);
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(!this.productos.contains(p))
            return PRODUCTO_INEXISTENTE;
        if (codigo <= 0)
            return ERROR_CODIGO;
        if(descripcion == null || descripcion.equals(""))
            return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);

        return EXITO;
    }
    
    @Override
    public List<Producto> menu() {
        Collections.sort(productos, Producto.categoriaComp);
        Collections.sort(productos, Producto.descripcionComp);
        return this.productos;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        int i=0;
        List<Producto> productosPorDescripcion = new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion().equalsIgnoreCase(descripcion)){
                productosPorDescripcion.add(p);
                i++;
            }
        }
        if(i == 0)
            System.out.println(PRODUCTO_INEXISTENTE);
        
        Collections.sort(productos);
        return productosPorDescripcion;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        if(!productos.contains(producto)){
            System.out.println(PRODUCTO_INEXISTENTE);
            return false;
        }
        return true;
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        int i = 0;
        List<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria() == categoria){
                productosPorCategoria.add(p);
                i++;
            }
        }
        if (i == 0)
            System.out.println(PRODUCTO_INEXISTENTE);
        
        Collections.sort(productos, Producto.descripcionComp);
        return productosPorCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        if(codigo>0){
            for(Producto p: productos){
                if(p.verCodigo() == codigo){
                    System.out.println(VALIDACION_EXITO);
                    return p;
                }
            }
        } else {
            System.out.println(ERROR_CODIGO);
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        IGestorPedidos gPed = GestorPedidos.instanciar();
        if(producto != null && productos.contains(producto)){
            if(!gPed.hayPedidosConEsteProducto(producto)){
                productos.remove(producto);
                return EXITO;
            } else {
                return "No se ha podido borrar este producto ya que hay un pedido que lo contiene \n";
            }
        } else {
            return PRODUCTO_INEXISTENTE;
        }
    }

    private String guardarProducto(Producto p) {
        String atributosProducto;
        atributosProducto = "," + p.verCodigo() + "," + p.verDescripcion() + "," + p.verCategoria() + "," + p.verEstado() + "," 
                            + p.verPrecio() + "," +"\n";
        if (!existeEsteProducto(p)){
            File archivo = new File("Productos.txt");
            try (FileWriter fw = new FileWriter(archivo, true)){
                try(BufferedWriter bw = new BufferedWriter(fw)){
                    bw.write(atributosProducto);
                } catch (IOException e) {
                    return ESCRITURA_ERROR;
                }
            } catch (IOException e){
                return CREACION_ERROR;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else {
            return PRODUCTOS_DUPLICADOS;
        }      
        return ESCRITURA_OK;
    }
    
    private List<Producto> leerProductos(){
        int caracter, i = 1;
        Producto p;
        String productos = "";
        String[] cadenas;
        List<Producto> productosArchivo= new ArrayList<>();
        File archivo = new File("Productos.txt");
        try (FileReader fr = new FileReader(archivo)){
            while ((caracter = fr.read()) != -1){
                productos += ((char) caracter );
            }
            
            cadenas = productos.split(",");
            while (i < cadenas.length){
                int codigo = Integer.parseInt(cadenas[i]);
                if(codigo <= 0){
                    System.out.println(ERROR_CODIGO);
                    return null;
                }
                i++;
                String descripcion = cadenas[i];
                if (descripcion == null || descripcion.equals("")){
                    System.out.println(ERROR_DESCRIPCION);
                    return null;
                }
                i++;

                Categoria categoria;
                if(cadenas[i].equals(Categoria.ENTRADA.toString())){
                    categoria = Categoria.ENTRADA;
                } else if(cadenas[i].equals(Categoria.PLATO_PRINCIPAL.toString())) {
                    categoria = Categoria.PLATO_PRINCIPAL;
                } else if(cadenas[i].equals(Categoria.POSTRE.toString())) {
                    categoria = Categoria.POSTRE;
                } else {
                    System.out.println(ERROR_CATEGORIA);
                    return null;
                }
                i++;

                Estado estado;
                if(cadenas[i].equals(Estado.DISPONIBLE.toString())){
                    estado = Estado.DISPONIBLE;
                } else if (cadenas[i].equals(Estado.NO_DISPONIBLE.toString())){
                    estado = Estado.NO_DISPONIBLE;
                } else {
                    System.out.println(ERROR_ESTADO);
                    return null;
                }
                i++;

                float precio = Float.parseFloat(cadenas[i]);
                if (precio <= 0){
                    System.out.println(ERROR_PRECIO);
                    return null;
                }
                i = i+2;
                p = new Producto(codigo, descripcion, categoria, estado, precio);
                productosArchivo.add(p);
            }
        } catch (Exception e) {
            System.out.println(LECTURA_ERROR);
            return null;
        }
        System.out.println(LECTURA_OK);
        return productosArchivo;
    }
}
