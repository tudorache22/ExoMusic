import React, { useContext, useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, ContoCorrenteContext, MovimentoContext, UtenteContext } from "../App";
import { useForm } from "react-hook-form";

const Login = () => {

    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm();


    // const [email, setEmail] = useState("");
    // const [validateEmail, setValidateEmail] = useState(false);
    // const [password, setPassword] = useState("");
    // const [validatePassword, setValidatePassword] = useState(false);
    // const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/faiLogin";
    // const utenteContext = useContext(UtenteContext);
    // const connessoContext = useContext(ConnessoContext);
    // const contoCorrenteContext = useContext(ContoCorrenteContext);
    // const movimentoContext = useContext(MovimentoContext);


    // const history = useHistory();
    // function navigate(path) {
    //     history.push(path);
    // }

    // function saveUtente() {
    //     let requestBody = {
    //         idUtente: utenteContext.utente.idUtente,
    //         email: email,
    //         password: password,

    //     }
    //     console.log(requestBody);
    //     fetch(URI, {
    //         method: "POST",
    //         body: JSON.stringify(requestBody),
    //         headers: {
    //             'Content-type': 'application/json;charset=UTF-8'
    //         }
    //     }).then(responseJson => responseJson.json())
    //         .then(response => {
    //             if (null !== response && response !== "") {
    //                 connessoContext.setConnesso(true);
    //                 console.log(response)
    //                 utenteContext.setUtente(response);
    //                 contoCorrenteContext.setContoCorrente(response.contoCorrentes[0]);
    //                 movimentoContext.setMovimento(response.transaziones);
    //                 if (response.ruolo.idRuolo === 2) {
    //                     navigate("/manageTransazioni");
    //                 }
    //                 if (response.ruolo.idRuolo === 1) {
    //                     navigate("/home");
    //                 }
    //             }

    //         }).catch(error => {
    //             console.error(error);
    //         })
    // }

    // function controllaEmail(e) {
    //     const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    //     setEmail(e.target.value);
    //     setValidateEmail(emailRegex.test(e.target.value));
    // }

    // function controlloPassword(e) {
    //     const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d\W]{8,20}$/
    //     setPassword(e.target.value);
    //     setValidatePassword(passwordRegex.test(e.target.value));
    // }




    // return (
    //     <div className="row">
    //         <div className="col-5"></div>
    //         <div className="col-7">
    //             <img src="/logo.png" alt="" style={{ width: 200, height: 200, marginLeft: 100, marginTop: 70 }} />
    //         </div>


    //         <div className="col-4"></div>
    //         <div className="col-4">
    //             <form>
    //                 <label for="emailLogin">Email: </label>
    //                 <input type="text" placeholder="Inserisc la tua email" id="emailLogin" value={email} onChange={(e) => controllaEmail(e)} />
    //                 <label for="passwordLogin">Password:</label>
    //                 <input type="text" placeholder="Inserisci la password" id="passwordLogin" value={password} onChange={(e) => controlloPassword(e)} />
    //                 <button type="button" className="btn btn-outline-primary" onClick={() => saveUtente()} disabled={!validateEmail || !validatePassword}>Accedi</button>

    //                 <label for="registrati" style={{ paddingTop: 70 }}>Non hai un account?</label>
    //                 <button type="button" className="btn btn-outline-primary" onClick={() => navigate("/anagrafica")} id="registrati">Crea un account</button>
    //             </form >
    //         </div>
    //     </div>
    // )



}

export default Login;