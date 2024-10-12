import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:3000/',
})

//LOGIN: http://localhost:3000/auth/login -> POST -> {codigo, contrasenia}
export const login = async (credenciales) => {
    const response = await instance.post('auth/login', credenciales, {
        headers: {
            'Content-Type': 'application/json'
        }
    });
    return response.data;
}

//GET Organizadores
export const obtenerOrganizadores = async() => {
    const response = await instance.get('organizador/obtener');
    return response.data;
}

//GET Organizador
export const obtenerOrganizador = async(id) => {
    const response = await instance.get(`organizador/obtener/${id}`);
    return response.data;
}

//PUT Organizador
export const editarOrganizador = async(id, data) => {
    const response = await instance.put(`organizador/actualizar/${id}`, data);
    return response.data;
}

//DELETE Organizador
export const eliminarOrganizador = async(id) => {
    const response = await instance.delete(`organizador/eliminar/${id}`);
    return response.data;
}

//CARGA Organizador
export const cargarOrganizador = async(data) => {
    const response = await instance.post('organizador/carga', data);
    console.log(response.data)
    return response.data;
}