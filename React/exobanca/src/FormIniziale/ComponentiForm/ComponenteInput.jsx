import React from "react";
import { useForm } from "react-hook-form";

const ComponenteInput = (props) => {

    const valore = props.valore;
    const messaggioRequired = "Campo " + valore + " è richiesto"
    const messaggioPattern = "Campo" + valore + " non è valido";


    return (
        <div className="form-controll">
            <label>{props.label}</label>
            <input type="text" name={props.valore} {...props.register(props.valore, {
                required: messaggioRequired,
                pattern: {
                    value: props.pattern,
                    message: messaggioPattern
                }
            })} />
        </div>
    )
}





export default ComponenteInput;


