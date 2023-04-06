import React, { useContext, useEffect, useState } from "react";
import { MovimentoContext, UtenteContext } from "../App";

const ListaMovimenti = () => {

    const utenteContext = useContext(UtenteContext);
    const URI = "" + utenteContext.utente.idUtente;
    const [movimenti, setMovimenti] = useState([]);
    let costanteIndex = 1;
    const movimentoContext = useContext(MovimentoContext);

    function cercaMovimenti() {
        fetch(URI, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                setMovimenti(response);
            })
    };

    useEffect(() => {
        cercaMovimenti();
    }, []);


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
            </table>
            {movimenti.length > 0 ?
                <tbody>
                    {movimenti.map(movimento => {
                        <tr>
                            <th>{costanteIndex + 1}</th>
                            <td>{movimento.importo}</td>
                            <td>{movimento.stato}</td>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="modalMovimento"
                                onClick={movimentoContext.setMovimento(movimento)}>
                                More Info
                            </button>

                        </tr>
                    })}

                </tbody> :

                <div>
                    <p>Non ci sono movimenti</p>
                </div>}

        </div>
    )


}

export default ListaMovimenti;