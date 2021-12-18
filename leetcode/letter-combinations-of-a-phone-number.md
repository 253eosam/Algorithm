# Letter combinations of a phone number [🔗](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## 풀이

1. 번호마다 키 배열을 매핑해둔다.
2. 재귀함수를 이용해서 순차적으로 올수있는 경우에대해 최대 길이에서 값을 저장해둔다.

## 코드

```javascript
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  const phoneKeypad = {
    2: ['a','b','c'],
    3: ['d','e','f'],
    4: ['g','h','i'],
    5: ['j','k','l'],
    6: ['m','n','o'],
    7: ['p','q','r','s'],
    8: ['t','u','v'],
    9: ['w','x','y','z'],
  }

  let answer = []
  
  const combinationStr = (digits, deep, strs) => {
    if (deep === digits.length) {
      strs.join() && answer.push(strs.join(''))
      return 
    }

    for(const d of phoneKeypad[digits[deep]]) {
      strs[deep] = d
      combinationStr(digits, deep+1, strs)
    }
  }

  combinationStr(digits, 0, Array(digits.length))

  return answer
}
```

## 문제

![problem](/assets/letter-combinations-of-a-phone-number.png)
