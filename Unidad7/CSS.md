# CSS

<div align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/CSS3_logo_and_wordmark.svg" width="150"/></div>

## Introducción

En esta unidad se abordarán los temas de programación web, en específico se verá el lenguaje de estilos CSS. Este readme esta dedicado a mostrar un poco de la sintaxis de CSS y algunos ejemplos.

## Sintaxis

En CSS se pueden declarar estilos de la siguiente manera:

```css
/* Selector */
h1 {
    /* Propiedad: Valor */
    color: red;
    font-size: 20px;
}
```

## Selectores

En CSS se tienen los siguientes selectores:

### Selector de etiqueta

```css
h1 {
    color: red;
    font-size: 20px;
}
```

### Selector de clase

```css
.clase {
    color: red;
    font-size: 20px;
}
```

### Selector de id

```css
#id {
    color: red;
    font-size: 20px;
}
```

### Selector de atributo

```css
[atributo="valor"] {
    color: red;
    font-size: 20px;
}
```

### Selector de pseudo-clase

```css
selector:pseudo-clase {
    color: red;
    font-size: 20px;
}
```

### Selector de pseudo-elemento

```css
selector::pseudo-elemento {
    color: red;
    font-size: 20px;
}
```

## Propiedades

En CSS se tienen las siguientes propiedades:

### Color

```css
color: red;
```

### Tamaño de fuente

```css
font-size: 20px;
```

### Fondo

```css
background-color: red;
```

### Margen

```css
margin: 20px;
```

### Borde

```css
border: 1px solid red;
```

### Relleno

```css
padding: 20px;
```

### Ancho

```css
width: 100px;
```

### Alto

```css
height: 100px;
```

### Alineación de texto

```css
text-align: center;
```

### Decoración de texto

```css
text-decoration: underline;
```

### Transformación de texto

```css
text-transform: uppercase;
```

### Espaciado entre letras

```css
letter-spacing: 2px;
```

### Espaciado entre palabras

```css
word-spacing: 2px;
```

### Espaciado entre líneas

```css
line-height: 1.6;
```

### Familia de fuentes

```css
font-family: Arial, sans-serif;
```

### Estilo de fuente

```css
font-style: italic;
```

### Peso de fuente

```css
font-weight: bold;
```

### Decoración de fuente

```css
text-decoration: underline;
```

### Alineación de elementos

```css
text-align: center;
```

Para más información sobre las propiedades de CSS se puede consultar la documentación oficial de [CSS](https://developer.mozilla.org/es/docs/Web/CSS).