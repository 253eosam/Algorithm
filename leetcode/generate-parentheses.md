# Generate Parentheses [🔗](https://leetcode.com/problems/generate-parentheses/)

## 풀이

1. 재귀함수를 이용한 방법
2. 주어진 N보다 열린괄호가 적으면 열린괄호를 추가하는 함수 호출과 열린괄호보다 닫힌괄호의 수가 적으면 닫힌괄호를 추가하는 로직을 수행
3. 재귀함수가 깊어질때 N보다 열린괄호와 닫힌괄호의 수가 커지지 않도록 조건 처리
4. 열린괄호와 닫힌괄호와 N의 값이 같을때 현재 상태의 문자열을 저장한다.

## 코드

```javascript
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let answer = []
    
    const combination = (openCnt, closeCnt, str) => {
        if (n < openCnt || n < closeCnt) return 
        if (n === openCnt && n === closeCnt) {
            answer.push(str)
        }
        
        if (openCnt < n) combination(openCnt+1, closeCnt, str + '(')
        if (closeCnt < openCnt) combination(openCnt, closeCnt+1, str + ')')
    }
    
    combination(0,0,'')
    
    return answer
};
```

## 문제

![problem](/assets/generate-parentheses.png)
