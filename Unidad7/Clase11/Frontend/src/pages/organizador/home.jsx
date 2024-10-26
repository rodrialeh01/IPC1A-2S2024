import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import Service from "../../Service/Service";
const HomeOrganizador =() => {
    const [eventos, setEventos] = useState([])
    const navigate = useNavigate();

    useEffect(() => {
        const data_logueado = JSON.parse(localStorage.getItem("data_user"));
        if(!data_logueado){
            navigate("/");
        }
        Service.eventosPorOrganizador(data_logueado.codigo)
        .then((response) => {
            setEventos(response.eventos);
        })
        .catch(error =>{
            setEventos([])
        })
    },[]);

    const handleVerEvento = (codigo) => {
        navigate(`/organizador/evento/${codigo}`)
    }

    return (
        <div className="h-screen max-h-screen  bg-gradient-to-t from-white to-slate-300 flex flex-col">
            <div className="container mx-auto p-4">
                <h1 className="text-2xl font-bold mb-4">Mis Eventos Asignados</h1>
                <div className="space-y-4">
                    {eventos?eventos.map((evento) => (
                    <div key={evento.codigo} className="border rounded-lg overflow-hidden shadow-sm bg-orange-400">
                        <div className="grid grid-cols-[auto,1fr,auto] items-center">
                        <div className="bg-orange-800 p-4 ml-3 text-center font-bold text-white">
                            {evento.codigo}
                        </div>
                        <div className="p-4">
                            <p className="font-semibold">{evento.nombre}</p>
                            <p className="text-sm text-white">
                            Asistentes: {evento.asistentes}
                            </p>
                        </div>
                        <button className="px-4 py-2 m-2 text-gray-600 bg-gray-100 rounded transition duration-200" onClick={() => handleVerEvento(evento.codigo)}>
                            Ver
                        </button>
                        </div>
                    </div>
                    )):[]}
                </div>
            </div>
        </div>
    )
};

export default HomeOrganizador;