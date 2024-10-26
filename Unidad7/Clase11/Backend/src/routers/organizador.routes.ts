import { Router } from "express";
import { actualizarOrganizador, CargaMasivaOrganizadores, crearOrganizador, eliminarOrganizador, eventosPorOrganizador, obtenerOrganizador, obtenerOrganizadores, reporteOrganizador } from "../controllers/organizador.controller";

const routerOrganizador = Router();

routerOrganizador.post('/crear', crearOrganizador);
routerOrganizador.get('/obtener', obtenerOrganizadores);
routerOrganizador.get('/obtener/:codigo', obtenerOrganizador);
routerOrganizador.put('/actualizar/:codigo', actualizarOrganizador);
routerOrganizador.delete('/eliminar/:codigo', eliminarOrganizador);
routerOrganizador.post('/carga', CargaMasivaOrganizadores);
routerOrganizador.get('/eventos/:codigo', eventosPorOrganizador);
routerOrganizador.get('/reporte', reporteOrganizador);

export default routerOrganizador;