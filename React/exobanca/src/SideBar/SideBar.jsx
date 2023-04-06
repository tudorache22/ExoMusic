import React, { useContext } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext } from "../App";

const SideBar = () => {

    const connessoContext = useContext(ConnessoContext);


    const history = useHistory();

    function navigate(path) {
        history(path);
    }

    if (connessoContext === true) {
        return (
            <div>
                <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                    Menu
                </button>

                <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <button class="nav-link active" aria-current="page" onClick={() => navigate("/home")}>Home</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" onClick={() => navigate("/profilo")}>Profilo</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" onClick={() => navigate("/conto")}>Conto</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" onClick={() => navigate("/operazioni")}>Operazioni</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" onClick={() => navigate("/assistenza")}>Assistenza</button>
                            </li>

                        </ul>


                    </div>
                </div>
            </div>
        )
    }



}

export default SideBar;