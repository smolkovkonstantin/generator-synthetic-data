function getRequest(url){
    /* gets data that we need for tables in the DB*/
    return fetch(url).then(responce => {return responce.json()})
}

export default getRequest;