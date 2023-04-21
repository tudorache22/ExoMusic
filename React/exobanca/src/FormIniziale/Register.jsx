import React, { useContext } from "react";
import { useForm } from "react-hook-form";
import ComponenteInput from "./ComponentiForm/ComponenteInput";
import { useHistory } from "react-router-dom";
import { UtenteContext } from "../App";
import * as chiamata from "../Funzioni/ChiamataPost";

const Register = () => {
    const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const regexPassword = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    const utenteContext = useContext(UtenteContext);
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/insertUtente";
    const history = useHistory()

    function navigate(path) {
        history.push(path)
    }

    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm();

    const onSubmit = (data) => {
        chiamata.ChiamataPost(URI, data, utenteContext.setUtente)
        navigate("/home")
    }

    return (
        <div className="row">
            <div className="col-4"></div>
            <div className="col-8">
                <img src="/logo.png" alt="" style={{ width: 200, height: 200, marginLeft: 200, marginTop: 70 }} />
                <form onSubmit={handleSubmit(onSubmit)}>
                    <h3 style={{ paddingBottom: "40px" }}>Registrati</h3>
                    <ComponenteInput register={register} valore={"email"} pattern={regexEmail} sesso={"F"} label={"Email:"} />
                    {errors.email && <p className="errorMsg">{errors.email.message}</p>}
                    <ComponenteInput register={register} valore={"password"} pattern={regexPassword} sesso={"F"} label={"Password:"} />
                    {errors.password && <p className="errorMsg">{errors.password.message}</p>}

                    <div >
                        <label></label>
                        <button className="btn btn-outline-primary" type="submit">Conferma</button>
                    </div>
                    <div>
                        <label>Vuoi annullare la registrazione?</label>
                        <button className="btn btn-outline-primary" onClick={() => navigate("/anagrafica")}>Annulla Registrazione</button>
                    </div>
                </form>

            </div>
        </div>
    )


}

export default Register;