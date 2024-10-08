import { Outlet } from "react-router-dom";
import SideBarAdmin from "../components/sideBarAdmin";

const AdminLayout = () => {
    return(
        <div className="flex">
            <SideBarAdmin />
            <div className="w-full">
                <Outlet />
            </div>
        </div>
    )
}

export default AdminLayout;