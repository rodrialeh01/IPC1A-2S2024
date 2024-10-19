import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const HomeAdmin =() => {
    const navigate = useNavigate();
    useEffect(() => {
        const data_logueado = JSON.parse(localStorage.getItem("data_user"));
        if(!data_logueado){
            navigate("/");
        }
    },[]);

    return (
        <div className="h-screen max-h-screen w-screen bg-gradient-to-t from-[#5378cf] to-[#356894] flex flex-col">
            <h1>Admin Home</h1>
        </div>
    )
};

export default HomeAdmin;