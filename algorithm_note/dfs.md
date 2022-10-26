# DFS & Backtracking

![https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_13.png](https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_13.png)

![https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_01.png](https://swexpertacademy.com/main/images/sw_sub/img_visualcodelist_01.png)

## 깊이 우선 탐색(Depth First Search)

- `재귀함수`를 이용
- `조건에 도달하면 함수를 리턴`하면서 스택에 쌓인 함수를 수행해낸다.
- **가능 여부/최적의 경로를 탐색**에서 사용

### 효율성 높이는 방법

- 방문체크를 이용한 방법
  - 경로를 탐색 후 방문 체크를 풀어주는 방법
  - 경로를 탐색할때 방문 체크를 해주어 중복 방문을 막는 방법
- **백트래킹**을 이용한 방법
- `DP`를 이용하여 최소 경로를 찾는 방법이 존재

### 주의

조건을 적절하게 넣지 않으면 매우 많은 depth가 생기게되고 이것은 Stack overflow가 발생할 수 있다.

## 백트래킹(Backtracking)

해를 찾아가는 도중, 현재 경로가 해가 되지 않거나 될 수 없다면 더이상 가지않고 돌아가는 것을 말합니다.

이 방법은 알고리즘 문제를 풀때 코드를 반복적으로 실행되는 횟수를 줄이므로써 시간복잡도를 줄일 수 있는 효율적인 방법입니다.

일반적으로 **가지치기**라고 불리며, 불필요한 경우의 수를 줄이고 올바른 방향으로 갈 수 있게 만드는 방법을 말합니다.  
보통 백트래킹은 DFS와 함께 사용되고, 가지치기를 얼마나 잘하느냐에 따라서 효율성이 결정되기도함으로 문제를 풀어나갈때 시간 부족현상이 발생한다면 이 부분을 고려해서 다시 구현해보는것을 추천드립니다.

### 대표 문제

- leetcode : [79. Word Search](https://leetcode.com/problems/word-search/) :: [풀이](https://github.com/253eosam/Algorithm/blob/master/leetcode/p79.md)
