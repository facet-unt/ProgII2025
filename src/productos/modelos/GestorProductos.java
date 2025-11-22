package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos {

    private List<Producto> productos = new ArrayList<>();

    private static GestorProductos instancia;

    private final String NOMBRE_ARCHIVO = "productos.txt";

    private GestorProductos() {

    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String resultado = validarDatosProducto(codigo, descripcion, precio, categoria, estado);
        if (!resultado.equals(VALIDACION_EXITO)) {
            return resultado;
        }
        Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(nuevoProducto);
        return EXITO;
    }

    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (!(codigo > 0)) {
            return ERROR_CODIGO;
        }
        if (descripcion == null) {
            return ERROR_DESCRIPCION;
        }
        if (descripcion.trim().isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (!(precio > 0)) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }

        if (estado == null) {
            return ERROR_ESTADO;
        }
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        return EXITO;
    }

    @Override
    public List<Producto> menu() {
        List<Producto> copia = new ArrayList<>(productos);
        copia.sort((p1, p2) -> {
            int copararCategoria = p1.verCategoria().compareTo(p2.verCategoria());
            if (copararCategoria != 0) {
                return copararCategoria;
            }
            return p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion());
        });

        return copia;

    }

    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto u : productos) {
            if (u.verDescripcion().toUpperCase().contains(descripcion.toUpperCase())) { //Se Empleo el toUpperCase y toUpperCase para permitir la busqueda parcial 
                resultados.add(u);
            }
        }
        resultados.sort((p1, p2) -> {
            int copararCategoria = p1.verCategoria().compareTo(p2.verCategoria());
            if (copararCategoria != 0) {
                return copararCategoria;
            }
            return p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion());
        });
        return resultados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto u : productos) {
            if (u.verCategoria().equals(categoria)) {
                resultados.add(u);
            }
        }
        resultados.sort((p1, p2) -> p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion()));
        return resultados;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto u : productos) {
            if (u.verCodigo() == codigo) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        GestorPedidos gPedidos = GestorPedidos.instanciar();
        if (gPedidos.hayPedidosConEsteProducto(producto) == true) {
            return PRODUCTO_EN_PEDIDO;
        } else {
            productos.remove(producto);
            return PRODUCTO_BORRADO;
        }
    }

    private String validarDatosProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!(codigo > 0)) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (!(precio > 0)) {
            return ERROR_PRECIO;

        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }

        if (estado == null) {
            return ERROR_ESTADO;
        }
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return PRODUCTOS_DUPLICADOS;
            }
        }
        return VALIDACION_EXITO;
    }

    public void leerArchivo() {
        File file = new File(NOMBRE_ARCHIVO);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] v = linea.split(",");

                Producto prod = new Producto(Integer.parseInt(v[0]), v[1], Categoria.valueOf(v[3]), Estado.valueOf(v[4]), Float.parseFloat(v[2]));
                productos.add(prod);
            }

            System.out.println(LECTURA_OK);

        } catch (IOException ex) {
            System.out.println(LECTURA_ERROR);
            System.out.println(ex.getMessage());
        }
    }

}
