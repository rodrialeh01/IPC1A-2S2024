import { createContext, useContext, useState } from "react";

const AuthContext = createContext();

export const AuthContextProvider = ({ children }) => {
    const data_user = JSON.parse(localStorage.getItem("data_user"));
    let existe = false;
    if(data_user){
        existe = true;
    }

    const [logueado, setLogueado] = useState(existe);

    return (
        <AuthContext.Provider value={{logueado, setLogueado}}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext;

export const useAuthContext = () => useContext(AuthContext);