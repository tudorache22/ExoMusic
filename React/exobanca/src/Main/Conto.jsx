import React, { useContext, useEffect, useState } from "react";
import { ContoCorrenteContext, UtenteContext } from "../App";
import InfoConto from "./InfoConto";
import ListaMovimenti from "./ListaMovimenti";

const Conto = () => {


    return (
        <div className="row">
            <div className="col-12">
                <InfoConto />
            </div>
            <div className="col-12">
                <ListaMovimenti />
            </div>

        </div>
    )

}

export default Conto();