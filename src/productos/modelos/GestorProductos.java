
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
   

     private Producto convertirLineaAProducto(String linea) throws IllegalArgumentException {
        if (linea == null || linea.isBlank())
            return null;

        String[] partes = linea.split(SEPARADOR_ARCHIVO);

        if (partes.length != 5)
            throw new IllegalArgumentException("Formato inválido en la línea del archivo");

        int codigo = Integer.parseInt(partes[0].trim());
        String descripcion = partes[1].trim();
        float precio = Float.parseFloat(partes[2].trim());
        
        Categoria categoria = Categoria.desdeTexto(partes[3].trim());
        Estado estado = Estado.desdeTexto(partes[4].trim());

        return new Producto(codigo, descripcion, categoria, estado, precio);
    }
    
    
    @Override
    public String leerProductoConArchivo(){
        File prodArchivo = new File(NOMBRE_ARCHIVO_P);
        if(!prodArchivo.exists()){
            try{
                if(prodArchivo.createNewFile()){
                    return CREACION_OK; //Si el archivo se creo correctamente
                }
                else {
                    return CREACION_ERROR;
                }
            } catch(IOException e){
                return CREACION_ERROR;
            }
        }
        // Hago un try con argumento
        try(BufferedReader br = new BufferedReader (new FileReader(prodArchivo))){
            productos.clear(); //Evitamos que se dupliquen los productos si se vuelve a leer
            String linea;
            
            while((linea = br.readLine())!=null){
                linea=linea.trim();
                Producto p = convertirLineaAProducto(linea);
                if(p!=null && !productos.contains(p)){
                    productos.add(p);
                }
            }
            return LECTURA_OK;
        }
        catch(IOException | IllegalArgumentException e){
            return LECTURA_ERROR;
        } 
    }
   

    private GestorProductos() {
        
        this.leerProductoConArchivo();
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

    @Override
    public String guardarEnArchivo(Producto unProducto) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(NOMBRE_ARCHIVO_P);
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
    public String guardarEnArchivoAgregar (Producto unProducto) {
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
   
        if (codigo>0 && descripcion != null && !descripcion.isEmpty() && precio > 0 && categoria != null && estado != null) {
            if (!productos.contains(p)) {
                productos.add(p);
                resultadoArchivo = guardarEnArchivoAgregar(p);
                if (resultadoArchivo.equals(ESCRITURA_OK)) {
                    menu();
                    return (EXITO);
                 } else {
                    return (FRACASO);
                }
            }
            else
            {
                return PRODUCTOS_DUPLICADOS;
            }

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
    
    private String validarDatosProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
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
        return null;
    }

    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String resultadoArchivo;
        if (p==null){
            return PRODUCTO_INEXISTENTE;
        }
        String error = validarDatosProducto(codigo, descripcion, precio, categoria, estado);
        if (error != null)
            return error;
        
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        
        resultadoArchivo = guardarEnArchivo(p);
        if (resultadoArchivo.equals(ESCRITURA_OK))
        {
            menu();
            return EXITO;
        }
        else
            return FRACASO;
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
        String resultadoArchivo;
        productos.sort(Comparator.comparing(Producto::verCategoria).thenComparing(Producto::verDescripcion));
        for (Producto p: productos)
        {
            resultadoArchivo= guardarEnArchivo(p);
            if (resultadoArchivo.equals (ESCRITURA_ERROR))
            {
                System.out.println("No se pudieron ordenar los productos en el archivo");
                break;
            }
        }
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
        if (producto == null) {
            return PRODUCTO_INEXISTENTE;
        }
   
        GestorPedidos gp = GestorPedidos.instanciar();
        if (gp.hayPedidosConEsteProducto(producto)) {
            return "No se puede borrar el producto, existen pedidos con el mismo.";
        }
    
        if (productos.remove(producto)) {
            for (Producto p: productos)
            {
            guardarEnArchivo(p);
            }
            menu();
            return "Producto borrado con éxito.";
        } else {
            return PRODUCTO_INEXISTENTE;
        }
    }
}
 
