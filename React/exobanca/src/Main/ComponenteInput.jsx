import React from "react";

const ComponenteInput = (label, valore) => {

    return (
        <div>
            <label> {label}</label>
            <input type="text" id="" value={valore} />
        </div>
    )
}

export default ComponenteInput;