import React, {useState} from 'react';
import './Authorization.css';
import Header from "./Header";
import { saveAs } from 'file-saver';

function Authorization() {
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
    function getData(){
        let password = document.getElementById("password").value
        let username = document.getElementById("username").value
        let url = document.getElementById("url").value
        const json = {
            password: password,
            userName: username,
            url: url
        }
        const myjson = JSON.stringify(json)
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
