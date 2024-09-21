import { lista_usuarios } from "../db/db.js"
import { User } from "../models/user.model.js"

export const getInit = (req, res) => {
    res.send({
        message: "Bienvenido a mi API de la clase 8 de IPC1"
    })
}

//CREAR USUARIO
export const crearUsuario = (req, res) => {
    const { name, email, password } = req.body;
    const nuevoUsuario = new User(name, email, password);
    lista_usuarios.push(nuevoUsuario);
    res.send({
        mensaje: "Usuario creado correctamente",
        status: true,
        code: 200
    }), 200
}

//READ
export const obtenerUsuarios = (req, res) => {
    res.send({
        mensaje: "Usuarios obtenidos con exito",
        usuarios: lista_usuarios,
        status: true,
        code: 200
    }),200
}

//UPDATE
export const actualizarUsuario = (req, res) => {
    const { name, email, password } = req.body;
    for(let i = 0; i < lista_usuarios.length; i++){
        if(lista_usuarios[i].email === email){
            lista_usuarios[i].name = name;
            lista_usuarios[i].password = password;
            res.send({
                mensaje: "Usuario actualizado correctamente",
                status: true,
                code: 200
            }),200
        }
    }
    res.send({
        mensaje: "No se encontró al usuario",
        status: false,
        code: 400
    }),400
}

//DELETE
export const eliminarUsuario = (req, res) => {
    const { email } = req.body;
    for(let i = 0; i < lista_usuarios.length; i++){
        if(lista_usuarios[i].email === email){
            lista_usuarios.splice(i, 1);
            res.send({
                mensaje: "Usuario eliminado correctamente",
                status: true,
                code: 200
            }),200
        }
    }
    res.send({
        mensaje: "No se encontró al usuario",
        status: false,
        code: 400
    }),400
}