/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2.pkg1;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Math;
/**
 *
 * @author rodri
 */
public class Clase21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa la ruta del archivo");
        String ruta = leer.nextLine();
        LeerArchivo(ruta);
    }
    
    //LEER EL ARCHIVO
    public static void LeerArchivo(String ruta){
        //File = Abrir el archivo
        File archivo = null;
        //FileReader = Almacenar el texto del archivo
        FileReader fr = null;
        //BufferedReader = Leer el texto almacenado
        BufferedReader br = null;
        
        //TRY-CATCH = EVITAR QUE SE MUERA EL PROGRAMA
        try{
            //Creamos un objeto File
            archivo = new File(ruta);
            
            //almacenamos el contenido del archivo
            fr = new FileReader(archivo);
            
            //leer el contenidodel filereader
            br = new BufferedReader(fr);
            
            String linea = "";
            
            int contador_filas = 0;
            
            while((linea = br.readLine()) != null){
                if(contador_filas != 0){
                    System.out.println(linea);
                    procesarData(linea);
                }
                contador_filas++;
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static void procesarData(String linea){
        String[] data = linea.split(",");
        System.out.println("CODIGO: " + data[0]);
        System.out.println("NOMBRE: " + data[1]);
        System.out.println("PATRON: " + data[2]);
        
        String[] arreglo_patron = data[2].split(";");
        for (int i = 0; i < arreglo_patron.length; i++) {
            System.out.println("PATRON["+i +"] = "+ arreglo_patron[i]);
        }
        int dimension = (int) Math.sqrt(arreglo_patron.length);
        System.out.println("El tamaño del patron es " + dimension + "X" + dimension);
        System.out.println("----");
        int[][] matriz = new int[dimension][dimension];
        
        int contador1 = 0;
        int contador3 = 0;
        
        while(contador1 != dimension){
            int contador2 = 0;
            while(contador2 != dimension){
                matriz[contador1][contador2] = Integer.parseInt(arreglo_patron[contador3]);
                contador2++;
                contador3++;
            }
            contador1++;
        }
        
        for (int i = 0; i < matriz.length; i++) {
            
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println("");
        }
        
        crearArchivo(matriz,data[0],data[1]);
    }
    
    public static void crearArchivo(int[][] matriz, String codigo, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            //AGREGAMOS EL NOMBRE DEL FICHERO
            fichero = new FileWriter("Reportes/Matriz_"+codigo+".html");
            pw = new PrintWriter(fichero);
            
            //ESCRIBIMOS EL ARCHIVO
            pw.println("<html>");
            pw.println("    <head>");
            pw.println("        <title>Matriz " + codigo +" - "+nombre+"</title>");
            pw.println("    </head>");
            pw.println("    <body>");
            pw.println("        <h1>Matriz " + codigo +" - "+ nombre+"</h1>");
            pw.println("        <table>");
            for (int i = 0; i < matriz.length; i++) {
                pw.println("            <tr>");
                for (int j = 0; j < matriz[i].length; j++) {
                    pw.println("                <td> "+ matriz[i][j] + "</td>");
                }
                pw.println("            </tr>");
            }
            pw.println("        </table>");
            pw.println("    </body>");
            pw.println("</html>");
            System.out.println("Reporte generado exitosamente!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
