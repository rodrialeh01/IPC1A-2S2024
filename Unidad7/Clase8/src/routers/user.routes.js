import { Router } from "express";
import { actualizarUsuario, crearUsuario, eliminarUsuario, obtenerUsuarios } from "../controllers/user.controller.js";

const router = Router();

router.post('/crear', crearUsuario);
router.get('/leer', obtenerUsuarios);
router.put('/actualizar', actualizarUsuario);
router.delete('/eliminar',eliminarUsuario);

export default router;