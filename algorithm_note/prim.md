# Prime Algorithm

하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어 가는 방식

1. 임의 정점을 하나 선택해서 시작
2. 선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택
    - 간선들을 보관하는 `우선순위 큐<간선>`를 이용하여 가장 작은 가중치의 값을 뽑는다.
    - 위 가정에서 `사이클이 존재하지 않도록` 정점의 방문처리를 한다.
3. 모든 정점이 선택될 때까지 (1),(2) 과정을 반복

![prim algorithm](https://i.stack.imgur.com/TTwpR.png)

```javascript
// 주어진 그래프 [a,b,c,d,e,f,g,h,i]
const edgeCnt = 9;
const graph = [
    [0,4,0,0,0,0,0,8,0],
    [4,0,8,0,0,0,0,11,0],
    [0,8,0,7,0,4,0,0,2],
    [0,0,7,0,9,14,0,0,0],
    [0,0,0,9,0,10,0,0,0],
    [0,0,4,14,10,0,2,0,0],
    [0,0,0,0,0,2,0,1,6],
    [8,11,0,0,0,0,1,0,7],
    [0,0,2,0,0,0,0,6,7]
]
class Edge {
    constructor(next, cost) {
        this.next = next;
        this.cost = cost;
    }
}

let arr = graph.map(item => item.map((cost, next) => new Edge(next, cost)).filter(edge => edge.cost))
let visited = Array(9).fill(false)
let pq = [];

const priorityCost = (a,b) => b.cost - a.cost

const prim = (start = 0) => {
    let minimunCost = 0;    // 최소비용
    let lineCnt = edgeCnt-1;// 최소 간선의 수
    visited[start] = true   // 초기 노드의 방문 처리

    // 초기 노드의 간선 정보를 모두 PriorityQueue에 넣어준다.
    arr[start].forEach(edge => pq.push(edge))
    pq.sort(priorityCost)

    // 간선들의 비교
    while(pq.length && lineCnt) {
        const e = pq.pop();
        if(visited[e.next]) continue;

        visited[e.next] = true;
        minimunCost += e.cost;
        lineCnt--;

        arr[e.next].filter(edge => !visited[edge.next]).forEach(edge => pq.push(edge)) // 방문된 노드에 대한 간선은 넣어주지 않음.
        pq.sort(priorityCost)
    }

    return minimunCost;
}

console.log(prim());    // 37
```