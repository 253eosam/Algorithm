# Palindrome Number

## 풀이

수를 배열로 만들고 중간까지의 인덱스를 이용해서 배열 양쪽의 값을 비교하면서 틀린값이 있는지 확인한다.

## 코드

```js
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
  const arr = Array.from(String(x))
  for (let [i, mid] = [0, parseInt(arr.length / 2)]; i < mid; i++) {
    if (arr[i] !== arr[arr.length - i - 1]) return false
  }
  return true
}
```

## 문제

![problems](/assets/palindrome-number.png)