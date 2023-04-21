import React, { useContext, useEffect } from "react";
import { AllTransazioniContext, ContoCorrenteContext, MovimentoContext, UtenteContext, UtenteSelezionatoContext } from "../App";
import { useHistory } from "react-router-dom";
import Table from 'react-bootstrap/Table';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCommentsDollar } from '@fortawesome/free-solid-svg-icons'
import { ChiamataGet } from "../Funzioni/ChiamataGet";

const ManageTranaszioni = () => {

    const utenteSelezionatoContext = useContext(UtenteSelezionatoContext);
    const movimentoContext = useContext(MovimentoContext);
    const allTransazioniContext = useContext(AllTransazioniContext);
    const utenteContext = useContext(UtenteContext);
    const contoCorrenteContext = useContext(ContoCorrenteContext);

    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/findAllTransazioni"
    const URIutente = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/findUtenteById/";
    const URItransazione = "http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/findTransazioneById/";

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    function findTransazioni() {

        ChiamataGet(URI, allTransazioniContext.setAllTransazioni)
    }

    useEffect(() => {
        if (utenteContext.utente.ruolo.idRuolo === 2) {
            findTransazioni();
        }
    }, 60000);

    function manageTransazione(transazione) {
        findUtente(transazione[4]);
        findTransazione(transazione[0]);
        navigate("/controllTransazione");

    }

    function findUtente(idUtente) {
        let URIidUtente = URIutente + idUtente;

        fetch(URIidUtente, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                if (null !== response && "" !== response) {
                    utenteSelezionatoContext.setUtenteSelezionato(response);
                    contoCorrenteContext.setContoCorrente(response.contoCorrentes[0]);
                }
            })
            .catch(error => {
                console.log(error);
            })
    }

    function findTransazione(idTransazione) {
        let URIidTransazione = URItransazione + idTransazione;

        ChiamataGet(URIidTransazione, movimentoContext.setMovimento)
    }

    return (
        <div className="stilemio">
            <Table striped bordered hover variant="white">
                <thead>
                    <tr>
                        <th>Id Transazione</th>
                        <th>Data</th>
                        <th>Importo</th>
                        <th>Categoria</th>
                        <th>Stato</th>
                        <th>Controllo</th>
                    </tr>
                </thead>
                <tbody>

                    {allTransazioniContext.allTransazioni.map(transazione => {
                        if (transazione[5] === 1) {
                            return (
                                <tr>
                                    <td>{transazione[0]}</td>
                                    <td>{transazione[3]} </td>
                                    <td>${transazione[1]}</td>
                                    <td>{transazione[2]}</td>
                                    <td>{transazione[5]}</td>
                                    <td>
                                        <button className="text-dark btn text-start" style={{ paddingLeft: 40 }} onClick={() => manageTransazione(transazione)}>
                                            <FontAwesomeIcon icon={faCommentsDollar} size="lg" />
                                        </button>
                                    </td>
                                </tr>
                            )
                        }
                    })}

                </tbody>
            </Table>
        </div>
    )


}

export default ManageTranaszioni;