export class Asistente{
    private codigo: number;
    private nombre: string;
    private correo: string;
    private genero: string;
    private contrasenia: string;

    constructor(codigo: number, nombre: string, correo: string, genero: string, contrasenia: string) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.genero = genero;
        this.contrasenia = contrasenia;
    }

    public getCodigo():number{
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

    public getCorreo(): string {
        return this.correo;
    }

    public setCorreo(correo: string): void {
        this.correo = correo;
    }

    public getGenero(): string {
        return this.genero;
    }

    public setGenero(genero: string): void {
        this.genero = genero;
    }

    public getContrasenia(): string {
        return this.contrasenia;
    }

    public setContrasenia(contrasenia: string): void {
        this.contrasenia = contrasenia;
    }
}