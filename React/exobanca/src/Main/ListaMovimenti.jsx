import React, { useContext, useEffect, useState } from "react";
import { MovimentoContext, UtenteContext } from "../App";
import ModalMovimento from "./ModalMovimento";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCommentsDollar } from '@fortawesome/free-solid-svg-icons'
import Table from 'react-bootstrap/Table';

const ListaMovimenti = () => {

    const utenteContext = useContext(UtenteContext);
    let costanteIndex = 1;
    const movimentoContext = useContext(MovimentoContext);



    return (
        <div>
            <Table striped bordered hover variant="white">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Importo</th>
                        <th>Info</th>
                    </tr>
                </thead>
                <tbody>

                    {utenteContext.utente.transaziones.map(transazione => {
                        if (transazione.statoTransazione.idStato === 3) {
                            return (
                                <tr>
                                    <td>{transazione.data} </td>
                                    <td>${transazione.importo}</td>
                                    <td>
                                        <button className="text-dark btn text-start" style={{ paddingLeft: 40 }} data-bs-toggle="modal" data-bs-target="#modalMovimento" onClick={() => movimentoContext.setMovimento(transazione)}>
                                            <FontAwesomeIcon icon={faCommentsDollar} size="lg" />
                                        </button>
                                    </td>
                                </tr>
                            )
                        }
                    })}
                    <ModalMovimento />

                </tbody>
            </Table>
        </div>
    )


}

export default ListaMovimenti;