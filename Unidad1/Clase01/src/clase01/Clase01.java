/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase01;

/**
 *
 * @author rodri
 */
//IMPORTACIONES DE LIBRERIAS DE CÓDIGO
import java.util.Scanner;
public class Clase01 {

    /**
     * @param args the command line arguments
     */
    
    //VARIABLES GLOBALES
    static String varglobal = "Soy una variable global";
    public static void main(String[] args) {
        //COMENTARIOS
        
        // Hola soy un comentario simple
        /*
        Hola
        soy
        un
        comentario
        multilinea
        */
        
        //DECLARACIÓN DE VARIABLES
        //ENTERO
        int numero = 10;
        int numero2;
        //CADENAS DE TEXTO
        String texto = "Hola Mundo";
        //FLOAT
        float decimal1 = (float) 1.32;
        //DOUBLE
        double decimal2 = 52.25;
        //CHAR = CARACTER
        char caracter = 'a';
        //ASCII
        char ascii = 65;
        //BOOLEANO
        boolean booleano = true;
        //DECLARACIÓN COMPLEJA
        int suma = 10+5+9+6+9+8+10+45;
        
        //ASIGNACIÓN DE VARIABLES
        numero = 15;
        numero2 = 7;
        varglobal = "Hola!";
        
        //CASTEO
        int x = (int) 3.12; //3.12 -> 3
        int y = (int) 'a';
        
        //PARSEO
        String cadena_numeros = "123456";
        int numeros_cadena = Integer.parseInt(cadena_numeros);
        
        //OUTPUT
        //CON SALTO DE LÍNEA
        System.out.println("Hola Mundo!");
        //SIN SALTO DE LÍNEA
        //COMANDO PARA ESCRIBIR MAS RÁPIDO = sout + TAB
        System.out.print("I");
        System.out.print("P");
        System.out.println("C");
        
        //INPUT
        //CREAMOS UN OBJETO DE TIPO SCANNER
        Scanner lectura = new Scanner(System.in);
        //ENTEROS
        //System.out.println("Ingresa tu edad");
        //int numero_usuario = lectura.nextInt();
        //System.out.println("Ingresa un texto");
        //String texto_usuario = lectura.next();
        //String texto_usuario1 = lectura.nextLine();
        //System.out.println("Tu texto es: " + texto_usuario); 
        //System.out.println("Tu texto2 es: " + texto_usuario1);
        //System.out.println("ingresa otro numero");
        //int numextra = Integer.parseInt(lectura.nextLine());
        
        //CONDICIONAL IF-ELSE
        /*if(numero_usuario >18){
            System.out.println("Es mayor edad");
        }else if(numero_usuario == 18){
            System.out.println("Acabas de cumplir la mayoria de edad");
        }else{
            System.out.println("Sos menor de edad");
        }*/
        
        String hola = "hola";
        //STRING1.EQUALS(STRING2) = STRING1 == STRING2
        if(hola.equals("hola")){
            System.out.println("si es verdadero");
        }else{
            System.out.println("si es falso");
        }
        
        //SWITCH-CASE
        int dia = 4;
        switch(dia){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            default:
                System.out.println("No coincide con alguno de estos dias");
                break;
        }
        
        //CICLO WHILE
        int contador = 1;
        while(contador <=10){
            System.out.println(contador);
            contador++; // contador = contador + 1 || contador += 1
        }
        
        //DO-WHILE
        contador = 1;
        do{
            System.out.println("Hola!");
            contador++;
        }while(contador <=5);
        
        //FOR
        for (int i = 1; i <=10; i++) {
            System.out.println("CON FOR: " + i);
        }
        
        //OPERACIONES DE TRANSFERENCIA
        //BREAK
        int cont = 1;
        while(true){
            System.out.println(cont);
            if(cont == 3){
                break;
            }
            cont++;
        }
        //CONTINUE
        for (int i = 1; i <= 10; i++) {
            if(i == 5){
                continue;
            }
            System.out.println(i);
        }
        
        /*
        int i = 1;  i = 1
        IMPRIME 1
        i++  // i = i +1 -> i = 1+1
        i = 2
        IMPRIME 2
        i++  // i = i +1 -> i = 2+1
        i = 3
        IMPRIME 3
        
        */
        System.out.println("FACTORIAL");
        System.out.println("FACTORIAL DE 3: "+ factorial(3));
    }
    
    /*
    FACTORIAL
    1! = 1
    2! = 1*2
    3! = 1*2*3
    
    N! = N*(N-1)*(N-2)...
    */
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
}
