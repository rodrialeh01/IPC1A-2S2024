export class Valoracion {
    private valor: number;
    private asistente: number;

    constructor(valor: number, asistente: number) {
        this.valor = valor;
        this.asistente = asistente;
    }

    public getValor(): number {
        return this.valor;
    }

    public setValor(valor: number): void {
        this.valor = valor;
    }

    public getAsistente(): number {
        return this.asistente;
    }
}