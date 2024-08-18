/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extra2;

/**
 *
 * @author rodri
 */
import GUI.VentanaAdmin;
import GUI2.Ventana;
import Clases.*;
import java.util.LinkedList;
public class Extra2 {

    public static LinkedList<Analista> analistas = new LinkedList<Analista>();
    public static LinkedList<Coincidencia> coincidencias = new LinkedList<Coincidencia>();
    public static LinkedList<Documentos> documentos = new LinkedList<Documentos>();
    
    public static void main(String[] args) {
       /*
        MODELO = CLASES
        VISTA = GUI
        CONTROLADOR = LÓGICA QUE CONECTA LAS CLASES CON EL GUI
        */
       //VentanaAdmin va = new VentanaAdmin();
       Ventana v = new Ventana();
       v.setVisible(true);
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
}
