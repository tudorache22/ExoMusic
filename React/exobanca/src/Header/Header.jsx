import React, { useContext } from "react";
import { ConnessoContext } from "../App";
import ContainerHeader from "./ContainerHeader";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars } from '@fortawesome/free-solid-svg-icons'
import { faEnvelope } from '@fortawesome/free-solid-svg-icons'

import Logo from "./Logo";

const Header = () => {

    const connessoContext = useContext(ConnessoContext);

    if (connessoContext.connesso === true) {
        return (
            <header className="row">
                <div className="col-1">
                <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                <FontAwesomeIcon icon={faBars} size="2xl" />
            
              </button>
     
                </div>

                <div className="col-9">
                    <Logo />
                </div>
                <div className="col-2">
                    <ContainerHeader />
                </div>

            </header>
        )

    }

}


export default Header;