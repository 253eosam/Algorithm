# Reverse Integer

## 풀이

1. 음수인지 아닌지를 파악, 음수라면 '-'을 따로 보관
2. 문자를 뒤에서부터 새로운 배열의 값으로 추가함, '-'의 값만 추가하지않는 조건처리
3. integer의 범위를 확인하고 벗어나면 0으로 처리

## 코드

```js
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
  const str = `${x}`
  const isNegative = isNaN(str[0])
  let answer = isNegative ? '-' : ''
  
  for(let i = str.length-1; 0 <= i ; i--) {
      if (isNegative && i === 0) continue
      answer = answer.concat(str[i])
  }

  if (-Math.pow(2,31) <= +answer && answer <= Math.pow(2,31)-1) return +answer
  return 0
}
```

## 문제

![problem](/assets/reverse-integer.png)