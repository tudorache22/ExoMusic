import React, { useContext, useState } from "react";
import { MovimentoContext, UtenteContext } from "../App";
import ModalMovimento from "./ModalMovimento";
import ModalTransazione from "./ModalTransazione";

const Bonifico = () =>{

    const utenteContext=useContext(UtenteContext);
    const movimentoContext=useContext(MovimentoContext);
    const [importo,setImporto]=useState("");
    const [numConto,setNumConto]=useState("");
    const current = new Date();
    const date= `${current.getFullYear()}-0${current.getMonth()+1}-${current.getDate()}`;

    const URIconto= "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/findContoCorrenteByNumeroConto/"+numConto;
    const URItransazione="http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/insertTransazione";
    const [contoIntestatario,setContoIntestatario]=useState({
        idContoCorrente:"",
        numeroConto:"",
        saldo:"",
        dataScadenza:"",
        utente:{}
    })

   


    function trovaConto(){
        fetch(URIconto,{
            method:"GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
           }
        })
        .then(responseJson=>responseJson.json())
        .then(response=>{
            console.log(response);
            setContoIntestatario(response);
        })
        .catch(error => 
            console.log(error))
    }

    function transazioneUtente(){
        let requestBody={
            importo:importo,
            data:date,
            tipoTransazione:"bonifico",
            utente:utenteContext.utente,
            statoTransazione: {
                idStato: 5,
                stato: "IN SOSPESO"
            }
        }
        console.log(requestBody);
        console.log(JSON.stringify(requestBody));
        fetch(URItransazione,{
            method:"POST",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson=> responseJson.json())
        .then(response => {
            console.log(response);
            if (null !== response && "" !== response){
                trovaConto();
                transazioneDestinatario();
            }
        })

        .catch(error=>
            console.log(error))
    }

    function transazioneDestinatario(){
        let requestBody={
            importo:importo,
            data:date,
            tipoTransazione:"bonifico",
            utente:contoIntestatario.utente,
            statoTransazione: {
                idStato: 1
            }
        }
        console.log(requestBody);
        fetch(URItransazione,{
            method:"POST",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
        .then(responseJson => responseJson.json())
        .then(response => {
            console.log(response);
        })

        .catch(error =>
            console.log(error));
        
    }

    return(
        <div>
            <label for="importoBonifico">Importo</label>
            <input type="text" value={importo} onChange={(e)=>setImporto(e.target.value)} id="importoBonifico"></input>
            <label for="numContoBonifico">Inserisci L'intestatario</label>
            <input type="text" value={numConto} onChange={(e)=>setNumConto(e.target.value)} id="numContoBonifico"/>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalTransazione" onClick={() =>  transazioneUtente()}>Esegui Operazione</button>
        </div>
    )




}

export default Bonifico;