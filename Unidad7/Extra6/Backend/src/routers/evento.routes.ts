import { Router } from "express";
import { actualizarEvento, crearEvento, eliminarEvento, obtenerEvento, obtenerEventos } from '../controllers/evento.controller';

const routerEvento = Router();

routerEvento.post('/crear', crearEvento);
routerEvento.get('/obtener', obtenerEventos);
routerEvento.get('/obtener/:codigo', obtenerEvento);
routerEvento.put('/actualizar/:codigo', actualizarEvento);
routerEvento.delete('/eliminar/:codigo', eliminarEvento);

export default routerEvento;
