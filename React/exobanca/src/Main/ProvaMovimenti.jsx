import React, { useContext } from "react";
import { UtenteContext } from "../App";

const ProvaMovimenti = () =>{

    const utenteContext= useContext(UtenteContext);

    return(
        <div>
            {utenteContext.utente.transaziones.map(movimento =>{

                return(
                <div>
                    <p>s</p>
                <p>{movimento.importo}</p>
                <p>{movimento.tipoTransazione}</p>
                <p>{movimento.stato}</p>
                <p>{movimento.data}</p>
                </div>
                )
            })}

        </div>
    )


}

export default ProvaMovimenti;