/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaApplication1;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author USUARIO
 */
public class JavaApplication1 {
    
    public static void main(String[] args) {
        //leer un TXT       
//        archivo ArClientes = new archivo("Txt\\clientes.txt");
//        archivo ArProductos = new archivo("Txt\\productos.txt");
        archivo ArPrecios = new archivo("Txt\\precios.txt");
        archivo ArVentas = new archivo("Txt\\ventas.txt");
        
        
        Cliente cliente = new Cliente("Txt\\clientes.txt");
        List<String> clientes = cliente.getClientes();
        Producto producto = new Producto("Txt\\productos.txt");
        List<String> productos = producto.getProductos();
        List<String> precios = ArPrecios.leerTxt();
        
        
        
        
        
        Frame miFrame;
 
        //Panel principal
        Panel panel_filas = new Panel();
        panel_filas.setLayout(new BorderLayout());
        panel_filas.setLayout(new GridLayout(6,1));
    
        //Panel cliente
        Panel panel_cliente = new Panel();
        Label label_cliente = new Label("Elija el cliente:");
        Choice choice_cliente = new Choice();
        for( String cli: clientes){
            choice_cliente.addItem(cli);
        }
        panel_cliente.setLayout(new BorderLayout());
        panel_cliente.add(label_cliente, BorderLayout.WEST);
        panel_cliente.add(choice_cliente, BorderLayout.CENTER);
       
        //Panel producto
        Panel panel_producto = new Panel();
        Label label_producto = new Label("Elija el producto:");  
        Choice choice_producto = new Choice();
        for(String prod : productos){
            choice_producto.addItem(prod);
        }
        panel_producto.setLayout(new BorderLayout());
        panel_producto.add(label_producto, BorderLayout.WEST);
        panel_producto.add(choice_producto, BorderLayout.CENTER);
        
        //Panel valor
        Panel panel_valor = new Panel();
        Label label_valor = new Label("valor unidad:");  
        Label label_val = new Label(precios.get(choice_producto.getSelectedIndex()));
        panel_valor.setLayout(new BorderLayout());
        panel_valor.add(label_valor, BorderLayout.WEST);
        panel_valor.add(label_val, BorderLayout.CENTER);
    
        //Panel cantidad
        Panel panel_cantidad = new Panel();
        Label label_cantidad  = new Label("Escriba la cantidad:");
        TextField text_cantidad = new TextField(30);  
        panel_cantidad.setLayout(new BorderLayout());
        panel_cantidad.add(label_cantidad, BorderLayout.WEST);
        panel_cantidad.add(text_cantidad, BorderLayout.CENTER);
    
        //Panel agregar
        Panel panel_agregar= new Panel();
        Button button_agregar = new Button( "Agregar producto" );
        panel_agregar.add(button_agregar);

        //Se añaden los paneles
        panel_filas.add(panel_cliente);
        panel_filas.add(panel_producto);
        panel_filas.add(panel_valor);
        panel_filas.add(panel_cantidad);
        panel_filas.add(panel_agregar);
    
       
        // Instancia un objeto Frame con su titulo indicativo de que se
        // se trata, utilizando un FlowLayout
        miFrame = new Frame( "APP tienda" );
        miFrame.setLayout( new FlowLayout() );

        // Añade tres objetos Button al Frame
        miFrame.add( panel_filas, BorderLayout.CENTER );  

        // Fija el tamaño del Frame y lo hace visible
        miFrame.setSize( 500,500 );
        miFrame.setVisible( true );    

        // Instancia y registra objetos ActionListener sobre los
        // tres botones utilizando la sintaxis abreviada de las
        // clases anidadas
        button_agregar.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent evt ) {               
                String vCliente = choice_cliente.getSelectedItem();
                String vProducto = choice_producto.getSelectedItem() ;
                String vPrecio = precios.get(choice_producto.getSelectedIndex()) ;
                String vCantidad =  text_cantidad.getText() ;
                int total = Integer.parseInt(vPrecio)*Integer.parseInt(vCantidad);
                String venta = vCliente + "  " + vProducto + "  " + vPrecio + "  " + vCantidad + "  " + Integer.toString(total) + "\n";
                System.out.println(venta);
                ArVentas.grabar(venta);
            }
        } );
        
        choice_producto.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent ie) {
            label_val.setText(precios.get(choice_producto.getSelectedIndex()));
         }
      });

        // Instancia y registra un objeto WindowListener sobre el objeto
        // Frame para terminar el programa cuando el usuario haga click
        // con el raton sobre el boton de cerrar la ventana que se 
        // coloca sobre el objeto Frame
            miFrame.addWindowListener( new WindowAdapter() {
                public void windowClosing( WindowEvent evt ) {
                    // Concluye la aplicacion cuando el usuario cierra la 
                   // ventana
                    System.exit( 0 );
                    }
                } );
            }  
   
    
}







