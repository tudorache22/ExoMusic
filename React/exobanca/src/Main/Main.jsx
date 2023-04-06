import React from "react";
import { Route, Switch, useHistory } from "react-router-dom";
import Anagrafica from "../FormIniziale/Anagrafica";
import Login from "../FormIniziale/Login";
import Register from "../FormIniziale/Register";
import Assistenza from "./Assistenza";
import Conto from "./Conto";
import Home from "./Home";
import Operazioni from "./Operazioni";
import Profilo from "./Profilo";

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
            </Switch>
        </div>


    )


}

export default Main;