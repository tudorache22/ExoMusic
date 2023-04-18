import React, { useContext } from "react";
import { ConnessoContext } from "../App";

const Footer = () => {

    const connessoContext = useContext(ConnessoContext);

    if (connessoContext.connesso === true) {
        return (
            <footer>
                <p>@ExoBanca</p>
            </footer>
        )
    }
    else {
        return <div></div>
    }
}

export default Footer;