import React, { useContext } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, UtenteContext } from "../App";

const NavBar = () => {

    const connessoContext = useContext(ConnessoContext);
    const utenteContext = useContext(UtenteContext);

    const history = useHistory();

    function navigate(path) {
        history.push(path)
    }

    if (connessoContext.connesso && utenteContext.utenteContext.ruolo.idRuolo === 1) {
        return (
            <div style={{ marginBottom: "30px" }}>
                <nav className="navbar navbar-expand-lg bg-body-tertiary">
                    <div className="container-fluid">
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                                <li className="nav-item">
                                    <button className="text-dark btn text-start" aria-current="page" onClick={() => navigate("/home")}>Home</button>
                                </li>
                                <li className="nav-item">
                                    <button className="text-dark btn text-start" onClick={() => navigate("/profilo")}>Profilo</button>
                                </li>
                                <li className="nav-item">
                                    <button className="text-dark btn text-start" onClick={() => navigate("/conto")}>Conto</button>
                                </li>
                                <li className="nav-item">
                                    <button className="text-dark btn text-start" onClick={() => navigate("/operazioni")}>Operazioni</button>
                                </li>
                                <li className="nav-item">
                                    <button className="text-dark btn text-start" onClick={() => navigate("/assistenza")}>Assistenza</button>
                                </li>

                            </ul>

                        </div>
                    </div>
                </nav>
            </div>
        )
    }

}


export default NavBar;