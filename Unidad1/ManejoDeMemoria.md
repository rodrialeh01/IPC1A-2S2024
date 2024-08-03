# 🤓 Manejo de Memoria
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

Este archivo es de utilidad para refrescar los conocimientos de la memoria y su uso en la programación.

## Arreglos (Arrays)

Un array (arreglo) en Java es una estructura de datos que nos permite almacenar un conjunto de datos de un mismo tipo. El tamaño de los arrays se declara en un primer momento y no puede cambiar luego durante la ejecución del programa.

### Declaración de un array

Para declarar un array en Java se utiliza la siguiente sintaxis:

```java
tipo[] nombreArray = new tipo[tamaño];
```
Ejemplo:
```java
//ENTEROS
int[] numeros = new int[5];
//CADENAS
String[] nombres = new String[3];
//CARACTERES
char[] letras = new char[4];
//BOOLEANOS
boolean[] valores = new boolean[2];
//DECIMALES
double[] decimales = new double[3];
float[] decimales2 = new float[5];
```

### Inicialización de un array

Para inicializar un array en Java se utiliza la siguiente sintaxis:

```java
tipo[] nombreArray = {valor1, valor2, valor3, ..., valorN};
```

Ejemplo:
```java
int[] numeros = {1,2,3,4,5};
String[] nombres = {"Juan","Pedro","María"};
char[] letras = {'a','b','c','d'};
boolean[] valores = {true,false};
double[] decimales = {1.2,3.4,5.6};
float[] decimales2 = {1.2f,3.4f,5.6f,7.8f,9.0f};
```
### Acceso a los elementos de un array
Para acceder a los elementos de un array en Java se utiliza la siguiente sintaxis:

```java
nombreArray[posicion];
```
Ejemplo:
```java
int[] numeros = {1,2,3,4,5};
System.out.println(numeros[0]); //Imprime 1
System.out.println(numeros[1]); //Imprime 2
System.out.println(numeros[2]); //Imprime 3
System.out.println(numeros[3]); //Imprime 4
System.out.println(numeros[4]); //Imprime 5
```
Para recorrerlo de una manera más sencilla usamos un for:

```java
int[] numeros = {1,2,3,4,5};
for(int i = 0; i < numeros.length; i++){
    System.out.println(numeros[i]);
}
/*
Imprime:
1
2
3
4
5
*/
```

## Arreglos multidimensionales
Un array (arreglo) en Java puede tener más de una dimensión. El caso más general son los arrays bidimensionales tambien llamados matrices o tablas.

### Declaración de un array bidimensional

Para declarar un array bidimensional en Java se utiliza la siguiente sintaxis:

```java
tipo[][] nombreArray = new tipo[fila][columna];
```
Ejemplo:
```java
int[][] matriz = new int[3][3];
```
### Acceso a los elementos de un array bidimensional
Para acceder a los elementos de un array bidimensional en Java se utiliza la siguiente sintaxis:

```java
nombreArray[fila][columna];
```
Ejemplo:
```java
int[][] matriz = new int[3][3];
matriz[0][0] = 1;
matriz[0][1] = 2;
matriz[0][2] = 3;
matriz[1][0] = 4;
matriz[1][1] = 5;
matriz[1][2] = 6;
matriz[2][0] = 7;
matriz[2][1] = 8;
matriz[2][2] = 9;
```

Esta matriz se puede visualizar de la siguiente manera:

| 1 | 2 | 3 |
|---|---|---|
| 4 | 5 | 6 |
| 7 | 8 | 9 |

Para recorrer una matriz de una manera más sencilla usamos dos for anidados, donde el primer for recorremos las filas y el segundo for recorremos las columnas:

```java
int[][] matriz = new int[3][3];
for(int i = 0; i < matriz.length; i++){
    for(int j = 0; j < matriz[i].length; j++){
        System.out.println(matriz[i][j]);
    }
}
```

Las posiciones de las matrices se conforman de `filas,columnas` entonces las posiciones de la matriz anterior quedarian:

