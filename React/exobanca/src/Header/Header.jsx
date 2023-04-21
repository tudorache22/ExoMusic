import React, { useContext } from "react";
import { ConnessoContext } from "../App";
import ContainerHeader from "./ContainerHeader";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars } from '@fortawesome/free-solid-svg-icons'
import { faEnvelope } from '@fortawesome/free-solid-svg-icons'

import Logo from "./Logo";
import ButtonSidebar from "./ButtonSidebar";

const Header = () => {

    const connessoContext = useContext(ConnessoContext);

    if (connessoContext.connesso === true) {
        return (
            <header className="row">
                <div className="col-1">
                    <ButtonSidebar />
                </div>

                <div className="col-8">
                    <Logo />
                </div>
                <div className="col-3">
                    <ContainerHeader />
                </div>

            </header>
        )

    }

}


export default Header;