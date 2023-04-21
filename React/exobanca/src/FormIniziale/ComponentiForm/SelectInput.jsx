import React from "react";
import { useForm } from "react-hook-form";

const SelectInput = (props) => {

    const lista = props.lista;
    const valore = props.valore;
    const messaggioRequired = "Campo " + valore + " è richiesto"




    return (
        <div className="form-controll">
            <label> {props.label}</label>
            <select name={props.valore} {...props.register(props.valore, {
                required: messaggioRequired
            })}>
                <option selected disabled value="">Seleziona un elemento</option>
                {lista.map(elemento => {
                    return <option value={elemento}>{elemento}</option>
                })}
            </select>
        </div>
    )
}





export default SelectInput;