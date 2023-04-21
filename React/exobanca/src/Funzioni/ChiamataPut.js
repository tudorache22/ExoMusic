export function ChiamataPut(URI, body, callback) {


    fetch(URI, {
        method: "PUT",
        body: JSON.stringify(body),
        headers: {
            'Content-type': 'application/json;charset=UTF-8'
        }
    })
        .then(responseJson => responseJson.json())
        .then(response => {
            if (null !== response) {
                callback(response);
                return response;
            }
        })
        .catch(error =>
            console.log);


}
