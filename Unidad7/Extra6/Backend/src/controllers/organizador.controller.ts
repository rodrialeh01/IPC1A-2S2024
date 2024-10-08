import { Request, Response } from 'express';
import { lista_organizadores } from '../db/db';
import { Organizador } from '../models/organizador.model';

export const crearOrganizador = (req: Request, res: Response) => {
    const { codigo, nombre, correo, genero, contrasenia } = req.body
    if(existeOrganizador(codigo)){
        res.json({
            mensaje: 'El organizador ya existe',
            type: 'error',
            status: 409
        }).status(409);
    }

    const nuevoOrganizador = new Organizador(codigo, nombre, correo, genero, contrasenia);
    lista_organizadores.push(nuevoOrganizador);
    res.json({
        mensaje: 'Organizador creado',
        type: 'success',
        status: 201
    }).status(201);
}

export const obtenerOrganizadores = (req: Request, res: Response) => {
    if(lista_organizadores.length === 0){
        res.json({
            mensaje: 'No hay organizadores',
            type: 'error',
            status: 404
        }).status(404)
    }

    res.json({
        mensaje: 'Organizadores encontrados',
        organizadores: lista_organizadores,
        type: 'success',
        status: 200
    }).status(200);
}

export const obtenerOrganizador = (req: Request, res: Response) => {
    const { codigo } = req.params;
    for(let i:number = 0; i < lista_organizadores.length; i++){
        if(lista_organizadores[i].getCodigo() === codigo){
            res.json({
                mensaje: 'Organizador encontrado',
                organizador: lista_organizadores[i],
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Organizador no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const actualizarOrganizador = (req: Request, res: Response) => {
    const { codigo } = req.params;
    const { nombre, correo, genero, contrasenia } = req.body;
    for(let i:number = 0; i < lista_organizadores.length; i++){
        if(lista_organizadores[i].getCodigo() === codigo){
            lista_organizadores[i].setNombre(nombre);
            lista_organizadores[i].setCorreo(correo);
            lista_organizadores[i].setGenero(genero);
            lista_organizadores[i].setContrasenia(contrasenia);
            res.json({
                mensaje: 'Organizador actualizado',
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Organizador no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const eliminarOrganizador = (req: Request, res: Response) => {
    const { codigo } = req.params;
    for(let i:number = 0; i < lista_organizadores.length; i++){
        if(lista_organizadores[i].getCodigo() === codigo){
            lista_organizadores.splice(i, 1);
            res.json({
                mensaje: 'Organizador eliminado',
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Organizador no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const existeOrganizador = (codigo: string) => {
    for(let i:number = 0; i < lista_organizadores.length; i++){
        if(lista_organizadores[i].getCodigo() === codigo){
            return true;
        }
    }
    return false;
}