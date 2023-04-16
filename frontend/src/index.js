import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Authorisation from "./components/UI/Authorisation";
import Header from "./components/UI/Header";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Authorisation />
);
