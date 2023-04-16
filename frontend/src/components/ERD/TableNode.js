import ClickableTable from "./ClickableTable";
import "./TableNode.css"
import {useState} from "react";

function TableNode(props) {

    const showModalHandler = (showModal) => {
        props.onShowModal(showModal)
    }

    return (
        <div className="table-node">
            <ClickableTable
                data={props.data.data}
                title={props.data.title}
                onShowModal={showModalHandler} />
        </div>
    );
}

export default TableNode