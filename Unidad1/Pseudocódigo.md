# 🤓 Pseudocódigo
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

Este archivo es de utilidad para refrescar los conocimientos de algoritmos y su uso en la programación enfocandolo desde el pseudocódigo.

## ¿Qué es un pseudocódigo?
Un pseudocódigo es un lenguaje de programación informal que se asemeja a un lenguaje de programación real, pero no sigue las reglas de sintaxis de un lenguaje de programación real. El pseudocódigo es una forma de escribir programas de computadora para que los entiendan los humanos y no las máquinas. Este mismo puede ser escrito en español para que se entienda la relación entre el algoritmo realizado y el código al cual quiere uno replicar en la programación.

## Herramientas para pseudocódigo

Dentro de las herramientas para realizar pseudocódigo podemos encontrar a PSeInt, este es un software libre educativo multiplataforma dirigido a personas que se inician en la programación. Y su código esta orientado al pseudocódigo.

### Sintaxis PSeInt

PSeInt cuenta con dos lineas obligatorias que van al inicio y al final del programa, los cuales son los siguientes:

```python
Algoritmo nombre_algoritmo

FinAlgoritmo
```

#### Comentarios
Los comentarios son una forma de agregar notas a nuestro código, para que otros programadores puedan entender

```java
// Comentario de una línea
```

#### Declaración de variables
- ##### Números enteros
```python
Definir variable Como Entero
```
- ##### Números decimales
```python
Definir variable Como Real
```
- ##### Caracteres
```python
Definir variable Como Caracter
```
- ##### Cadenas de texto
```python
Definir variable Como Cadena
```
- ##### Booleanos
```python
Definir variable Como Logico
```

### Asignación
```python
variable <- 10
```
### Operadores
- #### Operadores aritméticos
```python
suma <- 5 + 5
resta <- 5 - 5
multiplicacion <- 5 * 5
division <- 5 / 5
modulo <- 5 % 5
```
- #### Operadores relacionales
```python
mayor <- 5 > 5
menor <- 5 < 5
mayor_o_igual <- 5 >= 5
menor_o_igual <- 5 <= 5
igual <- 5 == 5
diferente <- 5 <> 5
```
- #### Operadores lógicos
```python
and <- 5 > 5 Y 5 < 5
or <- 5 > 5 O 5 < 5
not <- NO 5 > 5
```
- #### Operadores de incremento y decremento
```python
numero <- 5
numero <- numero + 1
numero <- numero - 1
```

### Estructuras de control
- #### Estructura condicional
```python
Si condicion Entonces
    // Código
SiNo
    // Código
FinSi
```
- #### Estructura de repetición
```python
Mientras condicion Hacer
    // Código
FinMientras

Repetir
    // Código
HastaQue condicion

Para variable <- 1 Hasta 10 Con Paso 1 Hacer
    // Código
FinPara
```

### Ejemplo de un pseudocódigo
El siguiente pseudocódigo es un ejemplo para calcular la suma entre dos números.
    
```python
Algoritmo suma
	
    Definir a, b Como Entero;
	
    Escribir "Ingrese el primer número";
    Leer a;
	
    Escribir "Ingrese el segundo número";
    Leer b;
	
	Definir sumar Como Entero;
    sumar <- a + b;
	
    Escribir "La suma de los números es: ", sumar;
FinAlgoritmo
```

