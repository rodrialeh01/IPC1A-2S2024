import { Actividad } from "./actividad.model";
import { Asistente } from "./asistente.model";

export class Evento {
    private codigo: number;
    private nombre: string;
    private fecha: Date;
    private lugar: string;
    private organizador: string;
    private asistentes: Asistente[];
    private actividades: Actividad[];

    constructor(codigo: number, nombre: string, fecha: Date, lugar:string, organizador: string){
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.organizador = organizador;
        this.asistentes = [];
        this.actividades = [];
    }

    public getCodigo(): number {
        return this.codigo;
    }

    public setCodigo(codigo: number): void {
        this.codigo = codigo;
    }

    public getNombre(): string {
        return this.nombre;
    }

    public setNombre(nombre: string): void {
        this.nombre = nombre;
    }

    public getFecha(): Date {
        return this.fecha;
    }

    public setFecha(fecha: Date): void {
        this.fecha = fecha;
    }

    public getLugar(): string {
        return this.lugar;
    }

    public setLugar(lugar: string): void {
        this.lugar = lugar;
    }

    public getOrganizador(): string {
        return this.organizador;
    }

    public setOrganizador(organizador: string): void {
        this.organizador = organizador;
    }

    public getAsistentes(): Asistente[] {
        return this.asistentes;
    }

    public setAsistentes(asistentes: Asistente[]): void {
        this.asistentes = asistentes;
    }

    public getActividades(): Actividad[] {
        return this.actividades;
    }

    public setActividades(actividades: Actividad[]): void {
        this.actividades = actividades;
    }

    public addAsistente(asistente: Asistente): void {
        this.asistentes.push(asistente);
    }

    public addActividad(actividad: Actividad): void {
        this.actividades.push(actividad);
    }
}