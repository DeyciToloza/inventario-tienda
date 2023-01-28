package JavaApplication1;
import java.util.List;

public class Cliente {
//Atributos
    String direccion;
    archivo ArClientes;
    
//Constructor
    public Cliente(String direccion){
        this.direccion = direccion;
        this.ArClientes = new archivo(direccion);
        
    };
//getters setters
    public List<String> getClientes(){
        List<String> clientes = ArClientes.leerTxt();
        return clientes;
    }}
