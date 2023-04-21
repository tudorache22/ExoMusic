import React, { useContext } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, MovimentoContext, UtenteContext } from "../App";

const SideBar = () => {

    const connessoContext = useContext(ConnessoContext);
    const utenteContext = useContext(UtenteContext);


    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    if (connessoContext.connesso) {
        if (utenteContext.utente.ruolo.idRuolo === 1) {
            return (
                <div>

                    <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                        <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasExampleLabel">ExoBanca</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body" style={{ backgroundColor: "#0D4C92" }}>
                            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                <li class="nav-item">
                                    <button className="text-white btn text-start" aria-current="page" onClick={() => navigate("/home")} style={{ width: "100px", height: "50px" }}>Home</button>
                                </li>
                                <li class="nav-item">
                                    <button className="text-white btn text-start" onClick={() => navigate("/profilo")}>Profilo</button>
                                </li>
                                <li class="nav-item">
                                    <button className="text-white btn text-start" onClick={() => { navigate("/conto"); console.log(utenteContext.utente) }}>Conto</button>
                                </li>
                                <li class="nav-item">
                                    <button className="text-white btn text-start" onClick={() => navigate("/operazioni")}>Operazioni</button>
                                </li>
                                <li class="nav-item">
                                    <button className="text-white btn text-start" onClick={() => navigate("/assistenza")}>Assistenza</button>
                                </li>

                            </ul>


                        </div>
                    </div>
                </div>
            )
        }
    }


}

export default SideBar;