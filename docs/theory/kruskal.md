# KRUSKAL Algorithm

간선을 하나씩 선택하여 MST를 찾는 알고리즘

1. 모든 간선의 가중치에따라 정렬
2. 가중치가 가장 낮은 간선부터 선택하며 그래프를 그려나감
    - 사이클이 존재하지 않도록 간선을 선택해야함.
3. N-1개의 간선이 선택될 때까지 (2)를 반복

![kruskal](https://www.researchgate.net/profile/Yael_Jacob/publication/221923505/figure/fig5/AS:305090574471176@1449750670012/An-example-of-how-the-Kruskal-algorithm-can-be-used-in-order-to-find-the-minimal-spanning.png)

```javascript
// 주어진 그래프 [a,b,c,d,e,f,g]
const edgeCnt = 9;
const graph = [
    [0,7,0,5,0,0,0],
    [7,0,8,9,7,0,0],
    [0,8,0,0,5,0,0],
    [5,9,0,0,15,6,0],
    [0,7,5,15,0,8,9],
    [0,0,0,6,8,0,11],
    [0,0,0,0,9,11,0]
]
class Edge {
    constructor(from, to, cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

let arr = graph.map((item,from) => item.map((cost, to) => new Edge(from, to, cost)).filter(edge => edge.cost))
let queue = [];
const priorityCost = (a,b) => b.cost - a.cost

const makeSet = (p,x) => p[x] = x
const findSet = (p,x) => {
    if(p[x] === x) return x;
    return p[x] = findSet(p,p[x]);
}
const unionSet = (p,edge) => {
    let pFrom = findSet(p, edge.from);
    let pTo = findSet(p, edge.to);

    if(pFrom !== pTo) {
        p[pTo] = pFrom;
        return true;
    }
    return false;
}


const kruskal = () => {
    let minimunCost = 0;      // 최소비용
    const edgeNumber = 7;     // 정점의 개수
    let lineCnt = edgeNumber-1;    // 최소비용의 간선의 개수

    // 정점의 개수만큼 집합생성
    let p = Array(edgeNumber);        
    for(let i = 0 ; i < edgeNumber; i++) makeSet(p,i);

    arr = arr.flat().sort(priorityCost);

    while(arr.length && lineCnt) {
        const edge = arr.pop();
        if(unionSet(p,edge,minimunCost)) {
            minimunCost += edge.cost;
            lineCnt--;
            console.log(`minimum cost : ${minimunCost}, edge : `, edge)
        }
    }
}
kruskal();
// console
/*
    minimum cost : 5, edge :  Edge { from: 4, to: 2, cost: 5 }
    minimum cost : 10, edge :  Edge { from: 3, to: 0, cost: 5 }
    minimum cost : 16, edge :  Edge { from: 5, to: 3, cost: 6 }
    minimum cost : 23, edge :  Edge { from: 4, to: 1, cost: 7 }
    minimum cost : 30, edge :  Edge { from: 1, to: 0, cost: 7 }
    minimum cost : 39, edge :  Edge { from: 6, to: 4, cost: 9 }
*/
```