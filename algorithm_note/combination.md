# 조합 (Combination)

> 집합에서 서로 다른 n개의 원소 중에서 순서와 상관없이 r개를 선택하는 것.

-   장점 : 모든 경우의 수를 구할 수 있는 완전 탐색.
-   단점 : 경우의 수가 많아질수록 계산 시간이 늘어남.

<br>

## 인덱스를 이용한 조합

```javascript
const combination = (arr, r) => {
	const result = [];
	com(result, arr, r, Array(r).fill());
	return result;
};
/**
 *
 * @param {Array} target
 * @param {Array} arr
 * @param {number} r
 * @param {Array} picked
 * @param {number} deep
 * @param {number} pivot
 */
const com = (target, arr, r, picked, deep = 0, pivot = 0) => {
	if (deep === r) {
		target.push(picked.slice());
		return;
	}
	for (let i = pivot; i < arr.length; i++) {
		picked[deep] = arr[i];
		com(target, arr, r, picked, deep + 1, i + 1);
	}
};
const n = 5;
const r = 3;
const arr = Array.from(Array(n).fill(), (_, i) => i + 1);
combination(arr, r).forEach(item => console.log(item));

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
