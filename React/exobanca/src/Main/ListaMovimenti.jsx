import React, { useContext, useEffect, useState } from "react";
import { MovimentoContext, UtenteContext } from "../App";
import ModalMovimento from "./ModalMovimento";

const ListaMovimenti = () => {

    const utenteContext = useContext(UtenteContext);
    let costanteIndex = 1;
    const movimentoContext = useContext(MovimentoContext);



    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Importo</th>
                        <th scope="col">Stato</th>
                        <th scope="col">Info</th>
                    </tr>
                </thead>
        
            {utenteContext.utente.transaziones.length > 0 ?
                <tbody>
                    {utenteContext.utente.transaziones.map(movimento => {
                        return(
                        <tr>
                            <th>{costanteIndex + 1}</th>
                            <td>{movimento.importo}</td>
                            <td>{movimento.stato}</td>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalMovimento"
                                onClick={movimentoContext.setMovimento(movimento)}>
                                More Info
                            </button>
                            <ModalMovimento/>

                        </tr>
                        )
                    })}

                </tbody> :
                <div>
                    <p>Non ci sono movimenti</p>
                </div>}
                </table>
        </div>
    )


}

export default ListaMovimenti;