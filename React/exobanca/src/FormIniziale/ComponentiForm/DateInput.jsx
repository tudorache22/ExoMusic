import React from "react";
import { useForm } from "react-hook-form";

const DateInput = (props) => {

    const messaggioRequired = "Data mancante";

    return (
        <div className="form-controll">
            <label>{props.label} </label>
            <input type="date" name={props.valore} {...props.register(props.valore, {
                required: messaggioRequired,
            })} />
        </div>
    )

}

export default DateInput;