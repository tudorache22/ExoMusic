import React, { useContext } from "react";
import { AnagraficaContext, UtenteContext } from "../App";
import ModalProfilo from "./ModalProfilo";

const Profilo = () => {

    const utenteContext=useContext(UtenteContext);
    const anagraficaContext=useContext(AnagraficaContext);

    return (
        <div>
           <p>{utenteContext.utente.email}</p>
           <p>{utenteContext.utente.password}</p>
           <p>{utenteContext.utente.anagrafica.nome}</p>
           <p>{utenteContext.utente.anagrafica.cognome}</p>
           <p>{utenteContext.utente.anagrafica.dataNascita}</p>
           <p>{utenteContext.utente.anagrafica.sesso}</p>
           <p>{utenteContext.utente.anagrafica.provincia}</p>
           <p>{utenteContext.utente.anagrafica.codiceFiscale}</p>

           <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalProfilo">
                               Aggiorna dati utente
                            </button>
                            <ModalProfilo/>
        </div>
    )

}

export default Profilo;