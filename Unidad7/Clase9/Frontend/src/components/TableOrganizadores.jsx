import { FaRegTrashAlt } from "react-icons/fa";
import { MdEdit } from "react-icons/md";
import { useNavigate } from "react-router-dom";
import Service from "../Service/Service";
const TableOrganizadores = ({contenido}) => {
    const navigate = useNavigate();
    const handleEditar = (codigo) => {
        navigate(`/admin/organizadores/edit/${codigo}`)
    }

    const handleEliminar = (codigo) => {
        Service.eliminarOrganizador(codigo)
        .then(response => {
            console.log(response)
            window.location.reload()
        })
    }

    return (
        <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
            <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                        <th scope="col" class="px-6 py-3">
                            Código
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Nombres y Apellidos
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Correo
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Género
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Acciones
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {contenido.map((dato) => {
                    return(<tr  class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                        <td scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                            {dato.codigo}
                        </td>
                        <td class="px-6 py-4">
                            {dato.nombre}
                        </td>
                        <td class="px-6 py-4">
                            {dato.correo}
                        </td>
                        <td class="px-6 py-4">
                            {dato.genero}
                        </td>
                        <td class="px-6 py-4 text-center">
                            <button 
                            type="button" 
                            class="focus:outline-none text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 dark:bg-purple-600 dark:hover:bg-purple-700 dark:focus:ring-purple-900 mr-5"
                            onClick={()=>handleEditar(dato.codigo)}
                            ><MdEdit className="text-white"/>
                            </button>
                            <button 
                            type="button" 
                            class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900 ml-5"
                            onClick={()=>handleEliminar(dato.codigo)}
                            ><FaRegTrashAlt className="text-white" />
                            </button>
                        </td>
                    </tr>)
                    })}
                </tbody>
            </table>
        </div>
    )
}

export default TableOrganizadores;