import ClickableTable from "./ClickableTable";

function ERD() {

    const data = [
        {
            column1: 'Row 1, Column 1',
            column2: 'Row 1, Column 2',
        },
        {
            column1: 'Row 2, Column 1',
            column2: 'Row 2, Column 2',
        },
        {
            column1: 'Row 3, Column 1',
            column2: 'Row 3, Column 2',
        },
    ];

    return (
        <ClickableTable data={data} />
    );
}

export default ERD;