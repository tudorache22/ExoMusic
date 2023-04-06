import React, { useContext, useState } from "react";
import { useHistory } from "react-router-dom";
import { AnagraficaContext } from "../App";

const Anagrafica = () => {

    const [nome, setNome] = useState("");
    const [cognome, setCognome] = useState("");
    const [codiceFiscale, setCondiceFiscale] = useState("");
    const [luogoNascita, setLuogoNascita] = useState("");
    const [provincia, setProvincia] = useState("");
    const [dataNascita, setDataNascita] = useState("");
    const [sesso, setSesso] = useState("");
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/insertAnagrafica";

    const anagraficaContext = useContext(AnagraficaContext);

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }


    function saveAnagrafica() {
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


    return (

        <form>
            <label for="nomeRegister">Nome:</label>
            <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} id="nomeRegister" />
            <label for="cognomeRegister">Cognome:</label>
            <input type="text" value={cognome} onChange={(e) => setCognome(e.target.value)} id="cognomeRegister" />
            <label for="codiceFiscaleRegister">CodiceFiscale:</label>
            <input type="text" value={codiceFiscale} onChange={(e) => setCondiceFiscale(e.target.value)} id="codiceFiscaleRegister" />
            <label for="luogoNascitaRegister">LuogoNascita:</label>
            <input type="text" value={luogoNascita} onChange={(e) => setLuogoNascita(e.target.value)} id="luogoNascitaRegister" />
            <label for="provinciaRegister">Provincia:</label>
            <input type="text" value={provincia} onChange={(e) => setProvincia(e.target.value)} id="provinciaRegister" />
            <label for="dataRegister">DataNascita:</label>
            <input type="date" value={dataNascita} onChange={(e) => setDataNascita(e.target.value)} id="dataRegister" />
            <label for="sessoRegister">Sesso:</label>
            <select id="sessoRegister" value={sesso} onChange={(e) => setSesso(e.target.value)}>
                <option selected >Seleziona Sesso</option>
                <option value="M">M</option>
                <option value="F">F</option>
            </select>

            <button type="button" className="btn btn-outline-danger" onClick={() => saveAnagrafica()} >Completa Registrazione</button>
            <label for="bottoneLogin">Hai già un account?</label>
            <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/login")}> Accedi</button>
        </form>
    )



}

export default Anagrafica;