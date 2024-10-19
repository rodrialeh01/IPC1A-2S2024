import React from 'react';
import { FaHome, FaSignOutAlt } from "react-icons/fa";
import { useNavigate } from 'react-router-dom';
import { useAuthContext } from '../context/AuthContext';
const SideBarOrganizador = () =>{
    const navigate = useNavigate();
    const {logueado, setLogueado} = useAuthContext();

    const handlerInicio = () => {
        navigate('/organizador/home')
    }

    const handlerCerrarSesion = () => {
        navigate('/');
        setLogueado(false);
        localStorage.removeItem('data_user');
    }
    const infoSideBar = [
        {
            title: "Inicio",
            icon: <FaHome />,
            event: handlerInicio
        },
        {
            title: 'Cerrar Sesión',
            icon: <FaSignOutAlt />,
            event: handlerCerrarSesion
        }
    ]
    return (
        <div className="flex">
            <div className="bg-orange-400 text-gray-400 w-72 p-5 text-xs lg:text-sm border-r border-gray-900 overflow-y-scroll scrollbar-hide h-screen sm:max-w-[12rem] lg:max-w-[16rem] hidden md:inline-flex fixed">
                <div className="space-y-4 w-full">
                <div className="flex items-center justify-center space-x-2">
                    <div style={{ width: "100px", height: "100px" }}>
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-full h-full text-white"
                    >
                        <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 0 1 2.25-2.25h13.5A2.25 2.25 0 0 1 21 7.5v11.25m-18 0A2.25 2.25 0 0 0 5.25 21h13.5A2.25 2.25 0 0 0 21 18.75m-18 0v-7.5A2.25 2.25 0 0 1 5.25 9h13.5A2.25 2.25 0 0 1 21 11.25v7.5m-9-6h.008v.008H12v-.008ZM12 15h.008v.008H12V15Zm0 2.25h.008v.008H12v-.008ZM9.75 15h.008v.008H9.75V15Zm0 2.25h.008v.008H9.75v-.008ZM7.5 15h.008v.008H7.5V15Zm0 2.25h.008v.008H7.5v-.008Zm6.75-4.5h.008v.008h-.008v-.008Zm0 2.25h.008v.008h-.008V15Zm0 2.25h.008v.008h-.008v-.008Zm2.25-4.5h.008v.008H16.5v-.008Zm0 2.25h.008v.008H16.5V15Z"
                        />
                    </svg>
                    </div>
                </div>
                {infoSideBar.map((value, index) =>{
                    return(
                    <button
                        className="flex items-center space-x-2 "
                        onClick={value.event}
                    >
                        {value.icon}
                        <p className="text-gray-500 hover:text-white">{value.title}</p>
                    </button>)
                })}
                </div>
            </div>
            <div className="flex justify-between"></div>
        </div>
    )
}

export default SideBarOrganizador;