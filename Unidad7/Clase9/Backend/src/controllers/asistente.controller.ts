import { Request, Response } from 'express';
import { lista_asistentes } from '../db/db';
import { Asistente } from '../models/asistente.model';

export const crearAsistente = (req: Request, res: Response) => {
    const { codigo, nombre, correo, genero, contrasenia } = req.body
    if(existeAsistente(codigo)){
        res.json({
            mensaje: 'El asistente ya existe',
            type: 'error',
            status: 409
        }).status(409);
    }

    const nuevoAsistente = new Asistente(codigo, nombre, correo, genero, contrasenia);
    lista_asistentes.push(nuevoAsistente);
    res.json({
        mensaje: 'Asistente creado',
        type: 'success',
        status: 201
    }).status(201);
}

const existeAsistente = (codigo: number) => {
    for(let i:number = 0; i < lista_asistentes.length; i++){
        if(lista_asistentes[i].getCodigo() === codigo){
            return true;
        }
    }
    return false;
}

export const obtenerAsistentes = (req: Request, res: Response) => {
    if(lista_asistentes.length === 0){
        res.json({
            mensaje: 'No hay asistentes',
            type: 'error',
            status: 404
        }).status(404)
    }

    res.json({
        mensaje: 'Asistentes encontrados',
        asistentes: lista_asistentes,
        type: 'success',
        status: 200
    }).status(200);
}

export const obtenerAsistente = (req: Request, res: Response) => {
    const { codigo } = req.params;
    for(let i:number = 0; i < lista_asistentes.length; i++){
        if(lista_asistentes[i].getCodigo() === Number(codigo)){
            res.json({
                mensaje: 'Asistente encontrado',
                asistente: lista_asistentes[i],
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Asistente no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const actualizarAsistente = (req: Request, res: Response) => {
    const { codigo } = req.params;
    const { nombre, correo, genero, contrasenia } = req.body;
    for(let i:number = 0; i < lista_asistentes.length; i++){
        if(lista_asistentes[i].getCodigo() === Number(codigo)){
            lista_asistentes[i].setNombre(nombre);
            lista_asistentes[i].setCorreo(correo);
            lista_asistentes[i].setGenero(genero);
            lista_asistentes[i].setContrasenia(contrasenia);
            res.json({
                mensaje: 'Asistente actualizado',
                asistente: lista_asistentes[i],
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Asistente no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const eliminarAsistente = (req: Request, res: Response) => {
    const { codigo } = req.params;
    for(let i:number = 0; i < lista_asistentes.length; i++){
        if(lista_asistentes[i].getCodigo() === Number(codigo)){
            lista_asistentes.splice(i, 1);
            res.json({
                mensaje: 'Asistente eliminado',
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Asistente no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}
