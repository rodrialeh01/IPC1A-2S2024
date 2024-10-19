import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Service from "../../Service/Service";

const Asistenteeditar = () => {
    const { codigo } = useParams();
    const navigate = useNavigate();
    const [nombre, setNombre] = useState("");
    const [correo, setCorreo] = useState("");
    const [contrasenia, setContrasenia] = useState("");

    useEffect(() => {
        const data_logueado = JSON.parse(localStorage.getItem("data_user"));
        if(!data_logueado){
            navigate("/");
        }
        Service.obtenerAsistente(codigo)
        .then(response =>{
            console.log(response)
            setNombre(response.asistente.nombre);
            setCorreo(response.asistente.correo);
            setContrasenia(response.asistente.contrasenia);
        })
    },[])

    const handleSubmit = (e) => {
        e.preventDefault();
    }

    const onChangeCorreo = (e) => {
        setCorreo(e.target.value)
    }

    const onChangePassword = (e) => {
        setContrasenia(e.target.value)
    }

    const onChangeNombre = (e) => {
        setNombre(e.target.value)
    }

    const handleEditar = () =>{
        const data = {
            nombre: nombre,
            correo: correo,
            contrasenia: contrasenia
        }
        Service.editarAsistente(codigo, data)
        .then(response => {
            if(response.status === 200){
                navigate('/admin/asistentes')
            }
        })
    }

    const handleCancelar = () => {
        navigate('/admin/asistentes');
    }

    return(
    <form class="max-w-md mx-auto mt-28" type="submit" onSubmit={handleSubmit}>
        <h1 className="text-3xl mb-5">Editar Asistente</h1>
        <div class="relative z-0 w-full mb-5 group">
            <input 
                type="email" 
                name="floating_email" 
                id="floating_email" 
                class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" 
                placeholder=" " 
                required 
                value={correo}
                onChange={onChangeCorreo}
                />
            <label for="floating_email" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Correo Eléctronico</label>
        </div>
        <div class="relative z-0 w-full mb-5 group">
            <input 
                type="password" 
                name="floating_password" 
                id="floating_password" 
                class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none  dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" 
                placeholder=" " 
                required 
                value={contrasenia}
                onChange={onChangePassword}
            />
            <label for="floating_password" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Contraseña</label>
        </div>
        <div class="relative z-0 w-full mb-5 group">
            <input 
                type="text" 
                name="floating_first_name" 
                id="floating_first_name" 
                class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none  dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" 
                placeholder=" " 
                required 
                value={nombre}
                onChange={onChangeNombre}
            />
            <label for="floating_first_name" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Nombres y Apellidos</label>
        </div>
        <button 
        type="button" 
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 mr-5"
        onClick={handleEditar}
        >Confirmar Cambios</button>
        <button 
            type="button" 
            class="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800"
            onClick={handleCancelar}
        >Cancelar</button>
    </form>
    )
}

export default Asistenteeditar;