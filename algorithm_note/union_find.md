# Union find

> -   disjoint-set 이란?
> -   union-find 구현

## Disjoint-Set 이란?

-   **서로소** 또는 상호베타 집합들은 서로 중복 포함된 원소가 없는 집합들이다.
    => 교집합이 없다.
-   집합에 속한 하나의 특정 멤버를 통해 각 집합들을 구분한다. 이를 **대표자**라고 한다.
-   상호베타 집합을 표현하는 방법
    -   연결 리스트
    -   **트리** (효율적)
-   상호베타 집합 연산
    -   `make-set(x)` : [초기화 단계], 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산 
    -   `find-set(x)` : [대표자 찾기], x를 포함하는 집합을 찾는 오퍼레이션
    -   `union(x,y)` : [합치기], x와 y를 포함하는 두 집합을 통합하는 오퍼레이션

## Union-find 구현

![참고] (https://k.kakaocdn.net/dn/dF8aEk/btqE1p11KbP/ZVKrRFjKQ4Ydm944hmjZrk/img.png)

```javascript
const makeSet = arr => arr.fill().map((_,i) => i);

const findSet = (arr, x) => arr[x] === x ? x : arr[x] = findSet(arr[x]);

const unionSet = (arr, x, y) => {
    x = findSet(arr, x);
    y = findSet(arr, y);
    if (x === y) return ;
    arr[y] = x;
}

let arr = Array(8);
arr = makeSet(arr);
console.log(arr)

// group 1
unionSet(arr,2,0);
unionSet(arr,2,1);

// group 2
unionSet(arr,4,3);
unionSet(arr,4,6);
unionSet(arr,4,7);
unionSet(arr,5,4);

// group 1 + group 2
unionSet(arr,5,2);

console.log(arr)

/**
 * [ 0, 1, 2, 3, 4, 5, 6, 7 ]
 * [ 2, 2, 5, 4, 5, 5, 4, 4 ]
 */
```
