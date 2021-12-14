# Longest Common Prefix [🔗](https://leetcode.com/problems/longest-common-prefix/)

## 풀이

1. 첫번째 문자열에서 두번째 문자열을 비교한다
2. 첫번째 인덱스부터 순차적으로 동일한 문자를 모아서 누산기에 저장한다.
3. 누산기와 그 다음 문자열을 비교하고 2번 행동을 반복한다.

## 코드

```javascript
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
  return strs.reduce((acc,cur) => {
    let temp = ''
    for(let i = 0; i < acc.length; i++) {
      if (i !== acc.indexOf(cur[i], i)) break
      temp += acc[i]
    }
    return temp
  })
}
```

## 문제

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

### Example 1:

```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

### Example 2:

```
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 ```

### Constraints:

- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lower-case English letters.