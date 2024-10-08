import { Request, Response } from "express";
import { lista_eventos } from "../db/db";
import { Evento } from "../models/evento.model";
import { existeOrganizador } from "./organizador.controller";

let contador_actividades = 1;

export const crearEvento = (req: Request, res: Response) => {
    const { codigo, nombre, fecha, lugar, organizador } = req.body;
    if(!existeOrganizador(organizador)){
        res.json({
            mensaje: 'El organizador no existe',
            type: 'error',
            status: 404
        }).status(404);
    }
    const fecha_casteada = new Date(fecha)
    const nuevoEvento = new Evento(codigo, nombre, fecha_casteada, lugar, organizador);
    lista_eventos.push(nuevoEvento);
    res.json({
        mensaje: 'Evento creado',
        type: 'success',
        status: 201
    }).status(201);
}

export const obtenerEventos = (req: Request, res: Response) => {
    if(lista_eventos.length === 0){
        res.json({
            mensaje: 'No hay eventos',
            type: 'error',
            status: 404
        }).status(404);
    }

    res.json({
        mensaje: 'Eventos encontrados',
        eventos: lista_eventos,
        type: 'success',
        status: 200
    }).status(200);
}

export const obtenerEvento = (req: Request, res: Response) => {
    const { codigo } = req.params;
    for(let i:number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            res.json({
                mensaje: 'Evento encontrado',
                evento: lista_eventos[i],
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Evento no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const actualizarEvento = (req: Request, res: Response) => {
    const { codigo } = req.params;
    const { nombre, fecha, lugar, organizador } = req.body;
    for(let i:number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            lista_eventos[i].setNombre(nombre);
            lista_eventos[i].setFecha(new Date(fecha));
            lista_eventos[i].setLugar(lugar);
            lista_eventos[i].setOrganizador(organizador);
            res.json({
                mensaje: 'Evento actualizado',
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Evento no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

export const eliminarEvento = (req: Request, res: Response) => {
    const { codigo } = req.params;
    for(let i:number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            lista_eventos.splice(i, 1);
            res.json({
                mensaje: 'Evento eliminado',
                type: 'success',
                status: 200
            }).status(200);
        }
    }

    res.json({
        mensaje: 'Evento no encontrado',
        type: 'error',
        status: 404
    }).status(404);
}

const existeEvento = (codigo: number) => {
    for(let i:number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === codigo){
            return true;
        }
    }
    return false;
}

