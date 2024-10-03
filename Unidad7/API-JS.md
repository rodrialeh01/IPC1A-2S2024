# 🤓 Creando una API usando NodeJS, ExpressJS y JavaScript
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

<div align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/800px-Unofficial_JavaScript_logo_2.svg.png" width="150"/></div>

Este archivo contiene conceptos que te pueden ayudar a crear tu primera API con NodeJS y JavaSript.

## 📚 Pasos para crear una API usando NodeJS, ExpressJS y JavaScript

### Instalaciones previas:
1. Instalar NodeJS: [https://nodejs.org/en](https://nodejs.org/en)
2. Instalar un editor de texto (recomiendo **VSCode**): [https://code.visualstudio.com/](https://code.visualstudio.com/)
3. Instalar Postman: [https://www.postman.com/downloads//](https://www.postman.com/downloads/)

### Crear un proyecto de NodeJS
1. Crear una carpeta para el proyecto y entrar a esta carpeta:

    ```bash
    mkdir api
    cd api
    ```

2. Inicializar un nuevo proyecto de Node.js

    ```bash
    npm init -y
    ```

3. Instalar ExpressJS

    ```bash
    npm install express
    ```

4. Instalar CORS

    ```bash
    npm install cors
    ```

5. Instalar Morgan

    ```bash
    npm install morgan
    ```

6. Instalar Nodemon

    ```bash
    npm install nodemon
    ```

7. Crear la carpeta de `src` para mantener nuestro código dentro de esta carpeta

    ```bash
    mkdir src
    ```

8. Dentro de nuestra carpeta `src` tienes que crear un archivo llamado `index.js`

9. Dentro de nuestra carpeta de `api` encuentra el archivo de `package.json` que se encontrará de la siguiente manera:

    ```json
    {
        "name": "api",
        "version": "1.0.0",
        "main": "index.js",
        "scripts": {
            "test": "echo \"Error: no test specified\" && exit 1"
        },
        "keywords": [],
        "author": "",
        "license": "ISC",
        "description": ""
    }
    ```

10. En el apartado de `scripts`, agrega lo siguiente:
    ```json
    "scripts": {
        "start": "node src/index.js",
        "dev": "nodemon src/index.js",
        "test": "echo \"Error: no test specified\" && exit 1"
    }
    ```

11. En el json, arriba de los scripts añade lo siguiente:

    ```json
    "type": "module",
    ```

12. Al final te tiene que quedar asi tu archivo `package.json`:

    ```json
    {
        "name": "api",
        "version": "1.0.0",
        "description": "",
        "main": "index.js",
        "type": "module",
        "scripts": {
            "start": "node src/index.js",
            "dev": "nodemon src/index.js",
            "test": "echo \"Error: no test specified\" && exit 1"
        },
        "author": "",
        "license": "ISC",
        "dependencies": {
            "cors": "^2.8.5",
            "express": "^4.21.0",
            "morgan": "^1.10.0",
            "nodemon": "^3.1.7"
        }
    }
    ```


13. En `index.js` importa tus librerias instaladas:

    ```js
    import cors from 'cors';
    import express from 'express';
    import morgan from 'morgan';
    ```

14. Crea tu nueva API:

    ```js
    const app = express();

    app.use(express.json());
    app.use(morgan('dev'));
    app.use(cors());
    ```

15. Asigna un puerto a tu API:

    ```js
    app.listen(3000);
    ```

16. Crea un método para mostrar tu primer Hola Mundo:

    ```js
    app.get('/', (req, res) => {
        res.send('Hola Mundo');
    });
    ```

17. Ejecuta tu API:

    ```bash
    npm run dev
    ```