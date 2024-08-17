/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase4;

import Clases.*;
//* = TODOS LOS ARCHIVOS DE ESA CARPETA
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author rodri
 */

//import CARPETA/PAQUETE.CARPETA2/PAQUETE2.CLASE/ARCHIVO;
public class Clase4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //INSTACIA = CREAR UN OBJETO
        //NOMBRE_CLASE nombre_variable = new NOMBRE_CLASE(PARAMETROS OBLIGATORIOS DEL CONSTRUCTOR);
        Animal animal1 = new Animal("leon");
        Animal animal2 = new Animal("pajaro");
        
        //si queremos llamar a cualquier método o funcion de una clase tiene que seguir la siguiente sintaxis
        //NOMBRE_OBJETO.NOMBRE_METODO();
        
        //GET
        System.out.println("Hola soy un " + animal1.getNombre());
        //SET
        animal1.setNombre("leon");
        //get
        System.out.println("Hola soy un " + animal1.getNombre());
        
        Gato gato1 = new Gato();
        Perro perro1 = new Perro();
        String[][] comidas = new String[2][2];
        for (int i = 0; i < comidas.length; i++) {
            for (int j = 0; j < comidas[i].length; j++) {
                comidas[i][j] = "a";
            }
        }
        /*
        |a|a|
        |a|a|
        */
        gato1.setComidas(comidas);
        System.out.println("======COMO HABLAN LOS ANIMALES======");
        System.out.println("Hola soy un " + animal2.getNombre() + " y te digo " + animal2.hablar() + "!");
        System.out.println("Hola soy un " + gato1.getNombre() + " y te digo " + gato1.hablar() + "!");
        System.out.println("Hola soy un " + perro1.getNombre() + " y te digo " + perro1.hablar() + "!");
        
        //CREANDO LISTAS DE OBJETOS
        LinkedList<Animal> animales = new LinkedList<Animal>();
        LinkedList<Gato> gatos = new LinkedList<Gato>();
        LinkedList<Perro> perros = new LinkedList<Perro>();
        
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingresa un nombre de un animal:");
            String neim = leer.next();
            Animal animal_nuevo = new Animal(neim);
            animales.add(animal_nuevo);
        }
        System.out.println("MI LISTA DE ANIMALES");
        for (int i = 0; i < animales.size(); i++) {
            //animales.get(i) -> OBJETO(ANIMAL)
            //animales.get(i).getNombre() -> OBJETO(ANIMAL).getATRIBUTO() -> ATRIBUTO
            System.out.println((i+1) + ". " + animales.get(i).getNombre());
        }
    }
    
}
