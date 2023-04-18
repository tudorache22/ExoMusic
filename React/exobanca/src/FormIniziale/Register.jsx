import React, { Component, useContext, useState } from "react";
import { useHistory } from "react-router-dom";
import { AnagraficaContext, ConnessoContext, UtenteContext } from "../App";


const Register = () => {
    const [email, setEmail] = useState("");
    const [emailIsValid, setEmailIsValid] = useState(false);
    const [password, setPassword] = useState("");
    const [passwordIsValid, setPasswordIsValid] = useState(false);
    const URIutente = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/insertUtente";
    const utenteContext = useContext(UtenteContext);
    const connessoContext = useContext(ConnessoContext);
    const anagraficaContext = useContext(AnagraficaContext);
    const regexEmail = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,})$/;
    const regexPassword = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }


    function saveUtente() {
        let requestBody = {
            anagrafica: anagraficaContext.anagrafica,
            email: email,
            password: password,
            ruolo: {
                idRuolo: 1,
            }
        }
        console.log(requestBody);
        console.log(JSON.stringify(requestBody))
        fetch(URIutente, {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                if (null != response) {
                    utenteContext.setUtente(response);
                    connessoContext.setConnesso(true);
                    navigate("/home");
                }
            })
            .catch(error => {
                console.error(error);
            })
    }

    function controlloEmail(e) {
        setEmail(e.target.value);
        setEmailIsValid(regexEmail.test(e.target.value));
    }

    function controlloPassword(e) {
        setPassword(e.target.value);
        setPasswordIsValid(regexPassword.test(e.target.value));
    }

    return (

        <form>
            <label for="emailRegister">Email:</label>
            <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} id="emailRegister" />
            <label for="passwordRegister">Password:</label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} id="passwordRegister" />

            <button type="button" className="btn btn-outline-danger" onClick={() => saveUtente()} >Completa la registrazione</button>
            <label for="bottoneLogin">Hai già un account?</label>
            <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/login")}>Annulla Registrazione</button>
        </form>
    )


}

export default Register;