| 0,0 | 0,1 | 0,2 |
|---|---|---|
| 1,0 | 1,1 | 1,2 |
| 2,0 | 2,1 | 2,2 |

## Métodos

### length
El método `length` nos permite obtener el tamaño de un array en Java.

Ejemplo:
```java
int[] numeros = {1,2,3,4,5};
System.out.println(numeros.length); //Imprime 5
```

### length()

El método `length()` nos permite obtener el tamaño de un string en Java.

Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.length()); //Imprime 4
```

### split()
El método `split()` nos permite dividir un string en un array de strings según un caracter determinado.

Ejemplo:
```java
String nombres = "Juan,Pedro,María";
String[] nombresArray = nombres.split(","); //nombresArray = ["Juan","Pedro","María"]
for(int i = 0; i < nombresArray.length; i++){
    System.out.println(nombresArray[i]);
}
/*
Imprime:
Juan
Pedro
María
*/
```

### toCharArray()

El método `toCharArray()` nos permite convertir un string en un array de caracteres.

Ejemplo:
```java
String nombre = "Juan";
char[] nombreArray = nombre.toCharArray(); //nombreArray = ['J','u','a','n']
for(int i = 0; i < nombreArray.length; i++){
    System.out.println(nombreArray[i]);
}
/*
Imprime:
J
u
a
n
*/
```

### toLowerCase() 
El método `toLowerCase()`nos permite convertir un string a minúsculas.

Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.toLowerCase()); //Imprime juan
```
### toUpperCase()
El método `toUpperCase()`nos permite convertir un string a mayúsculas.
Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.toUpperCase()); //Imprime JUAN
```
### trim()
El método `trim()` nos permite eliminar los espacios en blanco al inicio y al final de un string.
Ejemplo:
```java
String nombre = " Juan ";
System.out.println(nombre.trim()); //Imprime Juan
```
### equals()
El método `equals()` nos permite comparar dos strings.
Ejemplo:
```java
String nombre1 = "Juan";
String nombre2 = "Pedro";
System.out.println(nombre1.equals(nombre2)); //Imprime false
```
### equalsIgnoreCase()
El método `equalsIgnoreCase()` nos permite comparar dos strings sin importar si son mayúsculas o minúsculas.
Ejemplo:
```java
String nombre1 = "Juan";
String nombre2 = "juan";
System.out.println(nombre1.equalsIgnoreCase(nombre2)); //Imprime true
```
### charAt()
El método `charAt()` nos permite obtener un caracter de un string según una posición determinada.

Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.charAt(0)); //Imprime J
System.out.println(nombre.charAt(1)); //Imprime u
System.out.println(nombre.charAt(2)); //Imprime a
System.out.println(nombre.charAt(3)); //Imprime n
```
### indexOf()
El método `indexOf()` nos permite obtener la posición de la primera ocurrencia de un caracter en un string.
Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.indexOf('a')); //Imprime 2
```
### lastIndexOf()
El método `lastIndexOf()` nos permite obtener la posición de la última ocurrencia de un caracter en un string.
Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.lastIndexOf('a')); //Imprime 2
```
### replace()
El método `replace()` nos permite reemplazar un caracter por otro en un string.
Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.replace('a','o')); //Imprime Juon
```
### substring()
El método `substring()` nos permite obtener una subcadena de un string según una posición inicial y una posición final.
Ejemplo:
```java
String nombre = "Juan";
System.out.println(nombre.substring(0,2)); //Imprime Ju
```
## Listas
La lista tiene un enlace al primer contenedor y cada contenedor tiene un enlace al siguiente contenedor en la lista. Para agregar un elemento a la lista, el elemento se coloca en un nuevo contenedor y ese contenedor está vinculado a uno de los otros contenedores en la lista.

### ArrayList
El ArrayList la clase tiene una matriz regular dentro de ella. Cuando se agrega un elemento, se coloca en la matriz. Si la matriz no es lo suficientemente grande, se crea una matriz nueva y más grande para reemplazar la el viejo y el viejo se eliminan.

#### Declaración de un ArrayList
Para declarar un ArrayList en Java se utiliza la siguiente sintaxis:

```java
ArrayList<tipo> nombreArrayList = new ArrayList<tipo>();
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>();
ArrayList<String> nombres = new ArrayList<String>();
ArrayList<Character> letras = new ArrayList<Character>();
ArrayList<Boolean> valores = new ArrayList<Boolean>();
ArrayList<Double> decimales = new ArrayList<Double>();
ArrayList<Float> decimales2 = new ArrayList<Float>();
```
#### Inicialización de un ArrayList
Para inicializar un ArrayList en Java se utiliza la siguiente sintaxis:

```java
ArrayList<tipo> nombreArrayList = new ArrayList<tipo>(Arrays.asList(valor1, valor2, valor3, ..., valorN));
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
ArrayList<String> nombres = new ArrayList<String>(Arrays.asList("Juan","Pedro","María"));
ArrayList<Character> letras = new ArrayList<Character>(Arrays.asList('a','b','c','d'));
ArrayList<Boolean> valores = new ArrayList<Boolean>(Arrays.asList(true,false));
ArrayList<Double> decimales = new ArrayList<Double>(Arrays.asList(1.2,3.4,5.6));
ArrayList<Float> decimales2 = new ArrayList<Float>(Arrays.asList(1.2f,3.4f,5.6f,7.8f,9.0f));
```
#### Acceso a los elementos de un ArrayList
Para acceder a los elementos de un ArrayList en Java se utiliza la siguiente sintaxis:

```java
nombreArrayList.get(posicion);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(numeros.get(0)); //Imprime 1
System.out.println(numeros.get(1)); //Imprime 2
System.out.println(numeros.get(2)); //Imprime 3
System.out.println(numeros.get(3)); //Imprime 4
System.out.println(numeros.get(4)); //Imprime 5
```
Para recorrerlo de una manera más sencilla usamos un for:

```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
for(int i = 0; i < numeros.size(); i++){
    System.out.println(numeros.get(i));
}
/*
Imprime:
1
2
3
4
5
*/
```
#### Añadir elementos a un ArrayList
Para añadir elementos a un ArrayList en Java se utiliza el método `add()`.
```java
nombreArrayList.add(elemento);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);
numeros.add(5);
```
#### Eliminar elementos de un ArrayList
Para eliminar elementos de un ArrayList en Java se utiliza el método `remove()`.
```java
nombreArrayList.remove(posicion);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
numeros.remove(0);
```
#### Modificar elementos de un ArrayList
Para modificar elementos de un ArrayList en Java se utiliza el método `set()`.
```java
nombreArrayList.set(posicion, elemento);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
numeros.set(0,10);
```
#### Tamaño de un ArrayList
Para obtener el tamaño de un ArrayList en Java se utiliza el método `size()`.
```java
nombreArrayList.size();
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(numeros.size()); //Imprime 5
```
#### Búsqueda de elementos en un ArrayList
Para buscar elementos en un ArrayList en Java se utiliza el método `contains()`.
```java
nombreArrayList.contains(elemento);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(numeros.contains(3)); //Imprime true
```
#### Ordenar un ArrayList
Para ordenar un ArrayList en Java se utiliza el método `sort()`.
```java
Collections.sort(nombreArrayList);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(5,3,1,4,2));
Collections.sort(numeros);
```
#### Invertir un ArrayList
Para invertir un ArrayList en Java se utiliza el método `reverse()`.
```java
Collections.reverse(nombreArrayList);
```
Ejemplo:
```java
ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
Collections.reverse(numeros);
```

### LinkedList
El LinkedList almacena sus artículos en "contenedores." La lista tiene un enlace al primer contenedor y cada contenedor tiene un enlace al siguiente contenedor en la lista. Para agregar un elemento a la lista, el elemento se coloca en un nuevo contenedor y ese contenedor está vinculado a uno de los otros contenedores en la lista.

#### Declaración de un LinkedList
Para declarar un LinkedList en Java se utiliza la siguiente sintaxis:

```java
LinkedList<tipo> nombreLinkedList = new LinkedList<tipo>();
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>();
LinkedList<String> nombres = new LinkedList<String>();
LinkedList<Character> letras = new LinkedList<Character>();
LinkedList<Boolean> valores = new LinkedList<Boolean>();
LinkedList<Double> decimales = new LinkedList<Double>();
LinkedList<Float> decimales2 = new LinkedList<Float>();
```
#### Inicialización de un LinkedList
Para inicializar un LinkedList en Java se utiliza la siguiente sintaxis:

```java
LinkedList<tipo> nombreLinkedList = new LinkedList<tipo>(Arrays.asList(valor1, valor2, valor3, ..., valorN));
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
LinkedList<String> nombres = new LinkedList<String>(Arrays.asList("Juan","Pedro","María"));
LinkedList<Character> letras = new LinkedList<Character>(Arrays.asList('a','b','c','d'));
LinkedList<Boolean> valores = new LinkedList<Boolean>(Arrays.asList(true,false));
LinkedList<Double> decimales = new LinkedList<Double>(Arrays.asList(1.2,3.4,5.6));
LinkedList<Float> decimales2 = new LinkedList<Float>(Arrays.asList(1.2f,3.4f,5.6f,7.8f,9.0f));
```
#### Acceso a los elementos de un LinkedList
Para acceder a los elementos de un LinkedList en Java se utiliza la siguiente sintaxis:

```java
nombreLinkedList.get(posicion);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(numeros.get(0)); //Imprime 1
System.out.println(numeros.get(1)); //Imprime 2
System.out.println(numeros.get(2)); //Imprime 3
System.out.println(numeros.get(3)); //Imprime 4
System.out.println(numeros.get(4)); //Imprime 5
```
Para recorrerlo de una manera más sencilla usamos un for:

```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
for(int i = 0; i < numeros.size(); i++){
    System.out.println(numeros.get(i));
}
/*
Imprime:
1
2
3
4
5
*/
```
#### Añadir elementos a un LinkedList
Para añadir elementos a un LinkedList en Java se utiliza el método `add()`.
```java
nombreLinkedList.add(elemento);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);
numeros.add(5);
```

#### Eliminar elementos de un LinkedList
Para eliminar elementos de un LinkedList en Java se utiliza el método `remove()`.
```java
nombreLinkedList.remove(posicion);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
numeros.remove(0);
```
#### Modificar elementos de un LinkedList
Para modificar elementos de un LinkedList en Java se utiliza el método `set()`.
```java
nombreLinkedList.set(posicion, elemento);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
numeros.set(0,10);
```
#### Tamaño de un LinkedList
Para obtener el tamaño de un LinkedList en Java se utiliza el método `size()`.
```java
nombreLinkedList.size();
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(numeros.size()); //Imprime 5
```
#### Búsqueda de elementos en un LinkedList
Para buscar elementos en un LinkedList en Java se utiliza el método `contains()`.
```java
nombreLinkedList.contains(elemento);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(numeros.contains(3)); //Imprime true
```
#### Ordenar un LinkedList
Para ordenar un LinkedList en Java se utiliza el método `sort()`.
```java
Collections.sort(nombreLinkedList);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(5,3,1,4,2));
Collections.sort(numeros);
```
#### Invertir un LinkedList
Para invertir un LinkedList en Java se utiliza el método `reverse()`.
```java
Collections.reverse(nombreLinkedList);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
Collections.reverse(numeros);
```
#### Eliminar elementos de un LinkedList
Para eliminar elementos de un LinkedList en Java se utiliza el método `remove()`.
```java
nombreLinkedList.remove(posicion);
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
numeros.remove(0);
```
#### Eliminar todos los elementos de un LinkedList
Para eliminar todos los elementos de un LinkedList en Java se utiliza el método `clear()`.
```java
nombreLinkedList.clear();
```
Ejemplo:
```java
LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
numeros.clear();
```
