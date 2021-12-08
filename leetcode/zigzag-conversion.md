# Zigzag Conversion

## 풀이

행의 개수만큼 배열을 만든다. 배열의 값은 빈 배열로 초기화한다. <br/>
첫번째 행에서 마지막행까지 값을 순차적으로 넣어주고 행을 벗어나면 반대 방향으로 찍어주게 조건처리하여 문제를 해결하였다.

## 코드

```js
/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
const convert = function (s, numRows) {
  const arr = Array.from(Array(numRows), () => ([]))

  let flag = 1
  let idx = 0

  for(const c of s) {
    if (idx < 0) idx++
    else if (numRows <= idx) idx--
    arr[idx].push(c)
    idx += flag
    if (numRows-1 === idx || 0 === idx) flag *= -1
  }

  return arr
    .flat()
    .reduce((acc,c) => acc+c)
}
```

## 문제

![problem](/assets/zigzag-conversion.png)