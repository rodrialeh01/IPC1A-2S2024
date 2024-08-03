# 🤓 Manejo de Archivos
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

En este archivo se explicará el manejo de archivos en Java, desde la creación, lectura, escritura y cierre de archivos.

## Lectura de archivos
Para leer un archivo en Java, se necesita importar lo siguiente:

```java
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
````

Para leer un archivo, se necesita crear un objeto de la clase `File`,  `FileReader` y `BufferedReader` e inicializarlo como null:

```java
//File = Abrir el archivo
File archivo = null;
//FileReader = Almacenar el texto del archivo
FileReader fr = null;
//BufferedReader = Leer el texto almacenado
BufferedReader br = null;
```
Luego hay que agregar un `try-catch` para el manejo de errores en los archivos.

```java
try {
    //Código
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        if (null != fr) {
            fr.close();
        }
    } catch (Exception e2) {
        e2.printStackTrace();
    }
}
```

Luego dentro del try es donde leemos el archivo:

```java
try {
    //CREA EL FILE
    archivo = new File("archivo.txt");
    fr = new FileReader(archivo);
    br = new BufferedReader(fr);
    String linea;
    //LEE LINEA POR LINEA
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        if (null != fr) {
            fr.close();
        }
    } catch (Exception e2) {
        e2.printStackTrace();
    }
}
```

## Escritura de archivos
Para escribir un archivo en Java, se necesita importar lo siguiente:

```java
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
```
Luego creamos un objeto de tipo File y otro de tipo FileWriter, el cual es el que nos permitirá escribir en el archivo.

```java
File archivo = null;
FileWriter fw = null;
```
Luego dentro del try es donde escribimos el archivo:

```java
try {
    //creamos el archivo y le ponemos el nombre con el que lo vamos a crear
    archivo = new File("archivo.txt");
    fw = new FileWriter(archivo);
    PrintWriter pw = new PrintWriter(fw);
    //escribimos el contenido del archivo
    pw.println("Hola Mundo");
    pw.println("Adiós Mundo");
    //cerramos el archivo
    pw.close();
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        if (null != fw) {
            fw.close();
        }
    } catch (Exception e2) {
        e2.printStackTrace();
    }
}
```