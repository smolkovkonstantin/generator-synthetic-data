function postRequest(url, body=null) {
    /* sends a POST request to generate data */
    const method = "POST"
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
export default postRequest;