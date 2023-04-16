import React from "react";
import ReactDOM from "react-dom/client";
import "./Help.css"
import openPopup from "./OpenPop";
import closePopup from "./ClosePop";


function Help(){
    function closePopup(){
        let popup = document.getElementById("popup");
        popup.classList.remove("open-popup")}
    function openPopup(){
        let popup = document.getElementById("popup");
        popup.classList.add("open-popup")
    }
    return <div className="container">
        <button type="submit" className="btn" onClick={openPopup}>Help!</button>
        <div className="popup" id="popup">
        <h1>Help!</h1>
            <img src="https://mygarnizon.com/files/product/158577106cc0472070c8657fa2e6ef2942c46f8dd.png" alt="help"></img>
        <h2>Вы находитесь в программе: "Генерация синтетических данных для тестирования".
        В данной программе вы можете: сгенерировать синтетические данные для полей таблиц с помощью маск,
            скачать данные в json формате и посмотреть на структуру БД.

        </h2>
        <h2>Маски:</h2>
        <p># - цифра</p>
        <p>Пример: +7(###)###-##-##</p>
        <p>? - буква</p>
        <p>Пример: ?????@gmail.com</p>
        <p>?[n] - будет сгенерировано n букв</p>
        <p>Пример: [20]@mail.ru </p>
        <p>#[n] - будет сгенерировано n цифр</p>
        <p>Пример: +7#[10]</p>
        <p>Экранирование символов также доступно:</p>
        <p>Пример: \? = ?</p>
        <h2>Любые символы, за исключением указанных, будут расценены как необходимые символы.</h2>
            <button type="button" onClick={closePopup}>Закрыть</button>
        </div>
    </div>
}
export default Help;