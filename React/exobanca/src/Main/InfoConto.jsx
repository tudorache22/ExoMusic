import React, { useContext, useEffect, useState } from "react";
import { ContoCorrenteContext, UtenteContext } from "../App";


const InfoConto = () => {

    const contoCorrenteContext = useContext(ContoCorrenteContext);
    const utenteContext=useContext(UtenteContext);

    if(null !== utenteContext.utente.contoCorrentes && utenteContext.utente.contoCorrentes.length >0){
    return (
        <div className="stilemio">
            <h1>Il tuo Conto</h1>
            <p>conto:</p>
            <b>{contoCorrenteContext.contoCorrente.numeroConto}</b>
            <h4>Il tuo saldo attuale è di </h4>
            <h2>$ {contoCorrenteContext.contoCorrente.saldo}</h2>
            <p></p>
        </div>
    
    )
    }




}

export default InfoConto;