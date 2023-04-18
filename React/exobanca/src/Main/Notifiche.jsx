import React, { useContext } from "react";
import { MovimentoContext, NotificheContext, UtenteContext } from "../App";
import Table from 'react-bootstrap/Table';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCommentsDollar } from '@fortawesome/free-solid-svg-icons'
import ModalTransazione from "./ModalTransazione";

const Notifiche =()=> {

    const notificheContext=useContext(NotificheContext);
    const movimentoContext=useContext(MovimentoContext);
    const utenteContext=useContext(UtenteContext);

    if(utenteContext.utente.transaziones.length>0){
        return(
            <div className="stilemio">
    <Table striped bordered hover variant="white">
      <thead>
        <tr>
          <th>Data</th>
          <th>Importo</th>
          <th>Categoria</th>
          <th>Stato</th>
          <th>Conferma</th>
        </tr>
      </thead>
      <tbody>
        
        {utenteContext.utente.transaziones.map(notifica=>{
          if(notifica.statoTransazione.idStato===6){
          return(
            <tr>
              <td>{notifica.data} </td>
              <td>${notifica.importo}</td>
              <td>{notifica.tipoTransazione}</td>
              <td>{notifica.statoTransazione.stato}</td>
              <td>
                <button className="text-dark btn text-start" style={{paddingLeft:40}}  data-bs-toggle="modal" data-bs-target="#modalTransazione" onClick={()=>movimentoContext.setMovimento(notifica)}>
                  <FontAwesomeIcon icon={faCommentsDollar} size="lg" />
                  </button>
              </td>
              </tr>
          )}
        })}
     
      </tbody>
    </Table>   
    <ModalTransazione/>
            </div>
        )
    }

    else{
      <div>s</div>
    }



}

export default Notifiche;