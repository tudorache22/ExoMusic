import React, { useContext, useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, ContoCorrenteContext, NotificheContext, UtenteContext } from "../App";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBell } from '@fortawesome/free-solid-svg-icons'
import { AnagraficaContext } from "../App";

const ContainerHeader = () => {

    const connessoContext = useContext(ConnessoContext);
    const utenteContext = useContext(UtenteContext);
    const contoCorrenteContext=useContext(ContoCorrenteContext);
    const anagraficaContext=useContext(AnagraficaContext);

    const notificheContext=useContext(NotificheContext);

    
    
    function controlloNotifiche(){
        notificheContext.setNotifiche([]);
        utenteContext.utente.transaziones.map( notifica =>{
            if(notifica.statoTransazione.idStato ===6){
                notificheContext.notifiche.push(notifica);
            }else{
                console.log("no");
            }
        })
    }

    useEffect(()=>{
        controlloNotifiche();
    },[utenteContext.utente]);

    const history = useHistory();
    function navigate(path) {
        history.push(path)
    }

    function logOut(){
        utenteContext.setUtente({
            idUtente: "",
            password: "",
            email: "",
            ruolo: "",
            anagrafica: anagraficaContext.anagrafica,
            transaziones: [],
            contoCorrentes:[]
          });
          contoCorrenteContext.setContoCorrente({
            idContoCorrente:"",
            numeroConto: "",
            dataScadenza: "",
            saldo: ""
          });
          connessoContext.setConnesso(false); 
          navigate("/login");
          
    }

    if (connessoContext.connesso === true) {
        return (
            <div className="row">
            <div className="col-10">
                <p>Benvenuto {utenteContext.utente.anagrafica.nome}</p>  
            </div>
            <div className="col-2">
                <button type="button" class="btn btn-primary" onClick={()=>navigate("/notifiche")}>
                    <FontAwesomeIcon icon={faBell} style={{color: "#ffffff",}} /> 

                    {/* <span class="badge text-bg-secondary">{notificheContext.notifiche.lenght}</span> */}
                 </button>
           </div>
           <div className="col-12" style={{ marginRight: 0,marginRight:"auto"}}>
                <label>Vuoi fare il LogOut?</label>
                <button type="text" onClick={() => logOut()} class="btn btn-primary">LogOut</button>
                </div>
            </div>
           
        )
    }
    else {
        return (
            <div></div>
        )
    }

}

export default ContainerHeader;