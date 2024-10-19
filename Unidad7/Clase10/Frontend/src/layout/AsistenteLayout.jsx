import { Outlet } from "react-router-dom";
import SideBarAsistente from "../components/SideBarAsistente";
const AsistenteLayout = () => {
    return (
        <div className="flex">
            <SideBarAsistente />
            <div className="w-full ml-[16rem] flex-1">
                <Outlet />
            </div>
        </div>
    )
}

export default AsistenteLayout;