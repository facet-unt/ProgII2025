package productos.modelos;

import interfaces.IGestorProductos;

import java.io.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.*;

public class GestorProductos implements IGestorProductos {

    private List<Producto> productos = new ArrayList<>();

    private static GestorProductos instancia;

    private GestorProductos() {

    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos con Archivos">
    @Override
    public Boolean crearArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO_P);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    private String borrarArchivo() {
        File f;
        f = new File(NOMBRE_ARCHIVO_P);
        f.delete();
        if (f != null) {
            try {
                FileWriter fw = new FileWriter(f);
                fw.close();
            } catch (IOException ex) {

            }
            return (ARCHIVO_ERROR);
        } else {
            return (ARCHIVO_BORRADO);
        }
    }

    public String guardarEnArchivo(Producto unProducto) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(NOMBRE_ARCHIVO_P, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(unProducto.verCodigo() + ";" + unProducto.verDescripcion() + ";" + unProducto.verCategoria() + ";" + unProducto.verEstado() + ";" + unProducto.verPrecio());
            bw.newLine();
            bw.flush();
            return (ESCRITURA_OK);
        } catch (IOException ioe) {
            return (ESCRITURA_ERROR);
        } finally {
            if (fw != null) {
                try {
                    fw.close();

                } catch (IOException e) {
                    return (ESCRITURA_ERROR);
                }

            }
        }
    }

    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String resultadoArchivo;
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if (codigo > 0 && descripcion != null && !descripcion.isEmpty() && precio > 0 && categoria != null && estado != null) {
            if (!productos.contains(p)) {
                productos.add(p);
                resultadoArchivo = guardarEnArchivo(p);
                if (resultadoArchivo.equals(ESCRITURA_OK)) {
                    return (EXITO);
                } else {
                    return (FRACASO);
                }
            }
            return PRODUCTOS_DUPLICADOS;

        } else {
            if (codigo < 0) {
                return (ERROR_CODIGO);
            } else if (precio < 0) {
                return (ERROR_PRECIO);
            } else if (descripcion == null || descripcion.isEmpty()) {
                return (ERROR_DESCRIPCION);
            } else if (categoria == null) {
                return (ERROR_CATEGORIA);
            } else {
                return (ERROR_ESTADO);
            }
        }

    }

    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String resultadoArchivo;
        if (productos.contains(p)) {
            productos.remove(p);
        }
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        productos.add(p);
        if (codigo > 0 && descripcion != null && precio > 0 && categoria != null && estado != null) {
            productos.add(p);
            resultadoArchivo = borrarArchivo();
            if (resultadoArchivo.equals(ARCHIVO_BORRADO)) {
                for (Producto unProducto : productos) {
                    resultadoArchivo = guardarEnArchivo(unProducto);
                    if (!(resultadoArchivo.equals(ESCRITURA_OK))) {
                        return (FRACASO);
                    }
                }
                return (EXITO);
            } else {
                return (FRACASO);
            }

        } else {
            if (codigo < 0) {
                return (EXITO);
            } else {
                if (codigo < 0) {
                    return (ERROR_CODIGO);
                } else if (precio < 0) {
                    return (ERROR_PRECIO);
                } else if (descripcion == null) {
                    return (ERROR_DESCRIPCION);
                } else if (categoria == null) {
                    return (ERROR_CATEGORIA);
                } else {
                    return (ERROR_ESTADO);
                }
            }
        }
    }

    @Override
    public List<Producto> verProductos() {
        if (!crearArchivo()) {
            return null;
        }
        File f = new File(NOMBRE_ARCHIVO_P);
        try (FileReader fr = new FileReader(f);) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] cadenas = linea.split(SEPARADOR);
                int codigo = Integer.parseInt(cadenas[0]);
                String descripcion = cadenas[1];
                Categoria categoria = Categoria.compararValor(cadenas[2]);
                Estado estado = Estado.compararValor(cadenas[3]);
                float precio = Float.parseFloat(cadenas[4]);
                Producto unProducto = new Producto(codigo, descripcion, categoria, estado, precio);
                productos.add(unProducto);

            }
        } catch (IOException e1) {
            System.out.println(LECTURA_ERROR);
        }
        return productos;
    }

    @Override
    public List<Producto> menu() {
        productos.sort(Comparator.comparing(Producto::verCategoria).thenComparing(Producto::verDescripcion));
        return this.productos;

    }

    @Override

    public List<Producto> buscarProductos(String descripcion) {

        List<Producto> encontrados = new ArrayList<>();
        for (Producto p : this.menu()) {

            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                encontrados.add(p);
            }

        }

        return encontrados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> prodcat = new ArrayList<>();
        for (Producto p : productos) {

            if (p.verCategoria() == (categoria)) {
                prodcat.add(p);
            }

        }
        prodcat.sort(Comparator.comparing(Producto::verDescripcion));
        return prodcat;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {

            if (p.verCodigo() == (codigo)) {
                return p;
            }

        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        String resultadoArchivo;
        if (productos.contains(producto) && producto != null) {
            GestorPedidos pedidos = GestorPedidos.instanciar();
            for (Pedido unPedido : pedidos.verPedidos()) {
                for (ProductoDelPedido unProducto : unPedido.verProductoPedido()) {
                    if ((unProducto.verUnProducto()).equals(producto)) // si el producto se encuentra en un pedido
                    {
                        return (BORRADO_FALLIDO + PRODUCTO_EN_PEDIDO);
                    }

                }

            }

            productos.remove(producto);
            resultadoArchivo = borrarArchivo();
            if (resultadoArchivo.equals(ARCHIVO_BORRADO)) {
                for (Producto unProducto : productos) {
                    resultadoArchivo = guardarEnArchivo(unProducto);
                    if (!(resultadoArchivo.equals(ESCRITURA_OK))) {
                        return (BORRADO_FALLIDO);
                    }
                }
                return (OPERACION_EXITOSA);
            } else {
                return (BORRADO_FALLIDO);
            }

        } else {
            productos.remove(producto);
            return (OPERACION_EXITOSA);
        }
    }
}
