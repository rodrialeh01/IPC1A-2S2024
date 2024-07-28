/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package claseextra1;
import java.util.Scanner;
/**
 *
 * @author rodri
 */
public class ClaseExtra1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int opcion = 0;
        Scanner lectura = new Scanner(System.in);
        do{
            System.out.println("------------MENU PRINCIPAL-------------");
            System.out.println("- 1. SUMA                             -");
            System.out.println("- 2. RESTA                            -");
            System.out.println("- 3. MULTIPLICACION                   -");
            System.out.println("- 4. DIVISION                         -");
            System.out.println("- 5. SALIR                            -");
            opcion = lectura.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("------------SUMA------------");
                    System.out.println("Ingresa el primer número: ");
                    int numero1suma = lectura.nextInt();
                    System.out.println("Ingresa el segundo número: ");
                    int numero2suma = lectura.nextInt();
                    int resultado_suma = suma(numero1suma, numero2suma);
                    System.out.println("El resultado de la suma es: " + resultado_suma);
                    break;
                case 2:
                    int resultado_resta = resta();
                    System.out.println("El resultado de la resta es: " + resultado_resta);
                    break;
                case 3:
                    System.out.println("------------MULTIPLICACIÓN------------");
                    System.out.println("Ingresa el primer número: ");
                    int numero1multiplicacion = lectura.nextInt();
                    System.out.println("Ingresa el segundo número: ");
                    int numero2multiplicacion = lectura.nextInt();
                    multiplicacion(numero1multiplicacion, numero2multiplicacion);
                    break;
                case 4:
                    division();
                    break;
                case 5:
                    System.out.println("Adios, vuelve pronto!");
                    break;
                default:
                    System.out.println("[ERROR] INGRESA UNA OPCIÓN CORRECTA");
                    break;
            }            
        }while(opcion != 5);
    }
    
    //FUNCIÓN SUMA - PARAMÉTROS
    public static int suma(int numero1, int numero2){
        //OPCION1
        /*
        int resultado = numero1+numero2;
        return resultado;
        */
        //OPCION2
        return numero1+numero2;
    }
    
    //FUNCION RESTA - SIN PARÁMETROS
    public static int resta(){
        Scanner leer = new Scanner(System.in);
        System.out.println("------------RESTA------------");
        System.out.println("Ingresa el primer número: ");
        int numero1 = leer.nextInt();
        System.out.println("Ingresa el segundo número: ");
        int numero2 = leer.nextInt();
        return numero1 - numero2;
    }
    
    //METODO MULTIPLICACIÓN CON PARÁMETROS
    public static void multiplicacion(int numero1, int numero2){
        int resultado = numero1 * numero2;
        System.out.println("El resultado de la multiplicación es: " +  resultado);
    }
    
    //METODO DIVISION SIN PARÁMETROS
    public static void division(){
        Scanner leer = new Scanner(System.in);
        System.out.println("------------DIVISION------------");
        System.out.println("Ingresa el primer número: ");
        int numero1 = leer.nextInt();
        System.out.println("Ingresa el segundo número: ");
        int numero2 = leer.nextInt();
        if(numero2 == 0){
            System.out.println("No se puede procesar la división ya que quieres dividir con 0");
            return;
        }
        int resultado = numero1 / numero2;
        System.out.println("El resultado de la división es: " + resultado);
    }
}
