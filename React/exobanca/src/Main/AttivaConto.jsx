import React, { useContext } from "react";
import { AnagraficaContext, ContoCorrenteContext, UtenteContext } from "../App";
import * as chiamata from "../Funzioni/ChiamataPost";
import { useHistory } from "react-router-dom";

const AttivaConto = () => {

    const utenteContext = useContext(UtenteContext);
    const contoCorrenteContext = useContext(ContoCorrenteContext);
    const history = useHistory();

    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/ContoCorrenteRest/insertContoCorrente";

    function navigate(path) {
        history.push(path)
    }

    function attivaConto() {
        chiamata.ChiamataPost(URI, utenteContext.utente, contoCorrenteContext.setContoCorrente);
        navigate("/attesaConto")
    }

    return (
        <div>
            <p>Non hai attivato il tuo conto.</p>
            <p>Clicca sul bottone per attivare la richiesta di attivazione</p>
            <button type="button" className="btn btn-outline-danger" onClick={() => attivaConto()}>Attiva Conto</button>
        </div>
    )



}

export default AttivaConto;