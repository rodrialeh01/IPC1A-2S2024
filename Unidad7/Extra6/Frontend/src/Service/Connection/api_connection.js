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