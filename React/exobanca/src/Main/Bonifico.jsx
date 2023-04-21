import React, { useContext, useEffect, useState } from "react";
import { ContoCorrenteContext, MovimentoContext, UtenteContext, UtenteSelezionatoContext } from "../App";
import ModalMovimento from "./ModalMovimento";
import ModalTransazione from "./ModalTransazione";
import { ChiamataGet } from "../Funzioni/ChiamataGet";
import { ChiamataPost } from "../Funzioni/ChiamataPost";


const Bonifico = () => {

    const utenteContext = useContext(UtenteContext);
    const movimentoContext = useContext(MovimentoContext);
    const [importo, setImporto] = useState("");
    const [numConto, setNumConto] = useState("");
    const current = new Date();
    const date = `${current.getFullYear()}-0${current.getMonth() + 1}-${current.getDate()}`;
    const utenteSelezionatoContext = useContext(UtenteSelezionatoContext);
    const contoCorrenteContext = useContext(ContoCorrenteContext);

    const URIconto = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/findContoCorrenteByNumeroConto/" + numConto;
    const URItransazione = "http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/insertTransazione";
    const URIutente = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/findUtenteByConto";
    const [contoIntestatario, setContoIntestatario] = useState({
        idContoCorrente: "",
        numeroConto: "",
        saldo: "",
        dataScadenza: "",
        utente: {}
    })




    function trovaConto() {
        ChiamataGet(URIconto, setContoIntestatario);
    }

    function transazioneUtente() {
        let requestBody = {
            importo: importo,
            data: date,
            tipoTransazione: "bonificoUscita",
            utente: utenteContext.utente,
            statoTransazione: {
                idStato: 5,
                stato: "IN SOSPESO"
            }
        }
        ChiamataPost(URItransazione, requestBody, movimentoContext.setMovimento)
    }

    function transazioneDestinatario() {
        if (null !== importo && "" !== importo) {
            let requestBody = {
                importo: importo,
                data: date,
                tipoTransazione: "bonificoEntrata",
                utente: utenteSelezionatoContext.utenteSelezionato,
                statoTransazione: {
                    idStato: 1,
                    stato: "IN CORSO"
                }
            }
            console.log(requestBody)
            ChiamataPost(URItransazione, requestBody, console.log)
        }
    }

    function trovaUtente() {
        ChiamataPost(URIutente, contoIntestatario, utenteSelezionatoContext.setUtenteSelezionato)
    }

    function doBonifico() {
        trovaConto();
        transazioneUtente();
    }

    useEffect(() => {
        trovaUtente();
    }, [contoIntestatario])

    useEffect(() => {
        transazioneDestinatario()
    }, [utenteSelezionatoContext.utenteSelezionato])

    return (
        <div>
            <label for="importoBonifico">Importo</label>
            <input type="text" value={importo} onChange={(e) => setImporto(e.target.value)} id="importoBonifico"></input>
            <label for="numContoBonifico">Inserisci L'intestatario</label>
            <input type="text" value={numConto} onChange={(e) => setNumConto(e.target.value)} id="numContoBonifico" />
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalTransazione" onClick={() => doBonifico()}>Esegui Operazione</button>
        </div>
    )




}

export default Bonifico;