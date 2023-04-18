import React, { useContext, useState } from "react";
import { ContoCorrenteContext, MovimentoContext, UtenteContext } from "../App";
import ModalTransazione from "./ModalTransazione";


const Deposito = ()=> {

    const [importo,setImporto]= useState("")
    const URI="http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/insertTransazione";
    const utenteContext=useContext(UtenteContext);
    const movimentoContext=useContext(MovimentoContext);
    const current = new Date();
    const date= `${current.getFullYear()}-0${current.getMonth()+1}-${current.getDate()}`;

    function doPrelievo(){
        let requestBody={
                importo:importo,
                data:date,
                tipoTransazione:"deposito",
                utente:utenteContext.utente,
                statoTransazione: {
                    idStato: 5,
                    stato: "IN SOSPESO"
                }
        }

        fetch(URI,{
            method:"POST",
            body: JSON.stringify(requestBody),
            headers:{
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
        .then(responseJson=> responseJson.json())
        .then(response=>{
            console.log(response);
            if(null !== response && ""!==response){
                utenteContext.utente.transaziones.push(console);
                movimentoContext.setMovimento(response);
                
            }
        })
        .catch(error=> 
            console.log(error))
    }


    return(
        <div>
            <label for="importoDeposito">Inserisci l'importo da depositare</label>
            <input type="text" value={importo} onChange={(e)=> setImporto(e.target.value)} id="importoDeposito"/>
            <button onClick={()=>doPrelievo()} type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalTransazione">Effetua l'operazione</button>

        </div>
    )

}

export default Deposito;