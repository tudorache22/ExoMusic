import React, { useContext, useEffect, useRef, useState } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, ContoCorrenteContext, MovimentoContext, UtenteContext } from "../App";
import { useForm } from "react-hook-form";
import ComponenteInput from "./ComponentiForm/ComponenteInput";
import * as chiamata from "../Funzioni/ChiamataPost";
import Swal from "sweetalert2";



const Login = () => {
    const URI = "http://localhost:8080/ExoMusicBancaWEB/rest/UtenteRest/faiLogin";
    const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d\W]{8,20}$/;
    const history = useHistory();
    const utenteContext = useContext(UtenteContext);
    const connessoContext = useContext(ConnessoContext);
    // const [toast, setToast] = useState(false);
    // const toastRef = useRef()

    function navigate(path) {
        history.push(path)
    }

    // function convalida() {
    //     let timerInterval
    //     Swal.fire({
    //         title: 'Auto close alert!',
    //         html: 'I will close in <b></b> milliseconds.',
    //         timer: 1000,
    //         timerProgressBar: false,
    //         didOpen: () => {
    //             const b = Swal.getHtmlContainer().querySelector('b')
    //             timerInterval = setInterval(() => {
    //                 b.textContent = Swal.getTimerLeft()
    //             }, 100)
    //         },
    //         willClose: () => {
    //             clearInterval(timerInterval)
    //         }
    //     }).then((result) => {
    //         /* Read more about handling dismissals below */
    //         if (result.dismiss === Swal.DismissReason.timer) {
    //             console.log('I was closed by the timer')
    //         }
    //     })
    // }

    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm();


    const onSubmit = (data) => {
        chiamata.ChiamataPost(URI, data, utenteContext.setUtente);
        connessoContext.setConnesso(true);
        // convalida();
    }


    useEffect(() => {
        if (connessoContext.connesso) {
            if (utenteContext.utente.ruolo.idRuolo === 1) {
                navigate("/home")
            }
            else {
                navigate("/manageTransazioni")
            }
        }
    }, [utenteContext.utente])

    // useEffect(() => {
    //     var myToast = toastRef.current
    //     var bsToast = bootstrap.Toast.getInstance(myToast)

    //     if (!bsToast) {
    //         // initialize Toast
    //         bsToast = new Toast(myToast, { autohide: false })
    //         // hide after init
    //         bsToast.hide()
    //         setToast(false)
    //     }
    //     else {
    //         // toggle
    //         toast ? bsToast.show() : bsToast.hide()
    //     }
    // })


    return (
        <div className="row">
            <div className="col-4"></div>
            <div className="col-8">
                <img src="/logo.png" alt="" style={{ width: 200, height: 200, marginLeft: 200, marginTop: 70 }} />
                <form onSubmit={handleSubmit(onSubmit)}>
                    <h3 style={{ paddingBottom: "40px" }}>Accedi</h3>
                    <ComponenteInput register={register} valore={"email"} pattern={regexEmail} label={"Email:"} />
                    {errors.email && <p className="errorMsg">{errors.email.message}</p>}
                    <ComponenteInput register={register} valore={"password"} pattern={regexPassword} label={"Password:"} />
                    {errors.password && <p className="errorMsg">{errors.password.message}</p>}
                    <div >
                        <label></label>
                        <button className="btn btn-outline-primary" type="submit">Login
                        </button>
                    </div>
                    <div>
                        <label>Non Hai un account?</label>
                        <button className="btn btn-outline-primary" onClick={() => navigate("/anagrafica")}>Crea un Account</button>
                    </div>

                    <div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center w-100">


                        <div className="toast position-absolute m-4" role="alert">
                            <div className="toast-body">
                                Hello, world! This is a toast message.
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    )

}


export default Login;

