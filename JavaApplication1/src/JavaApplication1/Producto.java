package JavaApplication1;
import java.util.List;

public class Producto {
//Atributos
    String direccion;
    archivo ArProductos;
    
//Constructor
    public Producto(String direccion){
        this.direccion = direccion;
        this.ArProductos = new archivo(direccion);
        
    };
//getters setters
    public List<String> getProductos(){
        List<String> clientes = ArProductos.leerTxt();
        return clientes;
    }}

