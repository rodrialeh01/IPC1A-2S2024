import { createBrowserRouter } from 'react-router-dom';
import AdminLayout from '../layout/AdminLayout';
import AsistenteLayout from '../layout/AsistenteLayout';
import OrganizadorLayout from '../layout/OrganizadorLayout';
import Asistentes from '../pages/admin/asistentes';
import Asistenteeditar from '../pages/admin/editarAsistente';
import Eventoeditar from '../pages/admin/editarEvento';
import Organizadoreditar from '../pages/admin/editarOrganizador';
import Eventos from '../pages/admin/eventos';
import HomeAdmin from '../pages/admin/home';
import Organizadores from '../pages/admin/organizadores';
import HomeAsistente from '../pages/asistente/home';
import Login from '../pages/login';
import Eventodetalle from '../pages/organizador/evento';
import HomeOrganizador from '../pages/organizador/home';

export const routes = createBrowserRouter([
    {
        path: '/',
        element: <Login />,
    },
    {
        path: '/admin',
        element: <AdminLayout/>,
        children: [
            {
                path: "home",
                element: <HomeAdmin/>
            },
            {
                path: "organizadores",
                element: <Organizadores/>
            },
            {
                path: "organizadores/edit/:codigo",
                element: <Organizadoreditar/>
            },
            {
                path: "asistentes",
                element: <Asistentes/>
            },
            {
                path:"asistentes/edit/:codigo",
                element: <Asistenteeditar/>
            },
            {
                path: "eventos",
                element: <Eventos/>
            },
            {
                path: "eventos/editar/:codigo",
                element: <Eventoeditar/>
            }
        ]
    },
    {
        path: '/organizador',
        element: <OrganizadorLayout/>,
        children: [
            {
                path: "home",
                element: <HomeOrganizador/>
            },
            {
                path: "evento/:codigo",
                element: <Eventodetalle/>
            }
        ]
    },
    {
        path: '/asistente',
        element: <AsistenteLayout/>,
        children: [
            {
                path: "home",
                element: <HomeAsistente/>
            }
        ]
    }
])