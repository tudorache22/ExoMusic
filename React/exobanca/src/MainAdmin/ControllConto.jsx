import React, { useContext } from "react"
import { ContoCorrenteContext, UtenteSelezionatoContext } from "../App"
import { useHistory } from "react-router-dom"
import { ChiamataPut } from "../Funzioni/ChiamataPut"


const ControllConto = () => {

    const utenteSelezionatoContext = useContext(UtenteSelezionatoContext)
    const contoCorrenteContext = useContext(ContoCorrenteContext)
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/updateContoCorrente"
    const history = useHistory()

    function navigate(path) {
        history.push(path)
    }

    function attivaConto() {
        let requestBody = {
            idContoCorrente: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].idContoCorrente,
            dataScadenza: contoCorrenteContext.contoCorrente.dataScadenza,
            numeroConto: contoCorrenteContext.contoCorrente.numeroConto,
            saldo: contoCorrenteContext.contoCorrente.saldo,
            statoConto: "attivo",
            utente: utenteSelezionatoContext.utenteSelezionato
        }
        console.log(requestBody)
        ChiamataPut(URI, requestBody, contoCorrenteContext.setContoCorrente)

        navigate("/manageConti")

    }

    function rifiutaConto() {
        let requestBody = {
            idContoCorrente: utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].idContoCorrente,
            dataScadenza: contoCorrenteContext.contoCorrente.dataScadenza,
            numeroConto: contoCorrenteContext.contoCorrente.numeroConto,
            saldo: contoCorrenteContext.contoCorrente.saldo,
            statoConto: "attivo",
            utente: utenteSelezionatoContext.utenteSelezionato
        }
        console.log(requestBody)
        ChiamataPut(URI, requestBody, contoCorrenteContext.setContoCorrente)
        navigate("/manageConti")

    }

    return (
        <div className="row">
            <div className="col-5" >
                <div className="stilemio">
                    <h2>Conto Corrente</h2>
                    <h4>Dati Intestatario:</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.nome} {utenteSelezionatoContext.utenteSelezionato.anagrafica.cognome}</p>
                    <h4>Codice Fiscale:</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.codiceFiscale}</p>
                    <h4>Luogo Nascita:</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.luogoNascita}</p>
                    <h4>Data Di Nascita :</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.dataNascita}</p>
                    <h4>Provincia:</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.provincia}</p>
                    <h4>Sesso:</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.anagrafica.sesso}</p>
                </div>
            </div>

            <div className="col-2">
                <button onClick={() => attivaConto()}>Attiva Conto</button>
                <button onClick={() => rifiutaConto()}>Disattiva Conto</button>
            </div>

            <div className="col-5">
                <div className="stilemio">
                    <h2>Conto Corrente</h2>
                    <h4>ID CONTO:</h4>
                    <p>{utenteSelezionatoContext.utenteSelezionato.contoCorrentes[0].idContoCorrente}</p>
                    <h4>Data Scadenza:</h4>
                    <p>{contoCorrenteContext.contoCorrente.dataScadenza}</p>
                    <h4>Numero Conto:</h4>
                    <p>{contoCorrenteContext.contoCorrente.numeroConto}</p>
                </div>
            </div>
        </div>
    )


}

export default ControllConto 