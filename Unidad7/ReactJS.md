# React

<div align="center"><img src="https://static-00.iconduck.com/assets.00/react-original-wordmark-icon-840x1024-vhmauxp6.png" width="150"/></div>

## Introducción

En esta unidad se abordarán los temas de programación web, en específico se verá la librería de JavaScript React. Este readme esta dedicado a mostrar un poco de la sintaxis de React y algunos ejemplos.

## JSX

En React se utiliza JSX para escribir los componentes, JSX es una extensión de JavaScript que permite escribir HTML en JavaScript.

```jsx
import React from 'react';

function App() {
  return (
    <div>
      <h1>Hola Mundo</h1>
    </div>
  );
}

export default App;
```

## Componentes

En React se pueden crear componentes de la siguiente manera:

```jsx
import React from 'react';

function Saludo(props) {
  return (
    <h1>Hola {props.nombre}</h1>
  );
}

export default Saludo;
```

## Props

En React se pueden pasar propiedades a los componentes de la siguiente manera:

```jsx
import React from 'react';
import Saludo from './Saludo';

function App() {
  return (
    <div>
      <Saludo nombre="Rodrigo" />
    </div>
  );
}

export default App;
```

## Hooks

En React se pueden utilizar hooks para manejar el estado y ciclo de vida de los componentes de la siguiente manera:


### useState

Este hook se utiliza para manejar el estado de un componente. 

```jsx
import React, { useState } from 'react';

const [contador, setContador] = useState(0);
```

### useEffect

Este hook se utiliza para manejar el ciclo de vida de un componente.

```jsx
import React, { useEffect } from 'react';

useEffect(() => {
  console.log('Componente montado');
}, []);
```

### useContext

Este hook se utiliza para manejar el contexto de un componente.

```jsx
import React, { useContext } from 'react';

const valor = useContext(Contexto);
```

### useRef

Este hook se utiliza para manejar referencias a elementos del DOM.

```jsx
import React, { useRef } from 'react';

const inputRef = useRef();
```