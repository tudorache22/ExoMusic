import React, { useContext, useState } from "react";
import { UtenteContext } from "../App";
import * as chiamata from "../Funzioni/ChiamataPut";

const ModalProfilo = () => {

    const utenteContext = useContext(UtenteContext);
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const URI = "http://127.0.0.1:8080/ExoMusicBancaWEB/rest/UtenteRest/updateUtente";



    function updateProfilo() {
        let requestBody = {
            idUtente: utenteContext.utente.idUtente,
            password: password,
            email: email,
            ruolo: utenteContext.utente.ruolo,
            anagrafica: utenteContext.utente.anagrafica,
            transaziones: utenteContext.utente.transaziones,
            contoCorrentes: utenteContext.utente.contoCorrentes
        }

        chiamata.ChiamataPut(URI, requestBody, utenteContext.setUtente)
    }


    return (
        <div className="modal fade" id="modalProfilo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog modal-dialog-centered" >
                <div className="modal-content">
                    <div className="modal-header">
                        <h3>Modifica Dati</h3>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <label for="emailProfilo">Email: </label>
                        <input type="text" placeholder="Inserisc la tua email" id="emailProfilo" value={email} onChange={(e) => setEmail(e.target.value)} />
                        <label for="passwordProfilo">Password:</label>
                        <input type="text" placeholder="Inserisci la password" id="passwordProfilo" value={password} onChange={(e) => setPassword(e.target.value)} />

                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-secondary" onClick={() => updateProfilo()}>Salva Modifiche</button>
                    </div>
                </div>
            </div>
        </div>
    )




}

export default ModalProfilo;