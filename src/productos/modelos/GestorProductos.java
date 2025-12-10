package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;

import java.io.*;
import java.util.*;

import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

public class GestorProductos implements IGestorProductos {

    private static GestorProductos instancia;
    private final List<Producto> productos = new ArrayList<>();

    private GestorProductos() {
        cargarDesdeArchivo();
    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    @Override
    public String crearProducto(int codigo, String descripcion, float precio,
                                Categoria categoria, Estado estado) {

        String error = validarDatos(codigo, descripcion, precio, categoria, estado);
        if (error != null) return error;

        Producto nuevo = new Producto(codigo, descripcion, categoria, estado, precio);

        if (productos.contains(nuevo))
            return PRODUCTOS_DUPLICADOS;

        productos.add(nuevo);
        guardarEnArchivo();
        return EXITO;
    }

    @Override
    public String modificarProducto(Producto existente, int codigo, String descripcion,
                                    float precio, Categoria categoria, Estado estado) {

        if (!productos.contains(existente))
            return PRODUCTO_INEXISTENTE;

        String error = validarDatos(codigo, descripcion, precio, categoria, estado);
        if (error != null) return error;

        int indice = productos.indexOf(existente);
        productos.remove(existente);

        existente.asignarCodigo(codigo);
        existente.asignarDescripcion(descripcion);
        existente.asignarPrecio(precio);
        existente.asignarCategoria(categoria);
        existente.asignarEstado(estado);

        if (productos.contains(existente)) {
            productos.add(indice, new Producto(
                existente.verCodigo(), 
                existente.verDescripcion(), 
                existente.verCategoria(), 
                existente.verEstado(), 
                existente.verPrecio()
            ));
            return PRODUCTOS_DUPLICADOS;
        }

        productos.add(existente);
        guardarEnArchivo();
        return EXITO;
    }

    @Override
    public String borrarProducto(Producto p) {

        if (!productos.contains(p))
            return PRODUCTO_INEXISTENTE;


        IGestorPedidos gp = GestorPedidos.getInstancia();
        for (Pedido ped : gp.verPedidos()) {
            for (ProductoDelPedido pp : ped.verProductosDelPedido()) {
                if (pp.verUnProducto().equals(p)) {
                    return "No se puede borrar el producto porque está asociado a un pedido";
                }
            }
        }

        productos.remove(p);
        guardarEnArchivo();
        return "Producto borrado con éxito";
    }

    @Override
    public List<Producto> menu() {
        Collections.sort(productos);
        return new ArrayList<>(productos); 
    }

    @Override
    public List<Producto> buscarProductos(String texto) {
        String buscado = texto.toLowerCase();
        List<Producto> lista = new ArrayList<>();

        for (Producto p : productos) {
            if (p.verDescripcion().toLowerCase().contains(buscado)) {
                lista.add(p);
            }
        }

        Collections.sort(lista);
        return lista;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        return productos.stream()
                .filter(p -> p.verCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> verProductosPorCategoria(Categoria cat) {
        List<Producto> lista = new ArrayList<>();

        for (Producto p : productos) {
            if (p.verCategoria() == cat) {
                lista.add(p);
            }
        }

        Collections.sort(lista);
        return lista;
    }

    private void cargarDesdeArchivo() {
        productos.clear();
        File file = new File(NOMBREARCHIVO);

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(CREACION_OK);
            } catch (IOException e) {
                System.out.println(CREACION_ERROR);
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.replace("\uFEFF", "").trim();
                if (linea.isEmpty()) continue;

                String[] p = linea.split("\\*"); 

                if (p.length != 5) {
                    System.err.println("Línea mal formateada: " + linea);
                    continue;
                }

                try {
                    int codigo = Integer.parseInt(p[0].trim());
                    String desc = p[1].trim();
                    float precio = Float.parseFloat(p[2].trim());
                    Categoria cat = Categoria.valueOf(p[3].trim().toUpperCase());
                    Estado est = Estado.valueOf(p[4].trim().toUpperCase());

                    productos.add(new Producto(codigo, desc, cat, est, precio));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parseando línea: " + linea + " -> " + e.getMessage());
                }
            }

            System.out.println(LECTURA_OK + " - " + productos.size() + " productos cargados");

        } catch (IOException e) {
            System.out.println(LECTURA_ERROR);
            e.printStackTrace();
        }
    }

    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBREARCHIVO))) {
            for (Producto p : productos) {
                String linea = p.verCodigo() + "*" +
                              p.verDescripcion() + "*" +
                              p.verPrecio() + "*" +
                              p.verCategoria() + "*" +
                              p.verEstado();
                bw.write(linea);
                bw.newLine();
            }

            System.out.println(ESCRITURA_OK);

        } catch (IOException e) {
            System.out.println(ESCRITURA_ERROR);
            e.printStackTrace();
        }
    }

    private String validarDatos(int codigo, String desc, float precio,
                                Categoria cat, Estado est) {

        if (codigo <= 0) return ERROR_CODIGO;
        if (desc == null || desc.trim().isEmpty()) return ERROR_DESCRIPCION;
        if (precio <= 0) return ERROR_PRECIO;
        if (cat == null) return ERROR_CATEGORIA;
        if (est == null) return ERROR_ESTADO;

        return null;
    }
}

