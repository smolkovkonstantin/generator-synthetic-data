import React from 'react';

function Modal(props) {
    const handleSaveClick = () => {
        const data = {};

        props.data.forEach((row, rowIndex) => {
            const input_reg = document.getElementById(`input-${rowIndex}-reg`).value;
            const input_num = document.getElementById(`input-${rowIndex}-num`).value;
            data[row.column1] = {"regexp": input_reg, "number_of_characters":input_num};
        });

        const json = JSON.stringify(data);
        const blob = new Blob([json], {type: 'application/json'});
        const url = URL.createObjectURL(blob);

        const a = document.createElement('a');
        a.download = 'data.json';
        a.href = url;
        a.click();

        URL.revokeObjectURL(url);
    };

    return (
        <div className="modal">
            <div className="modal-content">
                <span className="close" onClick={props.handleCloseModal}>
                    &times;
                </span>
                <table>
                    <thead>
                        <tr>
                            <th colSpan="4" align={"center"}>{props.title}</th>
                        </tr>
                        <tr>
                            <th>field name</th>
                            <th>type</th>
                            <th>regexp</th>
                            <th>number of characters</th>
                        </tr>
                    </thead>
                    <tbody id="table-content">
                    {props.data.map((row, rowIndex) => (
                        <tr key={rowIndex}>
                            <td>{row.column1}</td>
                            <td>{row.column2}</td>
                            <td>
                                <input
                                    id={`input-${rowIndex}-reg`}
                                    type="text"
                                />
                            </td>
                            <td>
                                <input
                                    id={`input-${rowIndex}-num`}
                                    type="number"
                                />
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <button onClick={handleSaveClick}>Save</button>
            </div>
        </div>
    );
}

export default Modal;
