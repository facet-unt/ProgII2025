package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

public class GestorProductos implements IGestorProductos {

    public static final String ARCHIVO = "Productos.txt";

    public static final String SEPARADOR = "*";

    private final List<Producto> productos = new ArrayList();

    private static GestorProductos instancia;

    private GestorProductos() {
        cargarArchivoEnLista();
    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }
//<editor-fold defaultstate="collapsed" desc="Nombre">

    //</editor-fold>
    @Override
    public String borrarProducto(Producto producto) {
//      
        IGestorPedidos gped = GestorPedidos.instanciar();
        for (Pedido p : gped.verPedidos()) {
            for (ProductoDelPedido pdp : p.getCantidadProducto()) {
                if (pdp.getUnProducto().equals(producto)) {
                    return BORRADO_ERROR;
                }
            }
        }
        if(!productos.contains(producto)){
            return PRODUCTO_INEXISTENTE;
        }
        productos.remove(producto);

        cargarListaProductosEnArchivo();

        return BORRADO_EXITO;
    }

    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if (productos.contains(p)) {
            return PRODUCTOS_DUPLICADOS;
        } else {

            productos.add(p);
            cargarListaProductosEnArchivo();
        }
        return VALIDACION_EXITO;

    }

    private void cargarArchivoEnLista() {
        productos.clear();
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println(CREACION_OK);
            } catch (IOException e) {
                System.out.println(CREACION_ERROR);
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split("\\*");
                if (partes.length != 5) {
                    continue;
                }
                int codigo = Integer.parseInt(partes[0]);
                String desc = partes[1];
                float precio = Float.parseFloat(partes[2]);
                Categoria cat = Categoria.valueOf(partes[3]);
                Estado est = Estado.valueOf(partes[4]);
                productos.add(new Producto(codigo, desc, cat, est, precio));
            }
            System.out.println(LECTURA_OK);

        } catch (Exception e) {
            System.out.println(LECTURA_ERROR);
        }
    }

    private void cargarListaProductosEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, false))) {

            for (Producto p : productos) {
                bw.write(p.verCodigo() + SEPARADOR
                        + p.verDescripcion() + SEPARADOR
                        + p.verPrecio() + SEPARADOR
                        + p.verCategoria() + SEPARADOR
                        + p.verEstado());
                bw.newLine();
            }

            System.out.println(ESCRITURA_OK);
        } catch (IOException ex) {
            System.out.println(ESCRITURA_ERROR);
        }

    }

    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        if (!productos.contains(p)) {
            return PRODUCTO_INEXISTENTE;
        }
        productos.remove(p);
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        if (productos.contains(p)) {
            return PRODUCTOS_DUPLICADOS;
        }
        productos.add(p);
        cargarListaProductosEnArchivo();
        return EXITO;
    }

    @Override
    public List<Producto> menu() {
        Collections.sort(productos);
        return this.productos;
    }

    @Override
    public List<Producto> buscarProductos(String descripcion) {
//        List<Producto> prod = new ArrayList();
//
//        for (Producto p : productos) {
//            if (p.verDescripcion().contains(descripcion)) {
//                prod.add(p);
//            }
//
//        }
//        Collections.sort(prod);
//        return prod;

        List<Producto> prod = new ArrayList<>();

        String buscada = descripcion.toLowerCase();

        for (Producto p : productos) {
            String desc = p.verDescripcion();
            if (desc != null && desc.toLowerCase().contains(buscada)) {
                //aca creo q no es necesario el null xq no se crearia sino pero por las dudas
                prod.add(p);
            }
        }

        Collections.sort(prod);
        return prod;
    }

    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> productosPorCategoria = new ArrayList();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                productosPorCategoria.add(p);
            }
        }
        Collections.sort(productosPorCategoria);
        return productosPorCategoria;
    }

    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}
