package JavaApplication1;
import java.util.List;

public class Producto {
//Atributos
    String dirProducto;
    String dirPrecio;
    archivo ArProductos;
    archivo ArPrecios;
    
//Constructor
    public Producto(String dirProducto,String dirPrecio){
        this.dirProducto = dirProducto;
        this.dirPrecio = dirPrecio;
        this.ArProductos = new archivo(dirProducto);
        this.ArPrecios = new archivo(dirPrecio);
        
    };
//getters setters
    public List<String> getProductos(){
        List<String> clientes = ArProductos.leerTxt();
        return clientes;
    };
    public List<String> getPrecio(){
    List<String> precio = ArPrecios.leerTxt();
    return precio;
    }
};
 