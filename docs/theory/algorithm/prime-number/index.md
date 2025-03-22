# 소수 (Prime number)

> 자기 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수.

## 자신의 배수를 모두 제거하며 소수만 남기는 방법

```javascript
/**
 *
 * @param {number} N
 */
const primeNumber = N => {
	let isPrimeList = Array(N + 1).fill(true);
	for (let i = 2; i < Math.sqrt(isPrimeList.length); i++) {
		if (!isPrimeList[i]) continue;
		for (let j = i + i; j < isPrimeList.length; j += i) isPrimeList[j] = false;
	}
	return isPrimeList.map((item, i) => item && i).filter(item => item >= 2);
};
console.log(primeNumber(100));

/* ------------------------------------
[
   2,  3,  5,  7, 11, 13, 17, 19,
  23, 29, 31, 37, 41, 43, 47, 53,
  59, 61, 67, 71, 73, 79, 83, 89,
  97
]
*/
```
