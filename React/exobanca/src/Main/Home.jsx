import React from "react";
import Conto from "./Conto";
import Presentazione from "./Presentazione";
import InfoConto from "./InfoConto";

const Home = () => {

    return (
        <div className="row">
            <div className="col-4">
            <img src="/logo.png" alt=""  style={{ width: 250, height: 250, marginLeft:100, marginTop:150 }}/>
            </div>
            <div className="col-5">
                <div className="stilemio" >
                    <Presentazione/>
                </div>
            </div>
            <div className="col-3">
                <InfoConto/>
            </div>
        </div>
    )

}

export default Home;