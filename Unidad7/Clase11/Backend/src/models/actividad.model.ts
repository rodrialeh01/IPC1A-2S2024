import { Valoracion } from "./valoracion.model";

export class Actividad {
    private id: number;
    private nombre: string;
    private descripcion: string;
    private hora: Date;
    private valoraciones: Valoracion[];

    constructor(id: number, nombre: string, descripcion: string, hora: Date) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hora = hora;
        this.valoraciones = [];
    }

    public getId(): number {
        return this.id;
    }

    public setId(id: number): void {
        this.id = id;
    }

    public getNombre(): string {
        return this.nombre;
    }

    public setNombre(nombre: string): void {
        this.nombre = nombre;
    }

    public getDescripcion(): string {
        return this.descripcion;
    }

    public setDescripcion(descripcion: string): void {
        this.descripcion = descripcion;
    }

    public getHora(): Date {
        return this.hora;
    }

    public setHora(hora: Date): void {
        this.hora = hora;
    }

    public getValoraciones(): Valoracion[] {
        return this.valoraciones;
    }

    public setValoraciones(valoraciones: Valoracion[]): void {
        this.valoraciones = valoraciones;
    }

    public addValoracion(valoracion: Valoracion): void {
        this.valoraciones.push(valoracion);
    }
}