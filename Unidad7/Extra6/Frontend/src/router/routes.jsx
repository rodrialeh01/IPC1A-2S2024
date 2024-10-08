import { createBrowserRouter } from "react-router-dom";
import AdminLayout from "../layout/adminLayout";
import AsistenteLayout from "../layout/asistenteLayout";
import OrganizadorLayout from "../layout/organizadorLayout";
import HomeAdmin from "../pages/admin/home";
import HomeAsistente from "../pages/asistente/home";
import Login from "../pages/login";
import HomeOrganizador from "../pages/organizador/home";

export const routes = createBrowserRouter([
    {
        path: '/',
        element: <Login />
    },
    {
        path: '/admin',
        element: <AdminLayout/>,
        children: [
            {
                path: 'home',
                element: <HomeAdmin/>,
            }
        ]
    },
    {
        path: '/organizador',
        element: <OrganizadorLayout/>,
        children: [
            {
                path: 'home',
                element: <HomeOrganizador/>
            }
        ]
    },
    {
        path: '/asistente',
        element: <AsistenteLayout/>,
        children: [
            {
                path: 'home',
                element: <HomeAsistente/>
            }
        ]
    }
])