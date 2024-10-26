import { Router } from "express";
import { actualizarEvento, CargaMasivaActividadesEvento, CargaMasivaAsistentesEvento, CargaMasivaEventos, crearEvento, eliminarEvento, obtenerActividadesEvento, obtenerAsistentesEvento, obtenerEvento, obtenerEventos } from '../controllers/evento.controller';

const routerEvento = Router();

routerEvento.post('/crear', crearEvento);
routerEvento.get('/obtener', obtenerEventos);
routerEvento.get('/obtener/:codigo', obtenerEvento);
routerEvento.put('/actualizar/:codigo', actualizarEvento);
routerEvento.delete('/eliminar/:codigo', eliminarEvento);
routerEvento.post('/carga', CargaMasivaEventos);
routerEvento.post('/asistentes/cargar/:codigo', CargaMasivaAsistentesEvento);
routerEvento.get('/asistentes/:codigo', obtenerAsistentesEvento);
routerEvento.post('/actividades/cargar/:codigo', CargaMasivaActividadesEvento);
routerEvento.get('/actividades/:codigo', obtenerActividadesEvento);

export default routerEvento;
