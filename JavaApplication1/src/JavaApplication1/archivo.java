/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaApplication1;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 *
 * @author USUARIO
 */
public class archivo {
    
    List<String> texto = new ArrayList<String>();
    String direccion;
    
    public archivo(String direccion){
       this.direccion = direccion; 
    }
        
    // Leer archivo
    public List<String> leerTxt(){       
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            // Mientras bf tenga datos
            while((bfRead = bf.readLine()) != null){
                texto.add(bfRead);
            }           
                                   
        }catch(Exception e){System.err.println("No se encontro archivo");}
        
        return texto;
    }
    
    public void grabar(String Dato){
        FileWriter fileWriter; PrintWriter printWriter;
        try {
            fileWriter=new FileWriter(direccion,true);
            printWriter=new PrintWriter(fileWriter);
            printWriter.println(Dato); fileWriter.close();
        }
        catch (Exception exception){ }
    }
}
