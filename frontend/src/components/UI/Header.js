import "./Header.css"
import Help from "./Help";
import "./Help.css"
function Header(){
    return(
        <div className="Logo">
            <img src="https://sciencenotes.org/silicon-facts/silicon_tile/" alt="Logo" className="App-logo" />
            <text className="text1">Генерация синтетических данных для тестирования</text>
            <div className="new"><Help /></div>
        </div>
    )
}

export default Header;
