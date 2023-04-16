function getRequest(url){
    /* gets data that we need for tables in the DB*/
    return fetch(url).then(responce => {return responce.json()})
}
// const RequestUrl = "https://jsonplaceholder.typicode.com/users"
// getRequest(RequestUrl)
//     .then(data => console.log(data))
//     .catch(err => console.log(err))

export default getRequest;