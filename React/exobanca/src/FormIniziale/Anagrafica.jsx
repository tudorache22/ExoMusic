import React, { useContext } from "react";
import { useForm } from "react-hook-form";
import ComponenteInput from "./ComponentiForm/ComponenteInput";
import SelectInput from "./ComponentiForm/SelectInput";
import { AnagraficaContext, UtenteContext } from "../App";
import * as chiamata from "../Funzioni/ChiamataPost";
import { useHistory } from "react-router-dom";
import DateInput from "./ComponentiForm/DateInput";

const Anagrafica = () => {

    const regexNome = /^[a-zA-Z]+$/;
    const regexCodiceFiscale = /^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$/;
    const sessi = ["M", "F"]
    const utenteContext = useContext(UtenteContext);
    const anagraficaContext = useContext(AnagraficaContext);
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/insertAnagrafica";
    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm()

    const onSubmit = (data) => {
        chiamata.ChiamataPost(URI, data, anagraficaContext.setAnagrafica);
        navigate("/register")
    }


    return (
        <div className="row">
            <div className="col-4"></div>
            <div className="col-8">
                <img src="/logo.png" alt="" style={{ width: 200, height: 200, marginLeft: 200, marginTop: 70 }} />
                <form onSubmit={handleSubmit(onSubmit)}>
                    <h3 style={{ paddingBottom: "40px" }}>Inserisci i tuoi dati anagrafici</h3>

                    <ComponenteInput register={register} valore={"nome"} pattern={regexNome} label={"Nome:"} />
                    {errors.nome && <p className="alert alert-danger">{errors.nome.message}</p>}
                    <ComponenteInput register={register} valore={"cognome"} pattern={regexNome} label={"Cognome:"} />
                    {errors.cognome && <p className="alert alert-danger">{errors.cognome.message}</p>}
                    <ComponenteInput register={register} valore={"codiceFiscale"} pattern={regexCodiceFiscale} label={"Codice Fiscale:"} />
                    {errors.codiceFiscale && <p className="alert alert-danger">{errors.codiceFiscale.message}</p>}
                    <ComponenteInput register={register} valore={"luogoNascita"} pattern={regexNome} label={"Luogo Di Nascita:"} />
                    {errors.luogoNascita && <p className="alert alert-danger">{errors.luogoNascita.message}</p>}
                    <ComponenteInput register={register} valore={"provincia"} pattern={regexNome} label={"Provincia:"} />
                    {errors.provincia && <p className="alert alert-danger">{errors.provincia.message}</p>}
                    <SelectInput register={register} valore={"sesso"} pattern={regexNome} label={"Sesso:"} lista={sessi} />
                    {errors.sesso && <p className="alert alert-danger">{errors.sesso.message}</p>}
                    <DateInput register={register} valore={"dataNascita"} label={"Data di Nascita:"} />
                    <div>
                        <label></label>
                        <button type="submit" className="btn btn-outline-primary" >Prosegui Registrazione</button>
                    </div>

                    <div >
                        <label>Hai già un account?</label>
                        <button className="btn btn-outline-primary" onClick={() => navigate("/login")}>Fai Login</button>
                    </div>
                </form>
            </div>
        </div>
    )


}

export default Anagrafica;