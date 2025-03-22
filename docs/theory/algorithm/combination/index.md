# 조합 (Combination)

> 집합에서 서로 다른 n개의 원소 중에서 순서와 상관없이 r개를 선택하는 것.

- 장점 : 모든 경우의 수를 구할 수 있는 완전 탐색.
- 단점 : 경우의 수가 많아질수록 계산 시간이 늘어남.

<br>

## 인덱스를 이용한 조합 👍

경우의 수를 순서대로 뽑아낼 수 있는 장점이있고, 코드를 더 직관적으로 짤 수 있음.

```javascript
const combination = (arr, r) => {
  const result = []
  com(result, arr, r, Array(r).fill())
  return result
}
const com = (target, arr, r, picked, deep = 0, pivot = 0) => {
  if (deep === r) {
    target.push(picked.slice())
    return
  }
  for (let i = pivot; i < arr.length; i++) {
    picked[deep] = arr[i]
    com(target, arr, r, picked, deep + 1, i + 1)
  }
}
const n = 5
const r = 3
const arr = Array.from(Array(n).fill(), (_, i) => i + 1)
combination(arr, r).forEach((item) => console.log(item))

/* --------------------------------------------------------
[ 1, 2, 3 ]
[ 1, 2, 4 ]
[ 1, 2, 5 ]
[ 1, 3, 4 ]
[ 1, 3, 5 ]
[ 1, 4, 5 ]
[ 2, 3, 4 ]
[ 2, 3, 5 ]
[ 2, 4, 5 ]
[ 3, 4, 5 ]
*/
```

<br>

## 조합 계산법을 이용한 방법

```javascript
const n = 5
const r = 3
const arr = Array.from(Array(n).fill(), (_, i) => i + 1)
const picked = Array(r)
function Combination(n, r, c) {
  if (r == 0) {
    console.log(picked.slice())
    return
  }
  if (n < r) {
    return
  } else {
    picked[r - 1] = arr[n - 1]
    Combination(n - 1, r - 1, c)
    Combination(n - 1, r, c)
  }
}
Combination(n, r, r)
/* ---------------------------------------------
[ 3, 4, 5 ]
[ 2, 4, 5 ]
[ 1, 4, 5 ]
[ 2, 3, 5 ]
[ 1, 3, 5 ]
[ 1, 2, 5 ]
[ 2, 3, 4 ]
[ 1, 3, 4 ]
[ 1, 2, 4 ]
[ 1, 2, 3 ]
*/
```

```ts
const combination = (nums: number[], target: number, cb?: Function, etc?: { deep:number, index:number, coms:number[] }): void => {
  const { deep = 0, index = 0, coms = Array(target) } = { ...etc }
  if (deep === target) {
      cb && cb( ... coms )
    return
  }

  for(let i = index; i < nums.length; i++) {
    coms[deep] = nums[i]
    combination(nums, target, cb, { deep: deep+1, index: i+1, coms })
  }
}

combination([1,2,3,4,5],3,console.log)
/**
1 2 3
1 2 4
1 2 5
1 3 4
1 3 5
1 4 5
2 3 4
2 3 5
2 4 5
3 4 5
 * /
```
