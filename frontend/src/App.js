import logo from './logo.svg';
import './App.css';
import ER_Diagram from "./Diagram";
import Diagram from "./Diagram";
// function App() {
//   return (
//       <div className="App">
//         <header className="App-header">
//           <img src={logo} className="App-logo" alt="logo" />
//           <p>
//             Edit <code>src/App.js</code> and save to reload.
//           </p>
//           <a
//               className="App-link"
//               href="https://reactjs.org"
//               target="_blank"
//               rel="noopener noreferrer"
//           >
//             Learn React
//           </a>
//         </header>
//       </div>
//   );
// }
function App(){
    return (
        <div>
            <Header />
            <Diagram />
        </div>
    )
}

function Header(){
    return(
        <div className="Logo">
            <img src="https://sciencenotes.org/silicon-facts/silicon_tile/" alt="Logo" className="App-logo" />
            <text>Генерация синтетических данных для тестирования</text>
        </div>
    )
}
export default App;