import React, { useContext, useEffect, useState } from "react";


const InfoConto = () => {

    const contoCorrenteContext = useContext(contoCorrenteContext);
    const URIconto = "";

    function trovaConto() {
        fetch(URIconto, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                contoCorrenteContext.setContoCorrente(response);
            })
            .catch(error => {
                console.log(error);
            })
    }

    useEffect(() => {
        trovaConto();
    }, []);

    return (
        <div className="stilemio">
            <h1>Il tuo Conto</h1>
            <p>conto:</p>
            <b>{contoCorrenteContext.conto.numeroConto}</b>
            <h4>Il tuo conto attuale è di </h4>
            <h2>{contoCorrenteContext.conto.saldo}</h2>
        </div>
    )




}

export default InfoConto;