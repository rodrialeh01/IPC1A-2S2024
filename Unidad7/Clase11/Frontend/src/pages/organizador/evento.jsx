import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Service from "../../Service/Service";
const Eventodetalle = () => {
    const { codigo } = useParams();
    const [asistentes, setAsistentes] = useState([]);
    const [actividades, setActividades] = useState([]);
    const [nombre, setNombre] = useState("")

    useEffect(() => {
        Service.obtenerEvento(codigo)
        .then((response) => {
            setNombre(response.evento.nombre);
        })

        Service.obtenerAsistentesEvento(codigo)
        .then((response) => {
            setAsistentes(response.asistentes);
        })
        .catch((error) => {
            setAsistentes([]);
        })

        Service.obtenerActividadesEvento(codigo)
        .then((response) => {
            setActividades(response.actividades);
        })
        .catch((error) => {
            setActividades([]);
        })
    },[]);

    const cargarAsistentes = (e) => {
        const archivo = e.target.files[0];
        const fileReader = new FileReader();

        fileReader.readAsText(archivo, 'UTF-8');
        fileReader.onload = (e) => {
            const contenido = JSON.parse(e.target.result)
            const data = {
                asistentes: contenido
            }

            Service.cargarAsistentesEvento(data, codigo)
            .then((response) => {
                window.location.reload()
            })
        }
        fileReader.onerror = (error) => {
            console.log(error)
        }
    }

    const cargarActividades = (e) => {
        const archivo = e.target.files[0];
        const fileReader = new FileReader();

        fileReader.readAsText(archivo, 'UTF-8');
        fileReader.onload = (e) => {
            const contenido = JSON.parse(e.target.result)
            const data = {
                actividades: contenido
            }

            Service.cargarActividadesEvento(data, codigo)
            .then((response) => {
                window.location.reload()
            })
        }
        fileReader.onerror = (error) => {
            console.log(error)
        }
    }

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-2">Evento: {nombre}</h1>
            <h2 className="text-xl font-semibold mb-4">Código: {codigo}</h2>
            
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                {/* Listado de Alumnos */}
                <div className="border rounded-lg overflow-hidden shadow-md flex flex-col" style={{ height: '80vh' }}>
                    <h3 className="bg-gray-100 p-2 font-semibold">Listado de Asistentes</h3>
                    <div className="overflow-y-auto flex-grow">
                        <table className="w-full">
                            <thead>
                                <tr className="bg-gray-50">
                                    <th className="p-2 text-left">Código</th>
                                    <th className="p-2 text-left">Nombre Completo</th>
                                </tr>
                            </thead>
                            <tbody>
                                {asistentes.length > 0 ? asistentes.map((asistente, index) => (
                                    <tr key={index} className="border-t">
                                        <td className="p-2">{asistente.codigo}</td>
                                        <td className="p-2">{asistente.nombre}</td>
                                    </tr>
                                )) : (
                                    <tr>
                                        <td colSpan="2" className="p-2 text-center">No hay asistentes</td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                </div>
                
                {/* Listado de Actividades */}
                <div className="border rounded-lg overflow-hidden shadow-md flex flex-col" style={{ height: '80vh' }}>
                    <div className="bg-gray-100 p-2 flex justify-between items-center">
                        <h3 className="font-semibold">Listado de Actividades</h3>
                        <span className="text-sm">Actividades: {actividades.length}</span>
                    </div>
                    <div className="overflow-y-auto flex-grow">
                        <table className="w-full">
                            <thead>
                                <tr className="bg-gray-50">
                                    <th className="p-2 text-left">Nombre</th>
                                    <th className="p-2 text-left">Descripción</th>
                                    <th className="p-2 text-left">Hora</th>
                                    <th className="p-2 text-left">Promedio</th>
                                </tr>
                            </thead>
                            <tbody>
                                {actividades.length > 0 ? actividades.map((actividad, index) => (
                                    <tr key={index} className="border-t">
                                        <td className="p-2">{actividad.nombre}</td>
                                        <td className="p-2">{actividad.descripcion}</td>
                                        <td className="p-2">{actividad.hora}</td>
                                        <td className="p-2">{actividad.promedio}</td>
                                    </tr>
                                )) : (
                                    <tr>
                                        <td colSpan="4" className="p-2 text-center">No hay actividades</td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                    <div className="p-4 space-y-2">
                        <label 
                            htmlFor="inputact" 
                            className="w-full py-2 bg-gray-200 hover:bg-gray-300 transition duration-200 rounded cursor-pointer flex items-center justify-center"
                        >
                            Cargar Actividades
                        </label>
                        <input 
                            onChange={cargarActividades}
                            type="file" 
                            id='inputact' 
                            accept=".json" 
                            className="hidden" 
                        />
                        <label 
                            htmlFor="inputas" 
                            className="w-full py-2 bg-gray-200 hover:bg-gray-300 transition duration-200 rounded cursor-pointer flex items-center justify-center"
                        >
                            Cargar Asistentes
                        </label>
                        <input 
                            onChange={cargarAsistentes}
                            type="file" 
                            id='inputas' 
                            accept=".json" 
                            className="hidden" 
                        />
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Eventodetalle;