function sendRequest(method, url, body=null) {
    /* sends a POST request to generate data */
    const headers = {
        'Cpntent-Type': "application/json"
    }
    return fetch(url, {
        method: method,
        body: JSON.stringify(body),
        headers: headers
    }).then(responce => {
        if (responce.ok) {
            return responce.json()
        }

        return responce.json().then(
            error => {
                const e = new Error('Something went wrong')
                e.data = error
                throw e
            })

    })
}
function getRequest(url){
    /* gets data that we need for tables in the DB*/
    return fetch(url).then(responce => {return responce.json()})
}
// const RequestUrl = "https://jsonplaceholder.typicode.com/users"
// getRequest(RequestUrl)
//     .then(data => console.log(data))
//     .catch(err => console.log(err))

export default sendRequest;
export default getRequest;