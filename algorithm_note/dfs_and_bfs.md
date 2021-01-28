# DFS & BFS


### DFS

- `재귀함수`를 이용
- `조건에 도달하면 함수를 리턴`하면서 스택에 쌓인 함수를 수행해낸다.
- **최적의 경로 탐색**에서 사용
- 방문 체크
  - 경로를 탐색 후 방문 체크를 풀어주는 방법
  - 경로를 탐색할때 방문 체크를 해주어 중복 방문을 막는 방법
- `DP`를 이용하여 최소 경로를 찾는 방법이 존재 
  - 매우 깊은 탐색은 Stack overflow를 발생

![https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_13.png](https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_13.png)

![https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_01.png](https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_01.png)



### BFS

- `Queue`를 이용
- 조건에 도달했을때 요구하는 값을 출력가능
- **최단거리 탐색**에서 사용
- 방문 체크
  - 방문해야할 경로를 Queue에 넣어두는 동시에 방문 처리를 해줘야 중복 경로가 Queue에 담기지 않는다.
- Queue의 타입을 주로 Class를 선언하여 `Index`,`Count`를 속성으로 두고 목표 경로에 도달했을때 Count를 출력하는 방식

![https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_14.png](https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_14.png)

![https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_02.png](https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_02.png)

### 구현

```javascript
let arr = [
    [0,0,0,0,0],
    [0,1,1,1,0],
    [0,1,0,0,0],
    [0,1,0,1,0],
    [0,0,0,1,0],
]
const directions = [[-1,0],[0,1],[1,0],[0,-1]]

// arr 배열의 [0][0]에서 출발해서 [4][4]까지 도착하는 로직 (0: 길, 1: 벽), 길을 통해서만 이동가능 
const searchHandler = () => {
    console.log('Breadth First Search')
    const bfsResult = BFS(Array.from(Array(5), () => Array(5).fill(false)),arr);
    console.log("bfsResult", bfsResult)

    console.log('Depth First Search');
    let dfsResult = [Number.MAX_SAFE_INTEGER]
    DFS(0,0,0,dfsResult,Array.from(Array(5), () => Array(5).fill(false)));
    console.log("dfsResult", dfsResult[0])
}   

const BFS = (visited, arr) => {
    const start = [0,0,0]
    let queue = [start];
    visited[0][0] = true;

    while(queue.length) {
        const pos = queue.shift();
        
        if (pos[0] === arr.length-1 && pos[1] === arr[0].length-1) return pos[2];

        for(let dir of directions) {
            const ty = dir[0] + pos[0];
            const tx = dir[1] + pos[1];
            if (0 <= ty && ty < arr.length && 0 <= tx && tx < arr[0].length) {
                if (visited[ty][tx]) continue;
                if (arr[ty][tx] === 1) continue;
                visited[ty][tx] = true;
                queue.push([ty,tx,pos[2]+1])
            }
        }
    }
}

const DFS = (y,x,depth,answer,visited) => {
    if (arr[y][x] === 1) return;
    if (visited[y][x]) return;
    if (answer[0] < depth) return;
    visited[y][x] = true;

    console.log(y,x,depth);

    if(y === arr.length-1 && x === arr[0].length-1) {
        answer[0] = Math.min(answer[0], depth)
        return;
    }

    for(let dir of directions) {
        const ty = dir[0] + y;
        const tx = dir[1] + x;
        if (0 <= ty && ty < arr.length && 0 <= tx && tx < arr[0].length) {
            DFS(ty,tx,depth+1,answer,visited);
        }
    }
}

searchHandler();
```