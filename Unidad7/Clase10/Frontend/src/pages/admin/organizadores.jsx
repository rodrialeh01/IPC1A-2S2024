import { saveAs } from 'file-saver';
import { useEffect, useState } from "react";
import * as XLSX from 'xlsx';
import TableOrganizadores from "../../components/TableOrganizadores";
import Service from "../../Service/Service";

const Organizadores = () => {
    const [organizadores, setOrganizadores] = useState([]);
    useEffect(() => {
        const data_logueado = JSON.parse(localStorage.getItem("data_user"));
        if(!data_logueado){
            navigate("/");
        }
        Service.obtenerOrganizadores()
        .then(response =>{
            setOrganizadores(response.organizadores)
        })
    }, [])

    const abrirArchivo = (e) =>{
        const archivo = e.target.files[0];
        const fileReader = new FileReader();

        fileReader.readAsText(archivo,'UTF-8');
        fileReader.onload = (e) => {
            const contenido = JSON.parse(e.target.result);
            const data = {
                organizadores: contenido
            }
            console.log(data)
            Service.cargarOrganizador(data)
            .then(response => {
                window.location.reload();
            })
        }
        fileReader.onerror = (error) => {
            console.log(error)
        }
    }

    const exportarExcel = () => {
        //Crea una hoja de trabajo
        const ws = XLSX.utils.json_to_sheet(organizadores);

        //Crea un libro de trabajo
        const wb = XLSX.utils.book_new();
        XLSX.utils.book_append_sheet(wb, ws, "Organizadores");

        //Genera el archivo de Excel
        const excelBuffer = XLSX.write(wb, {bookType: 'xlsx', type: 'array'})

        //Guardamos el archivo
        const blob = new Blob([excelBuffer], { type: 'application/octet-stream' });
        saveAs(blob, 'organizadores.xlsx');
    }

    return (
        <div>
            <div className="mb-10">
            <h1 className="text-4xl mb-5">Organizadores</h1>
            
            <input onChange={abrirArchivo} type="file" id='inputff' accept=".json" className="hidden" />
            <label 
                for="inputff" 
                class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 cursor-pointer mr-3" 
            >
                Carga Masiva
            </label>
            <button 
                type="button" 
                class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-greeb-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
                onClick={exportarExcel}
            >Exportar Excel</button>
            </div>
            <TableOrganizadores contenido={organizadores?organizadores:[]}/>
        </div>
    )
}

export default Organizadores;