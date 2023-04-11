import React, { useContext } from "react";
import { MovimentoContext } from "../App";

const ModalMovimento = () => {

    const movimentoContext = useContext(MovimentoContext);

    return (
        <div className="modal fade" id="modalMovimento" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div className="modal-dialog modal-dialog-centered" >
            <div className="modal-content">
                <div className="modal-header">
                    <h3>Info Movimento</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div className="modal-body">
                    <p>Importo: {movimentoContext.movimento.importo}</p>
                    <p>Stato: {movimentoContext.movimento.stato}</p>
                    <p>Tipo Transazione: {movimentoContext.movimento.tipoTransazione}</p>
                    <p>Data: {movimentoContext.movimento.data}</p>
                </div>
            </div>
        </div>
        </div>
    )

}

export default ModalMovimento;