# 🤓 Programación Orientada a Objetos
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

Este archivo contiene conceptos que te pueden ayudar a utilizar este paradigma de programación para la realización de tus proyectos y prácticas en Java.

## ¿Qué es la Programación Orientada a Objetos?

La programación orientada a objetos (POO) es un paradigma de programación que utiliza objetos y sus interacciones para diseñar aplicaciones y programas de computadora. Este enfoque se basa en la creación de clases que representan entidades del mundo real y los objetos que se derivan de estas clases.

## ¿Qué es un objeto?

Un objeto es una instancia de una clase. Una clase es un modelo o plantilla a partir de la cual se crean objetos. Por lo tanto, un objeto es una instancia de una clase. Cuando se crea un objeto, se asigna memoria y se inicializa.

## ¿Qué es una clase?

Una clase es una plantilla para crear objetos. Define los datos y el comportamiento de un tipo de objeto. Las clases se utilizan para definir objetos y contienen variables de instancia y métodos.

## Pasos iniciales para programar utilizando POO

1. **Definir una clase:** La clase es la plantilla para crear objetos. Define los datos y el comportamiento de un tipo de objeto.

    - Para crear una clase es necesario crear un nuevo archivo con extensión `.java`. Te tiene que quedar inicialmente este código:

    > `NOTA:` El nombre del archivo debe ser el mismo nombre de la clase que estamos creando.

    Ejemplo de crear una Clase Carro

    ```java
    public class Carro {
      
    }
    ```

2. **Definir los atributos de la clase:** Los atributos son las características de un objeto. Se definen dentro de la clase.

    Por ejemplo en esta clase Carro, podemos definir que tiene los siguientes atributos:
    
    - Color
    - Marca
    - Modelo
    - Año

    Entonces teniendo los atributos definidos, los agregamos a la clase:

    ```java
    public class Carro {
      //Atributos
      String color;
      String marca;
      String modelo;
      int año;
    }
    ```
3. **Definir el constructor de la clase**: El constructor es una subrutina cuya misión es inicializar un objeto de una clase. En el constructor se asignan los valores iniciales del nuevo objeto.

    En base a los atributos definidos en el paso anterior, crearemos su constructor.

    ```java
    public class Carro {
      //Atributos
      String color;
      String marca;
      String modelo;
      int año;
      
      //Constructor
      public Carro(String color, String marca, String modelo, int año) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
      }
    }
    ```

4. **Definir los métodos de la clase:** Los métodos son las acciones que un objeto puede realizar. Se definen dentro de la clase.

    Por ejemplo en esta clase Carro, podemos definir que tiene los siguientes métodos:
    
    - Encender
    - Apagar
    - Acelerar
    - Frenar

    Entonces teniendo los métodos definidos, los agregamos a la clase:

    ```java
    public class Carro {
      //Atributos
      String color;
      String marca;
      String modelo;
      int año;
      
      //Constructor
      public Carro(String color, String marca, String modelo, int año) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
      }
      
      //Métodos
      public void encender() {
        System.out.println("El carro está encendido");
      }
      
      public void apagar() {
        System.out.println("El carro está apagado");
      }
      
      public void acelerar() {
        System.out.println("El carro está acelerando");
      }
      
      public void frenar() {
        System.out.println("El carro está frenando");
      }
    }
    ```
