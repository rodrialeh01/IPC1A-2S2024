# 🤓 Creando una API usando NodeJS, ExpressJS y TypeScript
>Creado por: Rodrigo Hernández para el laboratorio de Introducción a la Programación y Computación 1.

<div align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Typescript_logo_2020.svg/2048px-Typescript_logo_2020.svg.png" width="150"/></div>

Este archivo contiene conceptos que te pueden ayudar a crear tu primera API con NodeJS y JavaSript.

## 📚 Pasos para crear una API usando NodeJS, ExpressJS y TypeScript

### Instalaciones previas:
1. Instalar NodeJS: [https://nodejs.org/en](https://nodejs.org/en)
2. Instalar un editor de texto (recomiendo **VSCode**): [https://code.visualstudio.com/](https://code.visualstudio.com/)
3. Instalar Postman: [https://www.postman.com/downloads//](https://www.postman.com/downloads/)

### Crear un proyecto de NodeJS con TypeScript
1. Crear una carpeta para el proyecto y entrar a esta carpeta:

    ```bash
    mkdir api
    cd api
    ```

2. Instalar Typescript

    ```bash
    npm install -g typescript
    ```

3. Inicializar un nuevo proyecto de Node.js

    ```bash
    npm init -y
    ```

4. Instalar ExpressJS para Typescript

    ```bash
    npm install express
    npm install typescript ts-node @types/node @types/express --save-dev
    ```

5. Instalar CORS

    ```bash
    npm install cors
    npm install @types/cors --save-dev
    ```

6. Instalar Morgan

    ```bash
    npm install morgan
    npm install @types/morgan --save-dev
    ```

7. Instalar Nodemon

    ```bash
    npm install nodemon --save-dev
    npm install @types/node --save-dev
    ```

8. Configurar typescript

    ```bash
    tsc --init
    ```

9. En el archivo `tsconfig.json` ten las siguientes propiedades:

    ```json
    {
        "compilerOptions": {
            "target": "es6",
            "module": "commonjs",
            "outDir": "./dist",
            "rootDir": "./src",
            "strict": true,
            "esModuleInterop": true
        }
    }
    ```


10. Crear la carpeta de `src` para mantener nuestro código dentro de esta carpeta

    ```bash
    mkdir src
    ```

11. Dentro de nuestra carpeta `src` tienes que crear un archivo llamado `index.ts`

12. Dentro de nuestra carpeta de `api` encuentra el archivo de `package.json` que se encontrará de la siguiente manera:

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

13. En el apartado de `scripts`, agrega lo siguiente:
    ```json
    "scripts": {
        "start": "ts-node src/index.ts",
        "build": "tsc",
        "serve": "node dist/index.js",
        "dev": "nodemon",
        "test": "echo \"Error: no test specified\" && exit 1"
    }
    ```

14. Al final te tiene que quedar asi tu archivo `package.json`:

    ```json
    {
        "name": "api",
        "version": "1.0.0",
        "main": "index.js",
        "scripts": {
            "start": "ts-node src/index.ts",
            "build": "tsc",
            "serve": "node dist/index.js",
            "dev": "nodemon",
            "test": "echo \"Error: no test specified\" && exit 1"
        },
        "keywords": [],
        "author": "",
        "license": "ISC",
        "description": ""
    }
    ```
15. Crea un archivo llamado `nodemon.json` que tenga lo siguiente:

    ```json
    {
        "watch": ["src"],
        "ext": "ts",
        "ignore": ["dist"],
        "exec": "ts-node src/index.ts"
    }
    ```

16. En `index.ts` importa tus librerias instaladas:

    ```js
    import cors from 'cors';
    import express from 'express';
    import { Request, Response } from 'express';
    import morgan from 'morgan';
    ```

17. Crea tu nueva API:

    ```js
    const app = express();

    app.use(express.json());
    app.use(morgan('dev'));
    app.use(cors());
    ```

18. Asigna un puerto a tu API:

    ```js
    app.listen(3000);
    ```

19. Crea un método para mostrar tu primer Hola Mundo:

    ```js
    app.get('/', (req: Request, res: Response) => {
        res.send('Hola Mundo');
    });
    ```

20. Ejecuta tu API:

    ```bash
    npm run dev
    ```
