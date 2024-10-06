# JavaScript

<div align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/800px-Unofficial_JavaScript_logo_2.svg.png" width="150"/></div>

## Introducción

En esta unidad se abordarán los temas de programación web, en específico se verá el lenguaje de programación JavaScript. Este readme esta dedicado a mostrar un poco de la sintaxis de JavaScript y algunos ejemplos.

## Variables

En JavaScript se pueden declarar variables de la siguiente manera:

```javascript
// var: palabra reservada para declarar variables en JavaScript, se puede utilizar para declarar variables globales y locales y se puede reasignar y redeclarar.
var nombre = "Rodrigo";

// let: palabra reservada para declarar variables en JavaScript, se puede utilizar para declarar variables locales y se puede reasignar pero no redeclarar.
let apellido = "Hernández";

// const: palabra reservada para declarar variables en JavaScript, se puede utilizar para declarar variables locales y no se puede reasignar ni redeclarar.

const edad = 23;
```

## Tipos de Datos

En JavaScript se tienen los siguientes tipos de datos:

```javascript
// String
let nombre = "Rodrigo";

// Number
let edad = 23;

// Boolean
let esMayorDeEdad = true;

// Array

let frutas = ["Manzana", "Pera", "Sandía"];

// Object

let persona = {
    nombre: "Rodrigo",
    apellido: "Hernández",
    edad: 23
};
```
## Casteo

En JavaScript se puede realizar el casteo de la siguiente manera:

```javascript
let numero = "23";

let numeroCasteado = parseInt(numero);
```

## Operadores

En JavaScript se tienen los siguientes operadores:

```javascript
// Aritméticos
let suma = 2 + 3;
let resta = 2 - 3;
let multiplicacion = 2 * 3;
let division = 2 / 3;
let modulo = 2 % 3;

// Relacionales
let mayorQue = 2 > 3;
let menorQue = 2 < 3;
let mayorIgualQue = 2 >= 3;
let menorIgualQue = 2 <= 3;
let igualQue = 2 == 3;
let diferenteQue = 2 != 3;
let igualQueEstricto = 2 === 3;
let diferenteQueEstricto = 2 !== 3;

// Lógicos
let and = true && false;
let or = true || false;
let not = !true;
```

## Output

En JavaScript se puede imprimir en consola de la siguiente manera:

```javascript
// console.log: función que imprime en consola.
console.log("Hola Mundo");

// alert: función que muestra un mensaje en una ventana emergente.
alert("Hola Mundo");

// document.write: función que escribe en el documento.
document.write("Hola Mundo");

// innerHTML: propiedad que escribe en el documento.
document.getElementById("mensaje").innerHTML = "Hola Mundo";

//console.error: función que imprime un mensaje de error en consola.

console.error("Error");

//console.warn: función que imprime un mensaje de advertencia en consola.

console.warn("Advertencia");

//console.table: función que imprime un arreglo en forma de tabla en consola

console.table(["Manzana", "Pera", "Sandía"]);

//console.time: función que inicia un temporizador en consola

console.time("Tiempo");

//console.timeEnd: función que detiene un temporizador en consola

console.timeEnd("Tiempo");
```

## Input

En JavaScript se puede recibir un valor de la siguiente manera:

```javascript
// prompt: función que muestra un mensaje en una ventana emergente y recibe un valor.

let nombre = prompt("Ingresa tu nombre");
```

## Estructuras de Control

### if

En JavaScript se puede utilizar la estructura de control if de la siguiente manera:

```javascript
let edad = 23;

if (edad >= 18) {
    console.log("Es mayor de edad");
} else {
    console.log("Es menor de edad");
}
```

### switch

En JavaScript se puede utilizar la estructura de control switch de la siguiente manera:

```javascript
let dia = 3;

switch (dia) {
    case 1:
        console.log("Lunes");
        break;
    case 2:
        console.log("Martes");
        break;
    case 3:
        console.log("Miércoles");
        break;
    case 4:
        console.log("Jueves");
        break;
    case 5:
        console.log("Viernes");
        break;
    case 6:
        console.log("Sábado");
        break;
    case 7:
        console.log("Domingo");
        break;
    default:
        console.log("Día no válido");
        break;
}
```

## Ciclos

### for

En JavaScript se puede utilizar el ciclo for de la siguiente manera:

```javascript
for (let i = 0; i < 10; i++) {
    console.log(i);
}
```

### while

En JavaScript se puede utilizar el ciclo while de la siguiente manera:

```javascript
let i = 0;

while (i < 10) {
    console.log(i);
    i++;
}
```

### do while

En JavaScript se puede utilizar el ciclo do while de la siguiente manera:

```javascript
let i = 0;

do {
    console.log(i);
    i++;
} while (i < 10);
```

## Arreglos

En JavaScript se puede utilizar arreglos de la siguiente manera:

```javascript
let frutas = ["Manzana", "Pera", "Sandía"];

console.log(frutas[0]);
```

## Funciones

En JavaScript se pueden declarar funciones de la siguiente manera:

```javascript
function saludar(nombre) {
    console.log("Hola " + nombre);
}

saludar("Rodrigo");
```	

## Funciones flecha

En JavaScript se pueden declarar funciones flecha de la siguiente manera:

```javascript
const saludar = (nombre) => {
    console.log("Hola " + nombre);
}

saludar("Rodrigo");
```

## Objetos

En JavaScript se pueden declarar objetos de la siguiente manera:

```javascript
let persona = {
    nombre: "Rodrigo",
    apellido: "Hernández",
    edad: 23
};

console.log(persona.nombre);
```

## Clases

En JavaScript se pueden declarar clases de la siguiente manera:

```javascript
class Persona {
    constructor(nombre, apellido, edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    saludar() {
        console.log("Hola " + this.nombre);
    }
}

let rodrigo = new Persona("Rodrigo", "Hernández", 23);

rodrigo.saludar();
```

## Excepciones

En JavaScript se pueden manejar excepciones de la siguiente manera:

```javascript
try {
    let numero = "23";

    let numeroCasteado = parseInt(numero);
} catch (error) {
    console.error(error);
}
```

## Eventos

En JavaScript se pueden manejar eventos de la siguiente manera:

```javascript
let boton = document.getElementById("boton");

boton.addEventListener("click", () => {
    console.log("Click");
});
```

## DOM

En JavaScript se puede manipular el DOM de la siguiente manera:

```javascript
let titulo = document.getElementById("titulo");

titulo.innerHTML = "Nuevo Título";
```

## JSON

En JavaScript se puede manejar JSON de la siguiente manera:

```javascript
let persona = {
    nombre: "Rodrigo",
    apellido: "Hernández",
    edad: 23
};

let personaJSON = JSON.stringify(persona);

console.log(personaJSON);
```

## Local Storage

En JavaScript se puede manejar el Local Storage de la siguiente manera:

```javascript

// Guardar en Local Storage
localStorage.setItem("nombre", "Rodrigo");

// Obtener de Local Storage
let nombre = localStorage.getItem("nombre");

// Eliminar de Local Storage
localStorage.removeItem("nombre");

// Limpiar Local Storage
localStorage.clear();
```

## Cookies

En JavaScript se puede manejar las Cookies de la siguiente manera:

```javascript
// Crear una Cookie
document.cookie = "nombre=Rodrigo";

// Leer una Cookie
let cookies = document.cookie;

// Eliminar una Cookie
document.cookie = "nombre=; max-age=0";
```

Para más información sobre JavaScript, se puede consultar la documentación oficial de [JavaScript](https://developer.mozilla.org/es/docs/Web/JavaScript).