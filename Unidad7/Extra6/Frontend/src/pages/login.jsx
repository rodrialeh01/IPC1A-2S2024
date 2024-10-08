import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Service from "../Service/Service";
import { useAuthContext } from "../context/AuthContext";
const Login = () => {

    const navigate = useNavigate();

    const {logueado, setLogueado} = useAuthContext();

    const [credenciales, setCredenciales] = useState({
        codigo:'',
        contrasenia: ''
    })

    const handleSubmit = (e) => {
        e.preventDefault();
    }

    const onChangeCredentials = (e) => {
        setCredenciales({
            ...credenciales,
            [e.target.name]: e.target.value
        })
    }

    const handleLogin = () => {
        Service.login(credenciales)
        .then(response => {
            console.log(response)
            if(response.status === 200){
                /*
                {
                    codigo/carnet: xxxxx,
                    rol: 1/2/3
                }
                */
                const data_a_guardar = {
                    codigo: credenciales.codigo,
                    rol: response.rol
                }
                localStorage.setItem("data_user", JSON.stringify(data_a_guardar));
                setLogueado(true);
                if(response.rol === 1){
                    navigate('/admin/home')
                }else if(response.rol === 2){
                    navigate('/organizador/home')
                }else if(response.rol === 3){
                    navigate('/asistente/home')
                }
            }else{
                alert('Error al loguearse')
            }
        })
        .catch(error => {
            console.log(error);
        })
    }

    return(
        <div class="bg-gray-50 dark:bg-gray-900">
            <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
                <a href="#" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
                    <img class="w-8 h-8 mr-2" src="https://img.freepik.com/vector-premium/coleccion-logotipos-letras-alfabeticas_647881-448.jpg" alt="logo"/>
                    Eventos Chapines 502
                </a>
                <div class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
                    <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                        <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                            Inicia Sesión
                        </h1>
                        <form class="space-y-4 md:space-y-6" onSubmit={handleSubmit}>
                            <div>
                                <label for="codigo" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Código</label>
                                <input 
                                    type="text" 
                                    name="codigo" 
                                    id="codigo" 
                                    class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" 
                                    placeholder="EV-OR00" 
                                    required=""
                                    value={credenciales.codigo}
                                    onChange={onChangeCredentials}
                                />
                            </div>
                            <div>
                                <label for="contrasenia" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Contraseña</label>
                                <input 
                                    type="password" 
                                    name="contrasenia" 
                                    id="contrasenia" 
                                    placeholder="••••••••" 
                                    class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" 
                                    required=""
                                    value={credenciales.contrasenia}
                                    onChange={onChangeCredentials}
                                />
                            </div>
                            <button 
                                type="submit" 
                                class="w-full text-white bg-primary-600 hover:bg-primary-700 bg-gray-500 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center "
                                onClick={handleLogin}
                                >Iniciar Sesión
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Login;