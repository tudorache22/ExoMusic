import React, { useContext } from "react";
import { ConnessoContext, UtenteContext } from "../App";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars } from '@fortawesome/free-solid-svg-icons'

const ButtonSidebar = () => {

    const connessoContext = useContext(ConnessoContext)
    const utenteContext = useContext(UtenteContext)

    if (connessoContext.connesso && utenteContext.utente.ruolo.idRuolo === 1) {
        return (
            <div>
                <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                    <FontAwesomeIcon icon={faBars} size="2xl" />
                </button>
            </div>
        )
    }


}

export default ButtonSidebar;