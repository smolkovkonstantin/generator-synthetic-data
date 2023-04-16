import React, {useState} from 'react';
import './Authorization.css';
import Header from "./Header";
import ReactDOM from "react-dom/client";
import App from "../../App";

function Authorization() {
    function getRequest(url){
        /* gets data that we need for tables in the DB*/
        return fetch(url).then(responce => {
            if (responce.ok){
                const root = ReactDOM.createRoot(document.getElementById('root'));
                root.render(
                    <App />
                )
            }
        })
    }
    function postRequest(url, body) {
        /* sends a POST request to generate data */
        const method = "POST"
        return fetch(url, {
            method: method,
            body: body
        }).then(responce => {
            if (responce.ok) {
                return getRequest("http://localhost:8080/scheme/get")
            }

            return responce.json().then(
                error => {
                    const e = new Error('Something went wrong')
                    e.data = error
                    throw e
                })

        })
    }
    function getData(){
        let password = document.getElementById("password").value
        let username = document.getElementById("username").value
        let url = document.getElementById("url").value
        const body = {
            "password": password,
            "userName": username,
            "url": url
        }
        const myjson = JSON.stringify(body)
        postRequest("http://localhost:8080/connect", myjson)
    };
    return (
        <div>
            <Header />
        <div className="authorization-container">
            <h1 className="authorization-heading">Подключение к БД</h1>
            <form className="authorization-form">
                <label htmlFor="username">Username:</label>
                <input type="text" id="username" name="username" required />
                <label htmlFor="password">Password:</label>
                <input type="password" id="password" name="password" required />
                <label>URL:</label>
                <input type="text" id="url" name="password" required />
                <input type="submit" value="Log In" onClick={getData}/>
            </form>
        </div>
        </div>
    );
}

export default Authorization;
