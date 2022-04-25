const graph = {
    A: ['B', 'C'],
    B: ['A', 'D'],
    C: ['A', 'G', 'H', 'I'],
    D: ['B', 'E', 'F'],
    E: ['D'],
    F: ['D'],
    G: ['C'],
    H: ['C'],
    I: ['C', 'J'],
    J: ['I']
};

const BFS = (graph, startNode, cb) => {
    const visited = [];
    const needVisited = [startNode];
    const distance = {};
    const pred = {};
    while(needVisited.length) {
        // #1 맨 앞 것 가져오기
        const target = needVisited.shift();
        console.log(`${target}에 대한 검색을 시작합니다.`);
        // #2 visited에 인접 노드가 있으면 넣지 말고, 없다면 needVisited에 넣어주기
        graph[target].forEach(v=>{
            if(!visited.includes(v)) {
                needVisited.push(v);
                distance[v] = (distance[target] || 0 ) + 1;
                pred[v] = target;
                if(cb) cb(v);
            }
        });
        // #3 target에 대한 검사가 끝났으므로 visited에 넣어주기
        visited.push(target);
        console.log(`-----------------------`)
        console.log("visited", visited);
        console.log("needVisited", needVisited);
        console.log(`----- ${target} 검사종료-------`);
    }
    console.log(distance);
    console.log(pred);
}

const DFS = (graph, startNode, cb) => {
    const visited = [];
    const needVisited = [startNode];

    const search = (target) => {
        if(!visited.include(target)){
            visited.push(target);
            search()
        }
    }

    while(needVisited.length) {
        const target = needVisited.shift();
        if(!visited.includes(target)){
            console.log(`${target}에 대한 검색을 시작합니다.`);   
            needVisited.unshift(...graph[target]);
            visited.push(target);
            console.log(`-----------------------`)
            console.log("visited", visited);
            console.log("needVisited", needVisited);
            console.log(`----- ${target} 검사종료-------`);
        }
    }
}

const visited = [];
const DFSr = (value) => {
    visited.push(value);
    graph[value].forEach(item=>{
        if(!visited.includes(item)) {
            DFSr(item);
        }
    })
}

// DFSr("A");

BFS(graph, "A", (pushedItem)=>{console.log(`${pushedItem}이 들어갑니다!!`)});