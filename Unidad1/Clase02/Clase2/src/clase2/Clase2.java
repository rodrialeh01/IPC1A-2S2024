/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2;
import java.util.LinkedList;
/**
 *
 * @author rodri
 */
public class Clase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PARA CREAR UN ARREGLO
        // TIPODATO[] NOMBRE = NEW TIPODATO[TAMAÑO];
        //ARREGLO DE NUMEROS
        int[] arreglo_numeros = new int[3];
        
        //PARA OBTENER EL TAMAÑO DEL ARREGLO
        int tamanio = arreglo_numeros.length;
        
        System.out.println("El tamanio del array es: " + tamanio);
        
        //PARA IMPRIMIR LOS VALORES QUE TIENE EL ARREGLO:
        for (int i = 0; i < arreglo_numeros.length; i++) {
            System.out.println("arreglo_numeros["+i+"] = "+arreglo_numeros[i]);
        }
        
        System.out.println("------------------------------------------");
        //AGREGAR VALORES AL ARREGLO
        //FORMA 1: QUEMADO A MANITA
        arreglo_numeros[0] = 25;
        arreglo_numeros[1] = 50;
        arreglo_numeros[2] = 10;
        
        //PARA IMPRIMIR LOS NUEVOS VALORES QUE TIENE EL ARREGLO:
        for (int i = 0; i < arreglo_numeros.length; i++) {
            System.out.println("arreglo_numeros["+i+"] = "+arreglo_numeros[i]);
        }
        System.out.println("------------------------------------------");
        //MANEJO DE STRINGS
        String texto = "Hola mundo";
        //SPLIT
        String[] arreglo_texto = texto.split(" ");
        
        for (int i = 0; i < arreglo_texto.length; i++) {
            System.out.println(arreglo_texto[i]);
        }
        
        //TOCHARARRAY
        String texto2 = "letra";
        
        char[] arreglo_caracteres = texto2.toCharArray();
        int suma = 0;
        
        for (int i = 0; i < arreglo_caracteres.length; i++) {
            System.out.println("arreglo_caracteres["+i+"] = "+arreglo_caracteres[i]+ " = " + ((int)arreglo_caracteres[i]));
            suma += (int)arreglo_caracteres[i];
        }
        System.out.println("La suma es: " + suma);
        
        //CHARAT
        String texto3 = "murcielago";
        char caracter = texto3.charAt(4);
        System.out.println(caracter);
        
        //MATRICES
        //PARA CREAR UNA MATRIZ USARMOS LA SIG SINTAXIS
        // TIPODATO[][] NOMBRE = NEW TIPODATO[TAMANIO][TAMANIO];
        int[][] matriz = new int[2][2];
        //[[12,21],[32,55]]
        
        //ASIGNAR NUMEROS
        matriz[0][0] = 12;
        matriz[0][1] = 21;
        matriz[1][0] = 32;
        matriz[1][1] = 55;
        
        //PARA RECORRERLO ES NECESARIO 2 FOR
        //MATRIZ.LENGTH = TAMANIO FILAS
        for (int i = 0; i < matriz.length; i++) {
            //MATRIZ[I].LENGTH = TAMANIO COLUMNAS
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("matriz["+i+"]["+j+"] = "+matriz[i][j]);
            }
        }
        
        //LINKEDLIST
        //CREAR
        //LinkedList<TIPODATO> nombre = new LinkedList<TIPODATO>();
        LinkedList<String> lista = new LinkedList<String>();
        
        //TAMANIO
        System.out.println("La longitud de la lista es: " + lista.size());
        
        //INSERTAR
        lista.add("hola");
        lista.add("adios");
        lista.add("ipc1");
        lista.add("xd");
        
        //RECORRER
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("lista.get("+i+") = "+lista.get(i));
        }
        
        //TAMANIO ACTUALIZADO
        System.out.println("La longitud de la lista es: " + lista.size());
        
        //AIGNACION DE ARRAYS
        int[] a1 = {1,2,3,4};
        int[] a2 = new int[4];
        a1 = a2;
        
    }
    
}
