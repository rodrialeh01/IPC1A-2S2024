# ☕ Introducción a Java

>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

Este archivo es de utilidad para refrescar los conocimientos de java junto el uso de su sintaxis para el desarrollo de sus prácticas y actividades.

<div align="center"><img src="https://i.blogs.es/e7b69c/java_logo/450_1000.webp" width="200"/></div>

Java es un lenguaje multiplataforma, orientado a objetos y centrado en la red que se puede utilizar como una plataforma en sí mismo. Es un lenguaje de programación rápido, seguro y confiable para codificarlo todo, desde aplicaciones móviles y software empresarial hasta aplicaciones de macrodatos y tecnologías del servidor.

## ¿Qué versión usaremos en el laboratorio?
En el laboratorio usaremos la versión 21 de Java, la cual es la última versión estable.

## Sintaxis

### Comentarios

Son un texto adicional en el código para explicar su funcionalidad, funcionan como documentación del código y son ignorados por el compilador. 

```java
// Comentario de una línea
/*
Comentario de
varias líneas
*/
```

### Declaración de variables

- #### Números enteros
```java
int numero = 10;
```
- #### Números decimales
```java
float numero = 10.0;
double numero = 10.0;
```
- #### Caracteres
```java
char letra = 'a';
```
- #### Cadenas de texto
```java
String texto = "Hola mundo";
```
- #### Booleanos
```java
boolean verdadero = true;
```
- #### Constantes
```java
final int PI = 3.1416;
```

### Operadores
- #### Operadores aritméticos
```java
int suma = 5 + 5;
int resta = 5 - 5;
int multiplicacion = 5 * 5;
int division = 5 / 5;
int modulo = 5 % 5;
```
- #### Operadores de incremento y decremento
```java
int numero = 5;
numero++; // Incrementa en 1
numero--; // Decrementa en 1
```
- #### Operadores de asignación
```java
int numero = 5;
numero += 5; // numero = numero + 5;
numero -= 5; // numero = numero - 5;
numero *= 5; // numero = numero * 5;
numero /= 5; // numero = numero / 5;
numero %= 5; // numero = numero % 5;
```
- #### Operadores relacionales
```java
boolean mayor = 5 > 3; //true
boolean menor = 5 < 3; //false
boolean mayorIgual = 5 >= 3; //true
boolean menorIgual = 5 <= 3; //false
boolean igual = 5 == 3; //false
boolean diferente = 5 != 3; //false
```
- #### Operadores lógicos
```java
boolean and = true && false; //false
boolean or = true || false; //true
boolean not = !true; //false
```
- #### Operadores de tipo
```java
int numero = 5;
String texto = "Hola mundo";
boolean esNumero = numero instanceof Integer; //true
boolean esTexto = texto instanceof String; //true
```
- #### Casteo
```java
int numero = 5;
double decimal = (double) numero;
```
- #### Parseo
```java
String numero = "5";
int entero = Integer.parseInt(numero);
```

### Output
- #### Imprimir en consola
```java
System.out.println("Hola mundo");
System.out.print("Hola mundo");
```
- #### Formateo
```java
String nombre = "Juan";
int edad = 20;
System.out.printf("Hola %s, tienes %d años", nombre, edad);
```
### Input
- #### Leer desde consola
```java
Scanner scanner = new Scanner(System.in);
String nombre = scanner.nextLine();
String apellido = scanner.next();
int edad = scanner.nextInt();
double numero = scanner.nextDouble();
```

### Estructuras de Control
- #### Condicionales - If
```java
if (condicion) {
    // Código si la condición es verdadera
} else if (condicion) {
    // Código si la condición es verdadera
} else {
    // Código si ninguna condición es verdadera
}
```
- #### Condicionales - Switch
```java
switch (variable) {
    case valor1:
        // Código si la variable es igual a valor1
        break;
    case valor2:
        // Código si la variable es igual a valor2
        break;
    default:
        // Código si la variable no es igual a ningún valor
}
```
- #### Bucles - For
```java
for (int i = 0; i < 10; i++) {
    // Código a repetir
}
```
- #### Bucles - While
```java
while (condicion) {
    // Código a repetir
}
```
- #### Bucles - Do-While
```java
do {
    // Código a repetir
} while (condicion);
```
- #### Bucles - For-Each
```java
int[] numeros = {1, 2, 3, 4, 5};
for (int numero : numeros) {
    // Código a repetir
}
```
- #### Bucles - Break
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;
    }
}
```
- #### Bucles - Continue
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        continue;
    }
}
```
- #### Bucles - Return
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        return;
    }
}
```

### Funciones
- #### Sin parámetros
```java
public int suma() {
    int a = 10;
    int b = 10;
    return a+b;
}
```
- #### Con parámetros
```java
public int suma(int a, int b) {
    return a+b;
}
```
- #### Con retorno
```java
public int suma(int a, int b) {
    return a+b;
}
```
- #### Sin retorno (Métodos/void)
```java
public void suma(int a, int b) {
    System.out.println(a+b);
}
```
- #### Recursividad
```java
public int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}
```