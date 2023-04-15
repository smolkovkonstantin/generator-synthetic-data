function ClickableTable({ data }) {
    const handleClick = (rowIndex) => {
        console.log(`Row ${rowIndex} clicked!`);
    };

    return (
        <table>
            <thead>
            <tr>
                <th>Column 1</th>
                <th>Column 2</th>
            </tr>
            </thead>
            <tbody>
            {data.map((row, rowIndex) => (
                <tr key={rowIndex} onClick={() => handleClick(rowIndex)}>
                    <td>{row.column1}</td>
                    <td>{row.column2}</td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default ClickableTable;