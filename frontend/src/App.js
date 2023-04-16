import Header from "./components/UI/Header";
import ERD from "./components/ERD/ERD";
import Nodes from "./components/ERD/Nodes";
import {useState} from "react";
import Modal from "./components/ERD/Modal";

function App(){

    return (
        <div>
            <Header />
            <ERD />
        </div>
    )
}



export default App;
