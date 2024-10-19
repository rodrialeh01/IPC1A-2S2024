import { Request, Response } from "express";
import { lista_eventos } from "../db/db";
import { Actividad } from "../models/actividad.model";
import { Evento } from "../models/evento.model";
import { Valoracion } from "../models/valoracion.model";
import { getAsistente } from './asistente.controller';
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
    const lista_eventos2: any[] = [];
    lista_eventos.forEach(evento => {
        lista_eventos2.push({
            codigo: evento.getCodigo(),
            nombre: evento.getNombre(),
            fecha: dateToString(evento.getFecha(), '/'),
            lugar: evento.getLugar(),
            organizador: evento.getOrganizador()
        })
    });
    res.json({
        mensaje: 'Eventos encontrados',
        eventos: lista_eventos2,
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
    const { nombre, lugar, organizador } = req.body;
    for(let i:number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            lista_eventos[i].setNombre(nombre);
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

export const CargaMasivaEventos = (req: Request, res: Response) => {
    const { eventos } = req.body;

    for(let i:number = 0; i< eventos.length; i++){
        let evento = eventos[i];
        const nuevoEvento = new Evento(Number(evento.codigo), evento.nombre, stringToDate(evento.fecha), evento.lugar, evento.organizador);
        lista_eventos.push(nuevoEvento);
    }

    res.json({
        mensaje: 'Eventos creados',
        type: 'success',
        status: 201
    }).status(201);
}

export const CargaMasivaAsistentesEvento = (req: Request, res: Response) => {
    const {asistentes} = req.body;
    const {codigo} = req.params;

    for(let i: number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            for(let j:number = 0; j < asistentes.length; j++){
                let codigo_asistente = asistentes[j].codigo;
                let asistente = getAsistente(codigo_asistente);
                if(asistente){
                    lista_eventos[i].addAsistente(asistente);
                }
            }
        }
    }

    res.json({
        mensaje: 'Asistentes agregados',
        type: 'success',
        status: 200
    }).status(200);
}

export const obtenerAsistentesEvento = (req: Request, res: Response) => {
    const {codigo} = req.params;
    const lista_asistentes_evento = [];
    for(let i:number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            const asistentes = lista_eventos[i].getAsistentes();
            for(let j: number = 0; j < asistentes.length; j++){
                lista_asistentes_evento.push({
                    codigo: asistentes[j].getCodigo(),
                    nombre: asistentes[j].getNombre()
                })
            }
        }
    }

    res.json({
        mensaje: 'Asistentes encontrados',
        asistentes: lista_asistentes_evento,
        type: 'success',
        status: 200
    }).status(200);
}

export const CargaMasivaActividadesEvento = (req: Request, res: Response) => {
    const {codigo} = req.params;
    const {actividades} = req.body;

    for(let i: number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            for(let j:number = 0; j < actividades.length; j++){
                let actividad = new Actividad(contador_actividades, actividades[j].nombre, actividades[j].descripcion, stringToDate2(actividades[j].hora))
                for(let k:number = 0; k < actividades[j].valoraciones.length; k++){
                    let valoracion = new Valoracion(actividades[j].valoraciones[k].valoracion,actividades[j].valoraciones[k].codigo)
                    actividad.addValoracion(valoracion)
                }
                lista_eventos[i].addActividad(actividad);
                contador_actividades++;
            }
        }
    }
    res.json({
        mensaje: 'Actividades agregadas',
        type: 'success',
        status: 200
    }).status(200);
}

export const obtenerActividadesEvento = (req: Request, res: Response) => {
    const {codigo} = req.params;
    const lista_actividades_evento = [];
    for(let i: number = 0; i < lista_eventos.length; i++){
        if(lista_eventos[i].getCodigo() === Number(codigo)){
            const actividades = lista_eventos[i].getActividades();
            for(let j:number = 0; j < actividades.length; j++){
                let actividad = actividades[j]
                let total_valoraciones = actividad.getValoraciones().length;
                let suma_valoraciones = 0;
                for(let k:number = 0; k < total_valoraciones; k++){
                    suma_valoraciones += actividad.getValoraciones()[k].getValor();
                }
                let promedio = suma_valoraciones / total_valoraciones;
                lista_actividades_evento.push({
                    nombre: actividad.getNombre(),
                    descripcion: actividad.getDescripcion(),
                    hora: hourToString(actividad.getHora()),
                    promedio: promedio
                })
            }
        }
    }

    res.json({
        mensaje: 'Actividades encontradas',
        actividades: lista_actividades_evento,
        type: 'success',
        status: 200
    }).status(200);
}

export const stringToDate = (fecha: string): Date => {
    const parts: string[] = fecha.split("-");
    const dia = Number(parts[0]);
    const mes = Number(parts[1]) - 1; // Mes - 1 porque los meses en JS son 0-indexados
    const anio = Number(parts[2]);
    return new Date(anio, mes, dia);
}

export const stringToDate2 = (timeString:string):Date => {
    const [hours, minutes] = timeString.split(':').map(Number);
    const date = new Date();
    date.setHours(hours);
    date.setMinutes(minutes);
    date.setSeconds(0);
    return date;
}

export const hourToString = (hour: Date) => {
    const hours = String(hour.getHours()).padStart(2, '0');
    const minutes = String(hour.getMinutes()).padStart(2, '0');
    return `${hours}:${minutes}`;
}

export const dateToString = (fecha: Date, separacion: string): string => {
    const dia: string = String(fecha.getDate()).padStart(2, '0');
    const mes: string = String(fecha.getMonth() + 1).padStart(2, '0'); // +1 porque los meses son 0-indexados
    const anio: string = String(fecha.getFullYear());
    const fechaFormateada: string = `${dia}${separacion}${mes}${separacion}${anio}`;
    return fechaFormateada;
}