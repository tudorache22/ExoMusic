import React, { useContext } from "react";
import { ConnessoContext } from "../../App";
import Header from "../../Header/Header";

const HeaderAdmin = () => {

    const connessoContext = useContext(ConnessoContext)

    if (connessoContext.connesso === true) {
        return (
            <div className="row">
                <div className="col-8">
                    <Header />
                </div>

            </div>
        )
    }



}

export default HeaderAdmin;