import React from "react";
import { Route, Switch, useHistory } from "react-router-dom";

import Login from "../FormIniziale/Login";
import Assistenza from "./Assistenza";
import Conto from "./Conto";
import Home from "./Home";
import Operazioni from "./Operazioni";
import Profilo from "./Profilo";
import InfoConto from "./InfoConto";
import ListaMovimenti from "./ListaMovimenti";
import ProvaMovimenti from "./ProvaMovimenti";
import Deposito from "./Deposito";
import Notifiche from "./Notifiche";
import ManageTranaszioni from "../MainAdmin/ManageTransazioni";
import ControllTransazione from "../MainAdmin/ControllTransazione";
import ManageConti from "../MainAdmin/ManageConti";
import ControllConto from "../MainAdmin/ControllConto";
import Anagrafica from "../FormIniziale/Anagrafica";
import Register from "../FormIniziale/Register";
import AttivaConto from "./AttivaConto";
import AttesaConto from "./AttesaConto";



const Main = () => {


    return (
        <div>
            <Switch>
                <Route exact path={"/"}>
                    <Login />
                </Route>
                <Route exact path={"/register"}>
                    <Register />
                </Route>
                <Route exact path={"/login"}>
                    <Login />
                </Route>
                <Route exact path={"/home"}>
                    <Home />
                </Route>
                <Route exact path={"/profilo"}>
                    <Profilo />
                </Route>
                <Route exact path={"/operazioni"}>
                    <Operazioni />
                </Route>
                <Route exact path={"/conto"}>
                    <Conto />
                </Route>
                <Route exact path={"/assistenza"}>
                    <Assistenza />
                </Route>
                <Route exact path={"/anagrafica"}>
                    <Anagrafica />
                </Route>
                <Route exact path={"/notifiche"}>
                    <Notifiche />
                </Route>
                <Route exact path={"/manageTransazioni"}>
                    <ManageTranaszioni />
                </Route>
                <Route exact path={"/controllTransazione"}>
                    <ControllTransazione />
                </Route>
                <Route exact path={"/manageConti"}>
                    <ManageConti />
                </Route>
                <Route exact path={"/controllConto"}>
                    <ControllConto />
                </Route>
                <Route exact path={"/attivaConto"}>
                    <AttivaConto />
                </Route>
                <Route exact path={"/attesaConto"}>
                    <AttesaConto />
                </Route>
            </Switch>
        </div>


    )


}

export default Main;