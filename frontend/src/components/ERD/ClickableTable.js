import './ClickableTable.css';
import { useState } from 'react';


function ClickableTable(props) {
    const [showModal, setShowModal] = useState(false);

    const handleClick = () => {
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };

    return (
        <>
            <table onClick={() => handleClick()}>
                <thead>
                <tr>
                    <th colSpan="2">{props.title}</th>
                </tr>
                </thead>
                <tbody id="table-content">
                {props.data.map((row, rowIndex) => (
                    <tr key={rowIndex}>
                        <td>{row.column1}</td>
                        <td>{row.column2}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            {showModal && (
                <div className="modal">
                    <div className="modal-content">
                        <span className="close" onClick={handleCloseModal}>&times;</span>
                        <p>{props.title}</p>
                    </div>
                </div>
            )}
        </>
    );
}

export default ClickableTable;
