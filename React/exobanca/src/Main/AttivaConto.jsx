import React, { useContext } from "react";
import { AnagraficaContext, ContoCorrenteContext, UtenteContext } from "../App";

const AttivaConto = ()=> {

    const utenteContext= useContext(UtenteContext);
    const contoCorrenteContext=useContext(ContoCorrenteContext);

    const URI="http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/insertContoCorrente";


    function attivaConto(){

        fetch(URI, {
            method:"POST",
            body:JSON.stringify(utenteContext.utente),
            headers:{
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
        .then(responseJson=> responseJson.json())
        .then(response=> {
            console.log(response);
            if (null != response && ""!= response){
                contoCorrenteContext.setContoCorrente();
            }
        })
        .catch(error => 
            console.log(error))

    }

    return(
        <div>
            <p>Non hai attivato il tuo conto.</p>
            <p>Clicca sul bottone per attivare la richiesta di attivazione</p>
            <button type="button" className="btn btn-outline-danger" onClick={() => attivaConto()}>Attiva Conto</button>
        </div>
    )



}

export default AttivaConto;