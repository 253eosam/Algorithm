# Regular Expression Matching [🔗](https://leetcode.com/problems/regular-expression-matching/)

## 풀이

문제는 정규식을 사용하는 방법을 물어보고있다. 주어진 문자열이 정확하게 패턴의 값과 같은지를 물어보고 있기때문에 정규식패턴에 ^,$ 을 넣어서 처음과 끝까지 비교할 수 있도록 하였다.

## 코드

```javascript
/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    return RegExp('^'+p+'$').test(s)
};
```

## 문제

![problem](/assets/regular-expression-matching.png)