5. **Encapsular los atributos de la clase:** Para encapsular es necesario para que no cualquiera tenga acceso a los atributos de nuestra clase, asi que los ponemos privados y agregamos métodos para leer y editar estos métodos.

    ```java
    public class Carro {
        //Atributos
        //ATRIBUTOS ENCAPSULADOS
        private String color;
        private String marca;
        private String modelo;
        private int año;
        
        //Constructor
        public Carro(String color, String marca, String modelo, int año) {
            this.color = color;
            this.marca = marca;
            this.modelo = modelo;
            this.año = año;
        }
        
        //Métodos
        public void encender() {
            System.out.println("El carro está encendido");
        }
        
        public void apagar() {
            System.out.println("El carro está apagado");
        }
        
        public void acelerar() {
            System.out.println("El carro está acelerando");
        }
        
        public void frenar() {
            System.out.println("El carro está frenando");
        }

        //Métodos para encapsular los atributos
        //GET: Es para leer los atributos del objeto
        public String getColor() {
            return color;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public int getAño() {
            return año;
        }

        //SET: Es para modificar los valores de los atributos del objeto
        public void setColor(String color) {
            this.color = color;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setModelo(String modelo){
            this.modelo = modelo;
        }

        public void setAño(int año){
            this.año = año;
        }
    }
    ```

6. **Crear un objeto de la clase:** Para crear un objeto de una clase, se utiliza la palabra clave `new` seguida del nombre de la clase y de los paréntesis.

    La sintaxis es la siguiente
    ```java
    NOMBRE_OBJETO nombre_variable = new NOMBRE_OBJETO(LOS_ATRIBUTOS_QUE_ME_PIDE_EL_CONSTRUCTOR);
    ```
    Por ejemplo, para crear un objeto de la clase Carro, se hace de la siguiente manera:

    ```java
    public class Main {
        public static void main(String[] args) {
            //Creación de un objeto de la clase Carro
            Carro miCarro = new Carro("Rojo", "Toyota", "Corolla", 2021);
        }
    }
    ```
7. **Utilizar los métodos y atributos del objeto:** Para utilizar los métodos y atributos de un objeto, se utiliza el operador punto `.` seguido del nombre del método o atributo.

    Por ejemplo, para utilizar el método `encender` del objeto `miCarro`, se hace de la siguiente manera:

    ```java
    public class Main {
        public static void main(String[] args) {
            //Creación de un objeto de la clase Carro
            Carro miCarro = new Carro("Rojo", "Toyota", "Corolla", 2021);
            
            //Utilización del método encender
            miCarro.encender();
        }
    }
    ```
8. **Imprimir los atributos del objeto:** Para imprimir los atributos de un objeto, se utiliza el método `System.out.println()`.
        
        Por ejemplo, para imprimir el color del objeto `miCarro`, se hace de la siguiente manera:
    
        ```java
        public class Main {
            public static void main(String[] args) {
                //Creación de un objeto de la clase Carro
                Carro miCarro = new Carro("Rojo", "Toyota", "Corolla", 2021);
                
                //Utilización del método encender
                miCarro.encender();
                
                //Imprimir el color del carro
                System.out.println("El color del carro es: " + miCarro.getColor());
            }
        }
        ```
9. **Modificar los atributos del objeto:** Para modificar los atributos de un objeto, se utiliza el método `set` seguido del nombre del atributo y el valor que se desea asignar.

    Por ejemplo, para modificar el color del objeto `miCarro`, se hace de la siguiente manera:

    ```java
    public class Main {
        public static void main(String[] args) {
            //Creación de un objeto de la clase Carro
            Carro miCarro = new Carro("Rojo", "Toyota", "Corolla", 2021);
            
            //Utilización del método encender
            miCarro.encender();
            
            //Imprimir el color del carro
            System.out.println("El color del carro es: " + miCarro.getColor());
            
            //Modificar el color del carro
            miCarro.setColor("Azul");
            
            //Imprimir el color del carro
            System.out.println("El color del carro es: " + miCarro.getColor());
        }
    }
    ```

## Herencia
La herencia es una característica de la programación orientada a objetos que permite a una clase heredar atributos y métodos de otra clase. La clase que hereda se conoce como subclase y la clase de la cual hereda se conoce como superclase.

Para heredar de una clase, se utiliza la palabra clave `extends` seguida del nombre de la superclase.

Además usamos el `super` para heredar y setear los valores del constructor de su clase padre.

Ejemplo:

