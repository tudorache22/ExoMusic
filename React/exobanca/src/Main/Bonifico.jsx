import React, { useContext, useState } from "react";
import { MovimentoContext, UtenteContext } from "../App";

const Bonifico = () =>{

    const utenteContext=useContext(UtenteContext);
    const movimentoContext=useContext(MovimentoContext);
    const [importo,setImporto]=useState("");
    const [numConto,setNumConto]=useState("");
    const URIconto= ""+numConto;
    const URItransazione="";
    const [contoIntestatario,setContoIntestatario]=useState({
        idContoCorrente:"",
        numeroConto:"",
        saldo:"",
        dataScadenza:"",
        utente:""
    })

   


    function trovaConto(){
        fetch(URI,{
            method:"GET",
            headers:"  'Content-type': 'application/json;charset=UTF-8'"
        })
        .then(responseJson=>responseJson.json())
        .then(response=>{
            console.log(response);
            setContoIntestatario(response);
        })
        .catch(error => 
            console.log(error))
    }

    return(
        <div>
            <label for="importoBonifico">Importo</label>
            <input type="text" value={importo} onChange={(e)=>setImporto(e.target.value)} id="importoBonifico"></input>
            <label for="numContoBonifico">Inserisci L'intestatario</label>
            <input type="text" value={numConto} onChange={(e)=>setNumConto(e.target.value)} id="numContoBonifico"/>


        </div>
    )




}

export default Bonifico;