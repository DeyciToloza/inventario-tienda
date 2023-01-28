package JavaApplication1;
import java.util.List;

public class Venta {
//Atributos
    String direccion;
    archivo ArVentas;
    
//Constructor
    public Venta(String direccion){
        this.direccion = direccion;
        this.ArVentas = new archivo(direccion);
        
    };
//getters setters
    public void setVenta(String Dato){
        ArVentas.grabar(Dato);
    }}
