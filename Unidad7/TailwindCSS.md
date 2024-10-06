# TailwindCSS

<div align="center"><img src="https://miro.medium.com/v2/resize:fit:632/1*KTAstxDm8yEG17u94avrXw.png" width="150"/></div>

## Introduccion

TailwindCSS es un framework de CSS que nos permite crear estilos personalizados de manera sencilla y rápida. A diferencia de otros frameworks como Bootstrap, TailwindCSS no tiene estilos predefinidos, por lo que es necesario crearlos nosotros mismos.

## Instalación

Para instalar TailwindCSS en nuestro proyecto, necesitamos tener instalado Node.js y npm. Una vez que tengamos Node.js y npm instalados, podemos instalar TailwindCSS ejecutando el siguiente comando:

```bash
npm install -D tailwindcss
npx tailwindcss init
```

Se creará un archivo `tailwind.config.js` en la raíz de nuestro proyecto, donde podremos configurar los estilos de TailwindCSS.

## Uso

Para utilizar TailwindCSS en nuestro proyecto, necesitamos importar los estilos de TailwindCSS en nuestro archivo CSS principal. Por ejemplo, si estamos utilizando un archivo `styles.css`, podemos importar los estilos de TailwindCSS de la siguiente manera:

```css
@import 'tailwindcss/base';
@import 'tailwindcss/components';
@import 'tailwindcss/utilities';
```
Tambien en el archivo `tailwind.config.js` podemos configurar que se apliquen los estilos en las paginas que queramos indicandolas en el content.

```javascript
content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
```

Además instalamos PostCSS y Autoprefixer para que funcione correctamente TailwindCSS.

```bash
npm install -D postcss autoprefixer
```

Además necesitamos agregar un archivo llamado `postcss.config.js` en la raíz de nuestro proyecto con el siguiente contenido:

```javascript
export default {
    plugins: {
      tailwindcss: {},
      autoprefixer: {},
    },
}
```

Una vez que hayamos importado los estilos de TailwindCSS, podemos utilizar las clases de TailwindCSS en nuestro HTML. Por ejemplo, si queremos aplicar un color de fondo azul a un elemento, podemos hacerlo de la siguiente manera:

```html
<div class="bg-blue-500">
  Este es un elemento con fondo azul.
</div>
```

## Personalización

TailwindCSS nos permite personalizar los estilos de manera sencilla a través del archivo `tailwind.config.js`. En este archivo, podemos configurar los colores, fuentes, márgenes, padding, y otros estilos que queramos utilizar en nuestro proyecto.

Por ejemplo, si queremos agregar un color personalizado a nuestro proyecto, podemos hacerlo de la siguiente manera:

```javascript
// tailwind.config.js
module.exports = {
  theme: {
    extend: {
      colors: {
        'custom-blue': '#007bff',
      },
    },
  },
};
```

Una vez que hayamos agregado el color personalizado a nuestro archivo de configuración, podemos utilizarlo en nuestro HTML de la siguiente manera:

```html
<div class="bg-custom-blue">
  Este es un elemento con fondo azul personalizado.
</div>
```

También podemos instalar plugins de TailwindCSS para agregar funcionalidades adicionales a nuestro proyecto. Por ejemplo, podemos instalar el plugin `scrollbar-hide` para ocultar la barra de desplazamiento en nuestro proyecto:

```bash
npm install -D @tailwindcss/scrollbar-hide
```

Para utilizar el plugin `scrollbar-hide`, necesitamos agregarlo a nuestro archivo de configuración de TailwindCSS:

```javascript
// tailwind.config.js
module.exports = {
  plugins: [
    require('@tailwindcss/scrollbar-hide'),
  ],
};
```
Una vez que hayamos agregado el plugin a nuestro archivo de configuración, podemos utilizarlo en nuestro HTML de la siguiente manera:

```html
<div class="scrollbar-hide">
  Este es un elemento con la barra de desplazamiento oculta.
</div>
```