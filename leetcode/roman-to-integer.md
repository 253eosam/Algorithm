# Roman to Integer [🔗](https://leetcode.com/problems/roman-to-integer/)

## 풀이

1. 로마 심볼의 배열을 내름차순으로 생성한다.
2. 문자열 첫번째부터 심볼이 존재하는 여부를 파악한다. 심볼이 존재한다면 해당 심볼의 길이만큼 인덱스를 이동시켜 찾고자하는 심볼이 인덱스의 첫번째 값인지 파악한다.
3. => 뒤쪽에 심볼이 체크되는것을 방지하기 위해서...
4. 문자열을 돌면서 심볼의 해당 값만큼 합을 구하고 반복되는 심볼은 반복되는 만큼 더한다.

## 코드

```javascript
/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
  let answer = 0
  let index = 0
  const romans = [
    [1000, 'M'],
    [900, 'CM'],
    [500, 'D'],
    [400, 'CD'],
    [100, 'C'],
    [90, 'XC'],
    [50, 'L'],
    [40, 'XL'],
    [10, 'X'],
    [9, 'IX'],
    [5, 'V'],
    [4, 'IV'],
    [1, 'I'],
  ]
  
  for(const [value, symbol] of romans) {
      while (s.indexOf(symbol,index) === index) {
          answer += value
          index += symbol.length
      }
  }
    
    return answer
};
```

## 문제

조만간 올릴께요 
