# Valid Parentheses [🔗](https://leetcode.com/problems/valid-parentheses/)

## 풀이

1. 문자열을 순차적으로 받는다.
2. 괄호가 열리면 stack에 집어넣고, 닫히는 부분이라면 stack에서 뺀다.
3. stack에서 뺀 값과 괄호가 닫히 문자와 매핑되는 열리는 괄호를 비교한다.
4. 모든 문자열을 비교 후 스택이 비어있지않으면 괄호의 쌍의 수가 맞지 않으므로 `false`를 리턴한다.

## 코드

```javascript
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = []
    const mapping = {
        ')':'(',
        '}':'{',
        ']':'['
    }
    
    for(const c of s) {
        if (/[\(\[\{]/.test(c)) stack.push(c)
        else if (stack.pop() !== mapping[c]) return false
    }
    
    return stack.length === 0
};
```

## 문제

![problem](/assets/valid-parentheses.png)
