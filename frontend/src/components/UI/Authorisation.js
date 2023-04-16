import React, {useState} from 'react';
import './Authorization.css';
import Header from "./Header";
import { saveAs } from 'file-saver';

function Authorization() {

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
        console.log(json)
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
