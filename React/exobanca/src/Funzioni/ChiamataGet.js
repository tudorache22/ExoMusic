export function ChiamataGet(URI, callback) {
    console.log(URI)
    fetch(URI, {
        method: "GET",
        headers: {
            'Content-type': 'application/json;charset=UTF-8'
        }
    })
        .then(responseJson => responseJson.json())
        .then(response => {
            if (null != response) {
                callback(response);
                console.log(response);
                return response;
            }
        })
        .catch(error =>
            console.log(error))

}
