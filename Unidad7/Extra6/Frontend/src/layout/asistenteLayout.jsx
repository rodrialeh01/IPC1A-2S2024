import { Outlet } from "react-router-dom";
import SideBarAsistente from "../components/sideBarAsistente";

const AsistenteLayout = () => {
    return(
        <div className="flex">
            <SideBarAsistente />
            <div className="w-full">
                <Outlet />
            </div>
        </div>
    )
}

export default AsistenteLayout;