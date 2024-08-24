/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase5;

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
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class Clase5 {

    public static LinkedList<Analista> analistas = new LinkedList<Analista>();
    public static LinkedList<Coincidencia> coincidencias = new LinkedList<Coincidencia>();
    public static LinkedList<Documento> documentos = new LinkedList<Documento>();
    
    public static void main(String[] args) {
       /*
        MODELO = CLASES
        VISTA = GUI
        CONTROLADOR = LÓGICA QUE CONECTA LAS CLASES CON EL GUI
        */
       VentanaAdmin va = new VentanaAdmin();
       //VLogin vl = new VLogin();
       //Ventana v = new Ventana();
       //v.setVisible(true);
    }
    
    //-------------------- ANALISTAS ---------------------------------------
    //CREAR
    public static void añadirAnalista(Analista analista){
        analistas.add(analista);
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
    }
    
    //ELIMINAR
    public static void eliminarAnalista(String usuario){
        for (int i = 0; i < analistas.size(); i++) {
            if (analistas.get(i).getUsuario().equals(usuario)) {
                analistas.remove(i);
            }
        }
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
    }
    
    //RETORNAR UNA MATRIZ DE OBJETOS
    public static Object[][] convertirTablaDocumentos(){
        Object[][] documentostabla = new Object[documentos.size()][4];
        for (int i = 0; i < documentos.size(); i++) {
            documentostabla[i][0] = documentos.get(i).getCodigo();
            documentostabla[i][1] = documentos.get(i).getDescripcion();
            documentostabla[i][2] = documentos.get(i).getEstado();
            documentostabla[i][3] = "";
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
            analistastabla[i][2] = "";
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
    
    public static int[][] csv_to_matrix(File archivo){
        FileReader fr = null;
        BufferedReader br = null;
        int [][] data = null;
        try{
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            int contador = 0;
            
            while((linea = br.readLine()) != null){
                System.out.println(linea);
                String[] fila_numeros = linea.split(",");
                data = new int[fila_numeros.length][fila_numeros.length];
                for (int i = 0; i < fila_numeros.length; i++) {
                    System.out.println(fila_numeros[i]);
                    System.out.println("["+contador+"]"+"["+i+"] = " + Integer.parseInt(fila_numeros[i]));
                    data[contador][i] = Integer.parseInt(fila_numeros[i]);
                    System.out.println(data[contador][i]);
                }
                contador++;
            }
            
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    System.out.println("["+i+"]"+"["+j+"] = " + data[i][j]);
                }
            }
            return data;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return data;
    }
}