- Clase Padre:
    
    ```java
    public class Figura{
        private String nombre;
        private int lados;

        public Figura(String nombre, int lados){
            this.nombre = nombre;
            this.lados = lados;
        }

        public String getNombre(){
            return nombre;
        }

        public int getLados(){
            return lados;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public void setLados(int lados){
            this.lados = lados;
        }
    }
    ```

- Clase Hija:

    ```java
    public class Triangulo extends Figura{
        private double base;
        private double altura;

        public Triangulo(double base, double altura){
            super("Triángulo", 3);
            this.base = base;
            this.altura = altura;
        }

        public double getBase(){
            return base;
        }

        public double getAltura(){
            return altura;
        }

        public void setBase(double base){
            this.base = base;
        }

        public void setAltura(double altura){
            this.altura = altura;
        }
    }
    ```

## Polimorfismo
El polimorfismo es una característica de la programación orientada a objetos que permite a una clase tener múltiples formas. Esto significa que una clase puede tener varios métodos con el mismo nombre pero con diferentes implementaciones.

Ejemplo:

- Clase Padre:

    ```java
    public class Animal{
        public void sonido(){
            System.out.println("Sonido de un animal");
        }
    }
    ```
- Clase Hija:

    ```java
    public class Perro extends Animal{
        public void sonido(){
            System.out.println("Guau guau");
        }
    }
    ```

    ```java
    public class Gato extends Animal{
        public void sonido(){
            System.out.println("Miau miau");
        }
    }
    ```

    ```java
    public class Main{
        public static void main(String[] args){
            Animal animal = new Animal();
            Perro perro = new Perro();
            Gato gato = new Gato();

            animal.sonido(); //Retorna en consola: Sonido de un animal
            perro.sonido(); //Retorna en consola: Guau guau
            gato.sonido(); //Retorna en consola: Miau miau
        }
    }
    ```

## Clases Abstractas
Una clase abstracta es una clase que no se puede instanciar. Se utiliza para definir una clase base que contiene métodos abstractos que deben ser implementados por las subclases.
Ejemplo:

- Clase Abstracta:

    ```java
    public abstract class Figura{
        private String nombre;
        private int lados;

        public Figura(String nombre, int lados){
            this.nombre = nombre;
            this.lados = lados;
        }

        public abstract double area();
    }
    ```
- Clase Hija:

    ```java
    public class Triangulo extends Figura{
        private double base;
        private double altura;

        public Triangulo(double base, double altura){
            //Se llama al constructor de la clase padre
            super("Triángulo", 3);
            this.base = base;
            this.altura = altura;
        }

        public double getBase(){
            return base;
        }

        public double getAltura(){
            return altura;
        }

        public void setBase(double base){
            this.base = base;
        }

        public void setAltura(double altura){
            this.altura = altura;
        }

        //SIEMPRE VA A OBLIGAR A USAR LA FUNCIÓN ÁREA
        @Override
        public double area(){
            return (base * altura) / 2;
        }
    }
    ```

## Interfaces
Una interfaz es una colección de métodos abstractos. Una clase puede implementar una o más interfaces. Las interfaces se utilizan para definir un contrato que una clase debe cumplir. Además las clases de una interfaz heredan utilizando la palabra reservado `implements`.

A diferencia de una clase abstracta, las interfaces no contienen atributos, sino únicamente métodos.

Ejemplo:

- Interfaz:

    ```java
    public interface Figura{
        public double area();
    }
    ```
- Clase que implementa la interfaz:

    ```java
    public class Triangulo implements Figura{
        private double base;
        private double altura;

        public Triangulo(double base, double altura){
            this.base = base;
            this.altura = altura;
        }

        public double getBase(){
            return base;
        }

        public double getAltura(){
            return altura;
        }

        public void setBase(double base){
            this.base = base;
        }

        public void setAltura(double altura){
            this.altura = altura;
        }

        //FUNCION OBLIGATORIA A IMPLEMENTAR AL ESTAR HEREDANDO DE UNA INTERFAZ
        @Override
        public double area(){
            return (base * altura) / 2;
        }
    }
    ```
