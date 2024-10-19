import { createContext, useContext, useState } from "react";

const AuthContext = createContext();

export const AuthContextProvider = ({ children }) => {
    const data_user = JSON.parse(localStorage.getItem("data_user"));
    let exist = false;
    if (data_user) {
        exist = true;
    }

    const [logueado, setLogueado] = useState(exist);

    return (
        <AuthContext.Provider value={{ logueado, setLogueado }}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext;

export const useAuthContext = () => useContext(AuthContext);