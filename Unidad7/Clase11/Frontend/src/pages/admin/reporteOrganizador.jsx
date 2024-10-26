import {
    BarElement,
    CategoryScale,
    Chart as ChartJS,
    Legend,
    LinearScale,
    Title,
    Tooltip
} from 'chart.js';

import { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import Service from "../../Service/Service";
const Organizadorreporte = () => {

    const getRandomColor = () => {
        const letters = '0123456789ABCDEF';
        let color = '#';
        for (let i=0; i<6; i++){
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color
    }

    //Registrar la grafica de barras
    ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend)

    const [cantidades, setCantidades] = useState([0,0]);
    const [labels, setLabels] = useState(["",""]);
    const [color1, setColor1] = useState(getRandomColor());
    const [color2, setColor2] = useState(getRandomColor());
    useEffect(() => {
        Service.cantidadOrganizadoresGenero()
        .then(response => {
            setCantidades([response.masculino, response.femenino])
            setLabels(["Masculino", "Femenino"])
        })
        .catch(error => {
            console.log(error)
        })
    },[])

    
    return(
        <div>
            <h1>Reporte Organizador</h1>
            <Bar
                data = {{
                    labels: labels,
                    datasets: [{
                        label: 'Cantidad',
                        data: cantidades,
                        backgroundColor: [
                            color1,
                            color2
                        ],
                        borderColor: [
                            color1,
                            color2
                        ],
                        borderWidth: 1
                    }]
                }}
            />
        </div>
    )
}

export default Organizadorreporte;