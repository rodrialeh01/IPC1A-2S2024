import cors from 'cors';
import express from 'express';
import morgan from 'morgan';
import routerAsistente from './routers/asistente.routes';
import routerAuth from './routers/auth.routes';
import routerEvento from './routers/evento.routes';
import routerOrganizador from './routers/organizador.routes';



const app = express();
const port = 3000;

app.use(express.json());
app.use(morgan('dev'));
app.use(cors());

app.use('/organizador', routerOrganizador);
app.use('/asistente', routerAsistente);
app.use('/evento', routerEvento);
app.use('/auth', routerAuth);

app.listen(port, ()=> {
    console.log(`Backend levantado en http://localhost:${port}`);
})