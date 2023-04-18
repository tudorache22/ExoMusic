import React, { useContext } from "react";
import { ContoCorrenteContext, MovimentoContext, UtenteSelezionatoContext } from "../App";
import { useHistory } from "react-router-dom";

const ControllTransazione = () => {

    const utenteSelezionatoContext = useContext(UtenteSelezionatoContext);
    const movimentoContext = useContext(MovimentoContext);
    const contoCorrenteContext = useContext(ContoCorrenteContext);
    const URItransazione = "http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/updateTransazione";
    const URIconto = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/updateContoCorrente";

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    function accettaTransazione() {
        let requestBody = {
            idTransazione: movimentoContext.movimento.idTransazione,
            importo: movimentoContext.movimento.importo,
            data: movimentoContext.movimento.data,
            tipoTransazione: movimentoContext.movimento.tipoTransazione,
            utente: utenteSelezionatoContext.utenteSelezionato,
            statoTransazione: {
                idStato: 3,
                stato: "ESEGUITA"
            }
        }

        fetch(URItransazione, {
            method: "PUT",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            })
    }

    function rifiutaTransazione() {
        let requestBody = {
            idTransazione: movimentoContext.movimento.idTransazione,
            importo: movimentoContext.movimento.importo,
            data: movimentoContext.movimento.data,
            tipoTransazione: movimentoContext.movimento.tipoTransazione,
            utente: utenteSelezionatoContext.utenteSelezionato,
            statoTransazione: {
                idStato: 2,
                stato: "RIFIUTATA"
            }
        }

        fetch(URItransazione, {
            method: "PUT",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                navigate("/manageTransazioni");
            })
            .catch(error => {
                console.log(error);
            })
    }

    function entrataConto() {
        let requestBody = {
            idContoCorrente: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].idContoCorrente,
            dataScadenza: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].dataScadenza,
            numeroConto: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].numeroConto,
            saldo: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].saldo + movimentoContext.movimento.importo,
            utente: utenteSelezionatoContext.utenteSelezionato
        }
        console.log(requestBody);

        fetch(URIconto, {
            method: "PUT",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            })
    }

    function uscitaConto() {
        let requestBody = {
            idContoCorrente: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].idContoCorrente,
            dataScadenza: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].dataScadenza,
            numeroConto: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].numeroConto,
            saldo: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].saldo - movimentoContext.movimento.importo,
            utente: utenteSelezionatoContext.utenteSelezionato
        }
        console.log(requestBody);

        fetch(URIconto, {
            method: "PUT",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            })
    }

    function completaTransazione() {
        accettaTransazione();
        if (movimentoContext.movimento.tipoTransazione === "deposito" || movimentoContext.movimento.tipoTransazione === "bonificoEntrata") {
            entrataConto();
        }
        if (movimentoContext.movimento.tipoTransazione === "prelievo" || movimentoContext.movimento.tipoTransazione === "bonificoUscita" || movimentoContext.movimento.tipoTransazione === "abbonamento") {
            uscitaConto();
        }
        navigate("/manageTransazioni");
    }

    if (utenteSelezionatoContext.utenteSelezionato.idUtente !== "" && movimentoContext.movimento.idTransazione !== "") {
        return (
            <div className="row">
                <div className="col-5" >
                    <div className="stilemio">
                        <h2>Conto Corrente</h2>
                        <h4>Intestatario:</h4>
                        <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.nome} {utenteSelezionatoContext.utenteSelezionato.anagrafica.cognome}</p>
                        <h4>Conto:</h4>
                        <p>{utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].numeroConto}</p>
                        <h4>Saldo Attuale:</h4>
                        <p>{utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].saldo}</p>
                    </div>
                </div>

                <div className="col-2">
                    <button onClick={() => completaTransazione()}>Convalida la transazione</button>
                    <button onClick={() => rifiutaTransazione()}>Rifiuta la transazione</button>
                </div>

                <div className="col-5">
                    <div className="stilemio">
                        <h2>Transazione</h2>
                        <h4>Data:</h4>
                        <p>{movimentoContext.movimento.data}</p>
                        <h4>Stato:</h4>
                        <p>{movimentoContext.movimento.statoTransazione.stato}</p>
                        <h4>Categoria:</h4>
                        <p>{movimentoContext.movimento.tipoTransazione}</p>
                        <h4>Importo:</h4>
                        <p>{movimentoContext.movimento.importo}</p>
                    </div>
                </div>
            </div>
        )
    }


}

export default ControllTransazione;