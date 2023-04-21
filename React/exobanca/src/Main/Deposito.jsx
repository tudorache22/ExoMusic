import React, { useContext, useState } from "react";
import { ContoCorrenteContext, MovimentoContext, UtenteContext } from "../App";
import ModalTransazione from "./ModalTransazione";
import { ChiamataPost } from "../Funzioni/ChiamataPost";


const Deposito = () => {

    const [importo, setImporto] = useState("")
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/insertTransazione";
    const utenteContext = useContext(UtenteContext);
    const movimentoContext = useContext(MovimentoContext);
    const current = new Date();
    const date = `${current.getFullYear()}-0${current.getMonth() + 1}-${current.getDate()}`;



    function deposito() {
        let requestBody = {
            importo: importo,
            data: date,
            tipoTransazione: "deposito",
            utente: utenteContext.utente,
            statoTransazione: {
                idStato: 5,
                stato: "IN SOSPESO"
            }
        }
        ChiamataPost(URI, requestBody, movimentoContext.setMovimento)
    }


    return (
        <div>
            <label for="importoDeposito">Inserisci l'importo da depositare</label>
            <input type="text" value={importo} onChange={(e) => setImporto(e.target.value)} id="importoDeposito" />
            <button onClick={() => deposito()} type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalTransazione">Effetua l'operazione</button>

        </div>
    )

}

export default Deposito;