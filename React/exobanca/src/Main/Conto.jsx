import React, { useContext,  useState } from "react";
import { ConnessoContext, ContoCorrenteContext, UtenteContext } from "../App";
import InfoConto from "./InfoConto";
import ListaMovimenti from "./ListaMovimenti";
import AttivaConto from "./AttivaConto";

const Conto = () => {
    
    const contoCorrenteContext= useContext(ContoCorrenteContext);
    const utenteContext=useContext(UtenteContext);

    if (null !== utenteContext.utente.contoCorrentes && utenteContext.utente.contoCorrentes.length !==0)
{
    return (
        <div className="row">
            <div className="col-12">
                <InfoConto />
            </div>
            <div className="col-12">
                <ListaMovimenti />
            </div>

        </div>
    ) 
}
else{
    return (
        <div>
            <AttivaConto />
        </div>
    )
}

}

export default Conto;