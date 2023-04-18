import React, { useContext, useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { AnagraficaContext } from "../App";

const Anagrafica = () => {

    const [nome, setNome] = useState("");
    const [nomeIsValid, setNomeIsvalid] = useState(false)
    const [cognome, setCognome] = useState("");
    const [cognomeIsValid, setCognomeIsvalid] = useState(false)
    const [codiceFiscale, setCodiceFiscale] = useState("");
    const [codiceFiscaleIsValid, setCodiceFiscaleIsvalid] = useState(false)
    const [luogoNascita, setLuogoNascita] = useState("");
    const [luogoNascitaIsValid, setLuogoNascitaIsvalid] = useState(false)
    const [provincia, setProvincia] = useState("");
    const [provinciaIsValid, setProvinciaIsvalid] = useState(false)
    const [dataNascita, setDataNascita] = useState("");
    const [sesso, setSesso] = useState("");
    const [sessoIsValid, setSessoIsvalid] = useState(false)
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/insertAnagrafica";
    const nomeRegex = /^[a-zA-Z]+$/;
    const codiceFiscaleRegex = /^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$/;


    const [messNome, setMessNome] = useState("");
    const [messCognome, setMessCognome] = useState("");
    const [messCodiceFiscale, setMessCodiceFiscale] = useState("");
    const [messLuogoNasscita, setMessLuogoNasita] = useState("");
    const [messProvincia, setMessProvincia] = useState("");
    const [messDataNascita, setMessDataNascita] = useState("");
    const [messSesso, setMessSesso] = useState("");

    const [buttonDisable, setButtonDisable] = useState(true);

    const anagraficaContext = useContext(AnagraficaContext);

    const history = useHistory();


    useEffect(() => {
        if (nomeIsValid && cognomeIsValid && codiceFiscaleIsValid && luogoNascitaIsValid && provinciaIsValid && sessoIsValid) {
            setButtonDisable(false)
        }
        else {
            setButtonDisable(true);
        }
    })

    function navigate(path) {
        history.push(path);
    }


    function saveAnagrafica() {
        if (nomeIsValid === true && cognomeIsValid === true && codiceFiscaleIsValid === true && luogoNascitaIsValid === true && provinciaIsValid === true && sessoIsValid === true) {

            let requestBody = {
                nome: nome,
                cognome: cognome,
                codiceFiscale: codiceFiscale,
                luogoNascita: luogoNascita,
                provincia: provincia,
                dataNascita: dataNascita,
                sesso: sesso
            }

            fetch(URI, {
                method: "POST",
                body: JSON.stringify(requestBody),
                headers: {
                    'Content-type': 'application/json;charset=UTF-8'
                }
            }).then(responseJson => responseJson.json())
                .then(response => {
                    console.log(response);
                    if (null !== response) {
                        anagraficaContext.setAnagrafica(response);
                        navigate("/register")
                    }
                }).catch(error => {
                    console.log(error)
                })
        }
        else {

        }

    }


    function controlloNome(e) {
        setNome(e.target.value);
        setNomeIsvalid(nomeRegex.test(e.target.value));
        (nomeRegex.test(e.target.value)) ? setMessNome("") : setMessNome("Nome non valido");
    }

    function controlloCognome(e) {
        setCognome(e.target.value);
        setCognomeIsvalid(nomeRegex.test(e.target.value));
        (nomeRegex.test(e.target.value)) ? setMessCognome("") : setMessCognome("Cognome non valido");
    }

    function controlloCodiceFiscale(e) {
        setCodiceFiscale(e.target.value);
        setCodiceFiscaleIsvalid(codiceFiscaleRegex.test(e.target.value));
        (codiceFiscaleRegex.test(e.target.value)) ? setMessCodiceFiscale("") : setMessCodiceFiscale("codice fiscale non valido");

    }

    function controlloLuogoNascita(e) {
        setLuogoNascita(e.target.value);
        setLuogoNascitaIsvalid(nomeRegex.test(luogoNascita));
        (nomeRegex.test(e.target.value)) ? setMessLuogoNasita("") : setMessLuogoNasita("Luogo Di nascita non valido");
    }

    function controlloProvincia(e) {
        setProvincia(e.target.value);
        setProvinciaIsvalid(nomeRegex.test(provincia));
        (nomeRegex.test(e.target.value)) ? setMessProvincia("") : setMessProvincia("Provincia non valida");
    }



    function controlloSesso(e) {
        setSesso(e.target.value);
        setSessoIsvalid(sesso.length === 1);
        (nomeRegex.test(e.target.value)) ? setMessSesso("") : setMessSesso("Sesso non valido");
    }


    return (

        // <form>
        //     <label for="nomeRegister">Nome:</label>
        //     <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} id="nomeRegister" />
        //     <label for="cognomeRegister">Cognome:</label>
        //     <input type="text" value={cognome} onChange={(e) => setCognome(e.target.value)} id="cognomeRegister" />
        //     <label for="codiceFiscaleRegister">CodiceFiscale:</label>
        //     <input type="text" value={codiceFiscale} onChange={(e) => setCondiceFiscale(e.target.value)} id="codiceFiscaleRegister" />
        //     <label for="luogoNascitaRegister">LuogoNascita:</label>
        //     <input type="text" value={luogoNascita} onChange={(e) => setLuogoNascita(e.target.value)} id="luogoNascitaRegister" />
        //     <label for="provinciaRegister">Provincia:</label>
        //     <input type="text" value={provincia} onChange={(e) => setProvincia(e.target.value)} id="provinciaRegister" />
        //     <label for="dataRegister">DataNascita:</label>
        //     <input type="date" value={dataNascita} onChange={(e) => setDataNascita(e.target.value)} id="dataRegister" />
        //     <label for="sessoRegister">Sesso:</label>
        //     <select id="sessoRegister" value={sesso} onChange={(e) => setSesso(e.target.value)}>
        //         <option selected >Seleziona Sesso</option>
        //         <option value="M">M</option>
        //         <option value="F">F</option>
        //     </select>

        //     <button type="button" className="btn btn-outline-danger" onClick={() => saveAnagrafica()} >Completa Registrazione</button>
        //     <label for="bottoneLogin">Hai già un account?</label>
        //     <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/login")}> Annulla la Registrazione</button>
        // </form>

        <form class="row g-3 " id="formAnagrafica" >
            <div class="col-mid-4"></div>
            <label for="nomeRegister">Nome: </label>
            <input type="text" class="form-control" value={nome} onChange={(e) => controlloNome(e)} id="nomeRegister" />
            <div >
                {messNome}
            </div>
            <div class="col-mid-4"></div>
            <label for="cognomeRegister">Cognome:</label>
            <input type="text" class="form-control" value={cognome} onChange={(e) => controlloCognome(e)} id="cognomeRegister" />
            <div >
                {messCognome}
            </div>
            <div class="col-mid-4"></div>
            <label for="codiceFiscaleRegister">CodiceFiscale:</label>
            <input type="text" class="form-control" value={codiceFiscale} onChange={(e) => controlloCodiceFiscale(e)} id="codiceFiscaleRegister" />
            <div >
                {messCodiceFiscale}
            </div>
            <label for="luogoNascitaRegister">LuogoNascita:</label>
            <input type="text" class="form-control" value={luogoNascita} onChange={(e) => controlloLuogoNascita(e)} id="luogoNascitaRegister" />
            <div >
                {messLuogoNasscita}
            </div>
            <label for="provinciaRegister">Provincia:</label>
            <input type="text" class="form-control" value={provincia} onChange={(e) => controlloProvincia(e)} id="provinciaRegister" />
            <div >
                {messProvincia}
            </div>
            <label for="dataRegister">DataNascita:</label>
            <input type="date" value={dataNascita} onChange={(e) => setDataNascita(e.target.value)} id="dataRegister" />
            <div >
                {messDataNascita}
            </div>
            <div class="col-mid-4"></div>
            <label for="sessoRegister">Sesso:</label>
            <select id="sessoRegister" class="form-select" value={sesso} onChange={(e) => controlloSesso(e)}>
                <option selected disabled value="">Seleziona il sesso..</option>
                <option value="M">M</option>
                <option value="F">F</option>
            </select>
            <div >
                {messSesso}
            </div>

            <div class="col-mid-4"></div>
            <button type="button" className="btn btn-outline-danger" onClick={() => saveAnagrafica()} disabled={buttonDisable} >Completa Registrazione</button>
            <label for="bottoneLogin">Hai già un account?</label>
            <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/login")}> Annulla la Registrazione</button>
        </form>
    )



}

export default Anagrafica;