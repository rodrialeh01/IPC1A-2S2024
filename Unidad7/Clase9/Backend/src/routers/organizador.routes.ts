import { Router } from "express";
import { actualizarOrganizador, CargaMasivaOrganizadores, crearOrganizador, eliminarOrganizador, obtenerOrganizador, obtenerOrganizadores } from "../controllers/organizador.controller";

const routerOrganizador = Router();

routerOrganizador.post('/crear', crearOrganizador);
routerOrganizador.get('/obtener', obtenerOrganizadores);
routerOrganizador.get('/obtener/:codigo', obtenerOrganizador);
routerOrganizador.put('/actualizar/:codigo', actualizarOrganizador);
routerOrganizador.delete('/eliminar/:codigo', eliminarOrganizador);
routerOrganizador.post('/carga', CargaMasivaOrganizadores);

export default routerOrganizador;