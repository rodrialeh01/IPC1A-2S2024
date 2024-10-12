import { Outlet } from "react-router-dom";
import SideBarOrganizador from "../components/sideBarOrganizador";

const OrganizadorLayout = () => {
    return(
        <div className="flex">
            <SideBarOrganizador />
            <div className="w-full">
                <Outlet />
            </div>
        </div>
    )
}

export default OrganizadorLayout;