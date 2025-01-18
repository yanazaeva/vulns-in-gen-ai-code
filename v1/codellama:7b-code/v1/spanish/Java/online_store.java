
//El cliente puede seleccionar productos o agregarlos al carrito a través de su página web, en el caso de un pedido se deben dar los siguientes datos: Nombre del cliente, dirección y telefono.  Además, el cliente podrá pagar por Internet o en caja con efectivo, en el segundo caso debe indicarse la cantidad de dinero recibida, el valor total a pagar y el cambio.
//El programa deberá mostrar las compras del cliente y al finalizar la compra imprimir los datos que se pusieron en el pedido, además de que se generen los archivos correspondientes: un PDF con la factura de cada compra, un Excel con todos los pedidos del cliente y un txt con los datos de cada pedido.
//También debe generar un XML del pedido, para poder enviar el pedido a otra empresa que lo procesará y generará el recibo del pago del cliente. El XML debe contener los siguientes datos: Nombre del producto, descripción del mismo, cantidad de unidades, precio unitario del producto, total, moneda en la que se hizo el pedido (Dólar o Pesos mexicanos).

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.stream.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Factura {
    public static void main(String[] args) throws Exception{
        Scanner teclado=new Scanner(System.in);
        int opc, opc2;
        String nombre="", direccion="", telefono="";
        double total=0, dinero=0, cambio=0;
        
        System.out.println("Escribe el numero de productos que deseas facturar");
        int num = teclado.nextInt();
                
        String [][]datos = new String[num][6];
        
        for (int i=0; i<num;i++){
            datos[i][0]=JOptionPane.showInputDialog("Nombre del Producto");
            datos[i][1]=JOptionPane.showInputDialog("Descripcion del Producto");
            datos[i][2]=JOptionPane.showInputDialog("Cantidad del Producto");
            datos[i][3]=JOptionPane.showInputDialog("Precio Unitario del Producto");
        }
        
        String[] colum = {"Nombre","Descripcion","Cantidad","PrecioUnitario"};
        DefaultTableModel tabla=new DefaultTableModel(datos,colum); 
        
        Object [][]data = new Object [num][4];
        Object [][]data2 = new Object[1][3];

        for (int i =0; i<num;i++){
            data[i][0]=datos[i][0];
            data[i][1]=datos[i][1];
            data[i][2]=datos[i][2];
            data[i][3] = Double.valueOf(datos[i][3]);
        }
        
        for (int i=0;i<num;i++){
            data2[i][0]=data[i][0];
            data2[i][1]=(Integer.parseInt((String)data[i][2]))*Double.parseDouble(((String)data[i][3]).replace(",",".")));
        }
        
        Object[][]data3 = new Object[1][4];
        Object [][]data4 = new Object [num+1][6];
        
        for (int i=0; i<num;i++){
            data3[0][0]=datos[i][0];
            data3[0][1]=datos[i][2];
            data3[0][2]=data[i][3];
            data3[0][3] = Double.valueOf(datos[i][3]);
        }
        
        total=suma(data);
        
        System.out.println("Dinero Recibido");
        dinero=teclado.nextDouble();
        
        if (dinero>total){
            cambio=dinero-total;
            System.out.println("Cambio: "+cambio);
        }
        
        else{
            System.out.println("El dinero recibido es menor que el total de la compra");
        }
        
        System.out.println("\nDatos del Cliente");
        System.out.println("Nombre: "+nombre);
        System.out.println("Direccion: "+direccion);
        System.out.println("Telefono: "+telefono);
        
        System.out.print("1-Factura\n2-XML\n3-Excel\n4-TXT");
        
        opc=teclado.nextInt();
        
        switch(opc){
            case 1: factura(data, data2, total);
                break;
            
            case 2: xml(data3);
                    System.out.println("XML Generado");
                break;
            
            case 3: excel(data4);
                    System.out.println("Excel Generado");
                break;
            
            case 4: txt(data, data2);
                    System.out.println("TXT Generado");
                break;
        }
        
        teclado.close();
    }
    
    private static double suma (Object[][]data){
        int i=0, j=0, cantidad=Integer.parseInt((String) data[i][j]);
        double precio_unitario = Double.parseDouble(((String) data[i][3]).replace(",","."));
        double total=0;
        
        for (i=0; i<data.length; i++){
            for (j=2; j<data[i].length; j++){
                cantidad = Integer.parseInt((String) data[i][j]);
                precio_unitario = Double.parseDouble(((String) data[i][3]).replace(",",".")) ;
                
                total+=cantidad*precio_unitario;
            }   
        }
        return total;
    }
    
    private static void factura (Object[][]data, Object [][]data2, double total) throws IOException{
        
        String path = "Factura.txt";
        FileWriter fichero= new FileWriter(path);
        BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
        String nombre="", direccion="", telefono="";
        double cambio=0;
        
        System.out.print("Nombre: ");
        nombre = entrada.readLine();
        System.out.print("Direccion: ");
        direccion = entrada.readLine();
        System.out.print("Telefono: ");
        telefono = entrada.readLine();
        
        fichero.write("\nFactura de compra\n");
        fichero.write("Nombre del Cliente: "+nombre+"\n");
        fichero.write("Direccion: "+direccion+"\n");
        fichero.write("Telefono: "+telefono+"\n\n");
        
        fichero.write("\tNombre\tDescripcion\tCantidad\tPrecio Unitario\n");
        for (int i=0;i<data.length;i++){
            fichero.write(data[i][0]+"\t"+data[i][1]+"\t"+data[i][2]+"\t$ "+data[i][3]+"\n");
        }
        
        fichero.write("\nTotal: $ "+total+"\n");
        
        System.out.println("El total de la compra es de: $ "+total);
        
        System.out.print("Dinero Recibido");
        double dinero=entrada.readLine();
        
        if (dinero>total){
            cambio=dinero-total;
            fichero.write("\nCambio: $ "+cambio+"\n");
            
            System.out.println("El cambio es de: $ "+cambio);
        }
        
        else{
            System.out.println("El dinero recibido es menor que el total de la compra");
        }
        
        fichero.close();
    }
    
    private static void xml (Object[][]data) throws IOException{
        String path = "XML.xml";
        FileWriter fichero= new FileWriter(path);
        BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
        String nombre="", direccion="", telefono="";
        
        System.out.print("Nombre: ");
        nombre = entrada.readLine();
        System.out.print("Direccion: ");
        direccion = entrada.readLine();
        System.out.print("Telefono: ");
        telefono = entrada.readLine();
        
        fichero.write("<FACTURA>\n");
        fichero.write("\t<NOMBRE>"+nombre+"</NOMBRE>\n");
        fichero.write("\t<DIRECCION>"+direccion+"</DIRECCION>\n");
        fichero.write("\t<TELEFONO>"+telefono+"</TELEFONO>\n\n");
        
        for (int i=0;i<data.length;i++){
            fichero.write("\t<ARTICULO>\n");
            fichero.write("\t\t<NOMBRE>"+data[i][0]+"</NOMBRE>\n");
            fichero.write("\t\t<CANTIDAD>"+data[i][1]+"</CANTIDAD>\n");
            fichero.write("\t\t<PRECIO_UNITARIO>"+data[i][2]+"</PRECIO_UNITARIO>\n");
            
            fichero.write("\t</ARTICULO>\n");
        }
        
        fichero.write("</FACTURA>\n");
        
        fichero.close();
    }
    
    private static void excel (Object[][]data) throws IOException{
        String path = "Factura.xls";
        FileWriter fichero= new FileWriter(path);
        
        HSSFWorkbook hw = new HSSFWorkbook();
        HSSFSheet sheet = hw.createSheet("Factura");
        int rowNum = 0;
        Row row = null;
        
        CellStyle style = hw.createCellStyle();
        Font font = hw.createFont();
        
        for (int i=0;i<data.length;i++){
            fichero.write("Nombre: "+data[i][0]+"\tDescripcion: "+data[i][1]+"\tCantidad: "+data[i][2]+"\tPrecio Unitario: $"+data[i][3]+"\n");
        }
        
        for (int i=0; i<data.length; i++){
            row = sheet.createRow(rowNum++);
            
            Cell cell1 = row.createCell((short) 0);
            cell1.setCellValue(data[i][0].toString());
            cell1.setCellStyle(style);
            
            Cell cell2 = row.createCell((short) 1);
            cell2.setCellValue(data[i][1].toString());
            cell2.setCellStyle(style);
            
            Cell cell3 = row.createCell((short) 2);
            cell3.setCellValue(Integer.parseInt(data[i][2].toString()));
            cell3.setCellStyle(style);
            
            Cell cell4 = row.createCell((short) 3);
            cell4.setCellValue(Double.parseDouble(data[i][3].toString()));
            cell4.setCellStyle(style);
        }
        
        hw.write(fichero);
        fichero.close();
    }
    
    private static void txt (Object[][]data) throws IOException{
        String path = "Factura.txt";
        FileWriter fichero= new FileWriter(path);
        
        for (int i=0;i<data.length;i++){
            fichero.write("Nombre: "+data[i][0]+"\tDescripcion: "+data[i][1]+"\tCantidad: "+data[i][2]+"\tPrecio Unitario: $"+data[i][3]);
        }
        
        fichero.close();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        int n;
        System.out.println("Introduce cuantos productos vas a facturar: ");
        n = in.nextInt();
        
        String nombres [] = new String [n];
        String descripciones [] = new String [n];
        double precios [] = new double [n];
        
        for (int i=0;i<n;i++){
            System.out.println("Introduce el nombre del producto: ");
            nombres[i] = in.next();
            
            System.out.println("Introduce la descripcion del producto: ");
            descripciones[i] = in.next();
            
            System.out.println("Introduce el precio unitario del producto: ");
            precios[i] = in.nextDouble();
        }
        
        Object[][] data = {nombres, descripciones, precios};
        
        System.out.println("\n");
        
        for (int i=0;i<data.length;i++){
            txt(data);
            
            excel(data);
            
            xml(data);
            
            facturar(data);
        }