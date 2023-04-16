import React, {useCallback, useEffect, useMemo, useState} from 'react';
import ReactFlow, { useNodesState, useEdgesState, addEdge } from 'reactflow';
import 'reactflow/dist/style.css';
import TableNode from "./TableNode.js"
import "./Nodes.css"

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

// const initialEdges = [{ id: 'e1-2', source: '1', target: '2' }];

export default function Nodes(props) {

    const initialNodes = tables.map((table, index) => {
        return {
            id: (index + 1).toString(),
            position: { x: index % 4 * 200, y: Math.floor(index/4) * 200 },
            data: {
                label: (index + 1).toString(),
                ...table,
            },
            type: 'table',
            // draggable: false,
        };
    });

    const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
    const [edges, setEdges, onEdgesChange] = useEdgesState([]);

    const onConnect = useCallback((params) => setEdges((eds) => addEdge(params, eds)), [setEdges]);

    const nodeTypes = useMemo(() => ({ table: TableNode }), []);


    // const [nodePosition, setNodePosition] = useState({ x: 100, y: 100 })
    //
    // useEffect(() => {
    //     setNodes((nds) =>
    //         nds.map((node) => {
    //
    //             let maxX = 1000
    //             let maxY = 700
    //
    //             const validatedX = node.position.x < 0 ? 0 : node.position.x;
    //             const validatedY = node.position.y < 0 ? 0 : node.position.y;
    //             const finalX = validatedX > maxX ? maxX : validatedX;
    //             const finalY = validatedY > maxY ? maxY : validatedY;
    //
    //             node.position = {x: finalX, y: finalY}
    //             console.log('123213123')
    //             return node;
    //         })
    //     );
    // }, [nodePosition, setNodes]);


    return (
        <div className="nodes-field">
            <ReactFlow
                nodes={nodes}
                edges={edges}
                onNodesChange={onNodesChange}
                onEdgesChange={onEdgesChange}
                onConnect={onConnect}
                nodeTypes={nodeTypes}
                zoomOnScroll={false}
                zoomOnDoubleClick={false}
                zoomOnPinch={false}
                panOnDrag={false}
            />
        </div>
    );
}
