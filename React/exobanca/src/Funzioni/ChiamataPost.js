
export function ChiamataPost(URI, body, callback) {

    fetch(URI, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            'Content-type': 'application/json;charset=UTF-8'
        }
    })
        .then(responseJson => responseJson.json())
        .then(response => {
            callback(response);
            console.log(response);
            return response;
        })
        .catch(error => console.log(error))


}
