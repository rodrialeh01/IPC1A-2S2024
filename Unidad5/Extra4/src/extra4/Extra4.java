/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extra4;

/**
 *
 * @author rodri
 */
import GUI.VentanaAdmin;
//import GUI2.Ventana;
import GUI.VLogin;
import Clases.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.lang.Math;
import javax.swing.JLabel;
import java.util.Scanner;
//import GUI2.Ventana;

//SERIALIZACION
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Extra4 {

    public static LinkedList<Analista> analistas = new LinkedList<Analista>();
    public static LinkedList<Coincidencia> coincidencias = new LinkedList<Coincidencia>();
    public static LinkedList<Documento> documentos = new LinkedList<Documento>();
    
    //PARA CONTADOR AUTOINCREMENTABLE DE CODIGO DE ANALISIS
    public static int contador_analisis = 1;
    
    //VARIABLES PARA SERIALIZACIÓN
    //ANALISTAS
    public static ObjectInputStream oisa;
    public static ObjectOutputStream oosa;
    
    public static FileWriter fichero_analisis = null;
    public static PrintWriter pw_analisis = null;
    
    public static void main(String[] args) {
       /*
        MODELO = CLASES
        VISTA = GUI
        CONTROLADOR = LÓGICA QUE CONECTA LAS CLASES CON EL GUI
        */

       //CARGAMOS EL ARCHIVO SERIALIZADO DE ANALISTAS
       analistas = (LinkedList<Analista>) DeserializarAnalistas();
       documentos = (LinkedList<Documento>) DeserializarDocumentos();
       if(analistas == null){
           System.out.println("NO HAY ANALISTAS");
           analistas = new LinkedList<Analista>();
       }
       if(documentos == null){
           System.out.println("NO HAY DOCUMENTOS");
           documentos = new LinkedList<Documento>();
       }
       VLogin vl = new VLogin();
       
    }
    
    //--------------------- SERIALIZACION ----------------------------------
    
    //1. METODO PARA CREAR EL ARCHIVO BINARIO PARA LA SERIALIZACIÓN DE ANALISTAS Y SERIALIZARLOS
    public static void SerializarAnalistas(){
        try{
            oosa = new ObjectOutputStream(new FileOutputStream("Serializados/Analistas.bin"));
            oosa.writeObject(analistas);
            oosa.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //2. METODO PARA DES-SERIALIZAR EL ARCHIVO BINARIO DE ANALISTAS
    public static Object DeserializarAnalistas(){
        try{
            oisa = new ObjectInputStream(new FileInputStream("Serializados/Analistas.bin"));
            LinkedList<Analista> analistastemp = (LinkedList<Analista>) oisa.readObject();
            oisa.close();
            return analistastemp;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    //DOCUMENTOS
    //1. METODO PARA CREAR EL ARCHIVO BINARIO PARA LA SERIALIZACIÓN DE ANALISTAS Y SERIALIZARLOS
    public static void SerializarDocumentos(){
        try{
            oosa = new ObjectOutputStream(new FileOutputStream("Serializados/Documentos.bin"));
            oosa.writeObject(documentos);
            oosa.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //2. METODO PARA DES-SERIALIZAR EL ARCHIVO BINARIO DE ANALISTAS
    public static Object DeserializarDocumentos(){
        try{
            oisa = new ObjectInputStream(new FileInputStream("Serializados/Documentos.bin"));
            LinkedList<Documento> analistastemp = (LinkedList<Documento>) oisa.readObject();
            oisa.close();
            return analistastemp;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    //-------------------- ANALISTAS ---------------------------------------
    //CREAR
    public static void añadirAnalista(Analista analista){
        analistas.add(analista);
        SerializarAnalistas();
    }
    
    //OBTENER EL OBJETO
    public static Analista obtenerAnalista(String usuario){
        for (int i = 0; i < analistas.size(); i++) {
            if (analistas.get(i).getUsuario().equals(usuario)) {
                return analistas.get(i);
            }
        }
        return null;
    }
    
    //ACTUALIZAR
    public static void actualizarAnalista(String usuario, String nombre, String contrasenia, String genero){
        for (int i = 0; i < analistas.size(); i++) {
            if (analistas.get(i).getUsuario().equals(usuario)) {
                analistas.get(i).setNombre(nombre);
                analistas.get(i).setContrasenia(contrasenia);
                analistas.get(i).setGenero(genero);
            }
        }
        SerializarAnalistas();
    }
    
    //ELIMINAR
    public static void eliminarAnalista(String usuario){
        for (int i = 0; i < analistas.size(); i++) {
            if (analistas.get(i).getUsuario().equals(usuario)) {
                analistas.remove(i);
            }
        }
        SerializarAnalistas();
    }
    
    //RETORNAR UNA MATRIZ DE OBJETOS
    public static Object[][] convertirTablaAnalista(){
        Object[][] analistastabla = new Object[analistas.size()][4];
        for (int i = 0; i < analistas.size(); i++) {
            analistastabla[i][0] = analistas.get(i).getUsuario();
            analistastabla[i][1] = analistas.get(i).getNombre();
            analistastabla[i][2] = analistas.get(i).getGenero();
            analistastabla[i][3] = analistas.get(i).getCantidad_analisis();
        }
        return analistastabla;
    }
    
    //-------------------- DOCUMENTOS ---------------------------------------
    //CREAR
    public static void añadirDocumento(Documento documento){
        documentos.add(documento);
        SerializarDocumentos();
    }
    
    //OBTENER EL OBJETO
    public static Documento obtenerDocumento(String codigo){
        for (int i = 0; i < documentos.size(); i++) {
            if (documentos.get(i).getCodigo().equals(codigo)) {
                return documentos.get(i);
            }
        }
        return null;
    }
    
    //ACTUALIZAR 
    public static void actualizarDocumento(String codigo, String estado){
        for (int i = 0; i < documentos.size(); i++) {
            if (documentos.get(i).getCodigo().equals(codigo)){
                documentos.get(i).setEstado(estado);
            }
        }
        SerializarDocumentos();
    }
    
    //RETORNAR UNA MATRIZ DE OBJETOS
    public static Object[][] convertirTablaDocumentos(){
        Object[][] documentostabla = new Object[documentos.size()][4];
        for (int i = 0; i < documentos.size(); i++) {
            documentostabla[i][0] = documentos.get(i).getCodigo();
            documentostabla[i][1] = documentos.get(i).getDescripcion();
            documentostabla[i][2] = documentos.get(i).getEstado();
            JLabel nuevo = new JLabel("Ver");
            nuevo.setName("ReportesDocumentos/Documento_"+ documentos.get(i).getCodigo());
            documentostabla[i][3] = nuevo;
        }
        return documentostabla;
    }
    
    //-------------------- COINCIDENCIAS ---------------------------------------
    //CREAR
    public static void añadirCoincidencia(Coincidencia coincidencia){
        coincidencias.add(coincidencia);
    }
    
    //OBTENER EL OBJETO
    public static Coincidencia obtenerCoincidencia(String codigo){
        for (int i = 0; i < coincidencias.size(); i++) {
            if (coincidencias.get(i).getCodigo().equals(codigo)) {
                return coincidencias.get(i);
            }
        }
        return null;
    }
    
    //ELIMINAR
    public static void eliminarCoincidencia(String codigo){
        for (int i = 0; i < coincidencias.size(); i++) {
            if (coincidencias.get(i).getCodigo().equals(codigo)) {
                coincidencias.remove(i);
            }
        }
    }
    
    //RETORNAR UNA MATRIZ DE OBJETOS
    public static Object[][] convertirTablaCoincidencia(){
        Object[][] analistastabla = new Object[coincidencias.size()][3];
        for (int i = 0; i < coincidencias.size(); i++) {
            analistastabla[i][0] = coincidencias.get(i).getCodigo();
            analistastabla[i][1] = coincidencias.get(i).getNombre();
            JLabel nuevo = new JLabel("Ver");
            nuevo.setName("ReportesCoincidencias/Coincidencia_"+ coincidencias.get(i).getCodigo());
            analistastabla[i][2] = nuevo;
        }
        return analistastabla;
    }
    
    //VERIFICAR LOGIN DE ANALISTAS
    public static boolean validarCredenciales(String usuario, String password){
        for (int i = 0; i < analistas.size(); i++) {
            if (analistas.get(i).getUsuario().equals(usuario)) {
                if (analistas.get(i).getContrasenia().equals(password)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    //-------------------- CARGAS DE DOCUMENTOS Y COINCIDENCIAS --------------------
    
    public static int[][] csv_to_matrix(File archivo) {
        FileReader fr = null;
        BufferedReader br = null;
        int[][] data = null;
        
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            // Contar el número de filas y columnas
            String linea;
            int filas = 0;
            int columnas = 0;
            
            while ((linea = br.readLine()) != null) {
                filas++;
                String[] fila_numeros = linea.split(",");
                columnas = fila_numeros.length;
            }
            
            // Inicializar la matriz con el tamaño adecuado
            data = new int[filas][columnas];
            
            // Volver al inicio del archivo para llenar la matriz
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int contador = 0;
            
            while ((linea = br.readLine()) != null) {
                String[] fila_numeros = linea.split(",");
                for (int i = 0; i < fila_numeros.length; i++) {
                    data[contador][i] = Integer.parseInt(fila_numeros[i]);
                }
                contador++;
            }
            
            // Imprimir la matriz
            System.out.println("-----------------------------------------------");
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    System.out.println("[" + i + "][" + j + "] = " + data[i][j]);
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return data;
    }
    
    //ENTRADA: NUMERO;NUMERO;NUMERO;NUMERO...
    public static int[][] ptc_to_matrix(String cadena_entrada){
        String[] numeros = cadena_entrada.split(";");
        //["1","7","2","4"]
        
        //obtenemos la raiz cuadrada
        int dimension = (int) Math.sqrt(numeros.length);
        /*
        [1   7]
        [2   4]
        */
        
        //AGREGAMOS EL TAMAÑO DE LA MATRIZ
        int [][] data_numeros = new int[dimension][dimension];
        int contador1 = 0;
        int contador3 = 0;
        while(contador1 < dimension){
            int contador2 = 0;
            while(contador2 < dimension){
                data_numeros[contador1][contador2] = Integer.parseInt(numeros[contador3]);
                contador2++;
                contador3++;
            }
            contador1++;
        }
        
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < data_numeros.length; i++) {
            for (int j = 0; j < data_numeros[i].length; j++) {
                System.out.println("[" + i + "][" + j + "] = " + data_numeros[i][j]);
            }
        }
        
        return data_numeros;
    }
    
    //ORDENAMIENTO DE ANALISTAS
    public static Analista[] ordenamientoAnalistas(){
        //CREAMOS UN ARREGLO PARA EL ORDENAMIENTO
        Analista[] arreglo_analistas = new Analista[analistas.size()];
        //INSERTAMOS DATOS AL ARREGLO
        for (int i = 0; i < arreglo_analistas.length; i++) {
            arreglo_analistas[i] = analistas.get(i);
        }
        try{
            for (int i = 1; i < arreglo_analistas.length; i++) {
                Analista aux =  arreglo_analistas[i];
                int j = i - 1;
                while((j>=0) && (aux.getCantidad_analisis()> arreglo_analistas[j].getCantidad_analisis())){
                    arreglo_analistas[j+1] = arreglo_analistas[j];
                    j--;
                }
                arreglo_analistas[j+1] = aux;
            }
            return arreglo_analistas;
        }catch(Exception e){
            return arreglo_analistas;
        }
    }
    public static void crearArchivo(int[][] matriz, String codigo, String nombre_carpeta, String tipo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            //AGREGAMOS EL NOMBRE DEL FICHERO
            fichero = new FileWriter(nombre_carpeta+"/"+tipo+"_"+codigo+".html");
            pw = new PrintWriter(fichero);
            
            //ESCRIBIMOS EL ARCHIVO
            pw.println("<html>");
            pw.println("    <head>");
            pw.println("        <title>"+tipo+" " + codigo +" </title>");
            pw.println("    </head>");
            pw.println("    <body>");
            pw.println("<style>\n" +
"        table, th, td {\n" +
"          border:1px solid black;\n" +
"        }\n" +
"    </style>");
            pw.println("        <h1>"+tipo+" " + codigo +" </h1>");
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
    
    public static boolean Analizar(int[][] documento, int[][] coincidencia) throws IOException{
        //PASO 1: ENTRA LA MATRIZ DOCUMENTO
        fichero_analisis = new FileWriter("Analisis/Analisis.html");
        pw_analisis = new PrintWriter(fichero_analisis);
        pw_analisis.println("<html>");
        pw_analisis.println("    <head>");
        pw_analisis.println("        <title>Analisis </title>");
        pw_analisis.println("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">");
        pw_analisis.println("    </head>");
        pw_analisis.println("    <body class=\"bg-info\">");
        if(documento.length != coincidencia.length){
            pw_analisis.println("       <h1>NO SE PUDO HACER EL ANALISIS YA QUE LAS MATRICES NO TIENEN EL MISMO TAMAÑO</h1>");
            pw_analisis.println("    </body>");
            pw_analisis.println("</html>");
            return false;
        }
        /*
        [1,2]
        [3,4]
        
        [[1,2],[3,4]]
        */
        if (documento[0].length != coincidencia[0].length) {
            pw_analisis.println("       <h1>NO SE PUDO HACER EL ANALISIS YA QUE LAS MATRICES NO TIENEN EL MISMO TAMAÑO</h1>");
            pw_analisis.println("    </body>");
            pw_analisis.println("</html>");
            return false;
        }
        
        pw_analisis.println("<style>\n" +
"        table, th, td {\n" +
"          border:1px solid black;\n" +
"        }\n" +
"    </style>");
        pw_analisis.println("        <h1>PASO 1: INGRESA LA MATRIZ 1 </h1>");
        pw_analisis.println("        <table class=\"table table-success table-striped\">");
        for (int i = 0; i < documento.length; i++) {
            pw_analisis.println("            <tr>");
            for (int j = 0; j < documento[i].length; j++) {
                pw_analisis.println("                <td> "+ documento[i][j] + "</td>");
            }
            pw_analisis.println("            </tr>");
        }
        pw_analisis.println("        </table>");
        
        //PASO 2: CREAMOS LA MATRIZ TEMP1 DONDE SE OBTIENE MULTIPLICANDO LA MATRIZ DOCUMENTO * 3
        int[][] matriz_temp1 = new int[documento.length][documento.length];
        
        for (int i = 0; i < documento.length; i++) {
            for (int j = 0; j < documento[i].length; j++) {
                matriz_temp1[i][j] = documento[i][j] * 3;
            }
        }
        
        pw_analisis.println("        <h1>PASO 2: LA MATRIZ 1 SE MULTIPLICA CON 3 Y SE OBTIENE MATRIZ_TEMP1 </h1>");
        pw_analisis.println("        <table class=\"table table-success table-striped\">");
        for (int i = 0; i < matriz_temp1.length; i++) {
            pw_analisis.println("            <tr>");
            for (int j = 0; j < matriz_temp1[i].length; j++) {
                pw_analisis.println("                <td> "+ matriz_temp1[i][j] + "</td>");
            }
            pw_analisis.println("            </tr>");
        }
        pw_analisis.println("        </table>");
        //PASO 3: CREAMOS LA MATRIZ TEMP2 DONDE SE OBTIENE MULTIPLICANDO LA MATRIZ DOCUMENTO * 7
        int[][] matriz_temp2 = new int[documento.length][documento.length];
        for (int i = 0; i < documento.length; i++) {
            for (int j = 0; j < documento[i].length; j++) {
                matriz_temp2[i][j] = documento[i][j] * 7;
            }
        }
        pw_analisis.println("        <h1>PASO 3: LA MATRIZ 1 SE MULTIPLICA CON 7 Y SE OBTIENE MATRIZ_TEMP2 </h1>");
        pw_analisis.println("        <table class=\"table table-success table-striped\">");
        for (int i = 0; i < matriz_temp2.length; i++) {
            pw_analisis.println("            <tr>");
            for (int j = 0; j < matriz_temp2[i].length; j++) {
                pw_analisis.println("                <td> "+ matriz_temp2[i][j] + "</td>");
            }
            pw_analisis.println("            </tr>");
        }
        pw_analisis.println("        </table>");
        //PASO 4: CREAMOS LA MATRIZ TEMP3 DONDE SE HACE LA MULTIPLICACION DE MATRICES
        int[][] matriz_temp3 = new int[documento.length][documento.length];
        for (int i = 0; i < matriz_temp1.length; i++) {
            for (int j = 0; j < matriz_temp1.length; j++) {
                for (int k = 0; k < matriz_temp1.length; k++) {
                    matriz_temp3[i][j] += matriz_temp1[i][k] * matriz_temp2[k][j];
                }
            }
        }
        pw_analisis.println("        <h1>PASO 4: LA MATRIZTEMP1 SE MULTIPLICA CON MATRIZTEMP2 Y SE OBTIENE MATRIZ_TEMP3 </h1>");
        pw_analisis.println("        <table class=\"table table-success table-striped\">");
        for (int i = 0; i < matriz_temp3.length; i++) {
            pw_analisis.println("            <tr>");
            for (int j = 0; j < matriz_temp3[i].length; j++) {
                pw_analisis.println("                <td> "+ matriz_temp3[i][j] + "</td>");
            }
            pw_analisis.println("            </tr>");
        }
        pw_analisis.println("        </table>");
        //PASO 5: DAMOS COMO RESULTADO LA MATRIZ QUE COMPARAREMOS 
        int[][] matriz_2 = new int[matriz_temp3.length][matriz_temp3.length];
        for (int i = 0; i < matriz_temp3.length; i++) {
            for (int j = 0; j < matriz_temp3[i].length; j++) {
                matriz_2[i][j] = matriz_temp3[i][j] % 2;
            }
        }
        pw_analisis.println("        <h1>PASO 5: LA MATRIZTEMP3 SE MODULARIZA CON 2 </h1>");
        pw_analisis.println("        <table class=\"table table-success table-striped\">");
        for (int i = 0; i < matriz_2.length; i++) {
            pw_analisis.println("            <tr>");
            for (int j = 0; j < matriz_2[i].length; j++) {
                pw_analisis.println("                <td> "+ matriz_2[i][j] + "</td>");
            }
            pw_analisis.println("            </tr>");
        }
        pw_analisis.println("        </table>");
        
        //PASO 6: VALIDAMOS QUE LA MATRIZ RESULTADO SEA IGUAL A LA MATRIZ COINCIDENCIA
        pw_analisis.println("        <h1>PASO 6: SE VERIFICA CON LA MATRIZ COINCIDENCIA </h1>");
        pw_analisis.println("        <h2>MATRIZ COINCIDENCIA: </h2>");
        pw_analisis.println("        <table class=\"table table-success table-striped\">");
        for (int i = 0; i < coincidencia.length; i++) {
            pw_analisis.println("            <tr>");
            for (int j = 0; j < coincidencia[i].length; j++) {
                pw_analisis.println("                <td> "+ coincidencia[i][j] + "</td>");
            }
            pw_analisis.println("            </tr>");
        }
        pw_analisis.println("        </table>");
        for (int i = 0; i < coincidencia.length; i++) {
            for (int j = 0; j < coincidencia[i].length; j++) {
                if (coincidencia[i][j] != matriz_2[i][j]) {
                    pw_analisis.println("       <h1>LA MATRIZ NO COINCIDE CON EL PATRON DE COINCIDENCIA</h1>");
                    pw_analisis.println("    </body>");
                    pw_analisis.println("</html>");
                    return false;
                }
            }
        }
        pw_analisis.println("       <h1 class=\"text-success\">LA MATRIZ SI COINCIDE CON EL PATRON DE COINCIDENCIA</h1>");
        pw_analisis.println("       <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n");
        pw_analisis.println("    </body>");
        pw_analisis.println("</html>");
        return true;
    }
}
