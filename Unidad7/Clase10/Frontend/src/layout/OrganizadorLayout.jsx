import { Outlet } from "react-router-dom";
import SideBarOrganizador from "../components/SideBarOrganizador";
const OrganizadorLayout = () => {
    return (
        <div className="flex">
            <SideBarOrganizador />
            <div className="w-full ml-[16rem] flex-1">
                <Outlet />
            </div>
        </div>
    )
}

export default OrganizadorLayout;