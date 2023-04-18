import React, { useContext, useEffect, useState } from "react";
import { MovimentoContext, OtpContext, UtenteContext } from "../App";

const ModalTransazione = () => {

    const movimentoContext = useContext(MovimentoContext);
    const utenteContext = useContext(UtenteContext);
    const otpContext = useContext(OtpContext);
    const [otp, setOtp] = useState("");
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/OtpRest/creaOtp";
    const URIupdate = "http://localhost:8080/ExoMusicBancaWEB/rest/TransazioneRest/updateTransazione";
    const URIutente = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/findUtenteById/" + utenteContext.utente.idUtente;

    function controlloOtp() {
        if (parseInt(otp, 10) === otpContext.otp) {
            console.log("otp giusto");
            convalidaTransazione();
        }
        else {
            alert("Otp Non valido")
        }
    }

    useEffect(() => {
        creaOtp();

    }, [movimentoContext.movimento])


    function creaOtp() {
        fetch(URI, {
            method: "POST",
            body: JSON.stringify(movimentoContext.movimento),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                if (null !== response && "" !== response) {
                    otpContext.setOtp(response);
                }
            })
            .catch(error => {
                console.log(error)
            })
    }

    function convalidaTransazione() {
        let requestBody = {
            idTransazione: movimentoContext.movimento.idTransazione,
            importo: movimentoContext.movimento.importo,
            data: movimentoContext.movimento.data,
            tipoTransazione: movimentoContext.movimento.tipoTransazione,
            utente: utenteContext.utente,
            statoTransazione: {
                idStato: 1,
                stato: "IN CORSO"
            }
        }
        console.log(requestBody);
        fetch(URIupdate, {
            method: "PUT",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                if (null !== response && "" !== response) {
                    movimentoContext.setMovimento(response);
                }
            })
            .catch(error =>
                console.log(error));
    }

    useEffect(() => {
        fetch(URIutente, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        })
            .then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                if (null != response && "" != response) {
                    utenteContext.setUtente(response);
                }
            })
    }, [otpContext.otp])

    return (
        <div className="modal fade" id="modalTransazione" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog modal-dialog-centered" >
                <div className="modal-content">
                    <div className="modal-header">
                        <h3>Conferma Operazione</h3>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <label for="">Inserisci l'otp ricevuto tramite email</label>
                        <input type="text" value={otp} onChange={(e) => setOtp(e.target.value)} />
                        <button onClick={() => controlloOtp()}>Conferma codice</button>

                        <p>Se non hai ricevuto nessuna email, clicca sul bottone</p>
                        <button onClick={() => creaOtp()}>Ricevi Otp</button>
                    </div>
                </div>
            </div>
        </div>
    )

}

export default ModalTransazione;