import React, { useContext, useState } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, UtenteContext } from "../App";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const URI = "http://localhost:8080/ExoMusicBancaWEB-0.0.1-SNAPSHOT/rest/UtenteRest/faiLogin";
    const utenteContext = useContext(UtenteContext);
    const connessoContext = useContext(ConnessoContext);
    const URIget = "http://localhost:8080/ExoMusicBancaWEB-0.0.1-SNAPSHOT/rest/UtenteRest/findAllUtenti"

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    function saveUtente() {
        let requestBody = {
            email: email,
            password: password
        }
        console.log(requestBody);
        fetch(URI, {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                if (null !== response && response !== "") {
                    connessoContext.setConnesso(true);
                    console.log(response)
                    console.log(connessoContext.connesso)
                    utenteContext.setUtente(response);
                    console.log(utenteContext.utente);
                }

            }).catch(error => {
                console.error(error);
            })
    }

    function provaGet() {
        fetch(URIget, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                console.log("ha funzioanto")
            })
            .catch(error => {
                console.log(error)
            })
    }

    return (
        <form>
            <label for="emailLogin">Email: </label>
            <input type="text" placeholder="Inserisc la tua email" id="emailLogin" value={email} onChange={(e) => setEmail(e.target.value)} />
            <label for="passwordLogin">Password:</label>
            <input type="text" placeholder="Inserisci la password" id="passwordLogin" value={password} onChange={(e) => setPassword(e.target.value)} />
            <button type="button" className="btn btn-outline-danger" onClick={() => { saveUtente(); navigate("/home") }}>Accedi</button>
            <button type="button" className="btn btn-outline-danger" onClick={() => provaGet()}>prova</button>

            <label for="">Non hai un account?</label>
            <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/anagrafica")}>Crea un account</button>
        </form >
    )



}

export default Login;