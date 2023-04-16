import "./ERD.css"
import ClickableTable from "./ClickableTable";
import {tab} from "@testing-library/user-event/dist/tab";

function ERD() {

    const tables = [
        {
            title: 'Table 1',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 2',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 3',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 4',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 5',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 1',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 2',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 3',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 4',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
        {
            title: 'Table 5',
            data: [
                {
                    column1: 'id',
                    column2: 'integer',
                },
                {
                    column1: 'name',
                    column2: 'Alex',
                },
                {
                    column1: 'phone',
                    column2: '88005553535',
                },
            ],
        },
    ];

    return (
        <div className="table-container">
            {tables.map((table, index) => (
                <div key={index}>
                    <ClickableTable data={table.data} title={table.title} />
                </div>
            ))}
        </div>
    );
}

export default ERD;