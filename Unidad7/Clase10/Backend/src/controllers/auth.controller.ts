import { Request, Response } from "express";
import { lista_asistentes, lista_organizadores } from "../db/db";

export const login = (req: Request, res: Response) => {
    const { codigo, contrasenia } = req.body;
    /* ROLES:
    1. ADMINISTRADOR
    2. ORGANIZADOR
    3. ASISTENTE
    */
    if(codigo === 'admin' && contrasenia === 'admin'){
        res.json({
            mensaje: 'Bienvenido administrador',
            rol: 1,
            type: 'success',
            status: 200
        }).status(200);
    }
    for(let i:number = 0; i < lista_organizadores.length; i++){
        if(lista_organizadores[i].getCodigo() === codigo && lista_organizadores[i].getContrasenia() === contrasenia){
            res.json({
                mensaje: 'Bienvenido organizador',
                rol: 2,
                type: 'success',
                status: 200
            }).status(200);
        }
    }
    for(let i:number = 0; i < lista_asistentes.length; i++){
        if(lista_asistentes[i].getCodigo() === Number(codigo) && lista_asistentes[i].getContrasenia() === contrasenia){
            res.json({
                mensaje: 'Bienvenido asistente',
                rol: 3,
                type: 'success',
                status: 200
            }).status(200);
        }
    }
    res.json({
        mensaje: 'Credenciales incorrectas',
        type: 'error',
        status: 404
    }).status(404);
}