import React, { useContext, useEffect } from "react";
import { AllContiContext, ContoCorrenteContext, UtenteSelezionatoContext } from "../App";
import { useHistory } from "react-router-dom";
import Table from 'react-bootstrap/Table';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCommentsDollar } from '@fortawesome/free-solid-svg-icons'
import { ChiamataGet } from "../Funzioni/ChiamataGet";
import { ChiamataPut } from "../Funzioni/ChiamataPut";

const ManageConti = () => {
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/findAllConti"
    const allContiContext = useContext(AllContiContext);
    const contoCorrenteContext = useContext(ContoCorrenteContext);
    const utenteSelezionatoContext = useContext(UtenteSelezionatoContext);
    const URIconto = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/findContoCorrenteById/";
    const URIutente = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/findUtenteById/";
    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    function manageConto(conto) {
        findUtente(conto[4]);
        findConto(conto[0]);
        navigate("/controllConto");
    }

    function findUtente(idUtente) {
        let URIidUtente = URIutente + idUtente;
        ChiamataGet(URIidUtente, utenteSelezionatoContext.setUtenteSelezionato)
    }

    function findConto(idConto) {
        let URIidConto = URIconto + idConto;
        ChiamataGet(URIidConto, contoCorrenteContext.setContoCorrente)
    }

    useEffect(() => {
        ChiamataGet(URI, allContiContext.setAllConti)
    }, [contoCorrenteContext.contoCorrente])



    return (
        <div>
            <div className="stilemio">
                <Table striped bordered hover variant="white">
                    <thead>
                        <tr>
                            <th>Id Conto</th>
                            <th>Numero Conto</th>
                            <th>Data Scadenza</th>
                            <th>Stato Conto</th>
                            <th>Controllo</th>
                        </tr>
                    </thead>
                    <tbody>

                        {allContiContext.allConti.map(conto => {
                            if (conto[5] === "disattivato") {
                                return (
                                    <tr>
                                        <td>{conto[0]}</td>
                                        <td>{conto[1]} </td>
                                        <td>{conto[3]}</td>
                                        <td>{conto[5]}</td>
                                        <td>
                                            <button className="text-dark btn text-start" style={{ paddingLeft: 40 }} onClick={() => manageConto(conto)}>
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
        </div>
    )

}

export default ManageConti;