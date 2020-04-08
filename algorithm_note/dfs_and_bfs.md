### DFS

- `재귀함수`를 이용
- `조건에 도달하면 함수를 리턴`하면서 스택에 쌓인 함수를 수행해낸다.
- **최적의 경로 탐색 **에서 사용
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