export class Valoracion {
    private valor: number;
    private comentario: string;
    private asistente: number;

    constructor(valor: number, comentario: string, asistente: number) {
        this.valor = valor;
        this.comentario = comentario;
        this.asistente = asistente;
    }

    public getValor(): number {
        return this.valor;
    }

    public setValor(valor: number): void {
        this.valor = valor;
    }

    public getComentario(): string {
        return this.comentario;
    }

    public setComentario(comentario: string): void {
        this.comentario = comentario;
    }

    public getAsistente(): number {
        return this.asistente;
    }
}