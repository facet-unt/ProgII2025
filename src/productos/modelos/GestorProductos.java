package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos {

    private List<Producto> productos = new ArrayList();
    File archivoProductos = new File(NOMBREARCHIVO);
    public static final String NOMBREARCHIVO = "productos.txt";
    public static final String SEPARADOR = "_";

    private static GestorProductos instancia;

    private GestorProductos() {

    }

    private void creacionArchivo() {
        if (!archivoProductos.exists()) {
            try {
                archivoProductos.createNewFile();
                System.out.println(CREACION_OK);
            } catch (IOException e) {
                System.out.println(CREACION_ERROR);
            }
        }
    }

    private void guardarArchivo(Producto unProducto) {
        creacionArchivo();
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(archivoProductos,true))) {
            escritura.write(Integer.toString(unProducto.verCodigo()));
            escritura.write(SEPARADOR);
            escritura.write(unProducto.verDescripcion());
            escritura.write(SEPARADOR);
            escritura.write(unProducto.verCategoria().toString());
            escritura.write(SEPARADOR);
            escritura.write(unProducto.verEstado().toString());
            escritura.write(SEPARADOR);
            escritura.write(Float.toString(unProducto.verPrecio()));
            escritura.newLine();
            
            System.out.println(ESCRITURA_OK);
        } catch (IOException e) {
            System.out.println(ESCRITURA_ERROR);
        }

    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    @Override
    public String borrarProducto(Producto producto) {
        if (producto == null || !productos.contains(producto)) {
            return PRODUCTO_INEXISTENTE;
        }
        //verifica si hay pedidos que contengan el producto
        GestorPedidos gpedidos = GestorPedidos.instanciar();
        if (gpedidos.hayPedidosConEsteProducto(producto)) {
            return "no se puede borrar el producto porque tiene pedidos asociados";
        }
        productos.remove(producto);
        return EXITO_BORRADO;
    }

    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo < 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio < 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        System.out.println(VALIDACION_EXITO);
        Producto unProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(unProducto);
        guardarArchivo(unProducto);

        return EXITO;

    }

    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo < 0) {
            return ERROR_CODIGO;
        } else {
            for (Producto producto : productos) {
                if (producto.verCodigo() == codigo) {
                    return PRODUCTOS_DUPLICADOS;
                }
            }
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio < 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        System.out.println(VALIDACION_EXITO);
        p.asignarCodigo(codigo);
        p.asignarPrecio(precio);
        p.asignarDescripcion(descripcion);
        p.asignarEstado(estado);
        p.asignarCategoria(categoria);

        return EXITO;
    }

    @Override
    public List<Producto> menu() {
        Collections.sort(productos);
        return this.productos;
    }

    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                encontrados.add(p);
            }
        }
        Collections.sort(encontrados);
        return encontrados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto)) {
            return productos.contains(producto);
        }
        System.out.println(PRODUCTO_INEXISTENTE);
        return false;
    }

    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                encontrados.add(p);
            }
        }
        Comparator<Producto> descComp = (p1, p2) -> p1.verDescripcion().compareTo(p2.verDescripcion());
        Collections.sort(encontrados, descComp);
        return encontrados;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        System.out.println(PRODUCTO_INEXISTENTE);
        return null;
    }
}
