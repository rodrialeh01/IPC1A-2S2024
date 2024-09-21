import cors from 'cors';
import express from 'express';
import morgan from 'morgan';
import handleRouter from './routers/user.routes.js';

const app = express();

app.use(express.json());
app.use(morgan('dev'));
app.use(cors());

app.use('/user', handleRouter);

app.listen(3000);

console.log('Servidor levantado en el lugar: http://localhost:3000')