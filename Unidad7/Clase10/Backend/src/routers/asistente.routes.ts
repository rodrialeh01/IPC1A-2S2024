import { Router } from "express";
import { actualizarAsistente, CargaMasivaAsistentes, crearAsistente, eliminarAsistente, obtenerAsistente, obtenerAsistentes } from "../controllers/asistente.controller";

const routerAsistente = Router();

routerAsistente.post('/crear', crearAsistente);
routerAsistente.get('/obtener', obtenerAsistentes);
routerAsistente.get('/obtener/:codigo', obtenerAsistente);
routerAsistente.put('/actualizar/:codigo', actualizarAsistente);
routerAsistente.delete('/eliminar/:codigo', eliminarAsistente);
routerAsistente.post('/carga', CargaMasivaAsistentes);
export default routerAsistente;