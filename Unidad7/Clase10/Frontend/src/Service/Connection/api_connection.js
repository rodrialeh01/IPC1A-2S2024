import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:3000',
})

//Login
export const login = async(credentials) => {
    const response = await instance.post('auth/login', credentials, {
        headers: {
            'Content-Type': 'application/json'
        }
    });
    console.log(response);
    return response.data;
}

//----------------- ORGANIZADOR ---------------------
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

//Eventos por organizador
export const eventosPorOrganizador = async(id) => {
    const response = await instance.get(`organizador/eventos/${id}`);
    return response.data;
}

//----------------- ASISTENTE ---------------------
//GET Asistentes
export const obtenerAsistentes = async() => {
    const response = await instance.get('asistente/obtener');
    return response.data;
}

//GET Asistente
export const obtenerAsistente = async(id) => {
    const response = await instance.get(`asistente/obtener/${id}`);
    console.log(response)
    return response.data;
}

//PUT Asistente
export const editarAsistente = async(id, data) => {
    const response = await instance.put(`asistente/actualizar/${id}`, data);
    return response.data;
}

//DELETE Asistente
export const eliminarAsistente = async(id) => {
    const response = await instance.delete(`asistente/eliminar/${id}`);
    return response.data;
}

//CARGA Asistente
export const cargarAsistente = async(data) => {
    const response = await instance.post('asistente/carga', data);
    return response.data;
}

//----------------- EVENTO ---------------------
//GET Eventos
export const obtenerEventos = async() => {
    const response = await instance.get('evento/obtener');
    return response.data;
}

//GET Evento
export const obtenerEvento = async(id) => {
    const response = await instance.get(`evento/obtener/${id}`);
    return response.data;
}

//PUT Evento
export const editarEvento = async(id, data) => {
    const response = await instance.put(`evento/actualizar/${id}`, data);
    return response.data;
}

//DELETE Evento
export const eliminarEvento = async(id) => {
    const response = await instance.delete(`evento/eliminar/${id}`);
    return response.data;
}

//CARGA Evento
export const cargarEvento = async(data) => {
    const response = await instance.post('evento/carga', data);
    return response.data;
}

//CARGA Asistentes del evento
export const cargarAsistentesEvento = async(data, codigo) => {
    const response = await instance.post(`evento/asistentes/cargar/${codigo}`, data);
    return response.data;
}

//OBTENER Asistentes del evento
export const obtenerAsistentesEvento = async(codigo) => {
    const response = await instance.get(`evento/asistentes/${codigo}`);
    return response.data;
}

//CARGAR Actividades del evento
export const cargarActividadesEvento = async(data, codigo) => {
    const response = await instance.post(`evento/actividades/cargar/${codigo}`, data);
    return response.data;
}

//OBTENER Actividades del evento
export const obtenerActividadesEvento = async(codigo) => {
    const response = await instance.get(`evento/actividades/${codigo}`);
    return response.data;
}