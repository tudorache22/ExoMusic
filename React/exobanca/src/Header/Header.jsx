import React, { useContext } from "react";
import { ConnessoContext } from "../App";
import ContainerHeader from "./ContainerHeader";
import Logo from "./Logo";

const Header = () => {

    const connessoContext = useContext(ConnessoContext);

    if (connessoContext.connesso === true) {
        return (
            <header className="row">
                <div className="col-9">
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